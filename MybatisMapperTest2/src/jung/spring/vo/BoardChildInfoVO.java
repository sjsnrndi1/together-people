package jung.spring.vo;

public class BoardChildInfoVO {
	private int boardChildNumber;
	private int boardNumber;
	private int boardSympathy;
	private String boardComment;
	private String userId;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getBoardChildNumber() {
		return boardChildNumber;
	}
	public void setBoardChildNumber(int boardChildNumber) {
		this.boardChildNumber = boardChildNumber;
	}
	public int getBoardNumber() {
		return boardNumber;
	}
	public void setBoardNumber(int boardNumber) {
		this.boardNumber = boardNumber;
	}
	public int getBoardSympathy() {
		return boardSympathy;
	}
	public void setBoardSympathy(int boardSympathy) {
		this.boardSympathy = boardSympathy;
	}
	public String getBoardComment() {
		return boardComment;
	}
	public void setBoardComment(String boardComment) {
		this.boardComment = boardComment;
	}
	
}
