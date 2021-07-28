package jung.spring.svc;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jung.spring.dao.UserInfoDAO;
import jung.spring.vo.BoardChildInfoVO;
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
	public List<BoardInfoVO> getBoard(int boardNumber) {
		// TODO Auto-generated method stub
		ArrayList<BoardInfoVO> board = userInfoDAO.getBoard(boardNumber);
		return board;
	}
	/* ===========게시글 화면 가져오는서비스============ */
	
	/* ===========게시글 공감 서비스============ */
	@Override
	public void addBoardChild(String name, int boardNumber) {
		// TODO Auto-generated method stub
		userInfoDAO.addBoardChild(name, boardNumber);
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
	
	/* ===========게시글 공감, 댓글 가져오기 서비스============ */
	@Override
	public List<BoardChildInfoVO> getBoardChildList(int boardNumber) {
		// TODO Auto-generated method stub
		ArrayList<BoardChildInfoVO> boardChildList = userInfoDAO.getBoardChildList(boardNumber);
		return boardChildList;
	}
	/* ===========게시글 공감, 댓글 가져오기 서비스============ */
	
	/* ===========사용자 공감, 댓글 가져오기 서비스============ */
	@Override
	public List<BoardChildInfoVO> getBoardChilds(int boardNumber, String name) {
		// TODO Auto-generated method stub
		ArrayList<BoardChildInfoVO> boardChilds = userInfoDAO.getBoardChilds(boardNumber, name);
		return boardChilds;
	}
	/* ===========사용자 공감, 댓글 가져오기 서비스============ */
	
	
	
	
	
	
	
	
	
	
	
	
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