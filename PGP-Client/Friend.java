import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;

public class Friend implements Serializable{

	private static final long serialVersionUID = 1L;
	private PublicKey rsaPublicKey;
	private String userMail;

	public Friend(){}

	public Friend(PublicKey key,String userMail) {
		this.rsaPublicKey = key;
		this.userMail = userMail;
	}

	public PublicKey getPublicKey() {
		return this.rsaPublicKey;
	}

	public String getUserMail() {
		return this.userMail;
	}

	public void setFriendMail(String userMail) {
		this.userMail = userMail;
	}
	
	public boolean checkRSA(String key) {
		if(key.equals("")) {
			return false;
		}else {
			byte[] keyBytes;
			String pem;
			try {
				keyBytes = key.getBytes("UTF-8");
				pem = new String(keyBytes);
				pem = pem.replace("-----BEGIN RSA PUBLIC KEY-----", "");
				pem = pem.replace("-----END RSA PUBLIC KEY-----", "");
				pem = pem.replace("\r\n", "");
				byte[] decode = BASE64.decoder.decode(pem);
				X509EncodedKeySpec spec = new X509EncodedKeySpec(decode);
				KeyFactory factory = KeyFactory.getInstance("RSA");
				this.rsaPublicKey = factory.generatePublic(spec);
			} catch (UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				return false;
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			} catch (InvalidKeySpecException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}	
		}
		return true;
	}

}
