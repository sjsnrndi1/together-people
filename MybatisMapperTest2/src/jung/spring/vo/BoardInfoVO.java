package jung.spring.vo;

import java.util.Date;

public class BoardInfoVO {
	private int boardRegistNumber;
	private int boardNumber;
	private String boardUserId;
	private String boardTitle;
	private String boardWriter;
	private String boardContent;
	private Date boardDate;
	private int boardJoinUserNumber;
	private String boardSubject;
	private String boardFavorites;
	private String boardJoins;
	
	public int getBoardRegistNumber() {
		return boardRegistNumber;
	}
	public void setBoardRegistNumber(int boardRegistNumber) {
		this.boardRegistNumber = boardRegistNumber;
	}
	public int getBoardNumber() {
		return boardNumber;
	}
	public void setBoardNumber(int boardNumber) {
		this.boardNumber = boardNumber;
	}
	public String getBoardUserId() {
		return boardUserId;
	}
	public void setBoardUserId(String boardUserId) {
		this.boardUserId = boardUserId;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public String getBoardWriter() {
		return boardWriter;
	}
	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	public Date getBoardDate() {
		return boardDate;
	}
	public void setBoardDate(Date boardDate) {
		this.boardDate = boardDate;
	}
	public int getBoardJoinUserNumber() {
		return boardJoinUserNumber;
	}
	public void setBoardJoinUserNumber(int boardJoinUserNumber) {
		this.boardJoinUserNumber = boardJoinUserNumber;
	}
	public String getBoardSubject() {
		return boardSubject;
	}
	public void setBoardSubject(String boardSubject) {
		this.boardSubject = boardSubject;
	}
	public String getBoardFavorites() {
		return boardFavorites;
	}
	public void setBoardFavorites(String boardFavorites) {
		this.boardFavorites = boardFavorites;
	}
	public String getBoardJoins() {
		return boardJoins;
	}
	public void setBoardJoins(String boardJoins) {
		this.boardJoins = boardJoins;
	}
}
