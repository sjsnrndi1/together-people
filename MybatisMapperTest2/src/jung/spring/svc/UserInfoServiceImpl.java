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

	/* ===========������ �ϴ� ����============ */
	@Override
	public List<PostingInfoVO> getPostings() {
		// TODO Auto-generated method stub
		ArrayList<PostingInfoVO> postingList = userInfoDAO.getPostings();
		return postingList;
	}
	/* ===========������ �ϴ� ����============ */

	/* =========== ���� ȭ�� ����============ */
	@Override
	public UserInfoVO getUser(String user_id) {
		// TODO Auto-generated method stub
		UserInfoVO userInfo = userInfoDAO.getUser(user_id);
		return userInfo;
	}
	/* =========== ���� ȭ�� ����============ */

	/* ===========���� ���� ����Ʈ �������� ����============ */
	@Override
	public List<UserInfoVO> getMembers() {
		// TODO Auto-generated method stub
		ArrayList<UserInfoVO> userList = userInfoDAO.getMembers();
		return userList;
	}
	/* ===========���� ���� ����Ʈ �������� ����============ */

	/* ===========���� ���� �����ϴ� ����============ */
	@Override
	public void addUserInfo(HashMap<Object, Object> map) {
		userInfoDAO.addUser(map);
	}
	/* ===========���� ���� �����ϴ� ����============ */

	/* ===========���� id ã�� ����============ */
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
	/* ===========���� id ã�� ����============ */

	/* ===========���� pw ã�� ����============ */
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
	/* ===========���� pw ã�� ����============ */

	/* ===========���� ������ ����ϴ� ����============ */
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

	/* ===========���� ������ ����ϴ� ����============ */

	/* ===========����ڿ� �´� �� ��ȣ �������� ����============ */
	@Override
	public int getPopupNumber(String user_id) {
		// TODO Auto-generated method stub
		int popupNumber = userInfoDAO.getPopupNumber(user_id);
		return popupNumber;
	}
	/* ===========����ڿ� �´� �� ��ȣ �������� ����============ */

	/* ===========����� �˾�â ���� ����============ */
	@Override
	public void addUserPopup(String user_id) {
		// TODO Auto-generated method stub
		userInfoDAO.addUserPopup(user_id);
	}
	/* ===========����� �˾�â ���� ����============ */

	/* ===========����� �˾� ä�� ���� �������� ����============ */
	@Override
	public List<PopupChatInfoVO> getPopupChats(int popupNumber) {
		// TODO Auto-generated method stub
		ArrayList<PopupChatInfoVO> popupChatList = userInfoDAO.getPopupChats(popupNumber);
		return popupChatList;
	}
	/* ===========����� �˾� ä�� ���� �������� ����============ */

	/* ===========����� �˾� ä�� �Է� ����============ */
	@Override
	public void addPopupUserChat(String user_id, int popupNumber, String user_chat) {
		// TODO Auto-generated method stub
		userInfoDAO.addPopupUserChat(user_id, popupNumber, user_chat);
	}
	/* ===========����� �˾� ä�� �Է� ����============ */
	
	/* ===========�Խñ� ��� �������¼���============ */
	@Override
	public List<BoardInfoVO> getBoards() {
		// TODO Auto-generated method stub
		ArrayList<BoardInfoVO> boardList = userInfoDAO.getBoards();
		return boardList;
	}
	/* ===========�Խñ� ��� �������¼���============ */
	
	/* ===========�Խñ� ȭ�� �������¼���============ */
	@Override
	public BoardInfoVO getBoard(int boardNumber) {
		// TODO Auto-generated method stub
		BoardInfoVO boardInfo = userInfoDAO.getBoard(boardNumber);
		return boardInfo;
	}
	/* ===========�Խñ� ȭ�� �������¼���============ */
	
	/* ===========�Խñ� ���� ����============ */
	@Override
	public void addBoardSympathy(int boardNumber, String name) {
		// TODO Auto-generated method stub
		userInfoDAO.addBoardSympathy(boardNumber, name);
	}
	/* ===========�Խñ� ���� ����============ */
	
	/* ===========�Խñ� ���� ����============ */
	@Override
	public void updateBoardSympathy(int boardNumber, String name, int sym_count) {
		// TODO Auto-generated method stub
		userInfoDAO.updateBoardSympathy(boardNumber, name, sym_count);
	}
	/* ===========�Խñ� ���� ����============ */
	
	/* ===========�Խñ� ���� ����============ */
	@Override
	public void addBoard(String name, String title, String content, String subject) {
		// TODO Auto-generated method stub
		userInfoDAO.addBoard(name, title, content, subject);
	}
	/* ===========�Խñ� ���� ����============ */
	
	/* ===========�Խñ� �ڽ� ������ ��ȯ �Խñ� ��ȣ �������� ����============ */
	@Override
	public int getBoardNumber() {
		// TODO Auto-generated method stub
		int boardNumber = userInfoDAO.getBoardNumber();
		return boardNumber;
	}
	/* ===========�Խñ� �ڽ� ������ ��ȯ �Խñ� ��ȣ �������� ����============ */
	
	/* ===========����� ���� ��� �������� ����============ */
	@Override
	public BoardSympathyInfoVO getBoardSympathy(int boardNumber, String name) {
		// TODO Auto-generated method stub
		BoardSympathyInfoVO boardSympathyInfo = userInfoDAO.getBoardSympathy(boardNumber, name);
		return boardSympathyInfo;
	}
	/* ===========����� ���� ��� �������� ����============ */
	
	/* ===========�Խñ� ��� ���� ����============ */
	@Override
	public void addBoardComment(int boardNumber, String name, String comment, String userName) {
		// TODO Auto-generated method stub
		userInfoDAO.addBoardComment(boardNumber, name, comment, userName);
	}
	/* ===========�Խñ� ��� ���� ����============ */
	
	/* ===========����� ��� ��� �������� ����============ */
	@Override
	public List<BoardCommentInfoVO> getBoardComments(int boardNumber) {
		// TODO Auto-generated method stub
		ArrayList<BoardCommentInfoVO> boardComments = userInfoDAO.getBoardComments(boardNumber);
		return boardComments;
	}
	/* ===========����� ��� ��� �������� ����============ */
	
	/* ===========����� ��� ���� ����============ */
	@Override
	public void deleteBoardComment(int boardCommentNumber) {
		// TODO Auto-generated method stub
		userInfoDAO.deleteBoardComment(boardCommentNumber);
	}
	/* ===========����� ��� ���� ����============ */
	
	/* ===========�Խñ� ���� ����============ */
	@Override
	public List<BoardInfoVO> getBoardSort(String subject, String move) {
		// TODO Auto-generated method stub
		ArrayList<BoardInfoVO> boardSortList = userInfoDAO.getBoardSort(subject, move);
		return boardSortList;
	}
	/* ===========�Խñ� ���� ����============ */
	
	/* =========== ���� �Խñ� ���� ����============ */
	@Override
	public void addJoinBoard(String name, String title, String content, String subject) {
		// TODO Auto-generated method stub
		userInfoDAO.addJoinBoard(name, title, content, subject);
	}
	/* =========== ���� �Խñ� ���� ����============ */
	
	/* =========== ���� �Խñ� ��� ����============ */
	@Override
	public List<JoinBoardInfoVO> getJoinBoards() {
		// TODO Auto-generated method stub
		ArrayList<JoinBoardInfoVO> joinBoardList = userInfoDAO.getJoinBoards();
		return joinBoardList;
	}
	/* =========== ���� �Խñ� ��� ����============ */
	
	/* =========== ���� �Խñ� ���� ����============ */
	@Override
	public JoinBoardInfoVO getJoinBoard(int joinBoardNumber) {
		// TODO Auto-generated method stub
		JoinBoardInfoVO joinBoardInfo = userInfoDAO.getJoinBoard(joinBoardNumber);
		return joinBoardInfo;
	}
	/* =========== ���� �Խñ� ���� ����============ */
	
	/* =========== ���� �Խñ� �����ο� ���� ����============ */
	@Override
	public void addJoinBoard_joinUser(String name) {
		// TODO Auto-generated method stub
		userInfoDAO.addJoinBoard_joinUser(name);
	}
	/* =========== ���� �Խñ� �����ο� ���� ����============ */
	
	/* =========== ���� �Խñ� �����ο� ��� �������� ����============ */
	@Override
	public List<JoinBoard_JoinUserInfoVO> getJoinBoard_joinUsers(int joinBoardNumber) {
		// TODO Auto-generated method stub
		ArrayList<JoinBoard_JoinUserInfoVO> joinBoard_joinUserList = userInfoDAO.getJoinBoard_joinUsers(joinBoardNumber);
		return joinBoard_joinUserList;
	}
	/* =========== ���� �Խñ� �����ο� ��� �������� ����============ */
	
	/* =========== ���� �Խñ� ������û ����============ */
	@Override
	public void addJoinBoard_joinUser_regist(String name, int joinBoardNumber) {
		// TODO Auto-generated method stub
		userInfoDAO.addJoinBoard_joinUser_regist(name, joinBoardNumber);
	}
	/* =========== ���� �Խñ� ������û ����============ */
	
	/* =========== ���� �Խñ� ���� ����============ */
	@Override
	public List<JoinBoardInfoVO> getJoinBoardSorts(String subject) {
		// TODO Auto-generated method stub
		ArrayList<JoinBoardInfoVO> joinBoardSortList = userInfoDAO.getJoinBoardSorts(subject);
		return joinBoardSortList;
	}
	/* =========== ���� �Խñ� ���� ����============ */
	
	/* =========== �� ���� ���� ����============ */
	@Override
	public void updateUserInformation(HashMap<Object, Object> map) {
		// TODO Auto-generated method stub
		userInfoDAO.updateUserInformation(map);
	}
	/* =========== �� ���� ���� ����============ */
	
	/* =========== �� ��� �� �� �������� ����============ */
	@Override
	public List<BoardInfoVO> getMyBoards(String name) {
		// TODO Auto-generated method stub
		ArrayList<BoardInfoVO> myBoardList = userInfoDAO.getMyBoards(name);
		return myBoardList;
	}
	/* =========== �� ��� �� �� �������� ����============ */

	/* =========== �� ��� �� �� ���� ����============ */
	@Override
	public void deleteBoard(String data) {
		// TODO Auto-generated method stub
		userInfoDAO.deleteBoard(data);
	}
	/* =========== �� ��� �� �� ���� ����============ */
	
	/* =========== ������û�� �ο� ��� �������� ����============ */
	@Override
	public List<JoinBoard_JoinUserInfoVO> getJoinBoard_joinUserList() {
		// TODO Auto-generated method stub
		ArrayList<JoinBoard_JoinUserInfoVO> joinBoard_JoinUserList = userInfoDAO.getJoinBoard_joinUserList();
		return joinBoard_JoinUserList;
	}
	/* =========== ������û�� �ο� ��� �������� ����============ */
	
	/* =========== �����Խñ� ����/���� ����============ */
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
	/* =========== �����Խñ� ����/���� ����============ */
	
	/* =========== ���������� ��� ��� �������� ����============ */
	@Override
	public List<BoardCommentInfoVO> getBoardCommentList() {
		// TODO Auto-generated method stub
		ArrayList<BoardCommentInfoVO> boardCommentList = userInfoDAO.getBoardCommentList();
		return boardCommentList;
	}
	/* =========== ���������� ��� ��� �������� ����============ */



	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * ===========ä�� ����============
	 * 
	 * @Override public void chatJoin(int boardNumber, String user_id, boolean
	 * chatJoinCheck) { // TODO Auto-generated method stub
	 * userInfoDAO.chatJoin(boardNumber, user_id, chatJoinCheck); } ===========ä��
	 * ����============
	 * 
	 * ===========ä�� ���� ����============
	 * 
	 * @Override public void addChat(String user_id, int boardNumber, String
	 * content) { // TODO Auto-generated method stub userInfoDAO.addChat(user_id,
	 * boardNumber, content); } ===========ä�� ���� ����============
	 * 
	 * ===========ä�� ��ȭ �ҷ����� ����============
	 * 
	 * @Override public List<ChatInfoVO> getChats(int boardNumber) { // TODO
	 * Auto-generated method stub ArrayList<ChatInfoVO> chatList =
	 * userInfoDAO.getChats(boardNumber); return chatList; } ===========ä�� ��ȭ �ҷ�����
	 * ����============
	 * 
	 * ===========ä�� ȸ�� ���� ����============
	 * 
	 * @Override public List<BoardJoinUserInfoVO> getJoinUsers(int boardNumber) { //
	 * TODO Auto-generated method stub ArrayList<BoardJoinUserInfoVO> boardList =
	 * userInfoDAO.getJoinUsers(boardNumber); return boardList; } ===========ä�� ȸ��
	 * ���� ����============
	 */
}