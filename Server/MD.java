import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD {
	public final static String MD5(String message) {
		try {
			MessageDigest mDigest = MessageDigest.getInstance("MD5");
			byte[] bytes = mDigest.digest(message.getBytes());
			String s = byteArrayToHex(bytes);
			
			return s.toUpperCase();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

	private static String byteArrayToHex(byte[] bytes) {
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
}
