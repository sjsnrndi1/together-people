package jung.spring.mybatis;

import java.util.ArrayList;
import java.util.HashMap;

import jung.spring.vo.BoardInfoVO;

public interface BoardMapper {

	ArrayList<BoardInfoVO> getBoards(); // �Խñ� ��� ��������

	ArrayList<BoardInfoVO> getBoard(int boardNumber); // �Խñ� ����

	void countBoardViews(HashMap<Object, Object> map); //�Խñ� ��ȸ �� ��

	void addBoard(HashMap<Object, Object> map); //�Խñ� ����

}