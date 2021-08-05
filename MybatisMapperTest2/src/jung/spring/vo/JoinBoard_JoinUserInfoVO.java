package jung.spring.vo;

public class JoinBoard_JoinUserInfoVO {
	private int joinBoard_number;
	private int joinBoard_boardNumber;
	private String joinBoard_userId;
	private int verified;
	
	public int getJoinBoard_number() {
		return joinBoard_number;
	}
	public void setJoinBoard_number(int joinBoard_number) {
		this.joinBoard_number = joinBoard_number;
	}
	public int getJoinBoard_boardNumber() {
		return joinBoard_boardNumber;
	}
	public void setJoinBoard_boardNumber(int joinBoard_boardNumber) {
		this.joinBoard_boardNumber = joinBoard_boardNumber;
	}
	public String getJoinBoard_userId() {
		return joinBoard_userId;
	}
	public void setJoinBoard_userId(String joinBoard_userId) {
		this.joinBoard_userId = joinBoard_userId;
	}
	public int getVerified() {
		return verified;
	}
	public void setVerified(int verified) {
		this.verified = verified;
	}
}
