package jung.spring.vo;

public class BoardJoinUserInfoVO {
	private int boardJoinNumber;
	private String boardJoinUser_id;
	private String boardJoinUser_name;
	private int boardNumber;
	private int boardJoinUserCheck;
	private int chatJoinCheck;
	
	public int getBoardJoinNumber() {
		return boardJoinNumber;
	}
	public void setBoardJoinNumber(int boardJoinNumber) {
		this.boardJoinNumber = boardJoinNumber;
	}
	public String getBoardJoinUser_id() {
		return boardJoinUser_id;
	}
	public void setBoardJoinUser_id(String boardJoinUser_id) {
		this.boardJoinUser_id = boardJoinUser_id;
	}
	public String getBoardJoinUser_name() {
		return boardJoinUser_name;
	}
	public void setBoardJoinUser_name(String boardJoinUser_name) {
		this.boardJoinUser_name = boardJoinUser_name;
	}
	public int getBoardNumber() {
		return boardNumber;
	}
	public void setBoardNumber(int boardNumber) {
		this.boardNumber = boardNumber;
	}
	public int getBoardJoinUserCheck() {
		return boardJoinUserCheck;
	}
	public void setBoardJoinUserCheck(int boardJoinUserCheck) {
		this.boardJoinUserCheck = boardJoinUserCheck;
	}
	public int getChatJoinCheck() {
		return chatJoinCheck;
	}
	public void setChatJoinCheck(int chatJoinCheck) {
		this.chatJoinCheck = chatJoinCheck;
	}
}
