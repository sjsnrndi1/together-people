package jung.spring.vo;

import java.util.Date;

public class QnaInfoVO {
	private int qnaNumber;
	private int qnaRegistNumber;
	private String qnaTitle;
	private String qnaContent;
	private String qnaWriter;
	private String qnaUserId;
	private Date qnaDate;
	private String qnaComment;
	
	public int getQnaNumber() {
		return qnaNumber;
	}
	public void setQnaNumber(int qnaNumber) {
		this.qnaNumber = qnaNumber;
	}
	public int getQnaRegistNumber() {
		return qnaRegistNumber;
	}
	public void setQnaRegistNumber(int qnaRegistNumber) {
		this.qnaRegistNumber = qnaRegistNumber;
	}
	public String getQnaTitle() {
		return qnaTitle;
	}
	public void setQnaTitle(String qnaTitle) {
		this.qnaTitle = qnaTitle;
	}
	public String getQnaContent() {
		return qnaContent;
	}
	public void setQnaContent(String qnaContent) {
		this.qnaContent = qnaContent;
	}
	public String getQnaWriter() {
		return qnaWriter;
	}
	public void setQnaWriter(String qnaWriter) {
		this.qnaWriter = qnaWriter;
	}
	public String getQnaUserId() {
		return qnaUserId;
	}
	public void setQnaUserId(String qnaUserId) {
		this.qnaUserId = qnaUserId;
	}
	public Date getQnaDate() {
		return qnaDate;
	}
	public void setQnaDate(Date qnaDate) {
		this.qnaDate = qnaDate;
	}
	public String getQnaComment() {
		return qnaComment;
	}
	public void setQnaComment(String qnaComment) {
		this.qnaComment = qnaComment;
	}
}
