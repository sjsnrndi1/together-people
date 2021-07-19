package jung.spring.svc;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jung.spring.dao.UserInfoDAO;
import jung.spring.vo.AlarmInfoVO;
import jung.spring.vo.BoardInfoVO;
import jung.spring.vo.BoardJoinUserInfoVO;
import jung.spring.vo.ChatInfoVO;
import jung.spring.vo.NoticeInfoVO;
import jung.spring.vo.PostingInfoVO;
import jung.spring.vo.PostingRecommandInfoVO;
import jung.spring.vo.QnaInfoVO;
import jung.spring.vo.UserIdPasswordVO;
import jung.spring.vo.UserInfoVO;

@Service
public class UserInfoServiceImpl implements UserInfoService {
	
	@Autowired
	private UserInfoDAO userInfoDAO;
	
	/*===========로그인 하는 서비스============*/
	@Override
	public boolean selectUserInfo(String user_password, String user_id) {
		// TODO Auto-generated method stub
		boolean userInfoCheck = userInfoDAO.selectUserInfo(user_password, user_id);
		return userInfoCheck;
	}
	
	@Override
	public UserInfoVO getUserInfo(UserIdPasswordVO userIdPassword) {
		// TODO Auto-generated method stub
		UserInfoVO userInfo = userInfoDAO.getUserInfo(userIdPassword);
		return userInfo;
	}
	
	@Override
	public List<PostingInfoVO> getPostings() {
		// TODO Auto-generated method stub
		ArrayList<PostingInfoVO> postingList = userInfoDAO.getPostings();
		return postingList;
	}
	/*===========로그인 하는 서비스============*/
	
	/*=========== 메인 화면 서비스============*/
	@Override
	public UserInfoVO getUser(String user_id) {
		// TODO Auto-generated method stub
		UserInfoVO userInfo = userInfoDAO.getUser(user_id);
		return userInfo;
	}
	/*=========== 메인 화면 서비스============*/
	
	/*===========유저 정보 리스트 가져오는 서비스============*/
	@Override
	public List<UserInfoVO> getMembers(){
		// TODO Auto-generated method stub
		ArrayList<UserInfoVO> userList = userInfoDAO.getMembers();
		return userList;
	}
	/*===========유저 정보 리스트 가져오는 서비스============*/
	
	/*===========유저 정보 저장하는 서비스============*/
	@Override
	public boolean addUserInfo(HashMap<Object, Object> map) {
		boolean check = userInfoDAO.addUser(map);
		return check;
	}
	/*===========유저 정보 저장하는 서비스============*/
	
	/*===========유저 id 찾는 서비스============*/
	@Override
	public boolean checkUserEmail(String user_name, int user_phone) {
		// TODO Auto-generated method stub
		boolean idCheck = userInfoDAO.checkUserEmail(user_name, user_phone);
		return idCheck;
	}

	@Override
	public UserInfoVO selectUserId(String user_name, int user_phone) {
		// TODO Auto-generated method stub
		UserInfoVO userInfo = userInfoDAO.selectUserId(user_name, user_phone);
		return userInfo;
	}
	/*===========유저 id 찾는 서비스============*/
	
	/*===========유저 pw 찾는 서비스============*/
	@Override
	public UserInfoVO selectUserPassword(String user_id) {
		// TODO Auto-generated method stub
		UserInfoVO userInfo = userInfoDAO.selectUserPassword(user_id);
		return userInfo;
	}
	
	@Override
	public boolean selectUserPassword(String user_id, String user_name, int user_phone) {
		// TODO Auto-generated method stub
		boolean pwCheck = userInfoDAO.selectUserPassword(user_id, user_name, user_phone);
		return pwCheck;
	}
	
	@Override
	public void modifyUserPassword(String user_id, String user_password) {
		// TODO Auto-generated method stub
		userInfoDAO.modifyPassword(user_id, user_password);
	}
	/*===========유저 pw 찾는 서비스============*/
		
	/*===========유저 포스팅 등록하는 서비스============*/
	@Override
	public void addPosting(String content_title, String content_content, File content_picture, UserInfoVO user_id) {
		// TODO Auto-generated method stub
		userInfoDAO.addPosting(content_title, content_content, content_picture, user_id);
	}
	
