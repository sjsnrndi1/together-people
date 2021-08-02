package jung.spring.vo;

import java.util.Date;

public class BoardCommentInfoVO {
	private int boardCommentNumber;
	private int boardNumber;
	private String boardComment;
	private String userId;
	private String userName;
	private Date boardCommentDate;
	
	public int getBoardCommentNumber() {
		return boardCommentNumber;
	}
	public void setBoardCommentNumber(int boardCommentNumber) {
		this.boardCommentNumber = boardCommentNumber;
	}
	public int getBoardNumber() {
		return boardNumber;
	}
	public void setBoardNumber(int boardNumber) {
		this.boardNumber = boardNumber;
	}
	public String getBoardComment() {
		return boardComment;
	}
	public void setBoardComment(String boardComment) {
		this.boardComment = boardComment;
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
	public Date getBoardCommentDate() {
		return boardCommentDate;
	}
	public void setBoardCommentDate(Date boardCommentDate) {
		this.boardCommentDate = boardCommentDate;
	}

	
}
