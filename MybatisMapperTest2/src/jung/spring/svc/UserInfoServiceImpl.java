package jung.spring.svc;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jung.spring.dao.UserInfoDAO;
import jung.spring.vo.BoardSympathyInfoVO;
import jung.spring.vo.JoinBoardInfoVO;
import jung.spring.vo.JoinBoard_JoinUserInfoVO;
import jung.spring.vo.BoardCommentInfoVO;
import jung.spring.vo.BoardInfoVO;
import jung.spring.vo.PopupChatInfoVO;
import jung.spring.vo.PostingInfoVO;
import jung.spring.vo.UserInfoVO;

@Service
public class UserInfoServiceImpl implements UserInfoService {

	@Autowired
	private UserInfoDAO userInfoDAO;

	/* ===========포스팅 하는 서비스============ */
	@Override
	public List<PostingInfoVO> getPostings() {
		// TODO Auto-generated method stub
		ArrayList<PostingInfoVO> postingList = userInfoDAO.getPostings();
		return postingList;
	}
	/* ===========포스팅 하는 서비스============ */

	/* =========== 메인 화면 서비스============ */
	@Override
	public UserInfoVO getUser(String user_id) {
		// TODO Auto-generated method stub
		UserInfoVO userInfo = userInfoDAO.getUser(user_id);
		return userInfo;
	}
	/* =========== 메인 화면 서비스============ */

	/* ===========유저 정보 리스트 가져오는 서비스============ */
	@Override
	public List<UserInfoVO> getMembers() {
		// TODO Auto-generated method stub
		ArrayList<UserInfoVO> userList = userInfoDAO.getMembers();
		return userList;
	}
	/* ===========유저 정보 리스트 가져오는 서비스============ */

	/* ===========유저 정보 저장하는 서비스============ */
	@Override
	public void addUserInfo(HashMap<Object, Object> map) {
		userInfoDAO.addUser(map);
	}
	/* ===========유저 정보 저장하는 서비스============ */

	/* ===========유저 id 찾는 서비스============ */
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
	/* ===========유저 id 찾는 서비스============ */

	/* ===========유저 pw 찾는 서비스============ */
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
	/* ===========유저 pw 찾는 서비스============ */

	/* ===========유저 포스팅 등록하는 서비스============ */
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

	/* ===========유저 포스팅 등록하는 서비스============ */

	/* ===========사용자에 맞는 톡 번호 가져오는 서비스============ */
	@Override
	public int getPopupNumber(String user_id) {
		// TODO Auto-generated method stub
		int popupNumber = userInfoDAO.getPopupNumber(user_id);
		return popupNumber;
	}
	/* ===========사용자에 맞는 톡 번호 가져오는 서비스============ */

	/* ===========사용자 팝업창 생성 서비스============ */
	@Override
	public void addUserPopup(String user_id) {
		// TODO Auto-generated method stub
		userInfoDAO.addUserPopup(user_id);
	}
	/* ===========사용자 팝업창 생성 서비스============ */

	/* ===========사용자 팝업 채팅 내용 가져오는 서비스============ */
	@Override
	public List<PopupChatInfoVO> getPopupChats(int popupNumber) {
		// TODO Auto-generated method stub
		ArrayList<PopupChatInfoVO> popupChatList = userInfoDAO.getPopupChats(popupNumber);
		return popupChatList;
	}
	/* ===========사용자 팝업 채팅 내용 가져오는 서비스============ */

	/* ===========사용자 팝업 채팅 입력 서비스============ */
	@Override
	public void addPopupUserChat(String user_id, int popupNumber, String user_chat) {
		// TODO Auto-generated method stub
		userInfoDAO.addPopupUserChat(user_id, popupNumber, user_chat);
	}
	/* ===========사용자 팝업 채팅 입력 서비스============ */
	
	/* ===========게시글 목록 가져오는서비스============ */
	@Override
	public List<BoardInfoVO> getBoards() {
		// TODO Auto-generated method stub
		ArrayList<BoardInfoVO> boardList = userInfoDAO.getBoards();
		return boardList;
	}
	/* ===========게시글 목록 가져오는서비스============ */
	
	/* ===========게시글 화면 가져오는서비스============ */
	@Override
	public BoardInfoVO getBoard(int boardNumber) {
		// TODO Auto-generated method stub
		BoardInfoVO boardInfo = userInfoDAO.getBoard(boardNumber);
		return boardInfo;
	}
	/* ===========게시글 화면 가져오는서비스============ */
	
	/* ===========게시글 공감 서비스============ */
	@Override
	public void addBoardSympathy(int boardNumber, String name) {
		// TODO Auto-generated method stub
		userInfoDAO.addBoardSympathy(boardNumber, name);
	}
	/* ===========게시글 공감 서비스============ */
	
