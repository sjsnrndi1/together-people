package jung.spring.mybatis;

import java.util.ArrayList;
import java.util.HashMap;

import jung.spring.vo.JoinBoard_JoinUserInfoVO;

public interface JoinBoard_JoinUserMapper {

	void addJoinBoard_joinUser(HashMap<Object, Object> map); // �����Խñ� �����ο� ���� and ���� ��û

	ArrayList<JoinBoard_JoinUserInfoVO> getJoinBoard_joinUsers(int joinBoardNumber); // �����Խñ� �����ο� ��� ��������

	void deleteJoinBoard_joinUser(HashMap<Object, Object> map); // �� �� �����ο� ����

	ArrayList<JoinBoard_JoinUserInfoVO> getJoinBoard_joinUserList(); //������û�� �ο� ��� ��������

	void updateJoinUserAccept(int joinNumber); //�����Խñ� ����

	int selectJoinVerifieds(int joinBoardNumber); //������ �Խñ� ��ȣ�� �´� �ο� �� ��������

	void updateJoinUserRefuse(int joinNumber); //�����Խñ� ����

}