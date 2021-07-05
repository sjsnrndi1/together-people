package jung.spring.vo;

public class PostingRecommandInfoVO {
	private int postingRecommandNumber;
	private int postingNumber;
	private String userId;
	private int postingRecommandCountCheck;
	
	public int getPostingRecommandNumber() {
		return postingRecommandNumber;
	}
	public void setPostingRecommandNumber(int postingRecommandNumber) {
		this.postingRecommandNumber = postingRecommandNumber;
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
	public int getPostingRecommandCountCheck() {
		return postingRecommandCountCheck;
	}
	public void setPostingRecommandCountCheck(int postingRecommandCountCheck) {
		this.postingRecommandCountCheck = postingRecommandCountCheck;
	}
}
