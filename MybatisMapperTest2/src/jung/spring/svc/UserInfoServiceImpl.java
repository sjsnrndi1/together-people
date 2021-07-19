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
	
	/*===========�α��� �ϴ� ����============*/
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
	/*===========�α��� �ϴ� ����============*/
	
	/*=========== ���� ȭ�� ����============*/
	@Override
	public UserInfoVO getUser(String user_id) {
		// TODO Auto-generated method stub
		UserInfoVO userInfo = userInfoDAO.getUser(user_id);
		return userInfo;
	}
	/*=========== ���� ȭ�� ����============*/
	
	/*===========���� ���� ����Ʈ �������� ����============*/
	@Override
	public List<UserInfoVO> getMembers(){
		// TODO Auto-generated method stub
		ArrayList<UserInfoVO> userList = userInfoDAO.getMembers();
		return userList;
	}
	/*===========���� ���� ����Ʈ �������� ����============*/
	
	/*===========���� ���� �����ϴ� ����============*/
	@Override
	public boolean addUserInfo(HashMap<Object, Object> map) {
		boolean check = userInfoDAO.addUser(map);
		return check;
	}
	/*===========���� ���� �����ϴ� ����============*/
	
	/*===========���� id ã�� ����============*/
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
	/*===========���� id ã�� ����============*/
	
	/*===========���� pw ã�� ����============*/
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
	/*===========���� pw ã�� ����============*/
		
	/*===========���� ������ ����ϴ� ����============*/
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
	/*===========���� ������ ����ϴ� ����============*/
	
	/*===========���� ������ �����ϴ� ����============*/
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
	/*===========���� ������ �����ϴ� ����============*/
	
	/*===========���� ������ �����ϴ� ����============*/
	@Override
	public void deleteUserPostingInfo(String user_id, String postingContent, String user_name, int postingNumber, int postingRecommandCount) {
		// TODO Auto-generated method stub
		userInfoDAO.deletePostingInfo(user_id, postingContent, user_name, postingNumber, postingRecommandCount);
	}
	/*===========���� ������ �����ϴ� ����============*/
	
	/*===========���� ������ ��õ�ϴ� ����============*/
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
	/*===========���� ������ ��õ�ϴ� ����============*/
	
	/*===========�������� ����============*/
	@Override
	public List<NoticeInfoVO> getNotices() {
		// TODO Auto-generated method stub
		ArrayList<NoticeInfoVO> noticeList = userInfoDAO.getNotices();
		return noticeList;
	}
	/*===========�������� ����============*/
	
	/*===========�������� ��� ����============*/
	@Override
	public void addNotice(String noticeWriter, String noticeTitle, String noticeContent) {
		// TODO Auto-generated method stub
		userInfoDAO.addNotice(noticeWriter, noticeTitle, noticeContent);
	}
	/*===========�������� ��� ����============*/
	
	/*===========�������� ���� ����============*/
	@Override
	public NoticeInfoVO getNotice(int noticeNumber) {
		// TODO Auto-generated method stub
		NoticeInfoVO noticeInfo = userInfoDAO.getNotice(noticeNumber);
		return noticeInfo;
	}
	/*===========�������� ���� ����============*/

	/*===========�������� ���� ����============*/
	@Override
	public void modifyNotice(String noticeTitle, int noticeNumber, String noticeContent) {
		// TODO Auto-generated method stub
		userInfoDAO.modifyNotice(noticeTitle, noticeNumber, noticeContent);
	}
	/*===========�������� ���� ����============*/
	
	/*===========�������� ���� ����============*/
	@Override
	public void deleteNotice(int noticeNumber) {
		// TODO Auto-generated method stub
		userInfoDAO.deleteNotice(noticeNumber);
	}
	/*===========�������� ���� ����============*/
	
	/*===========�������� ��ȸ�� ����============*/
	@Override
	public void modifyNoticeReadCount(int noticeNumber) {
		// TODO Auto-generated method stub
		userInfoDAO.modifyNoticeReadCount(noticeNumber);
	}
	/*===========�������� ��ȸ�� ����============*/
	
	/*===========�Խ��� ����============*/
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
	/*===========�Խ��� ����============*/
	
	/*===========�Խ��� ��� ����============*/
	@Override
	public void addBoard(String boardWriter, String boardTitle, String boardContent, String selectBoard, String user_id) {
		// TODO Auto-generated method stub
		userInfoDAO.addBoard(boardWriter, boardTitle, boardContent, selectBoard, user_id);
	}
	/*===========�Խ��� ��� ����============*/
	
	/*===========�Խñ� ���� ����============*/
	@Override
	public BoardInfoVO getboard(int boardNumber) {
		// TODO Auto-generated method stub
		BoardInfoVO boardInfo = userInfoDAO.getBoard(boardNumber);
		return boardInfo;
	}
	/*===========�Խñ� ���� ����============*/
	
	/*===========�Խñ� ���� ����============*/
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
	/*===========�Խñ� ���� ����============*/

	/*===========�Խñ� ������� ����============*/
	@Override
	public void sendCancelBoardJoin(BoardJoinUserInfoVO boardJoinUserInfo) {
		// TODO Auto-generated method stub
		userInfoDAO.sendCancelBoardJoin(boardJoinUserInfo);
	}
	/*===========�Խñ� ������� ����============*/
	
	/*===========�Խñ� ������ ��� ����============*/
	@Override
	public List<BoardJoinUserInfoVO> getBoardJoinUsers() {
		// TODO Auto-generated method stub
		ArrayList<BoardJoinUserInfoVO> boardJoinUserList = userInfoDAO.getBoardJoinUsers();
		return boardJoinUserList;
	}
	/*===========�Խñ� ������ ��� ����============*/
	
	/*===========�Խñ� ������ ���� ����============*/
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
	/*===========�Խñ� ������ ���� ����============*/
	
	/*===========�Խñ� ������ ���� ����============*/
	@Override
	public void deleteBoardJoinUserInfo(BoardJoinUserInfoVO boardJoinUserInfo) {
		// TODO Auto-generated method stub
		userInfoDAO.deleteBoardJoinUserInfo(boardJoinUserInfo);
	}
	/*===========�Խñ� ������ ���� ����============*/
	
	/*===========�Խñ� ���� ����============*/
	@Override
	public void modifyBoard(String user_id, int boardNumber, String boardTitle, String boardContent) {
		// TODO Auto-generated method stub
		userInfoDAO.modifyBoard(user_id, boardNumber, boardTitle, boardContent);
	}
	/*===========�Խñ� ���� ����============*/
	
	/*===========�Խñ� ���� ����============*/
	@Override
	public void deleteBoard(UserInfoVO userInfo, BoardInfoVO boardInfo) {
		// TODO Auto-generated method stub
		userInfoDAO.deleteBoard(userInfo, boardInfo);
	}
	/*===========�Խñ� ���� ����============*/
	
	/*===========ä�� ����============*/
	@Override
	public void chatJoin(int boardNumber, String user_id, boolean chatJoinCheck) {
		// TODO Auto-generated method stub
		userInfoDAO.chatJoin(boardNumber, user_id, chatJoinCheck);
	}
	/*===========ä�� ����============*/
	
	/*===========ä�� ���� ����============*/
	@Override
	public void addChat(String user_id, int boardNumber, String content) {
		// TODO Auto-generated method stub
		userInfoDAO.addChat(user_id, boardNumber, content);
	}
	/*===========ä�� ���� ����============*/

	/*===========ä�� ��ȭ �ҷ����� ����============*/
	@Override
	public List<ChatInfoVO> getChats(int boardNumber) {
		// TODO Auto-generated method stub
		ArrayList<ChatInfoVO> chatList = userInfoDAO.getChats(boardNumber);
		return chatList;
	}
	/*===========ä�� ��ȭ �ҷ����� ����============*/

	/*===========ä�� ȸ�� ���� ����============*/
	@Override
	public List<BoardJoinUserInfoVO> getJoinUsers(int boardNumber) {
		// TODO Auto-generated method stub
		ArrayList<BoardJoinUserInfoVO> boardList = userInfoDAO.getJoinUsers(boardNumber);
		return boardList;
	}
	/*===========ä�� ȸ�� ���� ����============*/
	
	/*===========�Խñ� ���ã�� ����============*/
	@Override
	public void addFavoriteBoard(String user_id, int boardNumber) {
		// TODO Auto-generated method stub
		userInfoDAO.addFavoriteBoard(user_id, boardNumber);
	}
	/*===========�Խñ� ���ã�� ����============*/
	
	/*===========�Խñ� ���ã�� ��� ����============*/
	@Override
	public void modifyFavoriteBoard(String user_id, int boardNumber) {
		// TODO Auto-generated method stub
		userInfoDAO.modifyFavoriteBoard(user_id, boardNumber);
	}
	/*===========�Խñ� ���ã�� ��� ����============*/

	/*===========���������� ���ã�� ��� �������� ����============*/
	@Override
	public List<BoardInfoVO> getUserBoard(String user_id) {
		// TODO Auto-generated method stub
		ArrayList<BoardInfoVO> boardList = userInfoDAO.getUserBoard(user_id);
		return boardList;
	}
	/*===========���������� ���ã�� ��� �������� ����============*/

	/*===========���������� ȸ���������� ����============*/
	@Override
	public void modifyUserInfo(String user_name, String user_detailAddress,	String user_email, int user_phone, String user_id) {
		// TODO Auto-generated method stub
		userInfoDAO.modifyUserInfo(user_name, user_detailAddress, user_email, user_phone, user_id);
	}
	/*===========���������� ȸ���������� ����============*/
	
	/*===========���������� ��õ ������ �������� ����============*/
	@Override
	public List<PostingInfoVO> getPostingRecommands(String user_id) {
		// TODO Auto-generated method stub
		ArrayList<PostingInfoVO> postingRecommands = userInfoDAO.getPostingRecommands(user_id);
		return postingRecommands;
	}
	/*===========���������� ��õ ������ �������� ����============*/

	/*===========���������� ������ ���� ����============*/
	@Override
	public void deletePosting(String user_id, int postingNumber) {
		// TODO Auto-generated method stub
		userInfoDAO.deletePosting(user_id, postingNumber);
	}
	/*===========���������� ������ ���� ����============*/
	
	/*===========���������� �Խñ� ���� ����============*/
	@Override
	public void deleteMypageBoard(int boardNumber) {
		// TODO Auto-generated method stub
		userInfoDAO.deleteMypageBoard(boardNumber);
	}
	/*===========���������� �Խñ� ���� ����============*/
	
	/*===========ȸ��Ż�� ����============*/
	@Override
	public void userSecession(String user_id) {
		// TODO Auto-generated method stub
		userInfoDAO.userSecession(user_id);
	}
	/*===========ȸ��Ż�� ����============*/
	
	/*===========���ǻ��� ����============*/
	@Override
	public List<QnaInfoVO> getQnas(String user_id) {
		// TODO Auto-generated method stub
		ArrayList<QnaInfoVO> qnaList = userInfoDAO.getQnas(user_id);
		return qnaList;
	}
	/*===========���ǻ��� ����============*/
	
	/*===========���ǻ��� ��� ����============*/
	@Override
	public void addQna(String user_id, String qnaTitle, String qnaContent) {
		// TODO Auto-generated method stub
		userInfoDAO.addQna(user_id, qnaTitle, qnaContent);
	}
	/*===========���ǻ��� ��� ����============*/
	
	/*===========���ǻ��� ���� ����============*/
	@Override
	public void deleteQna(int qnaNumber) {
		// TODO Auto-generated method stub
		userInfoDAO.deleteQna(qnaNumber);
	}
	/*===========���ǻ��� ���� ����============*/
	
	/*===========���ǻ��� ���� ����============*/
	@Override
	public QnaInfoVO getQna(int qnaNumber) {
		// TODO Auto-generated method stub
		QnaInfoVO qnaInfo = userInfoDAO.getQna(qnaNumber);
		return qnaInfo;
	}
	/*===========���ǻ��� ���� ����============*/
	
	/*===========���ǻ��� ���� ����============*/
	@Override
	public void qnaModify(String user_id, int qnaNumber, String qnaTitle, String qnaContent) {
		// TODO Auto-generated method stub
		userInfoDAO.qnaModify(user_id, qnaNumber, qnaTitle, qnaContent);
	}
	/*===========���ǻ��� ���� ����============*/
	
	/*===========������ ������ ���� ����============*/
	@Override
	public void adminDeletePosting(int postingNumber) {
		// TODO Auto-generated method stub
		userInfoDAO.adminDeletePosting(postingNumber);
	}
	/*===========������ ������ ���� ����============*/
	
	/*===========������ �Խñ� ���� ����============*/
	@Override
	public void adminBoardDelete(int boardNumber) {
		// TODO Auto-generated method stub
		userInfoDAO.adminBoardDelete(boardNumber);
	}
	/*===========������ �Խñ� ���� ����============*/
	
	/*=========== ���� ����============*/
	@Override
	public List<QnaInfoVO> getQnaInfos() {
		// TODO Auto-generated method stub
		ArrayList<QnaInfoVO> qnaList = userInfoDAO.getQnaInfos();
		return qnaList;
	}
	/*=========== ���� ����============*/
	
	/*=========== ������ ���ǻ��� �亯 ����============*/
	@Override
	public void modifyQnaComment(String qna_id, int qnaNumber, String qnaComment) {
		// TODO Auto-generated method stub
		userInfoDAO.modifyQnaComment(qna_id, qnaNumber, qnaComment);
	}
	/*=========== ������ ���ǻ��� �亯 ����============*/

	/*=========== �Խñ� ȸ�� �߹� ����============*/
	@Override
	public void userBoardOut(String boardJoinUser_id, int boardNumber) {
		// TODO Auto-generated method stub
		userInfoDAO.userBoardOut(boardJoinUser_id, boardNumber);
	}
	/*=========== �Խñ� ȸ�� �߹� ����============*/
	
	/*=========== �Խñ� ������ �� ���߱� ����============*/
	@Override
	public void boardJoinUserNumberDown(int boardNumber) {
		// TODO Auto-generated method stub
		userInfoDAO.boardJoinUserNumberDown(boardNumber);
	}
	/*=========== �Խñ� ������ �� ���߱� ����============*/
	
	/*=========== �Խñ� �˻� ����============*/
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
	/*=========== �Խñ� �˻� ����============*/
	
	/*=========== ������ ��õ �˶� ����============*/
	@Override
	public void addAlarmPosting(String user_id, int postingNumber) {
		// TODO Auto-generated method stub
		userInfoDAO.addAlarmPosting(user_id, postingNumber);
	}
	/*=========== ������ ��õ �˶� ����============*/
	
	/*=========== �˶� ����============*/
	@Override
	public List<AlarmInfoVO> getAlarms() {
		// TODO Auto-generated method stub
		ArrayList<AlarmInfoVO> alarmList = userInfoDAO.getAlarms();
		return alarmList;
	}
	/*=========== �˶� ����============*/
	
	/*=========== �Խñ� ���� �˶� ���� ============*/
	@Override
	public void addAlarmBoard(BoardInfoVO boardInfo, UserInfoVO userInfo) {
		// TODO Auto-generated method stub
		userInfoDAO.addAlarmBoard(boardInfo, userInfo);
	}
	/*=========== �Խñ� ���� �˶� ============*/
	
	/*=========== �Խñ� ���� ���� �˶� ============*/
	@Override
	public void addAlarmBoardJoinSuccess(String user_id, BoardJoinUserInfoVO boardJoinUserInfo, int boardNumber) {
		// TODO Auto-generated method stub
		userInfoDAO.addAlarmBoardJoinSuccess(user_id, boardJoinUserInfo, boardNumber);
	}
	/*=========== �Խñ� ���� ���� �˶� ============*/

	/*=========== �Խñ� ���� ���� �˶� ============*/
	@Override
	public void addAlarmBoardJoinFail(String user_id, BoardJoinUserInfoVO boardJoinUserInfo, int boardNumber) {
		// TODO Auto-generated method stub
		userInfoDAO.addAlarmBoardJoinFail(user_id, boardJoinUserInfo, boardNumber);
	}
	/*=========== �Խñ� ���� ���� �˶� ============*/

	/*=========== �Խñ� ������ �߹� �˶� ============*/
	@Override
	public void addAlarmBoardOut(String user_id, BoardJoinUserInfoVO boardJoinUserInfo, int boardNumber) {
		// TODO Auto-generated method stub
		userInfoDAO.addAlarmBoardOut(user_id, boardJoinUserInfo, boardNumber);
	}
	/*=========== �Խñ� ������ �߹� �˶� ============*/
	
	/*=========== �Խñ� ������ �߹� �˶� ============*/
	@Override
	public void addAlarmQnaComment(String qna_id, int qnaNumber) {
		// TODO Auto-generated method stub
		userInfoDAO.addAlarmQnaComment(qna_id, qnaNumber);
	}
	/*=========== �Խñ� ������ �߹� �˶� ============*/
	
	/*=========== ���������� �� �Խñ� ���� �˶� ============*/
	@Override
	public void addAlarmBoardDelete(String user_id, int boardNumber) {
		// TODO Auto-generated method stub
		userInfoDAO.addAlarmBoardDelete(user_id, boardNumber);
	}
	/*=========== ���������� �� �Խñ� ���� �˶� ============*/
	
	/*=========== ���ǻ��� ��� �˶� ============*/
	@Override
	public void addAlarmQna(String user_id, String qnaTitle, String qnaContent) {
		// TODO Auto-generated method stub
		userInfoDAO.addAlarmQna(user_id, qnaTitle, qnaContent);
	}
	/*=========== ���ǻ��� ��� �˶� ============*/
	
	/*=========== ��������õ �������� ============*/
	@Override
	public PostingRecommandInfoVO getPosting(String user_id, int postingNumber) {
		// TODO Auto-generated method stub
		PostingRecommandInfoVO posting = userInfoDAO.getPosting(user_id, postingNumber);
		return posting;
	}
	/*=========== ��������õ �������� ============*/
}