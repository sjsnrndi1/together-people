package jung.spring.vo;

import java.util.Date;

public class JoinBoardInfoVO {
	private int joinBoardNumber;
	private String joinBoardUserId;
	private String joinBoardTitle;
	private String joinBoardWriter;
	private String joinBoardContent;
	private Date joinBoardDate;
	private String joinBoardSubject;
	private int joinBoard_joinUserNumber;
	
	public int getJoinBoardNumber() {
		return joinBoardNumber;
	}
	public void setJoinBoardNumber(int joinBoardNumber) {
		this.joinBoardNumber = joinBoardNumber;
	}
	public String getJoinBoardUserId() {
		return joinBoardUserId;
	}
	public void setJoinBoardUserId(String joinBoardUserId) {
		this.joinBoardUserId = joinBoardUserId;
	}
	public String getJoinBoardTitle() {
		return joinBoardTitle;
	}
	public void setJoinBoardTitle(String joinBoardTitle) {
		this.joinBoardTitle = joinBoardTitle;
	}
	public String getJoinBoardWriter() {
		return joinBoardWriter;
	}
	public void setJoinBoardWriter(String joinBoardWriter) {
		this.joinBoardWriter = joinBoardWriter;
	}
	public String getJoinBoardContent() {
		return joinBoardContent;
	}
	public void setJoinBoardContent(String joinBoardContent) {
		this.joinBoardContent = joinBoardContent;
	}
	public Date getJoinBoardDate() {
		return joinBoardDate;
	}
	public void setJoinBoardDate(Date joinBoardDate) {
		this.joinBoardDate = joinBoardDate;
	}
	public String getJoinBoardSubject() {
		return joinBoardSubject;
	}
	public void setJoinBoardSubject(String joinBoardSubject) {
		this.joinBoardSubject = joinBoardSubject;
	}
	public int getJoinBoard_joinUserNumber() {
		return joinBoard_joinUserNumber;
	}
	public void setJoinBoard_joinUserNumber(int joinBoard_joinUserNumber) {
		this.joinBoard_joinUserNumber = joinBoard_joinUserNumber;
	}
}
