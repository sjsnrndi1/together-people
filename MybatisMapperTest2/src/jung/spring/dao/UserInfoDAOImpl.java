package jung.spring.dao;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jung.spring.mybatis.BoardMapper;
import jung.spring.mybatis.MemberMapper;
import jung.spring.mybatis.PopupChatMapper;
import jung.spring.mybatis.PopupMapper;
import jung.spring.mybatis.PostingMapper;
import jung.spring.vo.BoardInfoVO;
import jung.spring.vo.PopupChatInfoVO;
import jung.spring.vo.PostingInfoVO;
import jung.spring.vo.UserInfoVO;

@Repository
public class UserInfoDAOImpl implements UserInfoDAO {

	@Autowired
	private SqlSession sqlSession;

	/* ===========포스팅 하는 서비스============ */
	@Override
	public ArrayList<PostingInfoVO> getPostings() {
		// TODO Auto-generated method stub
		PostingMapper postingMapper = sqlSession.getMapper(PostingMapper.class);
		ArrayList<PostingInfoVO> postingList = postingMapper.getPostings();
		return postingList;
	}
	/* ===========포스팅 하는 서비스============ */

	/* ===========메인 화면 서비스============ */
	@Override
	public UserInfoVO getUser(String user_id) {
		// TODO Auto-generated method stub
		MemberMapper userMapper = sqlSession.getMapper(MemberMapper.class);
		UserInfoVO userInfo = userMapper.getUser(user_id);
		return userInfo;
	}
	/* ===========메인 화면 서비스============ */

	/* ===========유저 정보 리스트 가져오는 서비스============ */
	@Override
	public ArrayList<UserInfoVO> getMembers() {
		// TODO Auto-generated method stub
		MemberMapper userMapper = sqlSession.getMapper(MemberMapper.class);
		ArrayList<UserInfoVO> userList = userMapper.getMembers();
		return userList;
	}
	/* ===========유저 정보 리스트 가져오는 서비스============ */

	/* ===========유저 정보 저장하는 서비스============ */
	@Override
	public void addUser(HashMap<Object, Object> map) {
		// TODO Auto-generated method stub
		MemberMapper userMapper = sqlSession.getMapper(MemberMapper.class);
		userMapper.addMember(map);
	}
	/* ===========유저 정보 저장하는 서비스============ */

	/* ===========유저 id 찾는 서비스============ */
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
	/* ===========유저 id 찾는 서비스============ */

	/* ===========유저 pw 찾는 서비스============ */
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
	/* ===========유저 pw 찾는 서비스============ */

	/* ===========유저 포스팅 등록하는 서비스============ */
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
	/* ===========유저 포스팅 등록하는 서비스============ */

	/* ===========사용자 별 팝업 창 생성============ */
	@Override
	public void addUserPopup(String user_id) {
		// TODO Auto-generated method stub
		PopupMapper popupMapper = sqlSession.getMapper(PopupMapper.class);
		PopupChatMapper popupChatMapper = sqlSession.getMapper(PopupChatMapper.class);
		popupMapper.addUserPopup(user_id);
		int popupNumber = popupMapper.getPopupNumber(user_id);
		String userChatContent = "";
		String adminChatContent = "안녕하세요.<br>Together people입니다.<br>궁금하신 사항 있으시면 질문해 주세요.<br>감사합니다.";
		HashMap<Object, Object> map = new HashMap<Object, Object>();
		map.put("popupNumber", popupNumber);
		map.put("userId", user_id);
		map.put("userChatContent", userChatContent);
		map.put("adminChatContent", adminChatContent);
		map.put("chat_date", new Date());
		popupChatMapper.addPopupUserChat(map);
	}
	/* ===========사용자 별 팝업 창 생성============ */

	/* ===========사용자에 맞는 톡 번호 가져오는 서비스============ */
	@Override
	public int getPopupNumber(String user_id) {
		// TODO Auto-generated method stub
		PopupMapper popupMapper = sqlSession.getMapper(PopupMapper.class);
		int popupNumber = popupMapper.getPopupNumber(user_id);
		return popupNumber;
	}
	/* ===========사용자에 맞는 톡 번호 가져오는 서비스============ */

