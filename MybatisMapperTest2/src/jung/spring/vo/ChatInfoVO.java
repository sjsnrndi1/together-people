package jung.spring.vo;

import java.util.Date;

public class ChatInfoVO {
	private int chatNumber;
	private int chatNum;
	private String chatUserId;
	private String chatContent;
	private Date chatDate;
	
	public int getChatNum() {
		return chatNum;
	}
	public void setChatNum(int chatNum) {
		this.chatNum = chatNum;
	}
	public int getChatNumber() {
		return chatNumber;
	}
	public void setChatNumber(int chatNumber) {
		this.chatNumber = chatNumber;
	}
	public String getChatUserId() {
		return chatUserId;
	}
	public void setChatUserId(String chatUserId) {
		this.chatUserId = chatUserId;
	}
	public String getChatContent() {
		return chatContent;
	}
	public void setChatContent(String chatContent) {
		this.chatContent = chatContent;
	}
	public Date getChatDate() {
		return chatDate;
	}
	public void setChatDate(Date chatDate) {
		this.chatDate = chatDate;
	}
}