package jung.spring.vo;

import java.util.Date;

public class PostingInfoVO {
	private int postingNumber;
	private String userId;
	private String userName;
	private String postingTitle;
	private String postingContent;
	private String postingPictureTitle;
	private int postingRecommandCount;
	private int postingAnswerCount;
	private Date postingDate;

	public String getPostingContent() {
		return postingContent;
	}
	public String getPostingPictureTitle() {
		return postingPictureTitle;
	}
	public void setPostingPictureTitle(String postingPictureTitle) {
		this.postingPictureTitle = postingPictureTitle;
	}
	public void setPostingContent(String postingContent) {
		this.postingContent = postingContent;
	}
	
	public int getPostingNumber() {
		return postingNumber;
	}
	public void setPostingNumber(int postingNumber) {
		this.postingNumber = postingNumber;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public int getPostingRecommandCount() {
		return postingRecommandCount;
	}
	public void setPostingRecommandCount(int postingRecommandCount) {
		this.postingRecommandCount = postingRecommandCount;
	}
	
	public Date getPostingDate() {
		return postingDate;
	}
	public void setPostingDate(Date postingDate) {
		this.postingDate = postingDate;
	}
	
	public String getPostingTitle() {
		return postingTitle;
	}
	public void setPostingTitle(String postingTitle) {
		this.postingTitle = postingTitle;
	}
	
	public int getPostingAnswerCount() {
		return postingAnswerCount;
	}
	public void setPostingAnswerCount(int postingAnswerCount) {
		this.postingAnswerCount = postingAnswerCount;
	}
}
