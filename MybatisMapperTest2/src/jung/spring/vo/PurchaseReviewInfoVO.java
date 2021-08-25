package jung.spring.vo;

import java.util.Date;

public class PurchaseReviewInfoVO {
	private int purchaseReviewNumber;
	private String purchaseReview_userId;
	private String purchaseReview_userName;
	private String purchaseReview_title;
	private String purchaseReview_content;
	private Date purchaseReview_date;
	private String purchaseReview_picture;
	
	public int getPurchaseReviewNumber() {
		return purchaseReviewNumber;
	}
	public void setPurchaseReviewNumber(int purchaseReviewNumber) {
		this.purchaseReviewNumber = purchaseReviewNumber;
	}
	public String getPurchaseReview_userId() {
		return purchaseReview_userId;
	}
	public void setPurchaseReview_userId(String purchaseReview_userId) {
		this.purchaseReview_userId = purchaseReview_userId;
	}
	public String getPurchaseReview_userName() {
		return purchaseReview_userName;
	}
	public void setPurchaseReview_userName(String purchaseReview_userName) {
		this.purchaseReview_userName = purchaseReview_userName;
	}
	public String getPurchaseReview_title() {
		return purchaseReview_title;
	}
	public void setPurchaseReview_title(String purchaseReview_title) {
		this.purchaseReview_title = purchaseReview_title;
	}
	public String getPurchaseReview_content() {
		return purchaseReview_content;
	}
	public void setPurchaseReview_content(String purchaseReview_content) {
		this.purchaseReview_content = purchaseReview_content;
	}
	public Date getPurchaseReview_date() {
		return purchaseReview_date;
	}
	public void setPurchaseReview_date(Date purchaseReview_date) {
		this.purchaseReview_date = purchaseReview_date;
	}
	public String getPurchaseReview_picture() {
		return purchaseReview_picture;
	}
	public void setPurchaseReview_picture(String purchaseReview_picture) {
		this.purchaseReview_picture = purchaseReview_picture;
	}
	
}
