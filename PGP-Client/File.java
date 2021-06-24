import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class File {
	
	private String fileName;
	
	public File(String fileName){
		this.fileName = fileName;
	}
	
	public boolean checkExist(String fileName) {
		try {
			java.io.File f = new java.io.File(fileName);
			if(f.exists()) {
				return true;
			}else {
				return false;
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	public void writeObj(User user) {
		FileOutputStream out;
		ObjectOutputStream obj;
		try {
			out = new FileOutputStream(fileName);
			obj = new ObjectOutputStream(out);
			obj.writeObject(user);
			obj.close();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public User readObj() {
		User user = new User();
		FileInputStream in;
		ObjectInputStream obj;
		try {
			in = new FileInputStream(fileName);
			obj = new ObjectInputStream(in);
			user = (User)obj.readObject();
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
		return user;
	}
	

}