	/* ===========사용자 팝업 채팅 내용 가져오는 서비스============ */
	@Override
	public ArrayList<PopupChatInfoVO> getPopupChats(int popupNumber) {
		// TODO Auto-generated method stub
		PopupChatMapper popupChatMapper = sqlSession.getMapper(PopupChatMapper.class);
		ArrayList<PopupChatInfoVO> popupChatList = popupChatMapper.getPopupChats(popupNumber);
		return popupChatList;
	}
	/* ===========사용자 팝업 채팅 내용 가져오는 서비스============ */

	/* ===========사용자 팝업 채팅 입력 서비스============ */
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
	/* ===========사용자 팝업 채팅 입력 서비스============ */

	/* ===========게시글 목록 가져오는 서비스============ */
	@Override
	public ArrayList<BoardInfoVO> getBoards() {
		// TODO Auto-generated method stub
		BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);
		ArrayList<BoardInfoVO> boardList = boardMapper.getBoards();
		return boardList;
	}
	/* ===========게시글 목록 가져오는 서비스============ */
	
	/* ===========게시글 가져오는 서비스============ */
	@Override
	public ArrayList<BoardInfoVO> getBoard(int boardNumber) {
		// TODO Auto-generated method stub
		BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);
		ArrayList<BoardInfoVO> board = boardMapper.getBoard(boardNumber);
		int count = board.get(0).getBoardViews() + 1;
		HashMap<Object, Object> map = new HashMap<Object, Object>();
		map.put("count", count);
		map.put("boardNumber", boardNumber);
		boardMapper.countBoardViews(map);
		return board;
	}
	/* ===========게시글 가져오는 서비스============ */
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * ===========채팅 서비스============
	 * 
	 * @Override public void chatJoin(int boardNumber, String user_id, boolean
	 * chatJoinCheck) { // TODO Auto-generated method stub BoardJoinUserMapper
	 * boardJoinUserMapper = sqlSession.getMapper(BoardJoinUserMapper.class);
	 * BoardJoinUserInfoVO boardJoin = new BoardJoinUserInfoVO();
	 * boardJoin.setBoardJoinUser_id(user_id);
	 * boardJoin.setBoardNumber(boardNumber); if(chatJoinCheck) {
	 * boardJoin.setChatJoinCheck(2); } else { boardJoin.setChatJoinCheck(1); }
	 * boardJoinUserMapper.modifyBoardJoinUser(boardJoin); } ===========채팅
	 * 서비스============
	 * 
	 * ===========채팅 저장 서비스============
	 * 
	 * @Override public void addChat(String user_id, int boardNumber, String
	 * content) { // TODO Auto-generated method stub ChatMapper chatMapper =
	 * sqlSession.getMapper(ChatMapper.class); ChatInfoVO chat = chatInfo(user_id,
	 * boardNumber, content); chatMapper.addChat(chat); }
	 * 
	 * public ChatInfoVO chatInfo(String user_id, int boardNumber, String content) {
	 * ChatInfoVO chat = new ChatInfoVO(); chat.setChatNum(boardNumber);
	 * chat.setChatUserId(user_id); chat.setChatContent(content);
	 * chat.setChatDate(new Date()); return chat; } ===========채팅 저장 서비스============
	 * 
	 * ===========채팅 대화 불러오기 서비스============
	 * 
	 * @Override public ArrayList<ChatInfoVO> getChats(int boardNumber) { // TODO
	 * Auto-generated method stub ChatMapper chatMapper =
	 * sqlSession.getMapper(ChatMapper.class); ArrayList<ChatInfoVO> chatList =
	 * chatMapper.getChats(boardNumber); return chatList; } ===========채팅 대화 불러오기
	 * 서비스============
	 * 
	 * ===========채팅 회원 정보 서비스============
	 * 
	 * @Override public ArrayList<BoardJoinUserInfoVO> getJoinUsers(int boardNumber)
	 * { // TODO Auto-generated method stub BoardJoinUserMapper boardJoinUserMapper
	 * = sqlSession.getMapper(BoardJoinUserMapper.class); BoardJoinUserInfoVO
	 * boardJoinUserInfo = new BoardJoinUserInfoVO();
	 * boardJoinUserInfo.setBoardNumber(boardNumber);
	 * boardJoinUserInfo.setBoardJoinUserCheck(2); ArrayList<BoardJoinUserInfoVO>
	 * boardList = boardJoinUserMapper.getJoinUsers(boardJoinUserInfo); return
	 * boardList; } ===========채팅 회원 정보 서비스============
	 */
}