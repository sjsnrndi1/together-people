package jung.spring.vo;

public class BoardCommentInfoVO {
	private int boardCommentNumber;
	private int boardNumber;
	private String boardComment;
	private String userId;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getBoardCommentNumber() {
		return boardCommentNumber;
	}
	public void setBoardSympathyNumber(int boardCommentNumber) {
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
	
}