	@Override
	public String getLastPostingNumber() {
		// TODO Auto-generated method stub
		String count = userInfoDAO.getLastPostingNumber();
		return count;
	}
	
	@Override
	public void deletePostingFail(String postingNumber) {
		// TODO Auto-generated method stub
		String posting_Number = postingNumber;
		userInfoDAO.deletePostingFail(posting_Number);
	}
	
	
	
	
	
	
	
	
	
	@Override
	public void addUserPosting(PostingInfoVO postingInfo) {
		// TODO Auto-generated method stub
		userInfoDAO.addUserPosting(postingInfo);
	}
	
	@Override
	public PostingInfoVO addUserPostingInfo(String user_id, String user_name, String postingContent) {
		// TODO Auto-generated method stub
		PostingInfoVO postingInfo = userInfoDAO.addUserPostingInfo(user_id, user_name, postingContent);
		return postingInfo;
	}
	/*===========유저 포스팅 등록하는 서비스============*/
	
	/*===========유저 포스팅 수정하는 서비스============*/
	@Override
	public PostingInfoVO getUserPostingInfo(String user_id, int postingNumber) {
		// TODO Auto-generated method stub
		PostingInfoVO postingInfo = userInfoDAO.getUserPostingInfo(user_id, postingNumber);
		return postingInfo;
	}
	
	@Override
	public void updateUserPostingInfo(String user_id, String postingContent, String user_name, int postingNumber, int postingRecommandCount) {
		// TODO Auto-generated method stub
		userInfoDAO.updatePostingInfo(user_id, postingContent, user_name, postingNumber, postingRecommandCount);
	}
	/*===========유저 포스팅 수정하는 서비스============*/
	
	/*===========유저 포스팅 삭제하는 서비스============*/
	@Override
	public void deleteUserPostingInfo(String user_id, String postingContent, String user_name, int postingNumber, int postingRecommandCount) {
		// TODO Auto-generated method stub
		userInfoDAO.deletePostingInfo(user_id, postingContent, user_name, postingNumber, postingRecommandCount);
	}
	/*===========유저 포스팅 삭제하는 서비스============*/
	
	/*===========유저 포스팅 추천하는 서비스============*/
	@Override
	public void createUserPostingRecommand(String user_id, int postingNumber) {
		// TODO Auto-generated method stub
		userInfoDAO.createUserPostingRecommand(user_id, postingNumber);
	}
	
	@Override
	public UserInfoVO getUserInfoRecommand(String user_id) {
		// TODO Auto-generated method stub
		UserInfoVO userInfo = userInfoDAO.getUserInfoRecommand(user_id);
		return userInfo;
	}
	/*===========유저 포스팅 추천하는 서비스============*/
	
	/*===========공지사항 서비스============*/
	@Override
	public List<NoticeInfoVO> getNotices() {
		// TODO Auto-generated method stub
		ArrayList<NoticeInfoVO> noticeList = userInfoDAO.getNotices();
		return noticeList;
	}
	/*===========공지사항 서비스============*/
	
	/*===========공지사항 등록 서비스============*/
	@Override
	public void addNotice(String noticeWriter, String noticeTitle, String noticeContent) {
		// TODO Auto-generated method stub
		userInfoDAO.addNotice(noticeWriter, noticeTitle, noticeContent);
	}
	/*===========공지사항 등록 서비스============*/
	
	/*===========공지사항 보기 서비스============*/
	@Override
	public NoticeInfoVO getNotice(int noticeNumber) {
		// TODO Auto-generated method stub
		NoticeInfoVO noticeInfo = userInfoDAO.getNotice(noticeNumber);
		return noticeInfo;
	}
	/*===========공지사항 보기 서비스============*/

	/*===========공지사항 수정 서비스============*/
	@Override
	public void modifyNotice(String noticeTitle, int noticeNumber, String noticeContent) {
		// TODO Auto-generated method stub
		userInfoDAO.modifyNotice(noticeTitle, noticeNumber, noticeContent);
	}
	/*===========공지사항 수정 서비스============*/
	
	/*===========공지사항 삭제 서비스============*/
	@Override
	public void deleteNotice(int noticeNumber) {
		// TODO Auto-generated method stub
		userInfoDAO.deleteNotice(noticeNumber);
	}
	/*===========공지사항 삭제 서비스============*/
	
