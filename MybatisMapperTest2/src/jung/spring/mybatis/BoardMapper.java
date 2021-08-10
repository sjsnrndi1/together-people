package jung.spring.mybatis;

import java.util.ArrayList;
import java.util.HashMap;

import jung.spring.vo.BoardInfoVO;
import jung.spring.vo.TestBean;

public interface BoardMapper {

	ArrayList<BoardInfoVO> getBoards(); // 게시글 목록 가져오기

	BoardInfoVO getBoard(int boardNumber); // 게시글 보기

	void countBoardViews(HashMap<Object, Object> map); //게시글 조회 수 업

	void addBoard(HashMap<Object, Object> map); //게시글 생성
	
	ArrayList<BoardInfoVO> getBoardNumberSort(); // 게시글 번호 정렬
	
	ArrayList<BoardInfoVO> getBoardTitleSort(); // 게시글 제목 정렬
	
	ArrayList<BoardInfoVO> getBoardWriterSort(); // 게시글 작성자 정렬
	
	ArrayList<BoardInfoVO> getBoardDateSort(); // 게시글 작성자 정렬

	ArrayList<BoardInfoVO> getBoardReadSort(); //게시글 조회수 정렬

	ArrayList<BoardInfoVO> getMyBoards(String name); // 글 목록 내 글 가져오기

}