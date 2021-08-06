package jung.spring.dao;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jung.spring.mybatis.BoardSympathyMapper;
import jung.spring.mybatis.JoinBoardMapper;
import jung.spring.mybatis.JoinBoard_JoinUserMapper;
import jung.spring.controller.MybatisController;
import jung.spring.mybatis.BoardCommentMapper;
import jung.spring.mybatis.BoardMapper;
import jung.spring.mybatis.MemberMapper;
import jung.spring.mybatis.PopupChatMapper;
import jung.spring.mybatis.PopupMapper;
import jung.spring.mybatis.PostingMapper;
import jung.spring.vo.BoardSympathyInfoVO;
import jung.spring.vo.JoinBoardInfoVO;
import jung.spring.vo.JoinBoard_JoinUserInfoVO;
import jung.spring.vo.BoardCommentInfoVO;
import jung.spring.vo.BoardInfoVO;
import jung.spring.vo.PopupChatInfoVO;
import jung.spring.vo.PostingInfoVO;
import jung.spring.vo.UserInfoVO;

@Repository
public class UserInfoDAOImpl implements UserInfoDAO {

	@Autowired
	private SqlSession sqlSession;

	/* ===========������ �ϴ� ����============ */
	@Override
	public ArrayList<PostingInfoVO> getPostings() {
		// TODO Auto-generated method stub
		PostingMapper postingMapper = sqlSession.getMapper(PostingMapper.class);
		ArrayList<PostingInfoVO> postingList = postingMapper.getPostings();
		return postingList;
	}
	/* ===========������ �ϴ� ����============ */

	/* ===========���� ȭ�� ����============ */
	@Override
	public UserInfoVO getUser(String user_id) {
		// TODO Auto-generated method stub
		MemberMapper userMapper = sqlSession.getMapper(MemberMapper.class);
		UserInfoVO userInfo = userMapper.getUser(user_id);
		return userInfo;
	}
	/* ===========���� ȭ�� ����============ */

	/* ===========���� ���� ����Ʈ �������� ����============ */
	@Override
	public ArrayList<UserInfoVO> getMembers() {
		// TODO Auto-generated method stub
		MemberMapper userMapper = sqlSession.getMapper(MemberMapper.class);
		ArrayList<UserInfoVO> userList = userMapper.getMembers();
		return userList;
	}
	/* ===========���� ���� ����Ʈ �������� ����============ */

	/* ===========���� ���� �����ϴ� ����============ */
	@Override
	public void addUser(HashMap<Object, Object> map) {
		// TODO Auto-generated method stub
		MemberMapper userMapper = sqlSession.getMapper(MemberMapper.class);
		userMapper.addMember(map);
	}
	/* ===========���� ���� �����ϴ� ����============ */

	/* ===========���� id ã�� ����============ */
	@Override
	public boolean checkUserEmail(String user_name, int user_phone) {
		// TODO Auto-generated method stub
		UserInfoVO str = null;
		boolean idCheck = false;
		MemberMapper userMapper = sqlSession.getMapper(MemberMapper.class);
		UserInfoVO userInfo = new UserInfoVO();
		userInfo.setUser_name(user_name);
		userInfo.setUser_phone(user_phone);
		str = userMapper.selectUserNamePhone(userInfo);
		if (str != null) {
			idCheck = true;
		}
		return idCheck;
	}

	@Override
	public UserInfoVO selectUserId(String user_name, int user_phone) {
		// TODO Auto-generated method stub
		MemberMapper userMapper = sqlSession.getMapper(MemberMapper.class);
		HashMap<Object, Object> map = new HashMap<Object, Object>();
		map.put("user_name", user_name);
		map.put("user_phone", user_phone);
		UserInfoVO userInfo = userMapper.selectUserId(map);
		return userInfo;
	}
	/* ===========���� id ã�� ����============ */

