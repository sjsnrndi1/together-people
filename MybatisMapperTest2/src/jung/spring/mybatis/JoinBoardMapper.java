package jung.spring.mybatis;

import java.util.ArrayList;
import java.util.HashMap;

import jung.spring.vo.JoinBoardInfoVO;

public interface JoinBoardMapper {

	void addJoinBoard(HashMap<Object, Object> map); //�����Խñ� ����

	ArrayList<JoinBoardInfoVO> getJoinBoards(); //�����Խñ� ��� ��������

	JoinBoardInfoVO getJoinBoard(int joinBoardNumber); //�����Խñ� ����

}