package jung.spring.vo;

import java.util.Date;

public class PopupChatInfoVO {
	
	private int popupChatNumber;
	private int popupNumber;
	private String userId;
	private String userChatContent;
	private String adminChatContent;
	private Date chat_date;
	
	public int getPopupChatNumber() {
		return popupChatNumber;
	}
	public void setPopupChatNumber(int popupChatNumber) {
		this.popupChatNumber = popupChatNumber;
	}
	public int getPopupNumber() {
		return popupNumber;
	}
	public void setPopupNumber(int popupNumber) {
		this.popupNumber = popupNumber;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserChatContent() {
		return userChatContent;
	}
	public void setUserChatContent(String userChatContent) {
		this.userChatContent = userChatContent;
	}
	public String getAdminChatContent() {
		return adminChatContent;
	}
	public void setAdminChatContent(String adminChatContent) {
		this.adminChatContent = adminChatContent;
	}
	public Date getChat_date() {
		return chat_date;
	}
	public void setChat_date(Date chat_date) {
		this.chat_date = chat_date;
	}
}