	/* ===========���� pw ã�� ����============ */
	@Override
	public UserInfoVO selectUserPassword(String user_id) {
		// TODO Auto-generated method stub
		MemberMapper userMapper = sqlSession.getMapper(MemberMapper.class);
		UserInfoVO userInfo = userMapper.selectUserPassword(user_id);
		return userInfo;
	}

	@Override
	public boolean selectUserPassword(String user_id, String user_name, int user_phone) {
		// TODO Auto-generated method stub
		MemberMapper userMapper = sqlSession.getMapper(MemberMapper.class);
		boolean pwCheck = false;
		HashMap<Object, Object> map = new HashMap<Object, Object>();
		map.put("user_id", user_id);
		map.put("user_name", user_name);
		map.put("user_phone", user_phone);
		UserInfoVO userInfo = userMapper.selectUserPasswordModify(map);
		if (userInfo != null) {
			pwCheck = true;
		}
		return pwCheck;
	}

	@Override
	public void modifyPassword(String user_id, String user_password) {
		// TODO Auto-generated method stub
		MemberMapper userMapper = sqlSession.getMapper(MemberMapper.class);
		HashMap<Object, Object> map = new HashMap<Object, Object>();
		map.put("user_password", user_password);
		map.put("user_id", user_id);
		userMapper.modifyPassword(map);
	}
	/* ===========���� pw ã�� ����============ */

	/* ===========���� ������ ����ϴ� ����============ */
	@Override
	public void addPosting(String content_title, String content_content, File content_picture, UserInfoVO userInfo) {
		// TODO Auto-generated method stub
		PostingMapper postingMapper = sqlSession.getMapper(PostingMapper.class);
		String cp = content_picture.getName();
		HashMap<Object, Object> map = new HashMap<Object, Object>();
		map.put("userId", userInfo.getUser_id());
		map.put("userName", userInfo.getUser_name());
		map.put("postingTitle", content_title);
		map.put("postingContent", content_content);
		map.put("postingPictureTitle", cp);
		map.put("postingRecommandCount", 0);
		map.put("postingAnswerCount", 0);
		map.put("postingDate", new Date());
		postingMapper.addPosting(map);
	}

	@Override
	public String getLastPostingNumber() {
		// TODO Auto-generated method stub
		PostingMapper postingMapper = sqlSession.getMapper(PostingMapper.class);
		ArrayList<PostingInfoVO> getLastPostingNumber = postingMapper.getLastPostingNumber();
		int count = (getLastPostingNumber.get(getLastPostingNumber.size() - 1).getPostingNumber());
		return String.valueOf(count);
	}

	@Override
	public void deletePostingFail(String posting_Number) {
		// TODO Auto-generated method stub
		PostingMapper postingMapper = sqlSession.getMapper(PostingMapper.class);
		int postingNumber = Integer.parseInt(posting_Number);
		postingMapper.deletePostingFail(postingNumber);
	}
	/* ===========���� ������ ����ϴ� ����============ */

	/* ===========����� �� �˾� â ����============ */
	@Override
	public void addUserPopup(String user_id) {
		// TODO Auto-generated method stub
		PopupMapper popupMapper = sqlSession.getMapper(PopupMapper.class);
		PopupChatMapper popupChatMapper = sqlSession.getMapper(PopupChatMapper.class);
		popupMapper.addUserPopup(user_id);
		int popupNumber = popupMapper.getPopupNumber(user_id);
		String userChatContent = "";
		String adminChatContent = "�ȳ��ϼ���.<br>Together people�Դϴ�.<br>�ñ��Ͻ� ���� �����ø� ������ �ּ���.<br>�����մϴ�.";
		HashMap<Object, Object> map = new HashMap<Object, Object>();
		map.put("popupNumber", popupNumber);
		map.put("userId", user_id);
		map.put("userChatContent", userChatContent);
		map.put("adminChatContent", adminChatContent);
		map.put("chat_date", new Date());
		popupChatMapper.addPopupUserChat(map);
	}
	/* ===========����� �� �˾� â ����============ */

