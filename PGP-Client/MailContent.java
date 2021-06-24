import java.io.Serializable;
import java.util.Date;

public class MailContent implements Serializable{

	private static final long serialVersionUID = 1L;
	private String emailDigest;
	private String content;
	private String mailRecv;
	private String mailSend;
	private long timeStamp;
	private byte[] signature;
	private boolean vertify;
	private boolean isSentOK;
	
	public MailContent(){}
	public MailContent(String emailDiget,String content,byte[] signature,String mailRecv,String mailSend,boolean vertify) {
		this.emailDigest = emailDiget;
		this.content = content;
		this.signature = signature;
		this.timeStamp = System.currentTimeMillis();
		this.mailRecv = mailRecv;
		this.mailSend = mailSend;
		this.vertify = vertify;
		this.isSentOK = false;
	}
	
	public String getemailDigest() {
		return this.emailDigest;
	}
	
	public String getContent() {
		return this.content;
	}
	
	public byte[] getSignature() {
		return this.signature;
	}
	
	public Date getDate() {
		return new Date(this.timeStamp);
	}
	
	public void setDate() {
		this.timeStamp = System.currentTimeMillis();
	}
	
	public String getMailRecv() {
		return this.mailRecv;
	}
	
	public String getMailSend() {
		return this.mailSend;
	}
	
	public boolean getVertify() {
		return this.vertify;
	}
	
	public void setVertify(boolean vertify) {
		this.vertify = vertify;
	}
	
	public void setIsSentOk(boolean isSentOk) {
		this.isSentOK = isSentOk;
	}
	public boolean getIsSentOk() {
		return this.isSentOK;
	}
}
