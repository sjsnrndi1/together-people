package jung.spring.vo;

public class BoardSympathyInfoVO {
	private int boardSympathyNumber;
	private int boardNumber;
	private int boardSympathy;
	private String userId;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getBoardSympathyNumber() {
		return boardSympathyNumber;
	}
	public void setBoardSympathyNumber(int boardSympathyNumber) {
		this.boardSympathyNumber = boardSympathyNumber;
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
	
}
