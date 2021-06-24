import java.io.Serializable;

public class DataPackage implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private byte[] encIdeaKey;
	private byte[] encData;
	private String sendMail;
	private String recvMail;
	public DataPackage(){}
	
	public DataPackage(byte[]encIdeaKey,byte[]encData,String recvMail,String sendMail) {
		this.encData = encData;
		this.encIdeaKey = encIdeaKey;
		this.recvMail = recvMail;
		this.sendMail = sendMail;
	}
	
	public byte[] getEncKey() {
		return this.encIdeaKey;
	}
	
	public byte[] getEncData() {
		return this.encData;
	}
	
	public String getRecvMail() {
		return this.recvMail;
	}
	
	public String getSendMail() {
		return this.sendMail;
	}
}
