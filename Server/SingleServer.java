import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Vector;

public class SingleServer implements Runnable{
	private Socket socket;
	public SingleServer(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			System.out.println(socket.getPort() + "," + socket.getInetAddress());
			InputStream in = socket.getInputStream();
			OutputStream out = socket.getOutputStream();
			ByteArrayOutputStream os = new ByteArrayOutputStream();
			byte[] buffer = new byte[1024];
			int len;
			while((len = in.read(buffer))!=-1) {
				os.write(buffer, 0, len);
			}
			String osContent = os.toString();
			if(!osContent.contains("#")) {
				byte[] decodeData = BASE64.decoder.decode(osContent);
				DataPackage dataPackage = (DataPackage) zip.byteToObj(decodeData);
				String recv = dataPackage.getRecvMail();


				if(Server.hash.containsKey(recv)) {
					Vector<byte[]> message = Server.hash.remove(recv);
					message.add(os.toByteArray());
					Server.hash.put(recv,message);
					zip.writeObj(Server.hash.get(recv), MD.MD5(recv));
					message = null;
				}else {
					Vector<byte[]> message = new Vector<byte[]>();
					message.add(os.toByteArray());
					Server.hash.put(recv, message);
					zip.writeObj(Server.hash.get(recv), MD.MD5(recv));
					message = null;
				}
//				new Thread(){
//					@Override
//					public void run() {
//						// TODO Auto-generated method stub
//						super.run();
//						String contantName = MD.MD5(recv);
//						String time = new Date(System.currentTimeMillis()).toString();
//						String send = dataPackage.getSendMail();
//						long size = zip.getFileSize(contantName);
//						String size_ = Long.toString(size) + "KB";
//						Server.model.addRow(new Object[] {contantName,time,recv,send,size_});
//					}
//				}.start();
				os.close();
				out.close();
				socket.close();
//				Server.contentStore.add(recv);
				return;
			}else {
				System.out.println("request");
				osContent = osContent.replace("#", "");
//				final String who = osContent;
				if(zip.checkExist(MD.MD5(osContent))) {
					Vector<byte[]> data = new Vector<byte[]>();
					data = (Vector<byte[]>) zip.readObj(MD.MD5(osContent));
					byte[] sendData = zip.ObjToByteArray(data);
					out.write(sendData);
					out.flush();
					out.close();
					in.close();
					socket.close();
					Server.hash.remove(osContent);
					/* */
//					new Thread(){
//						@Override
//						public void run() {
//							// TODO Auto-generated method stub
//							super.run();
//							try {
//								Vector<byte[]> recvData = (Vector<byte[]>) zip.byteToObj(sendData);	
//								for(int i = 0;i<recvData.size();i++) {
//									String eachData = new String(recvData.get(i));
//									byte[] decodeData = BASE64.decoder.decode(eachData);
//									DataPackage dataPackage = (DataPackage) zip.byteToObj(decodeData);
//								}
								
//								Vector<Integer>remove = new Vector<Integer>();
//								for(int i=0;i<Server.model.getRowCount();i++) {
//									if(Server.model.getValueAt(i, 2).equals(who)) {
//										remove.add(i);
//									}
//								}
//								for(int i=remove.size()-1;i>=0;i--) {
//									Server.model.removeRow(i);
//								}
//								remove = null;
//							}catch (Exception e) {
//								// TODO: handle exception
//								e.printStackTrace();
//							}
//						}
//					}.start();
					Path path = Paths.get(MD.MD5(osContent));
					Files.delete(path);
				}else {
					out.write("fail".getBytes());
					out.flush();
					out.close();
					in.close();
					socket.close();
				}
			}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		finally{
			System.out.println("client is disconnected!");
			try {
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
