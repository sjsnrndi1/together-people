package jung.spring.mybatis;

import java.util.ArrayList;

import jung.spring.vo.BoardInfoVO;

public interface BoardMapper {

	ArrayList<BoardInfoVO> getBoards(); // 게시글 목록 가져오기

	ArrayList<BoardInfoVO> getBoard(int boardNumber); // 게시글 보기

}