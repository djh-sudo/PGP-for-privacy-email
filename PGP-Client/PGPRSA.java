import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.bouncycastle.util.io.pem.PemObject;
import org.bouncycastle.util.io.pem.PemWriter;

public class PGPRSA {
	private static final String ALGOTITHM = "RSA";
	private static final int KEY_SIZE = 2048;
	private final static String SIGNATURE_ALROTITHM  = "MD5withRSA";

	private Base64.Decoder decoder;
	private Base64.Encoder encoder;
	private KeyPair key;
	private int keyLength;

	
	
	public KeyPair getKey() {
		return this.key;
	}

	public PrivateKey getPrivateKey() {
		return this.key.getPrivate();
	}

	public PublicKey getPublicKey() {
		return this.key.getPublic();
	}

	public PGPRSA() {
		// TODO Auto-generated constructor stub
		decoder = Base64.getDecoder();
		encoder = Base64.getEncoder();
		keyLength = KEY_SIZE;
	}

	void setRSAKey(KeyPair key) {
		this.key = key;
	}
	public void generateKeyPair() {
		KeyPairGenerator generator;
		try {
			generator = KeyPairGenerator.getInstance(ALGOTITHM);
			generator.initialize(keyLength);
			key =  generator.generateKeyPair();

		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public byte[] RSASign(String message,PrivateKey privateKey) {
		Signature signature;
		byte [] msg;
		msg = message.getBytes();
		try {
			signature = Signature.getInstance(SIGNATURE_ALROTITHM);
			try {
				signature.initSign(privateKey);
				signature.update(msg);
				byte [] signatureResult = signature.sign();
				return signatureResult;
			} catch (InvalidKeyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace(); 
			}		
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SignatureException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public boolean vertify(String data,byte[] signature,PublicKey publicKey) {
		try {
			byte [] bData = data.getBytes();
			Signature signature1 = Signature.getInstance(SIGNATURE_ALROTITHM);
			signature1.initVerify(publicKey);
			signature1.update(bData);
			boolean vertify = signature1.verify(signature);
			return vertify;
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SignatureException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	} 

	public byte[] Encrypt(byte[] data,PublicKey publicKey) {
		Cipher cipher;
		try {
			cipher = Cipher.getInstance(ALGOTITHM);
			cipher.init(Cipher.ENCRYPT_MODE, publicKey);
			return cipher.doFinal(data); 
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
		}
		return null;
	}

	public byte[] Decrypt(byte[] encData,PrivateKey privateKey) {
		Cipher cipher;
		try {
			cipher = Cipher.getInstance(ALGOTITHM);
			cipher.init(Cipher.DECRYPT_MODE, privateKey);
			return cipher.doFinal(encData); 
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
		}
		return null;
	}

	public String Decrypt(String encData,String publicKey) {
		byte[] decoded = decoder.decode(publicKey);
		RSAPublicKey pub;
		try {
			pub = (RSAPublicKey)KeyFactory.getInstance(ALGOTITHM).generatePublic(new X509EncodedKeySpec(decoded));
			Cipher cipher = Cipher.getInstance(ALGOTITHM);
			cipher.init(Cipher.DECRYPT_MODE, pub);
			return new String(cipher.doFinal(encData.getBytes("UTF-8")));
		} catch (InvalidKeySpecException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public String byteArrayToHex(byte[] bytes) {
		// TODO Auto-generated method stub
		String output = new String();
		for(int i=0;i<bytes.length;i++) {
			int b = 0XFF & bytes[i];
			if(b<=0xF)
				output += "0";
			output += Integer.toHexString(b);
		}
		output = output.toUpperCase();
		return output;
	}

	void setKeyLength(int length) {
		this.keyLength = length;
	}

	public PublicKey publicKeyRead(String fileName) {
		byte[] keyByte;
		X509EncodedKeySpec spec;
		KeyFactory keyFactory;
		try {
			keyByte = Files.readAllBytes(Paths.get(fileName));
			spec = new X509EncodedKeySpec(keyByte);
			keyFactory = KeyFactory.getInstance(ALGOTITHM);
			return keyFactory.generatePublic(spec);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void SaveToPEM(String filePath) {
		StringWriter writer;
		PemWriter pem;
		FileOutputStream out;
		
		try {
			writer = new StringWriter();
			pem = new PemWriter(writer);
			out = new FileOutputStream(filePath);
			pem.writeObject(new PemObject("RSA PUBLIC KEY", this.key.getPublic().getEncoded()));
			pem.flush();
			pem.close();
			String res = writer.getBuffer().toString();
			out.write(res.getBytes(), 0, res.length());
			writer.close();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getStringPublicKey(String filePath) {
		File file = new File(filePath);
		if(file.length()>4096) {
			return "";
		}else {
			Long fileLength = file.length();
			byte[] content = new byte[fileLength.intValue()];
			FileInputStream in;
			try {
				in = new FileInputStream(file);
				in.read(content);
				in.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return new String(content);
		}
	}
	
	public String getPublicKeyModulus() {
		BigInteger modulusPublicKey =  ((RSAPublicKey)this.key.getPublic()).getModulus();
		return modulusPublicKey.toString(16);
	}
	
	public String getPublicKeyExponent() {
		BigInteger exponentPublicKey = ((RSAPublicKey)this.key.getPublic()).getPublicExponent();
		return exponentPublicKey.toString();
	}
}
