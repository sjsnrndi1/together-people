package jung.spring.mybatis;

import java.util.ArrayList;
import java.util.HashMap;

import jung.spring.vo.BoardInfoVO;
import jung.spring.vo.TestBean;

public interface BoardMapper {

	ArrayList<BoardInfoVO> getBoards(); // �Խñ� ��� ��������

	BoardInfoVO getBoard(int boardNumber); // �Խñ� ����

	void countBoardViews(HashMap<Object, Object> map); //�Խñ� ��ȸ �� ��

	void addBoard(HashMap<Object, Object> map); //�Խñ� ����
	
	ArrayList<BoardInfoVO> getBoardNumberSort(); // �Խñ� ��ȣ ����
	
	ArrayList<BoardInfoVO> getBoardTitleSort(); // �Խñ� ���� ����
	
	ArrayList<BoardInfoVO> getBoardWriterSort(); // �Խñ� �ۼ��� ����
	
	ArrayList<BoardInfoVO> getBoardDateSort(); // �Խñ� �ۼ��� ����

	ArrayList<BoardInfoVO> getBoardReadSort(); //�Խñ� ��ȸ�� ����

	ArrayList<BoardInfoVO> getMyBoards(String name); // �� ��� �� �� ��������

}