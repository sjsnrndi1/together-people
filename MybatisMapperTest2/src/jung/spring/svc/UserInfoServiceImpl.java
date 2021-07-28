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
	public List<BoardInfoVO> getBoard(int boardNumber) {
		// TODO Auto-generated method stub
		ArrayList<BoardInfoVO> board = userInfoDAO.getBoard(boardNumber);
		return board;
	}
	/* ===========�Խñ� ȭ�� �������¼���============ */
	
	/* ===========�Խñ� ���� ����============ */
	@Override
	public void addBoardChild(String name, int boardNumber) {
		// TODO Auto-generated method stub
		userInfoDAO.addBoardChild(name, boardNumber);
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
	
	/* ===========�Խñ� ����, ��� �������� ����============ */
	@Override
	public List<BoardChildInfoVO> getBoardChildList(int boardNumber) {
		// TODO Auto-generated method stub
		ArrayList<BoardChildInfoVO> boardChildList = userInfoDAO.getBoardChildList(boardNumber);
		return boardChildList;
	}
	/* ===========�Խñ� ����, ��� �������� ����============ */
	
	/* ===========����� ����, ��� �������� ����============ */
	@Override
	public List<BoardChildInfoVO> getBoardChilds(int boardNumber, String name) {
		// TODO Auto-generated method stub
		ArrayList<BoardChildInfoVO> boardChilds = userInfoDAO.getBoardChilds(boardNumber, name);
		return boardChilds;
	}
	/* ===========����� ����, ��� �������� ����============ */
	
	
	
	
	
	
	
	
	
	
	
	
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