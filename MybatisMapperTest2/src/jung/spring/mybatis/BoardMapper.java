package jung.spring.mybatis;

import java.util.ArrayList;

import jung.spring.vo.BoardInfoVO;

public interface BoardMapper {

	ArrayList<BoardInfoVO> getBoards(); // �Խñ� ��� ��������

	ArrayList<BoardInfoVO> getBoard(int boardNumber); // �Խñ� ����

}