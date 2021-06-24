import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class zip {
	
	
	public static byte[] gZip(byte[] data) {
		ByteArrayInputStream in = new  ByteArrayInputStream(data);
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		GZIPOutputStream gzip;
		try {
			gzip = new GZIPOutputStream(out);
			byte[] buffer = new byte[4096];
			int n = 0;
			n = in.read(buffer,0,buffer.length);
			while(n > 0) {
				gzip.write(buffer, 0, n);
				n = in.read(buffer,0,buffer.length);
			}
			gzip.close();
			in.close();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return out.toByteArray();
	}
	
	public static byte[] unZip(byte[] zData) {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ByteArrayInputStream in = new ByteArrayInputStream(zData);
		GZIPInputStream gzip;
		try {
			gzip = new GZIPInputStream(in);
			byte[] buffer = new byte[4096];
			int n = 0;
			n = gzip.read(buffer);
			while(n > 0) {
				out.write(buffer, 0, n);
				n = gzip.read(buffer);
			}
			in.close();
			gzip.close();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return out.toByteArray();
	}
	
	public static byte[] ObjToByteArray(Object obj) {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ObjectOutputStream objStream;
		byte[] res;
		try {
			objStream = new ObjectOutputStream(out);
			objStream.writeObject(obj);
			objStream.flush();
			res = out.toByteArray();
			objStream.close();
			return res;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static Object byteToObj(byte[] data) {
		Object obj;
		ByteArrayInputStream in = new ByteArrayInputStream(data);
		ObjectInputStream oi;
		try {
			oi = new ObjectInputStream(in);
			obj = oi.readObject();
			oi.close();
			in.close();
			return obj;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static boolean checkExist(String fileName) {
		java.io.File f = new java.io.File(fileName);
		if(f.exists()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static void writeObj(Object userInfo,String fileName) {
		FileOutputStream out;
		ObjectOutputStream obj;
		try {
			out = new FileOutputStream(fileName);
			obj = new ObjectOutputStream(out);
			obj.writeObject(userInfo);
			obj.close();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Object readObj(String fileName) {
		Object userInfo = new Object();
		FileInputStream in;
		ObjectInputStream obj;
		try {
			in = new FileInputStream(fileName);
			obj = new ObjectInputStream(in);
			userInfo = obj.readObject();
			obj.close();
			in.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userInfo;
	}
	
	public static long getFileSize(String fileName) {
		java.io.File file = new java.io.File(fileName);
		if(!file.exists() || !file.isFile()) {
			return -1;
		}else {
			return file.length()/1024;
		}
	}
	
}