	/*===========공지사항 조회수 서비스============*/
	@Override
	public void modifyNoticeReadCount(int noticeNumber) {
		// TODO Auto-generated method stub
		userInfoDAO.modifyNoticeReadCount(noticeNumber);
	}
	/*===========공지사항 조회수 서비스============*/
	
	/*===========게시판 서비스============*/
	@Override
	public List<BoardInfoVO> getBoards() {
		// TODO Auto-generated method stub
		ArrayList<BoardInfoVO> boardList = userInfoDAO.getBoards();
		return boardList;
	}
	
	@Override
	public List<BoardInfoVO> getBoardOthers(String subject) {
		// TODO Auto-generated method stub
		ArrayList<BoardInfoVO> boardList = userInfoDAO.getBoardOthers(subject);
		return boardList;
	}
	/*===========게시판 서비스============*/
	
	/*===========게시판 등록 서비스============*/
	@Override
	public void addBoard(String boardWriter, String boardTitle, String boardContent, String selectBoard, String user_id) {
		// TODO Auto-generated method stub
		userInfoDAO.addBoard(boardWriter, boardTitle, boardContent, selectBoard, user_id);
	}
	/*===========게시판 등록 서비스============*/
	
	/*===========게시글 보기 서비스============*/
	@Override
	public BoardInfoVO getboard(int boardNumber) {
		// TODO Auto-generated method stub
		BoardInfoVO boardInfo = userInfoDAO.getBoard(boardNumber);
		return boardInfo;
	}
	/*===========게시글 보기 서비스============*/
	
	/*===========게시글 참여 서비스============*/
	@Override
	public void sendBoardJoin(BoardInfoVO boardInfo, UserInfoVO userInfo) {
		// TODO Auto-generated method stub
		userInfoDAO.sendBoardJoin(boardInfo, userInfo);
	}
	
	@Override
	public BoardJoinUserInfoVO getBoardJoinUser(int boardNumber, String user_id) {
		// TODO Auto-generated method stub
		BoardJoinUserInfoVO boardJoinUser = userInfoDAO.getBoardJoinUser(boardNumber, user_id);
		return boardJoinUser;
	}
	/*===========게시글 참여 서비스============*/

	/*===========게시글 참여취소 서비스============*/
	@Override
	public void sendCancelBoardJoin(BoardJoinUserInfoVO boardJoinUserInfo) {
		// TODO Auto-generated method stub
		userInfoDAO.sendCancelBoardJoin(boardJoinUserInfo);
	}
	/*===========게시글 참여취소 서비스============*/
	
	/*===========게시글 참여자 명단 서비스============*/
	@Override
	public List<BoardJoinUserInfoVO> getBoardJoinUsers() {
		// TODO Auto-generated method stub
		ArrayList<BoardJoinUserInfoVO> boardJoinUserList = userInfoDAO.getBoardJoinUsers();
		return boardJoinUserList;
	}
	/*===========게시글 참여자 명단 서비스============*/
	
	/*===========게시글 참여자 수락 서비스============*/
	@Override
	public void modifyBoardJoinUserInfo(BoardJoinUserInfoVO boardJoinUserInfo) {
		// TODO Auto-generated method stub
		userInfoDAO.modifyBoardJoinUserInfo(boardJoinUserInfo);
	}
	
	@Override
	public void modifyBoardJoinUserNumber(BoardInfoVO boardInfo) {
		// TODO Auto-generated method stub
		userInfoDAO.modifyBoardJoinUserNumber(boardInfo);
	}
	/*===========게시글 참여자 수락 서비스============*/
	
	/*===========게시글 참여자 거절 서비스============*/
	@Override
	public void deleteBoardJoinUserInfo(BoardJoinUserInfoVO boardJoinUserInfo) {
		// TODO Auto-generated method stub
		userInfoDAO.deleteBoardJoinUserInfo(boardJoinUserInfo);
	}
	/*===========게시글 참여자 거절 서비스============*/
	
