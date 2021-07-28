package jung.spring.mybatis;

import java.util.ArrayList;
import java.util.HashMap;

import jung.spring.vo.BoardInfoVO;

public interface BoardMapper {

	ArrayList<BoardInfoVO> getBoards(); // 게시글 목록 가져오기

	ArrayList<BoardInfoVO> getBoard(int boardNumber); // 게시글 보기

	void countBoardViews(HashMap<Object, Object> map); //게시글 조회 수 업

	void addBoard(HashMap<Object, Object> map); //게시글 생성

}