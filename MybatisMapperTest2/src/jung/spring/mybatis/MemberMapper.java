package jung.spring.mybatis;

import java.util.ArrayList;
import java.util.HashMap;
import jung.spring.vo.UserInfoVO;

public interface MemberMapper {

	UserInfoVO getUser(String user_id); // 사용자 가져오기
	
	ArrayList<UserInfoVO> getMembers(); // 회원정보 가져오기
	
	void addMember(HashMap<Object, Object> map); // 회원가입
	
	UserInfoVO selectUserNamePhone(UserInfoVO userInfo); // 이름과 폰으로 사용자 찾기
	
	UserInfoVO selectUserId(HashMap<Object, Object> map); // 아이디 찾기
	
	UserInfoVO selectUserPassword(String user_id); // 비밀번호 찾기
	
	UserInfoVO selectUserPasswordModify(HashMap<Object, Object> map); //비밀번호 변경 중
	
	void modifyPassword(HashMap<Object, Object> map); // 비밀번호 변경

}