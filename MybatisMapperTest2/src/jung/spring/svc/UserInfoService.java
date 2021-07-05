package jung.spring.svc;

import java.util.List;
import jung.spring.vo.AlarmInfoVO;
import jung.spring.vo.BoardInfoVO;
import jung.spring.vo.BoardJoinUserInfoVO;
import jung.spring.vo.ChatInfoVO;
import jung.spring.vo.NoticeInfoVO;
import jung.spring.vo.PostingInfoVO;
import jung.spring.vo.PostingRecommandInfoVO;
import jung.spring.vo.QnaInfoVO;
import jung.spring.vo.UserIdPasswordVO;
import jung.spring.vo.UserInfoPasswordVO;
import jung.spring.vo.UserInfoVO;

public interface UserInfoService {

	boolean selectUserInfo(String user_password, String user_id);
	UserInfoVO getUserInfo(UserIdPasswordVO userIdPassword);
	List<PostingInfoVO> getPostings(); // ������ ��������
	
	List<UserInfoVO> getMembers();

	void addUserInfo(UserInfoVO userInfo);
	
	/* ���̵� ã�� */
	boolean checkUserEmail(String user_name, int user_phone);
	UserInfoVO selectUserId(String user_name, int user_phone);
	/* ���̵� ã�� */
	
	/* ��й�ȣ  ã�� */
	boolean selectUserPassword(String user_id, String user_name, int user_phone);
	UserInfoVO selectUserPassword(String user_id);
	void modifyUserPassword(String user_id, String user_password);
	/* ��й�ȣ  ã�� */
	
	void addUserPosting(PostingInfoVO postingInfo);
	PostingInfoVO addUserPostingInfo(String user_id, String user_name, String postingContent);
	
	PostingInfoVO getUserPostingInfo(String user_id, int postingNumber);
	void updateUserPostingInfo(String user_id, String postingContent, String user_name, int postingNumber, int postingRecommandCount);
	
	void deleteUserPostingInfo(String user_id, String postingContent, String user_name, int postingNumber, int postingRecommandCount);
	
	void createUserPostingRecommand(String user_id, int postingNumber);
	UserInfoVO getUserInfoRecommand(String user_id);
	
	List<NoticeInfoVO> getNotices();
	
	void addNotice(String noticeWriter, String noticeTitle, String noticeContent);
	
	NoticeInfoVO getNotice(int noticeNumber);
	
	void modifyNotice(String noticeWriter, int noticeNumber, String noticeContent);
	
	void deleteNotice(int noticeNumber);
	
	UserInfoVO getUser(String user_id); //���̵� �´� ȸ������ ��������
	
	void modifyNoticeReadCount(int noticeNumber);
	
	List<BoardInfoVO> getBoards();

	List<BoardInfoVO> getBoardOthers(String subject);
	
	void addBoard(String boardWriter, String boardTitle, String boardContent, String selectBoard, String user_id);
	
	BoardInfoVO getboard(int boardNumber);
	
	void sendBoardJoin(BoardInfoVO boardInfo, UserInfoVO userInfo);
	
	List<BoardJoinUserInfoVO> getBoardJoinUsers();
	
	BoardJoinUserInfoVO getBoardJoinUser(int boardNumber, String user_id);
	
	void sendCancelBoardJoin(BoardJoinUserInfoVO boardJoinUserInfo);
	
	void modifyBoardJoinUserInfo(BoardJoinUserInfoVO boardJoinUserInfo);
	
	void modifyBoardJoinUserNumber(BoardInfoVO boardInfo);
	
	void deleteBoardJoinUserInfo(BoardJoinUserInfoVO boardJoinUserInfo);
	
	void modifyBoard(String user_id, int boardNumber, String boardTitle, String boardContent);
	
	void deleteBoard(UserInfoVO userInfo, BoardInfoVO boardInfo);
	
	void addChat(String user_id, int boardNumber, String content);
	
	List<ChatInfoVO> getChats(int boardNumber);
	
	void chatJoin(int boardNumber, String user_id, boolean chatJoinCheck);
	
	List<BoardJoinUserInfoVO> getJoinUsers(int boardNumber);
	
	void addFavoriteBoard(String user_id, int boardNumber);
	
	void modifyFavoriteBoard(String user_id, int boardNumber);
	
	List<BoardInfoVO> getUserBoard(String user_id);
	
	void modifyUserInfo(String user_name, String user_detailAddress, String user_email, int user_phone, String user_id);
	
	List<PostingInfoVO> getPostingRecommands(String user_id);
	
	void deletePosting(String user_id, int postingNumber);
	
	void deleteMypageBoard(int boardNumber);
	
	void userSecession(String user_id);
	
	List<QnaInfoVO> getQnas(String user_id);
	
	void addQna(String user_id, String qnaTitle, String qnaContent);
	
	void deleteQna(int qnaNumber);
	
	QnaInfoVO getQna(int qnaNumber);
	
	void qnaModify(String user_id, int qnaNumber, String qnaTitle, String qnaContent);
	
	void adminDeletePosting(int postingNumber);
	
	void adminBoardDelete(int boardNumber);
	
	List<QnaInfoVO> getQnaInfos();
	
	void modifyQnaComment(String qna_id, int qnaNumber, String qnaComment);
	
	void userBoardOut(String boardJoinUser_id, int boardNumber);
	
	void boardJoinUserNumberDown(int boardNumber);
	
	String getSearchBoard(String searchText);
	
	List<BoardInfoVO> getSearchBoards(String searchBoardList);
	
	void addAlarmPosting(String user_id, int postingNumber);
	
	List<AlarmInfoVO> getAlarms();
	
	void addAlarmBoard(BoardInfoVO boardInfo, UserInfoVO userInfo);
	
	void addAlarmBoardJoinSuccess(String user_id, BoardJoinUserInfoVO boardJoinUserInfo, int boardNumber);
	
	void addAlarmBoardJoinFail(String user_id, BoardJoinUserInfoVO boardJoinUserInfo, int boardNumber);
	
	void addAlarmBoardOut(String user_id, BoardJoinUserInfoVO boardJoinUserInfo, int boardNumber);
	
	void addAlarmQnaComment(String qna_id, int qnaNumber);
	
	void addAlarmBoardDelete(String user_id, int boardNumber);
	
	void addAlarmQna(String user_id, String qnaTitle, String qnaContent);
	
	PostingRecommandInfoVO getPosting(String user_id, int postingNumber);
	
}