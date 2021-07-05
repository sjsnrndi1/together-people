package jung.spring.vo;

import java.util.Date;

public class NoticeInfoVO {
	private int noticeRegistNumber;
	private int noticeNumber;
	private String noticeTitle;
	private String noticeWriter;
	private String noticeContent;
	private Date noticeDate;
	private int noticeReadCount;
	
	public int getNoticeRegistNumber() {
		return noticeRegistNumber;
	}
	public void setNoticeRegistNumber(int noticeRegistNumber) {
		this.noticeRegistNumber = noticeRegistNumber;
	}
	public int getNoticeNumber() {
		return noticeNumber;
	}
	public void setNoticeNumber(int noticeNumber) {
		this.noticeNumber = noticeNumber;
	}
	public String getNoticeTitle() {
		return noticeTitle;
	}
	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}
	public String getNoticeWriter() {
		return noticeWriter;
	}
	public void setNoticeWriter(String noticeWriter) {
		this.noticeWriter = noticeWriter;
	}
	public String getNoticeContent() {
		return noticeContent;
	}
	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}
	public Date getNoticeDate() {
		return noticeDate;
	}
	public void setNoticeDate(Date noticeDate) {
		this.noticeDate = noticeDate;
	}
	public int getNoticeReadCount() {
		return noticeReadCount;
	}
	public void setNoticeReadCount(int noticeReadCount) {
		this.noticeReadCount = noticeReadCount;
	}
}
