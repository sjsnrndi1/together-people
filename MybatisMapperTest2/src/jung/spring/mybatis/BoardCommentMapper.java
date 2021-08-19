package jung.spring.mybatis;

import java.util.ArrayList;
import java.util.HashMap;

import jung.spring.vo.BoardCommentInfoVO;

public interface BoardCommentMapper {

	void addBoardComment(HashMap<Object, Object> map); // �Խñ� ��� ����

	ArrayList<BoardCommentInfoVO> getBoardComments(int boardNumber); //����� ��� ��� ��������

	void deleteBoardComment(int boardCommentNumber); //����� ��� ����

	ArrayList<BoardCommentInfoVO> getBoardCommentList(); //��� ��� ��������

}