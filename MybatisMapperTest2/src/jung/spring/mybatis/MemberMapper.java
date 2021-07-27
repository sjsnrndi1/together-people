package jung.spring.mybatis;

import java.util.ArrayList;
import java.util.HashMap;
import jung.spring.vo.UserInfoVO;

public interface MemberMapper {

	UserInfoVO getUser(String user_id); // ����� ��������
	
	ArrayList<UserInfoVO> getMembers(); // ȸ������ ��������
	
	void addMember(HashMap<Object, Object> map); // ȸ������
	
	UserInfoVO selectUserNamePhone(UserInfoVO userInfo); // �̸��� ������ ����� ã��
	
	UserInfoVO selectUserId(HashMap<Object, Object> map); // ���̵� ã��
	
	UserInfoVO selectUserPassword(String user_id); // ��й�ȣ ã��
	
	UserInfoVO selectUserPasswordModify(HashMap<Object, Object> map); //��й�ȣ ���� ��
	
	void modifyPassword(HashMap<Object, Object> map); // ��й�ȣ ����

}