	/* ===========게시글 공감 서비스============ */
	@Override
	public void updateBoardSympathy(int boardNumber, String name, int sym_count) {
		// TODO Auto-generated method stub
		userInfoDAO.updateBoardSympathy(boardNumber, name, sym_count);
	}
	/* ===========게시글 공감 서비스============ */
	
	/* ===========게시글 생성 서비스============ */
	@Override
	public void addBoard(String name, String title, String content, String subject) {
		// TODO Auto-generated method stub
		userInfoDAO.addBoard(name, title, content, subject);
	}
	/* ===========게시글 생성 서비스============ */
	
	/* ===========게시글 자식 생성을 위환 게시글 번호 가져오기 서비스============ */
	@Override
	public int getBoardNumber() {
		// TODO Auto-generated method stub
		int boardNumber = userInfoDAO.getBoardNumber();
		return boardNumber;
	}
	/* ===========게시글 자식 생성을 위환 게시글 번호 가져오기 서비스============ */
	
	/* ===========사용자 공감 목록 가져오기 서비스============ */
	@Override
	public BoardSympathyInfoVO getBoardSympathy(int boardNumber, String name) {
		// TODO Auto-generated method stub
		BoardSympathyInfoVO boardSympathyInfo = userInfoDAO.getBoardSympathy(boardNumber, name);
		return boardSympathyInfo;
	}
	/* ===========사용자 공감 목록 가져오기 서비스============ */
	
	/* ===========게시글 댓글 생성 서비스============ */
	@Override
	public void addBoardComment(int boardNumber, String name, String comment, String userName) {
		// TODO Auto-generated method stub
		userInfoDAO.addBoardComment(boardNumber, name, comment, userName);
	}
	/* ===========게시글 댓글 생성 서비스============ */
	
	/* ===========사용자 댓글 목록 가져오기 서비스============ */
	@Override
	public List<BoardCommentInfoVO> getBoardComments(int boardNumber) {
		// TODO Auto-generated method stub
		ArrayList<BoardCommentInfoVO> boardComments = userInfoDAO.getBoardComments(boardNumber);
		return boardComments;
	}
	/* ===========사용자 댓글 목록 가져오기 서비스============ */
	
	/* ===========사용자 댓글 삭제 서비스============ */
	@Override
	public void deleteBoardComment(int boardCommentNumber) {
		// TODO Auto-generated method stub
		userInfoDAO.deleteBoardComment(boardCommentNumber);
	}
	/* ===========사용자 댓글 삭제 서비스============ */
	
	/* ===========게시글 정렬 서비스============ */
	@Override
	public List<BoardInfoVO> getBoardSort(String subject, String move) {
		// TODO Auto-generated method stub
		ArrayList<BoardInfoVO> boardSortList = userInfoDAO.getBoardSort(subject, move);
		return boardSortList;
	}
	/* ===========게시글 정렬 서비스============ */
	
	/* =========== 참여 게시글 생성 서비스============ */
	@Override
	public void addJoinBoard(String name, String title, String content, String subject) {
		// TODO Auto-generated method stub
		userInfoDAO.addJoinBoard(name, title, content, subject);
	}
	/* =========== 참여 게시글 생성 서비스============ */
	
	/* =========== 참여 게시글 목록 서비스============ */
	@Override
	public List<JoinBoardInfoVO> getJoinBoards() {
		// TODO Auto-generated method stub
		ArrayList<JoinBoardInfoVO> joinBoardList = userInfoDAO.getJoinBoards();
		return joinBoardList;
	}
	/* =========== 참여 게시글 목록 서비스============ */
	
	/* =========== 참여 게시글 보기 서비스============ */
	@Override
	public JoinBoardInfoVO getJoinBoard(int joinBoardNumber) {
		// TODO Auto-generated method stub
		JoinBoardInfoVO joinBoardInfo = userInfoDAO.getJoinBoard(joinBoardNumber);
		return joinBoardInfo;
	}
	/* =========== 참여 게시글 보기 서비스============ */
	
	/* =========== 참여 게시글 참여인원 생성 서비스============ */
	@Override
	public void addJoinBoard_joinUser(String name) {
		// TODO Auto-generated method stub
		userInfoDAO.addJoinBoard_joinUser(name);
	}
	/* =========== 참여 게시글 참여인원 생성 서비스============ */
	
	/* =========== 참여 게시글 참여인원 목록 가져오기 서비스============ */
	@Override
	public List<JoinBoard_JoinUserInfoVO> getJoinBoard_joinUsers(int joinBoardNumber) {
		// TODO Auto-generated method stub
		ArrayList<JoinBoard_JoinUserInfoVO> joinBoard_joinUserList = userInfoDAO.getJoinBoard_joinUsers(joinBoardNumber);
		return joinBoard_joinUserList;
	}
	/* =========== 참여 게시글 참여인원 목록 가져오기 서비스============ */
	
