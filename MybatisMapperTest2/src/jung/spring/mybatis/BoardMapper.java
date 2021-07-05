package jung.spring.mybatis;

import java.util.ArrayList;
import java.util.List;

import jung.spring.vo.BoardInfoVO;

public interface BoardMapper {

	ArrayList<BoardInfoVO> getBoards();

	ArrayList<BoardInfoVO> getBoardOthers(BoardInfoVO boardInfo);

	void addBoard(BoardInfoVO boardRegist);

	BoardInfoVO getboard(int boardNumber);

	void modifyBoardJoinUserNumber(BoardInfoVO boardInfo);

	void modifyBoard(BoardInfoVO board);

	void deleteBoard(int boardNumber);

	List<BoardInfoVO> getMakeBoard(String user_id);

	void modifyFavoriteBoard(BoardInfoVO board);

	void userSecession(String boardUserId);

	void adminBoardDelete(int boardNumber);

	void modifyBoardNumber(BoardInfoVO board);

	void boardJoinUserNumberDown(BoardInfoVO boardInfo);

	void modifyJoinBoard(BoardInfoVO board);

}