	/* ===========����ڿ� �´� �� ��ȣ �������� ����============ */
	@Override
	public int getPopupNumber(String user_id) {
		// TODO Auto-generated method stub
		PopupMapper popupMapper = sqlSession.getMapper(PopupMapper.class);
		int popupNumber = popupMapper.getPopupNumber(user_id);
		return popupNumber;
	}
	/* ===========����ڿ� �´� �� ��ȣ �������� ����============ */

	/* ===========����� �˾� ä�� ���� �������� ����============ */
	@Override
	public ArrayList<PopupChatInfoVO> getPopupChats(int popupNumber) {
		// TODO Auto-generated method stub
		PopupChatMapper popupChatMapper = sqlSession.getMapper(PopupChatMapper.class);
		ArrayList<PopupChatInfoVO> popupChatList = popupChatMapper.getPopupChats(popupNumber);
		return popupChatList;
	}
	/* ===========����� �˾� ä�� ���� �������� ����============ */

	/* ===========����� �˾� ä�� �Է� ����============ */
	@Override
	public void addPopupUserChat(String user_id, int popupNumber, String user_chat) {
		// TODO Auto-generated method stub
		PopupChatMapper popupChatMapper = sqlSession.getMapper(PopupChatMapper.class);
		String adminChatContent = "";
		HashMap<Object, Object> map = new HashMap<Object, Object>();
		map.put("popupNumber", popupNumber);
		map.put("userId", user_id);
		map.put("userChatContent", user_chat);
		map.put("adminChatContent", adminChatContent);
		map.put("chat_date", new Date());
		popupChatMapper.addPopupUserChat(map);
	}
	/* ===========����� �˾� ä�� �Է� ����============ */

