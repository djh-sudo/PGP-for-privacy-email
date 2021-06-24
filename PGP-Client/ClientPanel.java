import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.KeyPair;
import java.security.PublicKey;
import java.util.Random;
import java.util.Vector;

import javax.swing.JPanel;


public class ClientPanel extends JPanel{


	private static final long serialVersionUID = 1L;

	private PGPIDEA idea;
	private PGPRSA rsa;
	private User user;
	private int port;
	private String address;
	private Random random;
	private Socket socket;

	public ClientPanel() {
		// TODO Auto-generated constructor stub
		this.random = new Random();
		this.rsa = new PGPRSA();
		this.idea = new PGPIDEA();
		this.user = new User();
		this.port = 12531;
		this.address = "localhost";
	}

	public void setKeyLength(int length) {
		this.rsa.setKeyLength(length);
	}

	public String getUserName() {
		return user.getName();
	}

	public User getUser() {
		return this.user;
	}
	public void setPassword(String password) {
		this.user.setPassword(password);
	}

	public void setRSAKey(KeyPair key) {
		this.user.setKey(key);
		this.rsa.setRSAKey(key);
	}

	public void outputPublicKey(String s) {
		rsa.SaveToPEM(s + "/PublicKey.pem");
	}

	public void updateKeyPair() {
		rsa.generateKeyPair();
		this.user.setKey(rsa.getKey());
	}

	public String getPublicKeyModulus() {
		return rsa.getPublicKeyModulus().toUpperCase();
	}

	public String getPublicKeyExponent() {
		return rsa.getPublicKeyExponent().toUpperCase();
	}

	public String getPublicKeyFile(String s) {
		return rsa.getStringPublicKey(s);
	}

	public void updateUserInfo() {
		File file = new	File(MD.MD5(this.user.getName()));
		file.writeObj(this.user);
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getPort() {
		return this.port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public Socket getSocket() {
		return this.socket;
	}

	public boolean setSocket(int port,String addr) {
		try {
			int clientPort = random.nextInt(64510)+1025;
			InetAddress netAddress = InetAddress.getByName(addr);
			InetAddress localAddress = InetAddress.getByName("localhost");
			socket = new Socket(netAddress,port,localAddress,clientPort);
			return true;
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public void dropSocket() {
		this.socket = null;
	}
	public String sentEmail(String emailDigest,String content,int index) {
		String message = emailDigest+content;
		String messageMD5 = MD.MD5(message);
		String recvMail = user.getFriend().elementAt(index).getUserMail();
		byte[] sig = rsa.RSASign(messageMD5, rsa.getPrivateKey());
		MailContent mail = new MailContent(emailDigest,content,sig,recvMail,this.getUserName(),true);
		mail.setDate();
		user.saveSendMail(mail);
		byte[] byteRes = zip.ObjToByteArray(mail);
		byte[] zipData = zip.gZip(byteRes);
		idea.generateKey();
		byte[] ideaKey = idea.getKey().getEncoded();
		System.out.println("加密的IDEA Key " + ideaKey.toString());
		byte[] encZipData = idea.Encrypt(zipData, idea.getKey());
		PublicKey keyTemp = user.getFriend().elementAt(index).getPublicKey();
		byte[] ideaKeyEnc = rsa.Encrypt(ideaKey,keyTemp);
		DataPackage dataPackage = new DataPackage(ideaKeyEnc,encZipData,recvMail,user.getName());
		String dataSent = BASE64.encoder.encodeToString(zip.ObjToByteArray(dataPackage));
		return dataSent;
	}

	public boolean recvEmail(byte[] recvData) {
		try {
			byte[] decodeData = BASE64.decoder.decode(recvData);
			DataPackage dataPackage = (DataPackage) zip.byteToObj(decodeData);
			/* first decript the idea key */
			byte[] encKey = dataPackage.getEncKey();
			byte[] encData = dataPackage.getEncData();
			byte[] ideaKey =  rsa.Decrypt(encKey, rsa.getPrivateKey());
			byte[] rawData = idea.Decrypt(encData, ideaKey);
			byte[] uzipData = zip.unZip(rawData);
			MailContent mail = (MailContent) zip.byteToObj(uzipData);
			byte[] sig = mail.getSignature();
			String messageMd5 = MD.MD5(mail.getemailDigest()+mail.getContent());
			boolean vertify = rsa.vertify(messageMd5, sig, user.getFriend().elementAt(0).getPublicKey());
			return vertify;
		}
		catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	public boolean recvEmail(DataPackage dataPackage) {
		try {
			/* first decript the idea key */
			byte[] encKey = dataPackage.getEncKey();
			byte[] encData = dataPackage.getEncData();
			byte[] ideaKey =  rsa.Decrypt(encKey, rsa.getPrivateKey());
			byte[] rawData = idea.Decrypt(encData, ideaKey);
			byte[] uzipData = zip.unZip(rawData);
			MailContent mail = (MailContent) zip.byteToObj(uzipData);	
			byte[] sig = mail.getSignature();
			String messageMd5 = MD.MD5(mail.getemailDigest() + mail.getContent());
			String whoSend = dataPackage.getSendMail();
			int index = user.checkIsDuplicated(whoSend);
			if(index!=-1) {
				boolean vertify = rsa.vertify(messageMd5, sig, user.getFriendKey(whoSend));
				mail.setVertify(vertify);
				user.saveRecvMail(mail);
				this.updateUserInfo();
				return vertify;
			}else {
				mail.setVertify(false);
				user.saveRecvMail(mail);
				this.updateUserInfo();
				System.out.println("请导入用户公钥!");
				return false;
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}


	public boolean sendToServer(byte[] data) {
		try {
			OutputStream out = socket.getOutputStream();
			int len = 0;
			len = data.length;
			out.write(data, 0, len);
			out.close();
			socket.close();
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public boolean Request() {
		try {
			OutputStream out = socket.getOutputStream();
			int len = 0;
			String request = "#" + user.getName();
			byte[] data = request.getBytes();
			len = data.length;
			out.write(data, 0, len);
			socket.shutdownOutput();

			InputStream in = socket.getInputStream();
			ByteArrayOutputStream os = new ByteArrayOutputStream();
			byte[]buffer = new byte[8192];
			int length = 0;
			while((length = in.read(buffer))!=-1) {
				os.write(buffer, 0, length);
			}

			byte[] res = os.toByteArray();
			if(new String(res).equals("fail")) {
				return false;
			}
			Vector<byte[]> recvData = (Vector<byte[]>) zip.byteToObj(res);
			for(int i = 0;i<recvData.size();i++) {
				String eachData = new String(recvData.get(i));
				byte[] decodeData = BASE64.decoder.decode(eachData);
				DataPackage dataPackage = (DataPackage) zip.byteToObj(decodeData);
				recvEmail(dataPackage);
			}
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public PGPRSA getRSA() {
		return this.rsa;
	}

}
