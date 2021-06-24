import java.io.Serializable;
import java.security.KeyPair;
import java.security.PublicKey;
import java.util.Vector;

public class User implements Serializable{

	private static final long serialVersionUID = 1L;
	private String userName;
	private String password;
	private int keyLength;
	private KeyPair key;
	private Vector<Friend>friends;
	private boolean isRemember;
	private volatile Vector<MailContent>sendMailBox;
	private volatile Vector<MailContent>recvMailBox;

	public User(String userName,String password,int keyLength,KeyPair key) {
		// TODO Auto-generated constructor stub
		this.userName = userName;
		this.password = password;
		this.keyLength = keyLength;
		this.key = key;
		this.isRemember = false;
		this.friends = new Vector<Friend>();
		this.sendMailBox = new Vector<MailContent>();
		this.recvMailBox = new Vector<MailContent>();
	}

	public User() {
		this.keyLength = 2048;
		this.userName = "";
		this.password = MD.MD5("");
		this.isRemember = false;
		friends = new Vector<Friend>();
		this.sendMailBox = new Vector<MailContent>();
		this.recvMailBox = new Vector<MailContent>();
	}
	public String getName() {
		return this.userName;
	}

	public String getPassword() {
		return this.password;
	}

	public int getKeyLength() {
		return this.keyLength;
	}

	public KeyPair getKey() {
		return this.key;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setKey(KeyPair key) {
		this.key = key;
	}

	public void setKeyLength(int keyLength) {
		this.keyLength = keyLength;
	}

	public void addFriend(Friend friend) {
		this.friends.add(friend);
	}

	public boolean getRemember() {
		return this.isRemember;
	}

	public void setRemember(boolean remember) {
		this.isRemember = remember;
	}

	public Vector<Friend> getFriend() {
		return this.friends;
	}

	public int checkIsDuplicated(String s) {
		for(int i=0;i<friends.size();i++) {
			if(s.equals(friends.get(i).getUserMail())) {
				return i;
			}
			else continue;
		}
		return -1;
	}

	public boolean deleteFriend(int index) {
		try {
			friends.remove(index);
			return true;
		}catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	public void saveSendMail(MailContent content) {
		this.sendMailBox.add(content);
	}

	public void saveRecvMail(MailContent content) {
		this.recvMailBox.add(content);
	}
	
	public Vector<MailContent> getSendMail(){
		return this.sendMailBox;
	}

	public Vector<MailContent> getRecvMail(){
		return this.recvMailBox;
	}
	
	public PublicKey getFriendKey(String nameMail) {
		int index = checkIsDuplicated(nameMail);
		if(index!=-1) {
			return this.friends.elementAt(index).getPublicKey();
		}else {
			return null;
		}
	}
	
	
	public boolean deleteSendMail(int index) {
		try {
			int count = sendMailBox.size();
			if(index<count) {
				sendMailBox.remove(index);
				return true;
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		return false;
	}

	public boolean deleteRecvMail(int index) {
		try {
			int count = recvMailBox.size();
			if(index<count) {
				recvMailBox.remove(index);
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		return false;
	}
}
