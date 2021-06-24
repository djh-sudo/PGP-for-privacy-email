import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Security;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class PGPIDEA {
	private final static String ALGORTHM = "IDEA";
	private final static String MODEL = "IDEA/ECB/ISO10126Padding";
	private final static int KEY_LENGTH = 128;
	
	private Base64.Decoder decoder;
	private Base64.Encoder encoder;
	
	private Key key;
	
	public PGPIDEA() {
		// TODO Auto-generated constructor stub
		decoder = Base64.getDecoder();
		encoder = Base64.getEncoder();
	}
	
	public void generateKey() {
		KeyGenerator generator;
		Security.addProvider(new BouncyCastleProvider());
		try {
			generator = KeyGenerator.getInstance(ALGORTHM);
			generator.init(KEY_LENGTH);
			
			SecretKey secretKey = generator.generateKey();
			byte[] keyByte = secretKey.getEncoded();
			this.key = new SecretKeySpec(keyByte, ALGORTHM);
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public Key getKey() {
		return this.key;
	}
	

	
	public byte[] Encrypt(byte[] data,Key key) {
		Cipher cipher;
		Security.addProvider(new BouncyCastleProvider());
		try {
			cipher = Cipher.getInstance(MODEL,"BC");
			cipher.init(Cipher.ENCRYPT_MODE, key);
			return cipher.doFinal(data);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchProviderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public byte[] Decrypt(byte[] encData,Key key) {
		Cipher cipher;
		Security.addProvider(new BouncyCastleProvider());
		try {
			cipher = Cipher.getInstance(MODEL,"BC");
			cipher.init(Cipher.DECRYPT_MODE, key);
			return cipher.doFinal(encData);
		} catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchProviderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public byte[] Decrypt(byte[] encData,byte[] key) {
		SecretKey orignalKey = new SecretKeySpec(key,0,key.length,ALGORTHM);
		byte[] keyByte = orignalKey.getEncoded();
		Key ideaKey = new SecretKeySpec(keyByte, ALGORTHM);
		Cipher cipher;
		try {
			cipher = Cipher.getInstance(MODEL,"BC");
			cipher.init(Cipher.DECRYPT_MODE, ideaKey);
			return cipher.doFinal(encData);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchProviderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
