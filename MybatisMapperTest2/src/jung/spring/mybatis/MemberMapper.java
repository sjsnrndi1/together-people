package jung.spring.mybatis;

import java.util.ArrayList;
import java.util.HashMap;

import jung.spring.vo.UserIdPasswordVO;
import jung.spring.vo.UserInfoPasswordVO;
import jung.spring.vo.UserInfoVO;

public interface MemberMapper {

	ArrayList<UserInfoVO> getMembers(); // 회원정보 가져오기
	
	boolean addMember(HashMap<Object, Object> map); // 회원가입
	
	UserInfoVO selectUserId(HashMap<Object, Object> map); // 아이디 찾기
	
	UserInfoVO selectUserPassword(String user_id);
	
	UserInfoVO selectUserPasswordModify(HashMap<Object, Object> map); //비밀번호 찾기
	
	void modifyPassword(HashMap<Object, Object> map);
	
	String selectUserIdInfo(UserIdPasswordVO userIdPassword);
	
	String selectUserPasswordInfo(String user_id);
	
	UserInfoVO selectUserInfo(UserIdPasswordVO userIdPassword);

	UserInfoVO selectUserInfoRecommand(String user_id);

	UserInfoVO getUser(String user_id);

	void modifyUserReport(UserInfoVO user);

	void modifyUserInfo(UserInfoVO userInfo);

	void userSecession(String user_id);

	UserInfoVO selectUserNamePhone(UserInfoVO userInfo);
}