	/*===========게시글 수정 서비스============*/
	@Override
	public void modifyBoard(String user_id, int boardNumber, String boardTitle, String boardContent) {
		// TODO Auto-generated method stub
		userInfoDAO.modifyBoard(user_id, boardNumber, boardTitle, boardContent);
	}
	/*===========게시글 수정 서비스============*/
	
	/*===========게시글 삭제 서비스============*/
	@Override
	public void deleteBoard(UserInfoVO userInfo, BoardInfoVO boardInfo) {
		// TODO Auto-generated method stub
		userInfoDAO.deleteBoard(userInfo, boardInfo);
	}
	/*===========게시글 삭제 서비스============*/
	
	/*===========채팅 서비스============*/
	@Override
	public void chatJoin(int boardNumber, String user_id, boolean chatJoinCheck) {
		// TODO Auto-generated method stub
		userInfoDAO.chatJoin(boardNumber, user_id, chatJoinCheck);
	}
	/*===========채팅 서비스============*/
	
	/*===========채팅 저장 서비스============*/
	@Override
	public void addChat(String user_id, int boardNumber, String content) {
		// TODO Auto-generated method stub
		userInfoDAO.addChat(user_id, boardNumber, content);
	}
	/*===========채팅 저장 서비스============*/

	/*===========채팅 대화 불러오기 서비스============*/
	@Override
	public List<ChatInfoVO> getChats(int boardNumber) {
		// TODO Auto-generated method stub
		ArrayList<ChatInfoVO> chatList = userInfoDAO.getChats(boardNumber);
		return chatList;
	}
	/*===========채팅 대화 불러오기 서비스============*/

	/*===========채팅 회원 정보 서비스============*/
	@Override
	public List<BoardJoinUserInfoVO> getJoinUsers(int boardNumber) {
		// TODO Auto-generated method stub
		ArrayList<BoardJoinUserInfoVO> boardList = userInfoDAO.getJoinUsers(boardNumber);
		return boardList;
	}
	/*===========채팅 회원 정보 서비스============*/
	
	/*===========게시글 즐겨찾기 서비스============*/
	@Override
	public void addFavoriteBoard(String user_id, int boardNumber) {
		// TODO Auto-generated method stub
		userInfoDAO.addFavoriteBoard(user_id, boardNumber);
	}
	/*===========게시글 즐겨찾기 서비스============*/
	
	/*===========게시글 즐겨찾기 취소 서비스============*/
	@Override
	public void modifyFavoriteBoard(String user_id, int boardNumber) {
		// TODO Auto-generated method stub
		userInfoDAO.modifyFavoriteBoard(user_id, boardNumber);
	}
	/*===========게시글 즐겨찾기 취소 서비스============*/

	/*===========마이페이지 즐겨찾기 목록 가져오기 서비스============*/
	@Override
	public List<BoardInfoVO> getUserBoard(String user_id) {
		// TODO Auto-generated method stub
		ArrayList<BoardInfoVO> boardList = userInfoDAO.getUserBoard(user_id);
		return boardList;
	}
	/*===========마이페이지 즐겨찾기 목록 가져오기 서비스============*/

	/*===========마이페이지 회원정보수정 서비스============*/
	@Override
	public void modifyUserInfo(String user_name, String user_detailAddress,	String user_email, int user_phone, String user_id) {
		// TODO Auto-generated method stub
		userInfoDAO.modifyUserInfo(user_name, user_detailAddress, user_email, user_phone, user_id);
	}
	/*===========마이페이지 회원정보수정 서비스============*/
	
	/*===========마이페이지 추천 포스팅 가져오기 서비스============*/
	@Override
	public List<PostingInfoVO> getPostingRecommands(String user_id) {
		// TODO Auto-generated method stub
		ArrayList<PostingInfoVO> postingRecommands = userInfoDAO.getPostingRecommands(user_id);
		return postingRecommands;
	}
	/*===========마이페이지 추천 포스팅 가져오기 서비스============*/

	/*===========마이페이지 포스팅 삭제 서비스============*/
	@Override
	public void deletePosting(String user_id, int postingNumber) {
		// TODO Auto-generated method stub
		userInfoDAO.deletePosting(user_id, postingNumber);
	}
	/*===========마이페이지 포스팅 삭제 서비스============*/
	
