package jung.spring.mybatis;

import java.util.ArrayList;

import jung.spring.vo.BoardJoinUserInfoVO;

public interface BoardJoinUserMapper {

	void sendBoardJoin(BoardJoinUserInfoVO boardJoinUserInfoVO);

	ArrayList<BoardJoinUserInfoVO> getBoardJoinUsers();

	BoardJoinUserInfoVO getBoardJoinUser(BoardJoinUserInfoVO boardJoin);

	void sendCancelBoardJoin(BoardJoinUserInfoVO boardJoinUserInfoVO);

	void modifyBoardJoinUserInfo(BoardJoinUserInfoVO boardJoinUserInfo);

	void deleteBoardJoinUserInfo(BoardJoinUserInfoVO boardJoinUserInfo);

	void deleteBoard(int boardNumber);

	void modifyBoardJoinUser(BoardJoinUserInfoVO boardJoin);

	ArrayList<BoardJoinUserInfoVO> getJoinUsers(BoardJoinUserInfoVO boardJoinUserInfo);

	BoardJoinUserInfoVO getJoinUser(int boardJoinNumber);

	void modifyJoinUser(BoardJoinUserInfoVO boardJoinUserInfo);

	void deleteBoardJoinUser(BoardJoinUserInfoVO boardTemp);

	void userSecession(String boardJoinUser_id);

	void deleteUserBoardOut(BoardJoinUserInfoVO boardJoinUserInfo);

	void modifyFavoriteBoard(BoardJoinUserInfoVO boardJoinUserInfo);

	void modifyBoardJoinUserCheck(BoardJoinUserInfoVO boardJoinUserInfo);

}