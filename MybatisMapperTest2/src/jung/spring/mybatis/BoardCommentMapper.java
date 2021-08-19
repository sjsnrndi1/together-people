package jung.spring.mybatis;

import java.util.ArrayList;
import java.util.HashMap;

import jung.spring.vo.BoardCommentInfoVO;

public interface BoardCommentMapper {

	void addBoardComment(HashMap<Object, Object> map); // 게시글 댓글 생성

	ArrayList<BoardCommentInfoVO> getBoardComments(int boardNumber); //사용자 댓글 목록 가져오기

	void deleteBoardComment(int boardCommentNumber); //사용자 댓글 삭제

	ArrayList<BoardCommentInfoVO> getBoardCommentList(); //댓글 목록 가져오기

}