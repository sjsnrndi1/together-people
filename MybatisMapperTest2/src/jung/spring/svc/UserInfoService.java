package jung.spring.svc;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import jung.spring.vo.AlarmInfoVO;
import jung.spring.vo.BoardInfoVO;
import jung.spring.vo.BoardJoinUserInfoVO;
import jung.spring.vo.ChatInfoVO;
import jung.spring.vo.NoticeInfoVO;
import jung.spring.vo.PopupChatInfoVO;
import jung.spring.vo.PostingInfoVO;
import jung.spring.vo.PostingRecommandInfoVO;
import jung.spring.vo.QnaInfoVO;
import jung.spring.vo.UserIdPasswordVO;
import jung.spring.vo.UserInfoVO;

public interface UserInfoService {

	boolean selectUserInfo(String user_password, String user_id);
	UserInfoVO getUserInfo(UserIdPasswordVO userIdPassword);
	
	/********** 회원정보 **********/
	void addUserInfo(HashMap<Object, Object> map); //회원가입
	List<UserInfoVO> getMembers(); //회원 목록 가져오기
	boolean checkUserEmail(String user_name, int user_phone); //이메일 확인
	UserInfoVO selectUserId(String user_name, int user_phone); //아이디 찾기
	boolean selectUserPassword(String user_id, String user_name, int user_phone); //비밀번호 찾기 확인
	UserInfoVO selectUserPassword(String user_id); //비밀번호 찾기
	void modifyUserPassword(String user_id, String user_password); //비밀번호 변경
	/********** 회원정보 **********/
	
	/********** 포스팅 **********/
	List<PostingInfoVO> getPostings(); //포스팅 목록 가져오기
	void addPosting(String content_title, String content_content, File content_picture, UserInfoVO userInfo); //포스팅 등록
	String getLastPostingNumber(); //포스팅 마지막번호 가져오기
	void deletePostingFail(String postingNumber); //등록 실패지 포스팅 삭제
	/********** 포스팅 **********/
	
	/********** 팝업창 **********/
	void addUserPopup(String user_id); // 사용자 별 팝업 창 생성
	int getPopupNumber(String user_id); // 사용자에 맞는 톡 번호 가져오기
	List<PopupChatInfoVO> getPopupChats(int popupNumber); // 사용자 팝업 채팅 내용 가져오기
	void addPopupUserChat(String user_id, int popupNumber, String user_chat); // 사용자 팝업 채팅 내용 입력
	/********** 팝업창 **********/
	
	
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
	
	UserInfoVO getUser(String user_id); //아이디에 맞는 회원정보 가져오기
	
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