	/*===========마이페이지 게시글 삭제 서비스============*/
	@Override
	public void deleteMypageBoard(int boardNumber) {
		// TODO Auto-generated method stub
		userInfoDAO.deleteMypageBoard(boardNumber);
	}
	/*===========마이페이지 게시글 삭제 서비스============*/
	
	/*===========회원탈퇴 서비스============*/
	@Override
	public void userSecession(String user_id) {
		// TODO Auto-generated method stub
		userInfoDAO.userSecession(user_id);
	}
	/*===========회원탈퇴 서비스============*/
	
	/*===========문의사항 서비스============*/
	@Override
	public List<QnaInfoVO> getQnas(String user_id) {
		// TODO Auto-generated method stub
		ArrayList<QnaInfoVO> qnaList = userInfoDAO.getQnas(user_id);
		return qnaList;
	}
	/*===========문의사항 서비스============*/
	
	/*===========문의사항 등록 서비스============*/
	@Override
	public void addQna(String user_id, String qnaTitle, String qnaContent) {
		// TODO Auto-generated method stub
		userInfoDAO.addQna(user_id, qnaTitle, qnaContent);
	}
	/*===========문의사항 등록 서비스============*/
	
	/*===========문의사항 삭제 서비스============*/
	@Override
	public void deleteQna(int qnaNumber) {
		// TODO Auto-generated method stub
		userInfoDAO.deleteQna(qnaNumber);
	}
	/*===========문의사항 삭제 서비스============*/
	
	/*===========문의사항 삭제 서비스============*/
	@Override
	public QnaInfoVO getQna(int qnaNumber) {
		// TODO Auto-generated method stub
		QnaInfoVO qnaInfo = userInfoDAO.getQna(qnaNumber);
		return qnaInfo;
	}
	/*===========문의사항 삭제 서비스============*/
	
	/*===========문의사항 수정 서비스============*/
	@Override
	public void qnaModify(String user_id, int qnaNumber, String qnaTitle, String qnaContent) {
		// TODO Auto-generated method stub
		userInfoDAO.qnaModify(user_id, qnaNumber, qnaTitle, qnaContent);
	}
	/*===========문의사항 수정 서비스============*/
	
	/*===========관리자 포스팅 삭제 서비스============*/
	@Override
	public void adminDeletePosting(int postingNumber) {
		// TODO Auto-generated method stub
		userInfoDAO.adminDeletePosting(postingNumber);
	}
	/*===========관리자 포스팅 삭제 서비스============*/
	
	/*===========관리자 게시글 삭제 서비스============*/
	@Override
	public void adminBoardDelete(int boardNumber) {
		// TODO Auto-generated method stub
		userInfoDAO.adminBoardDelete(boardNumber);
	}
	/*===========관리자 게시글 삭제 서비스============*/
	
	/*=========== 관리 서비스============*/
	@Override
	public List<QnaInfoVO> getQnaInfos() {
		// TODO Auto-generated method stub
		ArrayList<QnaInfoVO> qnaList = userInfoDAO.getQnaInfos();
		return qnaList;
	}
	/*=========== 관리 서비스============*/
	
	/*=========== 관리자 문의사항 답변 서비스============*/
	@Override
	public void modifyQnaComment(String qna_id, int qnaNumber, String qnaComment) {
		// TODO Auto-generated method stub
		userInfoDAO.modifyQnaComment(qna_id, qnaNumber, qnaComment);
	}
	/*=========== 관리자 문의사항 답변 서비스============*/

	/*=========== 게시글 회원 추방 서비스============*/
	@Override
	public void userBoardOut(String boardJoinUser_id, int boardNumber) {
		// TODO Auto-generated method stub
		userInfoDAO.userBoardOut(boardJoinUser_id, boardNumber);
	}
	/*=========== 게시글 회원 추방 서비스============*/
	
	/*=========== 게시글 참여자 수 낮추기 서비스============*/
	@Override
	public void boardJoinUserNumberDown(int boardNumber) {
		// TODO Auto-generated method stub
		userInfoDAO.boardJoinUserNumberDown(boardNumber);
	}
	/*=========== 게시글 참여자 수 낮추기 서비스============*/
	
	/*=========== 게시글 검색 서비스============*/
	@Override
	public String getSearchBoard(String searchText) {
		// TODO Auto-generated method stub
		String searchBoardList = userInfoDAO.getSearchBoard(searchText);
		return searchBoardList;
	}
	
