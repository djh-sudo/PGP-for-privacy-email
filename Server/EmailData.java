import java.io.Serializable;

public class EmailData implements Serializable{

	private static final long serialVersionUID = 1L;
	private String recvMail;
	private byte[] messageData;
	
	public EmailData(String recvMail,byte[] messageData) {
		this.recvMail = recvMail;
		this.messageData = messageData;
	}
	
	public String getRecvMail() {
		return this.recvMail;
	}
	
	public byte[] getMessageData() {
		return this.messageData;
	}
	
	
}
