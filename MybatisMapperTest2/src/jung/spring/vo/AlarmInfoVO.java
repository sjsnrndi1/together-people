package jung.spring.vo;

import java.util.Date;

public class AlarmInfoVO {
	private int alarmNumber;
	private String alarmContent;
	private String alarmMyId;
	private String alarmYouId;
	private Date alarmDate;
	
	public int getAlarmNumber() {
		return alarmNumber;
	}
	public void setAlarmNumber(int alarmNumber) {
		this.alarmNumber = alarmNumber;
	}
	public String getAlarmContent() {
		return alarmContent;
	}
	public void setAlarmContent(String alarmContent) {
		this.alarmContent = alarmContent;
	}
	public String getAlarmMyId() {
		return alarmMyId;
	}
	public void setAlarmMyId(String alarmMyId) {
		this.alarmMyId = alarmMyId;
	}
	public String getAlarmYouId() {
		return alarmYouId;
	}
	public void setAlarmYouId(String alarmYouId) {
		this.alarmYouId = alarmYouId;
	}
	public Date getAlarmDate() {
		return alarmDate;
	}
	public void setAlarmDate(Date alarmDate) {
		this.alarmDate = alarmDate;
	}
}
