package jung.spring.mybatis;

import java.util.ArrayList;
import java.util.HashMap;

import jung.spring.vo.JoinBoardInfoVO;

public interface JoinBoardMapper {

	void addJoinBoard(HashMap<Object, Object> map); //참여게시글 생성

	ArrayList<JoinBoardInfoVO> getJoinBoards(); //참여게시글 목록 가져오기

	JoinBoardInfoVO getJoinBoard(int joinBoardNumber); //참여게시글 보기

	ArrayList<JoinBoardInfoVO> getJoinBoardSorts(String subject); //참여게시글 정렬

	void deleteJoinBoard(HashMap<Object, Object> map); //내 글 삭제

}