	/* ===========�Խñ� ��� �������� ����============ */
	@Override
	public ArrayList<BoardInfoVO> getBoards() {
		// TODO Auto-generated method stub
		BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);
		ArrayList<BoardInfoVO> boardList = boardMapper.getBoards();
		return boardList;
	}
	/* ===========�Խñ� ��� �������� ����============ */
	
	/* ===========�Խñ� �������� ����============ */
	@Override
	public BoardInfoVO getBoard(int boardNumber) {
		// TODO Auto-generated method stub
		BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);
		BoardInfoVO boardInfo = boardMapper.getBoard(boardNumber);
		int count = boardInfo.getBoardViews() + 1;
		HashMap<Object, Object> map = new HashMap<Object, Object>();
		map.put("count", count);
		map.put("boardNumber", boardNumber);
		boardMapper.countBoardViews(map);
		return boardInfo;
	}
	/* ===========�Խñ� �������� ����============ */
	
	/* ===========�Խñ� �ڽ� ���� ����============ */
	@Override
	public void addBoardSympathy(int boardNumber, String name) {
		// TODO Auto-generated method stub
		BoardSympathyMapper boardSympathyMapper = sqlSession.getMapper(BoardSympathyMapper.class);
		HashMap<Object, Object> map = new HashMap<Object, Object>();
		int boardSympathy = 1; // ���� �ȴ��� ����
		map.put("boardNumber", boardNumber);
		map.put("userId", name);
		map.put("boardSympathy", boardSympathy);
		boardSympathyMapper.addBoardSympathy(map);
	}
	/* ===========�Խñ� �ڽ� ���� ����============ */
	
	/* ===========�Խñ� ���� ����============ */
	@Override
	public void updateBoardSympathy(int boardNumber, String name, int sym_count) {
		// TODO Auto-generated method stub
		BoardSympathyMapper boardSympathyMapper = sqlSession.getMapper(BoardSympathyMapper.class);
		HashMap<Object, Object> map = new HashMap<Object, Object>();
		map.put("boardNumber", boardNumber);
		map.put("userId", name);
		if(sym_count == 0) { // ���� ����
			sym_count = 1;
			map.put("boardSympathy", sym_count);
			boardSympathyMapper.updateBoardSympathy(map);
		} else if(sym_count == 1) { // ���� �ϱ�
			sym_count = 0;
			map.put("boardSympathy", sym_count);
			boardSympathyMapper.updateBoardSympathy(map);
		}
	}
	/* ===========�Խñ� ���� ����============ */
	
	/* ===========�Խñ� ���� ����============ */
	@Override
	public void addBoard(String name, String title, String content, String subject) {
		// TODO Auto-generated method stub
		BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);
		MemberMapper userMapper = sqlSession.getMapper(MemberMapper.class);
		UserInfoVO userInfo = userMapper.getUser(name);
		HashMap<Object, Object> map = new HashMap<Object, Object>();
		int boardViews = 0;
		map.put("boardUserId", name);
		map.put("boardTitle", title);
		map.put("boardWriter", userInfo.getUser_name());
		map.put("boardContent", content);
		map.put("boardDate", new Date());
		map.put("boardSubject", subject);
		map.put("boardViews", boardViews);
		boardMapper.addBoard(map);
	}
	/* ===========�Խñ� ���� ����============ */
	
	/* ===========�Խñ� �ڽ� ������ ��ȯ �Խñ� ��ȣ �������� ����============ */
	@Override
	public int getBoardNumber() {
		// TODO Auto-generated method stub
		BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);
		ArrayList<BoardInfoVO> boardList = boardMapper.getBoards();
		int boardNumber = boardList.size();
		BoardInfoVO boardInfo = boardMapper.getBoard(boardNumber);
		return boardInfo.getBoardNumber();
	}
	/* ===========�Խñ� �ڽ� ������ ��ȯ �Խñ� ��ȣ �������� ����============ */
	
	/* ===========����� ���� ��� �������� ����============ */
	@Override
	public BoardSympathyInfoVO getBoardSympathy(int boardNumber, String name) {
		// TODO Auto-generated method stub
		BoardSympathyMapper boardSympathyMapper = sqlSession.getMapper(BoardSympathyMapper.class);
		HashMap<Object, Object> map = new HashMap<Object, Object>();
		map.put("boardNumber", boardNumber);
		map.put("userId", name);
		BoardSympathyInfoVO boardSympathyInfoVO = boardSympathyMapper.getBoardSympathy(map);
		return boardSympathyInfoVO;
	}
	/* ===========����� ���� ��� �������� ����============ */
	
	/* ===========�Խñ� ��� ���� ����============ */
	@Override
	public void addBoardComment(int boardNumber, String name, String comment, String userName) {
		// TODO Auto-generated method stub
		BoardCommentMapper boardCommentMapper = sqlSession.getMapper(BoardCommentMapper.class);
		HashMap<Object, Object> map = new HashMap<Object, Object>();
		map.put("boardNumber", boardNumber);
		map.put("userId", name);
		map.put("boardComment", comment);
		map.put("userName", userName);
		map.put("boardCommentDate", new Date());
		boardCommentMapper.addBoardComment(map);
	}
	/* ===========�Խñ� ��� ���� ����============ */
	
	/* ===========����� ��� ��� �������� ����============ */
	@Override
	public ArrayList<BoardCommentInfoVO> getBoardComments(int boardNumber) {
		// TODO Auto-generated method stub
		BoardCommentMapper boardCommentMapper = sqlSession.getMapper(BoardCommentMapper.class);
		ArrayList<BoardCommentInfoVO> boardComments = boardCommentMapper.getBoardComments(boardNumber);
		return boardComments;
	}
	/* ===========����� ��� ��� �������� ����============ */
	
	/* ===========����� ��� ���� ����============ */
	@Override
	public void deleteBoardComment(int boardCommentNumber) {
		// TODO Auto-generated method stub
		BoardCommentMapper boardCommentMapper = sqlSession.getMapper(BoardCommentMapper.class);
		boardCommentMapper.deleteBoardComment(boardCommentNumber);
	}
	/* ===========����� ��� ���� ����============ */

	/* ===========�Խñ� ���� ����============ */
	boolean boardTitle_sort = false;
	boolean boardWriter_sort = false;
	boolean boardDate_sort = false;
	boolean boardRead_sort = false;
	@Override
	public ArrayList<BoardInfoVO> getBoardSort(String subject, String move) {
		// TODO Auto-generated method stub
		BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);
		
		switch (subject) {
		case "title":
			if(move.equals("default")) {
				if(boardTitle_sort == false) {
					ArrayList<BoardInfoVO> boardSortNumber = boardMapper.getBoardTitleSort();
					boardTitle_sort = true;
					boardWriter_sort = false;
					boardDate_sort = false;
					boardRead_sort = false;
					return boardSortNumber;
				} else {
					ArrayList<BoardInfoVO> boardSortList = boardMapper.getBoards();
					boardTitle_sort = false;
					boardWriter_sort = false;
					boardDate_sort = false;
					boardRead_sort = false;
					return boardSortList;
				}
			} else {
				ArrayList<BoardInfoVO> boardSortNumber = boardMapper.getBoardReadSort();
				return boardSortNumber;
			}
		case "writer":
			if(move.equals("default")) {
				if(boardWriter_sort == false) {
					ArrayList<BoardInfoVO> boardSortWriter = boardMapper.getBoardWriterSort();
					boardTitle_sort = false;
					boardWriter_sort = true;
					boardDate_sort = false;
					boardRead_sort = false;
					return boardSortWriter;
				} else {
					ArrayList<BoardInfoVO> boardSortList = boardMapper.getBoards();
					boardTitle_sort = false;
					boardWriter_sort = false;
					boardDate_sort = false;
					boardRead_sort = false;
					return boardSortList;
				}
			} else {
				ArrayList<BoardInfoVO> boardSortWriter = boardMapper.getBoardReadSort();
				return boardSortWriter;
			}
		case "date":
			if(move.equals("default")) {
				if(boardDate_sort == false) {
					ArrayList<BoardInfoVO> boardSortDate = boardMapper.getBoardDateSort();
					boardTitle_sort = false;
					boardWriter_sort = false;
					boardDate_sort = true;
					boardRead_sort = false;
					return boardSortDate;
				} else {
					ArrayList<BoardInfoVO> boardSortList = boardMapper.getBoards();
					boardTitle_sort = false;
					boardWriter_sort = false;
					boardDate_sort = false;
					boardRead_sort = false;
					return boardSortList;
				}
			} else {
				ArrayList<BoardInfoVO> boardSortDate = boardMapper.getBoardReadSort();
				return boardSortDate;
			}
		case "read":
			if(move.equals("default")) {
				if(boardRead_sort == false) {
					ArrayList<BoardInfoVO> boardSortRead = boardMapper.getBoardReadSort(); 
					boardTitle_sort = false;
					boardWriter_sort = false;
					boardDate_sort = false;
					boardRead_sort = true;
					return boardSortRead;
				} else {
					ArrayList<BoardInfoVO> boardSortList = boardMapper.getBoards();
					boardTitle_sort = false;
					boardWriter_sort = false;
					boardDate_sort = false;
					boardRead_sort = false;
					return boardSortList;
				}
			} else {
				System.out.println(boardRead_sort);
				ArrayList<BoardInfoVO> boardSortRead = boardMapper.getBoardReadSort();
				return boardSortRead;
			}
		default:
			ArrayList<BoardInfoVO> boardSortList = boardMapper.getBoards();
			return boardSortList;
		}
			
	}

	/* ===========�Խñ� ���� ����============ */
	
	/* =========== ���� �Խñ� ���� ����============ */
	@Override
	public void addJoinBoard(String name, String title, String content, String subject) {
		// TODO Auto-generated method stub
		JoinBoardMapper joinBoardMapper = sqlSession.getMapper(JoinBoardMapper.class);
		MemberMapper userMapper = sqlSession.getMapper(MemberMapper.class);
		UserInfoVO userInfo = userMapper.getUser(name);
		HashMap<Object, Object> map = new HashMap<Object, Object>();
		map.put("joinBoardUserId", name);
		map.put("joinBoardTitle", title);
		map.put("joinBoardWriter", userInfo.getUser_name());
		map.put("joinBoardContent", content);
		map.put("joinBoardDate", new Date());
		map.put("joinBoardSubject", subject);
		map.put("joinBoard_joinUserNumber", 1);
		joinBoardMapper.addJoinBoard(map);
	}
	/* =========== ���� �Խñ� ���� ����============ */
	
	/* =========== ���� �Խñ� ��� �������� ����============ */
	@Override
	public ArrayList<JoinBoardInfoVO> getJoinBoards() {
		// TODO Auto-generated method stub
		JoinBoardMapper joinBoardMapper = sqlSession.getMapper(JoinBoardMapper.class);
		ArrayList<JoinBoardInfoVO> joinBoardList = joinBoardMapper.getJoinBoards();
		return joinBoardList;
	}
	/* =========== ���� �Խñ� ��� �������� ����============ */
	
	/* =========== ���� �Խñ� ���� ����============ */
	@Override
	public JoinBoardInfoVO getJoinBoard(int joinBoardNumber) {
		// TODO Auto-generated method stub
		JoinBoardMapper joinBoardMapper = sqlSession.getMapper(JoinBoardMapper.class);
		JoinBoardInfoVO joinBoardInfo = joinBoardMapper.getJoinBoard(joinBoardNumber);
		return joinBoardInfo;
	}
	/* =========== ���� �Խñ� ���� ����============ */
	
	/* =========== ���� �Խñ� �����ο� ���� ����============ */
	@Override
	public void addJoinBoard_joinUser(String name) {
		// TODO Auto-generated method stub
		JoinBoardMapper joinBoardMapper = sqlSession.getMapper(JoinBoardMapper.class);
		JoinBoard_JoinUserMapper joinBoard_joinUserMapper = sqlSession.getMapper(JoinBoard_JoinUserMapper.class);
		MemberMapper userMapper = sqlSession.getMapper(MemberMapper.class);
		UserInfoVO userInfo = userMapper.getUser(name);
		
		ArrayList<JoinBoardInfoVO> joinBoardList = joinBoardMapper.getJoinBoards();
		
		HashMap<Object, Object> map = new HashMap<Object, Object>();
		map.put("joinBoard_boardNumber", joinBoardList.get(joinBoardList.size() - 1).getJoinBoardNumber());
		map.put("joinBoard_userId", name);
		map.put("joinBoard_userName", userInfo.getUser_name());
		map.put("verified", 1);
		joinBoard_joinUserMapper.addJoinBoard_joinUser(map);
	}
	/* =========== ���� �Խñ� �����ο� ���� ����============ */
	
	/* =========== ���� �Խñ� �����ο� ��� �������� ����============ */
	@Override
	public ArrayList<JoinBoard_JoinUserInfoVO> getJoinBoard_joinUsers(int joinBoardNumber) {
		// TODO Auto-generated method stub
		JoinBoard_JoinUserMapper joinBoard_joinUserMapper = sqlSession.getMapper(JoinBoard_JoinUserMapper.class);
		ArrayList<JoinBoard_JoinUserInfoVO> joinBoard_joinUserList = joinBoard_joinUserMapper.getJoinBoard_joinUsers(joinBoardNumber);
		return joinBoard_joinUserList;
	}
	/* =========== ���� �Խñ� �����ο� ��� �������� ����============ */
	
	/* =========== ���� �Խñ� ������û ����============ */
	@Override
	public void addJoinBoard_joinUser_regist(String name, int joinBoardNumber) {
		// TODO Auto-generated method stub
		JoinBoard_JoinUserMapper joinBoard_joinUserMapper = sqlSession.getMapper(JoinBoard_JoinUserMapper.class);
		MemberMapper userMapper = sqlSession.getMapper(MemberMapper.class);
		UserInfoVO userInfo = userMapper.getUser(name);
		HashMap<Object, Object> map = new HashMap<Object, Object>();
		map.put("joinBoard_boardNumber", joinBoardNumber);
		map.put("joinBoard_userId", name);
		map.put("joinBoard_userName", userInfo.getUser_name());
		map.put("verified", 0);
		joinBoard_joinUserMapper.addJoinBoard_joinUser(map);
	}
	/* =========== ���� �Խñ� ������û ����============ */
	
	
	

	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * ===========ä�� ����============
	 * 
	 * @Override public void chatJoin(int boardNumber, String user_id, boolean
	 * chatJoinCheck) { // TODO Auto-generated method stub BoardJoinUserMapper
	 * boardJoinUserMapper = sqlSession.getMapper(BoardJoinUserMapper.class);
	 * BoardJoinUserInfoVO boardJoin = new BoardJoinUserInfoVO();
	 * boardJoin.setBoardJoinUser_id(user_id);
	 * boardJoin.setBoardNumber(boardNumber); if(chatJoinCheck) {
	 * boardJoin.setChatJoinCheck(2); } else { boardJoin.setChatJoinCheck(1); }
	 * boardJoinUserMapper.modifyBoardJoinUser(boardJoin); } ===========ä��
	 * ����============
	 * 
	 * ===========ä�� ���� ����============
	 * 
	 * @Override public void addChat(String user_id, int boardNumber, String
	 * content) { // TODO Auto-generated method stub ChatMapper chatMapper =
	 * sqlSession.getMapper(ChatMapper.class); ChatInfoVO chat = chatInfo(user_id,
	 * boardNumber, content); chatMapper.addChat(chat); }
	 * 
	 * public ChatInfoVO chatInfo(String user_id, int boardNumber, String content) {
	 * ChatInfoVO chat = new ChatInfoVO(); chat.setChatNum(boardNumber);
	 * chat.setChatUserId(user_id); chat.setChatContent(content);
	 * chat.setChatDate(new Date()); return chat; } ===========ä�� ���� ����============
	 * 
	 * ===========ä�� ��ȭ �ҷ����� ����============
	 * 
	 * @Override public ArrayList<ChatInfoVO> getChats(int boardNumber) { // TODO
	 * Auto-generated method stub ChatMapper chatMapper =
	 * sqlSession.getMapper(ChatMapper.class); ArrayList<ChatInfoVO> chatList =
	 * chatMapper.getChats(boardNumber); return chatList; } ===========ä�� ��ȭ �ҷ�����
	 * ����============
	 * 
	 * ===========ä�� ȸ�� ���� ����============
	 * 
	 * @Override public ArrayList<BoardJoinUserInfoVO> getJoinUsers(int boardNumber)
	 * { // TODO Auto-generated method stub BoardJoinUserMapper boardJoinUserMapper
	 * = sqlSession.getMapper(BoardJoinUserMapper.class); BoardJoinUserInfoVO
	 * boardJoinUserInfo = new BoardJoinUserInfoVO();
	 * boardJoinUserInfo.setBoardNumber(boardNumber);
	 * boardJoinUserInfo.setBoardJoinUserCheck(2); ArrayList<BoardJoinUserInfoVO>
	 * boardList = boardJoinUserMapper.getJoinUsers(boardJoinUserInfo); return
	 * boardList; } ===========ä�� ȸ�� ���� ����============
	 */
}