	@Override
	public List<BoardInfoVO> getSearchBoards(String searchBoardList) {
		// TODO Auto-generated method stub
		ArrayList<BoardInfoVO> boardList = userInfoDAO.getSearchBoards(searchBoardList);
		return boardList;
	}
	/*=========== 게시글 검색 서비스============*/
	
	/*=========== 포스팅 추천 알람 서비스============*/
	@Override
	public void addAlarmPosting(String user_id, int postingNumber) {
		// TODO Auto-generated method stub
		userInfoDAO.addAlarmPosting(user_id, postingNumber);
	}
	/*=========== 포스팅 추천 알람 서비스============*/
	
	/*=========== 알람 서비스============*/
	@Override
	public List<AlarmInfoVO> getAlarms() {
		// TODO Auto-generated method stub
		ArrayList<AlarmInfoVO> alarmList = userInfoDAO.getAlarms();
		return alarmList;
	}
	/*=========== 알람 서비스============*/
	
	/*=========== 게시글 참가 알람 서비스 ============*/
	@Override
	public void addAlarmBoard(BoardInfoVO boardInfo, UserInfoVO userInfo) {
		// TODO Auto-generated method stub
		userInfoDAO.addAlarmBoard(boardInfo, userInfo);
	}
	/*=========== 게시글 참가 알람 ============*/
	
	/*=========== 게시글 참가 성공 알람 ============*/
	@Override
	public void addAlarmBoardJoinSuccess(String user_id, BoardJoinUserInfoVO boardJoinUserInfo, int boardNumber) {
		// TODO Auto-generated method stub
		userInfoDAO.addAlarmBoardJoinSuccess(user_id, boardJoinUserInfo, boardNumber);
	}
	/*=========== 게시글 참가 성공 알람 ============*/

	/*=========== 게시글 참가 거절 알람 ============*/
	@Override
	public void addAlarmBoardJoinFail(String user_id, BoardJoinUserInfoVO boardJoinUserInfo, int boardNumber) {
		// TODO Auto-generated method stub
		userInfoDAO.addAlarmBoardJoinFail(user_id, boardJoinUserInfo, boardNumber);
	}
	/*=========== 게시글 참가 거절 알람 ============*/

	/*=========== 게시글 참가자 추방 알람 ============*/
	@Override
	public void addAlarmBoardOut(String user_id, BoardJoinUserInfoVO boardJoinUserInfo, int boardNumber) {
		// TODO Auto-generated method stub
		userInfoDAO.addAlarmBoardOut(user_id, boardJoinUserInfo, boardNumber);
	}
	/*=========== 게시글 참가자 추방 알람 ============*/
	
	/*=========== 게시글 참가자 추방 알람 ============*/
	@Override
	public void addAlarmQnaComment(String qna_id, int qnaNumber) {
		// TODO Auto-generated method stub
		userInfoDAO.addAlarmQnaComment(qna_id, qnaNumber);
	}
	/*=========== 게시글 참가자 추방 알람 ============*/
	
	/*=========== 마이페이지 내 게시글 삭제 알람 ============*/
	@Override
	public void addAlarmBoardDelete(String user_id, int boardNumber) {
		// TODO Auto-generated method stub
		userInfoDAO.addAlarmBoardDelete(user_id, boardNumber);
	}
	/*=========== 마이페이지 내 게시글 삭제 알람 ============*/
	
	/*=========== 문의사항 등록 알람 ============*/
	@Override
	public void addAlarmQna(String user_id, String qnaTitle, String qnaContent) {
		// TODO Auto-generated method stub
		userInfoDAO.addAlarmQna(user_id, qnaTitle, qnaContent);
	}
	/*=========== 문의사항 등록 알람 ============*/
	
	/*=========== 포스팅추천 가져오기 ============*/
	@Override
	public PostingRecommandInfoVO getPosting(String user_id, int postingNumber) {
		// TODO Auto-generated method stub
		PostingRecommandInfoVO posting = userInfoDAO.getPosting(user_id, postingNumber);
		return posting;
	}
	/*=========== 포스팅추천 가져오기 ============*/
}