	/* =========== 참여 게시글 참여신청 서비스============ */
	@Override
	public void addJoinBoard_joinUser_regist(String name, int joinBoardNumber) {
		// TODO Auto-generated method stub
		userInfoDAO.addJoinBoard_joinUser_regist(name, joinBoardNumber);
	}
	/* =========== 참여 게시글 참여신청 서비스============ */
	
	/* =========== 참여 게시글 정렬 서비스============ */
	@Override
	public List<JoinBoardInfoVO> getJoinBoardSorts(String subject) {
		// TODO Auto-generated method stub
		ArrayList<JoinBoardInfoVO> joinBoardSortList = userInfoDAO.getJoinBoardSorts(subject);
		return joinBoardSortList;
	}
	/* =========== 참여 게시글 정렬 서비스============ */
	
	/* =========== 내 정보 수정 서비스============ */
	@Override
	public void updateUserInformation(HashMap<Object, Object> map) {
		// TODO Auto-generated method stub
		userInfoDAO.updateUserInformation(map);
	}
	/* =========== 내 정보 수정 서비스============ */
	
	/* =========== 글 목록 내 글 가져오기 서비스============ */
	@Override
	public List<BoardInfoVO> getMyBoards(String name) {
		// TODO Auto-generated method stub
		ArrayList<BoardInfoVO> myBoardList = userInfoDAO.getMyBoards(name);
		return myBoardList;
	}
	/* =========== 글 목록 내 글 가져오기 서비스============ */

	/* =========== 글 목록 내 글 삭제 서비스============ */
	@Override
	public void deleteBoard(String data) {
		// TODO Auto-generated method stub
		userInfoDAO.deleteBoard(data);
	}
	/* =========== 글 목록 내 글 삭제 서비스============ */
	
	/* =========== 참여신청한 인원 목록 가져오기 서비스============ */
	@Override
	public List<JoinBoard_JoinUserInfoVO> getJoinBoard_joinUserList() {
		// TODO Auto-generated method stub
		ArrayList<JoinBoard_JoinUserInfoVO> joinBoard_JoinUserList = userInfoDAO.getJoinBoard_joinUserList();
		return joinBoard_JoinUserList;
	}
	/* =========== 참여신청한 인원 목록 가져오기 서비스============ */
	
	/* =========== 참여게시글 수락/거절 서비스============ */
	@Override
	public void updateJoinUserAccept(int joinNumber, int joinBoardNumber) {
		// TODO Auto-generated method stub
		userInfoDAO.updateJoinUserAccept(joinNumber, joinBoardNumber);
	}
	@Override
	public void updateJoinUserRefuse(int joinNumber) {
		// TODO Auto-generated method stub
		userInfoDAO.updateJoinUserRefuse(joinNumber);
	}
	/* =========== 참여게시글 수락/거절 서비스============ */
	
	/* =========== 마이페이지 댓글 목록 가져오기 서비스============ */
	@Override
	public List<BoardCommentInfoVO> getBoardCommentList() {
		// TODO Auto-generated method stub
		ArrayList<BoardCommentInfoVO> boardCommentList = userInfoDAO.getBoardCommentList();
		return boardCommentList;
	}
	/* =========== 마이페이지 댓글 목록 가져오기 서비스============ */



	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * ===========채팅 서비스============
	 * 
	 * @Override public void chatJoin(int boardNumber, String user_id, boolean
	 * chatJoinCheck) { // TODO Auto-generated method stub
	 * userInfoDAO.chatJoin(boardNumber, user_id, chatJoinCheck); } ===========채팅
	 * 서비스============
	 * 
	 * ===========채팅 저장 서비스============
	 * 
	 * @Override public void addChat(String user_id, int boardNumber, String
	 * content) { // TODO Auto-generated method stub userInfoDAO.addChat(user_id,
	 * boardNumber, content); } ===========채팅 저장 서비스============
	 * 
	 * ===========채팅 대화 불러오기 서비스============
	 * 
	 * @Override public List<ChatInfoVO> getChats(int boardNumber) { // TODO
	 * Auto-generated method stub ArrayList<ChatInfoVO> chatList =
	 * userInfoDAO.getChats(boardNumber); return chatList; } ===========채팅 대화 불러오기
	 * 서비스============
	 * 
	 * ===========채팅 회원 정보 서비스============
	 * 
	 * @Override public List<BoardJoinUserInfoVO> getJoinUsers(int boardNumber) { //
	 * TODO Auto-generated method stub ArrayList<BoardJoinUserInfoVO> boardList =
	 * userInfoDAO.getJoinUsers(boardNumber); return boardList; } ===========채팅 회원
	 * 정보 서비스============
	 */
}