package jung.spring.dao;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import jung.spring.mybatis.AlarmMapper;
import jung.spring.mybatis.BoardJoinUserMapper;
import jung.spring.mybatis.BoardMapper;
import jung.spring.mybatis.ChatMapper;
import jung.spring.mybatis.MemberMapper;
import jung.spring.mybatis.NoticeMapper;
import jung.spring.mybatis.PopupChatMapper;
import jung.spring.mybatis.PopupMapper;
import jung.spring.mybatis.PostingMapper;
import jung.spring.mybatis.PostingRecommandMapper;
import jung.spring.mybatis.QnaMapper;
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

@Repository
public class UserInfoDAOImpl implements UserInfoDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	/*===========로그인 하는 서비스============*/
	@Override
	public boolean selectUserInfo(String user_password, String user_id) {
		// TODO Auto-generated method stub
		MemberMapper userMapper = sqlSession.getMapper(MemberMapper.class);
		boolean userInfoCheck = false;
		String user_pw = userMapper.selectUserPasswordInfo(user_id);
		if(user_pw.equals(user_password)){
			userInfoCheck = true;
		}
		return userInfoCheck;
	}
	
	@Override
	public UserInfoVO getUserInfo(UserIdPasswordVO userIdPassword) {
		// TODO Auto-generated method stub
		MemberMapper userMapper = sqlSession.getMapper(MemberMapper.class);
		UserInfoVO userInfo = userMapper.selectUserInfo(userIdPassword);
		return userInfo;
	}
	
	@Override
	public ArrayList<PostingInfoVO> getPostings() {
		// TODO Auto-generated method stub
		PostingMapper postingMapper = sqlSession.getMapper(PostingMapper.class);
		ArrayList<PostingInfoVO> postingList = postingMapper.getPostings();
		return postingList;
	}
	/*===========로그인 하는 서비스============*/
	
	/*===========메인 화면 서비스============*/
	@Override
	public UserInfoVO getUser(String user_id) {
		// TODO Auto-generated method stub
		MemberMapper userMapper = sqlSession.getMapper(MemberMapper.class);
		UserInfoVO userInfo = userMapper.getUser(user_id);
		return userInfo;
	}
	/*===========메인 화면 서비스============*/
	
	/*===========유저 정보 리스트 가져오는 서비스============*/
	@Override
	public ArrayList<UserInfoVO> getMembers() {
		// TODO Auto-generated method stub
		MemberMapper userMapper = sqlSession.getMapper(MemberMapper.class);
		ArrayList<UserInfoVO> userList = userMapper.getMembers();
		return userList;
	}
	/*===========유저 정보 리스트 가져오는 서비스============*/
	
	/*===========유저 정보 저장하는 서비스============*/
	@Override
	public boolean addUser(HashMap<Object, Object> map) {
		// TODO Auto-generated method stub
		MemberMapper userMapper = sqlSession.getMapper(MemberMapper.class);
		boolean check = userMapper.addMember(map);
		return check;
	}
	/*===========유저 정보 저장하는 서비스============*/
	
	/*===========유저 id 찾는 서비스============*/
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
		if(str != null) {
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
	/*===========유저 id 찾는 서비스============*/
	
	/*===========유저 pw 찾는 서비스============*/
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
		if(userInfo != null) {
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
	/*===========유저 pw 찾는 서비스============*/
	
	/*===========유저 포스팅 등록하는 서비스============*/
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
	
	
	
	
	
	
	@Override
	public PostingInfoVO addUserPostingInfo(String user_id, String user_name, String postingContent) {
		// TODO Auto-generated method stub
		PostingInfoVO postingInfo = new PostingInfoVO();
		postingInfo.setUserId(user_id);
		postingInfo.setUserName(user_name);
		postingInfo.setPostingContent(postingContent);
		postingInfo.setPostingRecommandCount(0);
		postingInfo.setPostingDate(new Date());
		return postingInfo;
	}
	
	@Override
	public void addUserPosting(PostingInfoVO postingInfo) {
		// TODO Auto-generated method stub
		PostingMapper postingMapper = sqlSession.getMapper(PostingMapper.class);
		postingMapper.addUserPosting(postingInfo);
		
	}
	/*===========유저 포스팅 등록하는 서비스============*/
	
	/*===========사용자 별 팝업 창 생성============*/
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
	/*===========사용자 별 팝업 창 생성============*/
	
	/*===========사용자에 맞는 톡 번호 가져오는 서비스============*/
	@Override
	public int getPopupNumber(String user_id) {
		// TODO Auto-generated method stub
		PopupMapper popupMapper = sqlSession.getMapper(PopupMapper.class);
		int popupNumber = popupMapper.getPopupNumber(user_id);
		return popupNumber;
	}
	/*===========사용자에 맞는 톡 번호 가져오는 서비스============*/
	
	/*===========사용자 팝업 채팅 내용 가져오는 서비스============*/
	@Override
	public ArrayList<PopupChatInfoVO> getPopupChats(int popupNumber) {
		// TODO Auto-generated method stub
		PopupChatMapper popupChatMapper = sqlSession.getMapper(PopupChatMapper.class);
		ArrayList<PopupChatInfoVO> popupChatList = popupChatMapper.getPopupChats(popupNumber);
		return popupChatList;
	}
	/*===========사용자 팝업 채팅 내용 가져오는 서비스============*/
	
	/*===========사용자 팝업 채팅 입력 서비스============*/
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
	/*===========사용자 팝업 채팅 입력 서비스============*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*===========유저 포스팅 수정하는 서비스============*/
	@Override
	public PostingInfoVO getUserPostingInfo(String user_id, int postingNumber) {
		// TODO Auto-generated method stub
		PostingMapper postingMapper = sqlSession.getMapper(PostingMapper.class);
		PostingInfoVO postingInfo = postingMapper.getUserPosting(postingNumber);
		return postingInfo;
	}
	
	@Override
	public void updatePostingInfo(String user_id, String postingContent, String user_name, int postingNumber, int postingRecommandCount) {
		// TODO Auto-generated method stub
		PostingMapper postingMapper = sqlSession.getMapper(PostingMapper.class);
		PostingInfoVO postingInfo = new PostingInfoVO();
		postingInfo.setUserId(user_id);
		postingInfo.setUserName(user_name);
		postingInfo.setPostingContent(postingContent);
		postingInfo.setPostingNumber(postingNumber);
		postingInfo.setPostingRecommandCount(postingRecommandCount);
		postingMapper.updateUserPosting(postingInfo);
	}
	/*===========유저 포스팅 수정하는 서비스============*/
	
	/*===========유저 포스팅 삭제하는 서비스============*/
	@Override
	public void deletePostingInfo(String user_id, String postingContent, String user_name, int postingNumber, int postingRecommandCount) {
		// TODO Auto-generated method stub
		PostingMapper postingMapper = sqlSession.getMapper(PostingMapper.class);
		PostingInfoVO postingInfo = new PostingInfoVO();
		postingInfo.setUserId(user_id);
		postingInfo.setUserName(user_name);
		postingInfo.setPostingContent(postingContent);
		postingInfo.setPostingNumber(postingNumber);
		postingInfo.setPostingRecommandCount(postingRecommandCount);
		postingMapper.deleteUserPosting(postingInfo);
	}
	/*===========유저 포스팅 삭제하는 서비스============*/
	
	/*===========유저 포스팅 추천하는 서비스============*/
	@Override
	public void createUserPostingRecommand(String user_id, int postingNumber) {
		// TODO Auto-generated method stub
		PostingMapper postingMapper = sqlSession.getMapper(PostingMapper.class);
		PostingRecommandMapper postingRecommandMapper = sqlSession.getMapper(PostingRecommandMapper.class);
		boolean check = false;
		ArrayList<PostingRecommandInfoVO> postingRecommandInfoList = postingRecommandMapper.getUserPostingRecommand(user_id);
		PostingInfoVO posting = postingMapper.getUserPosting(postingNumber);
		
		for (int i = 0; i < postingRecommandInfoList.size(); i++) {
			if(postingRecommandInfoList.get(i).getPostingNumber() == postingNumber && postingRecommandInfoList.get(i).getUserId().equals(user_id)) {
				check = true;
				break;
			}
		}
		
		if(!check) {			
			PostingRecommandInfoVO postingRecommandInfo1 = new PostingRecommandInfoVO();
			postingRecommandInfo1.setPostingNumber(postingNumber);
			postingRecommandInfo1.setPostingRecommandCountCheck(0);
			postingRecommandInfo1.setUserId(user_id);
			postingRecommandMapper.addUserPostingRecommand(postingRecommandInfo1);
			System.out.println("??");
		}
		
		ArrayList<PostingRecommandInfoVO> postingRecommandList = postingRecommandMapper.getUserPostingRecommand(user_id);
		
		for (int i = 0; i < postingRecommandList.size(); i++) {
			if(postingRecommandList.get(i).getPostingNumber() == postingNumber && postingRecommandList.get(i).getUserId().equals(user_id)) {
				if(postingRecommandList.get(i).getPostingRecommandCountCheck() == 0) {
					System.out.println("hh");
					int count = 1;
					PostingInfoVO postingInfo = postingInfoForm(posting, count);
					postingMapper.updateUserPostingRecommand(postingInfo);
					PostingRecommandInfoVO postingRcInfo = postingRcInfoForm(user_id, postingNumber, count);
					postingRecommandMapper.updatePostingRecommand(postingRcInfo);
				} else {
					System.out.println("ㅗㅗ");
					int count = 0;
					PostingInfoVO postingInfo = postingInfoForm(posting, count);
					postingMapper.updateUserPostingRecommand(postingInfo);
					PostingRecommandInfoVO postingRcInfo = postingRcInfoForm(user_id, postingNumber, count);
					postingRecommandMapper.updatePostingRecommand(postingRcInfo);
					
				}
			}
		}
	}
	
	public PostingRecommandInfoVO postingRcInfoForm(String user_id, int postingNumber, int count) {
		PostingRecommandInfoVO postingRcInfo = new PostingRecommandInfoVO();
		postingRcInfo.setPostingNumber(postingNumber);
		postingRcInfo.setPostingRecommandCountCheck(count);
		postingRcInfo.setUserId(user_id);
		return postingRcInfo;
	}
	
	public PostingInfoVO postingInfoForm(PostingInfoVO posting, int count) {
		PostingInfoVO postingInfo = new PostingInfoVO();
		postingInfo.setPostingContent(posting.getPostingContent());
		postingInfo.setPostingNumber(posting.getPostingNumber());
		postingInfo.setUserId(posting.getUserId());
		postingInfo.setUserName(posting.getUserName());
		if(count == 1) {
			postingInfo.setPostingRecommandCount(posting.getPostingRecommandCount() + 1);			
		} else {
			postingInfo.setPostingRecommandCount(posting.getPostingRecommandCount() - 1);			
		}
		return postingInfo;
	}
	
	@Override
	public UserInfoVO getUserInfoRecommand(String user_id) {
		// TODO Auto-generated method stub
		MemberMapper userMapper = sqlSession.getMapper(MemberMapper.class);
		UserInfoVO userInfo = userMapper.selectUserInfoRecommand(user_id);
		return userInfo;
	}
	/*===========유저 포스팅 추천하는 서비스============*/
	
	/*===========공지사항 목록 서비스============*/
	@Override
	public ArrayList<NoticeInfoVO> getNotices() {
		// TODO Auto-generated method stub
		NoticeMapper noticeMapper = sqlSession.getMapper(NoticeMapper.class);
		ArrayList<NoticeInfoVO> noticeList = noticeMapper.getNotices();
		return noticeList;
	}
	/*===========공지사항 목록 서비스============*/
	
	/*===========공지사항 등록 서비스============*/
	@Override
	public void addNotice(String noticeWriter, String noticeTitle, String noticeContent) {
		// TODO Auto-generated method stub
		NoticeMapper noticeMapper = sqlSession.getMapper(NoticeMapper.class);
		ArrayList<NoticeInfoVO> noticeList = noticeMapper.getNotices();
		
		if(noticeList.size() == 0) {
			int noticeRegistNumber = 1;
			noticeMapper.addNotice(noticeRegist(noticeRegistNumber, noticeWriter, noticeTitle, noticeContent));			
		} else {
			int noticeRegistNumber = noticeList.size() + 1;
			noticeMapper.addNotice(noticeRegist(noticeRegistNumber, noticeWriter, noticeTitle, noticeContent));
		}
	}
	
	public NoticeInfoVO noticeRegist(int noticeRegistNumber, String noticeWriter, String noticeTitle, String noticeContent) {
		NoticeInfoVO noticeInfo = new NoticeInfoVO();
		noticeInfo.setNoticeRegistNumber(noticeRegistNumber);
		noticeInfo.setNoticeContent(noticeContent);
		noticeInfo.setNoticeWriter(noticeWriter);
		noticeInfo.setNoticeTitle(noticeTitle);
		noticeInfo.setNoticeDate(new Date());
		return noticeInfo;
	}
	/*===========공지사항 등록 서비스============*/
	
	/*===========공지사항 보기 서비스============*/
	@Override
	public NoticeInfoVO getNotice(int noticeNumber) {
		// TODO Auto-generated method stub
		NoticeMapper noticeMapper = sqlSession.getMapper(NoticeMapper.class);
		NoticeInfoVO noticeInfo = noticeMapper.getNotice(noticeNumber);
		return noticeInfo;
	}
	/*===========공지사항 보기 서비스============*/
	
	/*===========공지사항 수정 서비스============*/
	@Override
	public void modifyNotice(String noticeTitle, int noticeNumber, String noticeContent) {
		// TODO Auto-generated method stub
		NoticeMapper noticeMapper = sqlSession.getMapper(NoticeMapper.class);
		System.out.println(noticeTitle);
		System.out.println(noticeNumber);
		System.out.println(noticeContent);
		noticeMapper.modifyNotice(noticeModify(noticeTitle, noticeNumber, noticeContent));
	}
	
	public NoticeInfoVO noticeModify(String noticeTitle, int noticeNumber, String noticeContent) {
		NoticeInfoVO noticeInfo = new NoticeInfoVO();
		noticeInfo.setNoticeContent(noticeContent);
		noticeInfo.setNoticeTitle(noticeTitle);
		noticeInfo.setNoticeNumber(noticeNumber);
		return noticeInfo;
	}
	/*===========공지사항 수정 서비스============*/
	
	/*===========공지사항 삭제 서비스============*/
	@Override
	public void deleteNotice(int noticeNumber) {
		// TODO Auto-generated method stub
		NoticeMapper noticeMapper = sqlSession.getMapper(NoticeMapper.class);
		NoticeInfoVO noticeInfo = noticeMapper.getNotice(noticeNumber);
		ArrayList<NoticeInfoVO> noticeList = noticeMapper.getNotices();
		
		if(noticeInfo.getNoticeRegistNumber() > 1) {
			for (int i = 0; i < noticeList.size() - noticeInfo.getNoticeRegistNumber(); i++) {
				NoticeInfoVO notice = updateNotice(noticeList.get(i).getNoticeNumber(), noticeList.get(i).getNoticeRegistNumber());
				noticeMapper.modifyNoticeNumber(notice);
			}
		} else {
			for (int i = 0; i < noticeList.size() - 1; i++) {
				NoticeInfoVO notice = updateNotice(noticeList.get(i).getNoticeNumber(), noticeList.get(i).getNoticeRegistNumber());
				noticeMapper.modifyNoticeNumber(notice);
			}
		}
		noticeMapper.deleteNotice(noticeNumber);
	}

	public NoticeInfoVO updateNotice(int noticeNumber, int noticeRegistNumber) {
		// TODO Auto-generated method stub
		NoticeInfoVO notice = new NoticeInfoVO();
		notice.setNoticeRegistNumber(noticeRegistNumber - 1);
		notice.setNoticeNumber(noticeNumber);
		return notice;
	}
	/*===========공지사항 삭제 서비스============*/
	
	/*===========공지사항 조회수 서비스============*/
	@Override
	public void modifyNoticeReadCount(int noticeNumber) {
		// TODO Auto-generated method stub
		NoticeMapper noticeMapper = sqlSession.getMapper(NoticeMapper.class);
		NoticeInfoVO noticeInfo = noticeMapper.getNotice(noticeNumber);
		NoticeInfoVO modifyNoticeInfo = noticeReadCount(noticeInfo);
		noticeMapper.modifyNoticeReadCount(modifyNoticeInfo);
	}

	private NoticeInfoVO noticeReadCount(NoticeInfoVO noticeInfo) {
		// TODO Auto-generated method stub
		NoticeInfoVO notice = new NoticeInfoVO();
		notice.setNoticeNumber(noticeInfo.getNoticeNumber());
		notice.setNoticeReadCount(noticeInfo.getNoticeReadCount() + 1);
		return notice;
	}
	/*===========공지사항 조회수 서비스============*/
	
	/*===========게시판 목록 서비스============*/
	@Override
	public ArrayList<BoardInfoVO> getBoards() {
		// TODO Auto-generated method stub
		BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);
		ArrayList<BoardInfoVO> boardList = boardMapper.getBoards();
		return boardList;
	}
	
	@Override
	public ArrayList<BoardInfoVO> getBoardOthers(String subject) {
		// TODO Auto-generated method stub
		BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);
		ArrayList<BoardInfoVO> boardList = new ArrayList<BoardInfoVO>();
		String sb = null;//여길 고치자
		switch(subject) {
			case "study" : sb = "스터디"; boardList = boardMapper.getBoardOthers(boardSubjectInfo(sb)); break;
			case "exercise" : sb = "운동"; boardList = boardMapper.getBoardOthers(boardSubjectInfo(sb)); break;
			case "game" : sb = "게임"; boardList = boardMapper.getBoardOthers(boardSubjectInfo(sb)); break;
			case "tour" : sb = "여행"; boardList = boardMapper.getBoardOthers(boardSubjectInfo(sb)); break;
			case "meal" : sb = "식사"; boardList = boardMapper.getBoardOthers(boardSubjectInfo(sb)); break;
			case "etc" : sb = "기타"; boardList = boardMapper.getBoardOthers(boardSubjectInfo(sb)); break;
		}
		return boardList;
	}
	
	public BoardInfoVO boardSubjectInfo(String subject) {
		BoardInfoVO board = new BoardInfoVO();
		board.setBoardSubject(subject);
		return board;
	}
	/*===========게시판 목록 서비스============*/
	
	/*===========게시판 등록 서비스============*/
	@Override
	public void addBoard(String boardWriter, String boardTitle, String boardContent, String selectBoard, String user_id) {
		// TODO Auto-generated method stub
		BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);
		ArrayList<BoardInfoVO> boardList = boardMapper.getBoards();
		
		if(boardList.size() == 0) {
			int boardRegistNumber = 1;
			boardMapper.addBoard(boardRegist(boardRegistNumber, boardWriter, boardTitle, boardContent, selectBoard, user_id));			
		} else {
			int boardRegistNumber = boardList.size() + 1;
			boardMapper.addBoard(boardRegist(boardRegistNumber, boardWriter, boardTitle, boardContent, selectBoard, user_id));
		}
	}
	
	public BoardInfoVO boardRegist(int boardRegistNumber, String boardWriter, String boardTitle, String boardContent, 
			String selectBoard, String user_id) {
		BoardInfoVO boardInfo = new BoardInfoVO();
		boardInfo.setBoardRegistNumber(boardRegistNumber);
		boardInfo.setBoardUserId(user_id);
		boardInfo.setBoardTitle(boardTitle);
		boardInfo.setBoardWriter(boardWriter);
		boardInfo.setBoardContent(boardContent);
		boardInfo.setBoardDate(new Date());
		boardInfo.setBoardJoinUserNumber(1);
		boardInfo.setBoardSubject(selectBoard);
		boardInfo.setBoardFavorites("empty");
		boardInfo.setBoardJoins("empty");
		return boardInfo;
	}
	/*===========게시판 등록 서비스============*/
	
	/*===========게시글 보기 서비스============*/
	@Override
	public BoardInfoVO getBoard(int boardNumber) {
		// TODO Auto-generated method stub
		BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);
		BoardInfoVO boardInfo = boardMapper.getboard(boardNumber);
		return boardInfo;
	}
	/*===========게시글 보기 서비스============*/
	
	/*===========게시글 참여 서비스============*/
	@Override
	public void sendBoardJoin(BoardInfoVO boardInfo, UserInfoVO userInfo) {
		// TODO Auto-generated method stub
		BoardJoinUserMapper boardJoinUserMapper = sqlSession.getMapper(BoardJoinUserMapper.class);
		BoardJoinUserInfoVO boardJoinUserInfoVO = boardJoinUser(boardInfo, userInfo);
		boardJoinUserMapper.sendBoardJoin(boardJoinUserInfoVO);
	}
	
	public BoardJoinUserInfoVO boardJoinUser(BoardInfoVO boardInfo, UserInfoVO userInfo) {
		BoardJoinUserInfoVO boardJoinUserInfoVO = new BoardJoinUserInfoVO();
		boardJoinUserInfoVO.setBoardJoinUser_id(userInfo.getUser_id());
		boardJoinUserInfoVO.setBoardJoinUser_name(userInfo.getUser_name());
		boardJoinUserInfoVO.setBoardNumber(boardInfo.getBoardNumber());
		boardJoinUserInfoVO.setBoardJoinUserCheck(1);
		boardJoinUserInfoVO.setChatJoinCheck(1);
		return boardJoinUserInfoVO;
	}
	/*===========게시글 참여 서비스============*/
	
	/*===========게시글 참여취소 서비스============*/
	@Override
	public void sendCancelBoardJoin(BoardJoinUserInfoVO boardJoinUserInfo) {
		// TODO Auto-generated method stub
		BoardJoinUserMapper boardJoinUserMapper = sqlSession.getMapper(BoardJoinUserMapper.class);
		boardJoinUserMapper.sendCancelBoardJoin(boardJoinUserInfo);
	}
	
	@Override
	public BoardJoinUserInfoVO getBoardJoinUser(int boardNumber, String user_id) {
		// TODO Auto-generated method stub
		BoardJoinUserMapper boardJoinUserMapper = sqlSession.getMapper(BoardJoinUserMapper.class);
		BoardJoinUserInfoVO boardJoinUser = boardJoinUserMapper.getBoardJoinUser(boardJoin(boardNumber, user_id));
		return boardJoinUser;
	}
	
	public BoardJoinUserInfoVO boardJoin(int boardNumber, String user_id) {
		BoardJoinUserInfoVO boardJoinUser = new BoardJoinUserInfoVO();
		boardJoinUser.setBoardNumber(boardNumber);
		boardJoinUser.setBoardJoinUser_id(user_id);
		return boardJoinUser;
	}
	/*===========게시글 참여취소 서비스============*/
	
	/*===========게시글 참여자 명단 서비스============*/
	@Override
	public ArrayList<BoardJoinUserInfoVO> getBoardJoinUsers() {
		// TODO Auto-generated method stub
		BoardJoinUserMapper boardJoinUserMapper = sqlSession.getMapper(BoardJoinUserMapper.class);
		ArrayList<BoardJoinUserInfoVO> boardJoinUserList = boardJoinUserMapper.getBoardJoinUsers();
		return boardJoinUserList;
	}
	/*===========게시글 참여자 명단 서비스============*/
	
	/*===========게시글 참여자 수락 서비스============*/
	@Override
	public void modifyBoardJoinUserInfo(BoardJoinUserInfoVO boardJoinUserInfo) {
		// TODO Auto-generated method stub
		BoardJoinUserMapper boardJoinUserMapper = sqlSession.getMapper(BoardJoinUserMapper.class);
		BoardJoinUserInfoVO boardJoinUser = new BoardJoinUserInfoVO();
		boardJoinUser.setBoardJoinNumber(boardJoinUserInfo.getBoardJoinNumber());
		boardJoinUser.setBoardJoinUserCheck(boardJoinUserInfo.getBoardJoinUserCheck() + 1);
		boardJoinUserMapper.modifyBoardJoinUserInfo(boardJoinUser);
		
		BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);
		BoardInfoVO board = boardMapper.getboard(boardJoinUserInfo.getBoardNumber());
		String str = boardJoinUserInfo.getBoardJoinUser_id() + "|" + boardJoinUserInfo.getBoardNumber();
		
		String[] boardJoins = board.getBoardJoins().split(",");
		String join = joinPlus(boardJoins, str);
		board.setBoardJoins(join);
		boardMapper.modifyJoinBoard(board);
		String[] boardFavorites = board.getBoardFavorites().split(",");
		String favorite = favoritePlus(boardFavorites, str);
		board.setBoardFavorites(favorite);
		boardMapper.modifyFavoriteBoard(board);
	}
	
	public String joinPlus(String[] joins, String str) {
		String join = str;
		for (int i = 0; i < joins.length; i++) { if(joins[i].equals("empty")) {	break; } else { join += "," + joins[i]; } }
		return join;
	}
	public String favoritePlus(String[] favorites, String str) {
		String favorite = str;
		for (int i = 0; i < favorites.length; i++) { if(favorites[i].equals("empty")) {	break; } else { favorite += "," + favorites[i]; } }
		return favorite;
	}
	
	@Override
	public void modifyBoardJoinUserNumber(BoardInfoVO boardInfo) {
		// TODO Auto-generated method stub
		BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);
		BoardInfoVO board = new BoardInfoVO();
		board.setBoardJoinUserNumber(boardInfo.getBoardJoinUserNumber() + 1);
		board.setBoardNumber(boardInfo.getBoardNumber());
		boardMapper.modifyBoardJoinUserNumber(board);
	}
	/*===========게시글 참여자 수락 서비스============*/

	/*===========게시글 참여자 거절 서비스============*/
	@Override
	public void deleteBoardJoinUserInfo(BoardJoinUserInfoVO boardJoinUserInfo) {
		// TODO Auto-generated method stub
		BoardJoinUserMapper boardJoinUserMapper = sqlSession.getMapper(BoardJoinUserMapper.class);
		boardJoinUserMapper.deleteBoardJoinUserInfo(boardJoinUserInfo);
	}
	/*===========게시글 참여자 거절 서비스============*/
	
	/*===========게시글 수정 서비스============*/
	@Override
	public void modifyBoard(String user_id, int boardNumber, String boardTitle, String boardContent) {
		// TODO Auto-generated method stub
		BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);
		BoardInfoVO board = new BoardInfoVO();
		board.setBoardDate(new Date());
		board.setBoardContent(boardContent);
		board.setBoardNumber(boardNumber);
		board.setBoardTitle(boardTitle);
		board.setBoardUserId(user_id);
		boardMapper.modifyBoard(board);
	}
	/*===========게시글 수정 서비스============*/
	
	/*===========게시글 삭제 서비스============*/
	@Override
	public void deleteBoard(UserInfoVO userInfo, BoardInfoVO boardInfo) {
		// TODO Auto-generated method stub
		BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);
		BoardJoinUserMapper boardJoinUserMapper = sqlSession.getMapper(BoardJoinUserMapper.class);
		ArrayList<BoardInfoVO> boardList = boardMapper.getBoards();
		
		if(boardInfo.getBoardRegistNumber() > 1) {
			for (int i = 0; i < boardList.size() - boardInfo.getBoardRegistNumber(); i++) {
				BoardInfoVO board = modifyBoard(boardList.get(i).getBoardNumber(), boardList.get(i).getBoardRegistNumber());
				boardMapper.modifyBoardNumber(board);
			}
		} else {
			for (int i = 0; i < boardList.size() - 1; i++) {
				BoardInfoVO board = modifyBoard(boardList.get(i).getBoardNumber(), boardList.get(i).getBoardRegistNumber());
				boardMapper.modifyBoardNumber(board);
			}
		}
		
		boardMapper.deleteBoard(boardInfo.getBoardNumber());
		boardJoinUserMapper.deleteBoard(boardInfo.getBoardNumber());
	}
	/*===========게시글 삭제 서비스============*/

	/*===========채팅 서비스============*/
	@Override
	public void chatJoin(int boardNumber, String user_id, boolean chatJoinCheck) {
		// TODO Auto-generated method stub
		BoardJoinUserMapper boardJoinUserMapper = sqlSession.getMapper(BoardJoinUserMapper.class);
		BoardJoinUserInfoVO boardJoin = new BoardJoinUserInfoVO();
		boardJoin.setBoardJoinUser_id(user_id);
		boardJoin.setBoardNumber(boardNumber);
		if(chatJoinCheck) {
			boardJoin.setChatJoinCheck(2);			
		} else {
			boardJoin.setChatJoinCheck(1);
		}
		boardJoinUserMapper.modifyBoardJoinUser(boardJoin);
	}
	/*===========채팅 서비스============*/
	
	/*===========채팅 저장 서비스============*/
	@Override
	public void addChat(String user_id, int boardNumber, String content) {
		// TODO Auto-generated method stub
		ChatMapper chatMapper = sqlSession.getMapper(ChatMapper.class);
		ChatInfoVO chat = chatInfo(user_id, boardNumber, content);
		chatMapper.addChat(chat);
	}
	
	public ChatInfoVO chatInfo(String user_id, int boardNumber, String content) {
		ChatInfoVO chat = new ChatInfoVO();
		chat.setChatNum(boardNumber);
		chat.setChatUserId(user_id);
		chat.setChatContent(content);
		chat.setChatDate(new Date());
		return chat;
	}
	/*===========채팅 저장 서비스============*/

	/*===========채팅 대화 불러오기 서비스============*/
	@Override
	public ArrayList<ChatInfoVO> getChats(int boardNumber) {
		// TODO Auto-generated method stub
		ChatMapper chatMapper = sqlSession.getMapper(ChatMapper.class);
		ArrayList<ChatInfoVO> chatList = chatMapper.getChats(boardNumber);
		return chatList;
	}
	/*===========채팅 대화 불러오기 서비스============*/
	
	/*===========채팅 회원 정보 서비스============*/
	@Override
	public ArrayList<BoardJoinUserInfoVO> getJoinUsers(int boardNumber) {
		// TODO Auto-generated method stub
		BoardJoinUserMapper boardJoinUserMapper = sqlSession.getMapper(BoardJoinUserMapper.class);
		BoardJoinUserInfoVO boardJoinUserInfo = new BoardJoinUserInfoVO();
		boardJoinUserInfo.setBoardNumber(boardNumber);
		boardJoinUserInfo.setBoardJoinUserCheck(2);
		ArrayList<BoardJoinUserInfoVO> boardList = boardJoinUserMapper.getJoinUsers(boardJoinUserInfo);
		return boardList;
	}
	/*===========채팅 회원 정보 서비스============*/

	/*===========게시글 즐겨찾기 서비스============*/
	@Override
	public void addFavoriteBoard(String user_id, int boardNumber) {
		// TODO Auto-generated method stub
		BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);
		BoardInfoVO board = boardMapper.getboard(boardNumber);
		String str = user_id + "|" + boardNumber;
		if(board.getBoardFavorites().equals("empty")) {
			board.setBoardFavorites(str);
			boardMapper.modifyFavoriteBoard(board);
		} else {
			board.setBoardFavorites(board.getBoardFavorites() + "," + str);
			boardMapper.modifyFavoriteBoard(board);
		}
	}
	/*===========게시글 즐겨찾기  서비스============*/
	
	/*===========게시글 즐겨찾기 취소 서비스============*/
	@Override
	public void modifyFavoriteBoard(String user_id, int boardNumber) {
		// TODO Auto-generated method stub
		BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);
		BoardInfoVO board = boardMapper.getboard(boardNumber);
		String str = user_id + "|" + boardNumber;				  // 0   1   2   3
		ArrayList<String> arrayFavorites = new ArrayList<String>();
		String[] favorites = board.getBoardFavorites().split(",");//c|2 b|2 a|2 d|2 
		for (int i = 0; i < favorites.length; i++) {
			arrayFavorites.add(favorites[i]);
		}
		for (int i = 0; i < favorites.length; i++) {
			if(arrayFavorites.get(i).equals(str)) {
				arrayFavorites.remove(str);
				break;
			}
		}
		String str1 = null;
		for (int i = 0; i < arrayFavorites.size(); i++) {
			if(str1 == null) {
				str1 = arrayFavorites.get(i);
			} else {
				str1 += "," + arrayFavorites.get(i);
			}
		}

		if(str1 == null) {
			str1 = "empty";
		}
		
		board.setBoardFavorites(str1);
		boardMapper.modifyFavoriteBoard(board);
	}
	/*===========게시글 즐겨찾기 취소 서비스============*/
	
	/*===========마이페이지 즐겨찾기 목록 가져오기 서비스============*/
	@Override
	public ArrayList<BoardInfoVO> getUserBoard(String user_id) {
		// TODO Auto-generated method stub
		BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);
		ArrayList<BoardInfoVO> arrayBoardList = boardMapper.getBoards();
		ArrayList<String> boardListTemp = new ArrayList<String>();
		int[] number = new int[arrayBoardList.size()];
		for (int i = 0; i < arrayBoardList.size(); i++) {
			boardListTemp.add(arrayBoardList.get(i).getBoardFavorites());
			number[i] = 0;
		}
		String[] arrayTemp = new String[boardListTemp.size()];
		for (int i = 0; i < boardListTemp.size(); i++) {
			arrayTemp = boardListTemp.get(i).split(",");
			for (int j = 0; j < arrayTemp.length; j++) {
				String[] temp = arrayTemp[j].split("|");
				if(temp[0].equals(user_id)) {
					number[i] = arrayBoardList.get(i).getBoardNumber();
					break;
				}
			}
		}
		BoardInfoVO boardList = new BoardInfoVO();
		ArrayList<BoardInfoVO> boardLists = new ArrayList<BoardInfoVO>();
		for (int i = 0; i < number.length; i++) {
			if(number[i] != 0) {
				boardList = boardMapper.getboard(number[i]);
				boardLists.add(boardList);
			}
		}
		
		return boardLists;
	}
	/*===========마이페이지 즐겨찾기 목록 가져오기 서비스============*/

	/*===========마이페이지 회원정보수정 서비스============*/
	@Override
	public void modifyUserInfo(String user_name, String user_detailAddress,	String user_email, int user_phone, String user_id) {
		// TODO Auto-generated method stub
		MemberMapper userMapper = sqlSession.getMapper(MemberMapper.class);
		UserInfoVO userInfo = new UserInfoVO();
		userInfo.setUser_name(user_name);
		userInfo.setUser_id(user_id);
		userInfo.setUser_detailAddress(user_detailAddress);
		userInfo.setUser_email(user_email);
		userInfo.setUser_phone(user_phone);
		userMapper.modifyUserInfo(userInfo);
	}
	/*===========마이페이지 회원정보수정 서비스============*/
	
	/*===========마이페이지 추천 포스팅 가져오기 서비스============*/
	@Override
	public ArrayList<PostingInfoVO> getPostingRecommands(String user_id) {
		// TODO Auto-generated method stub
		PostingRecommandMapper postingRecommandMapper = sqlSession.getMapper(PostingRecommandMapper.class);
		PostingMapper postingMapper = sqlSession.getMapper(PostingMapper.class);
		ArrayList<PostingRecommandInfoVO> postingRecommands = postingRecommandMapper.getPostingRecommands(user_id);
		ArrayList<PostingInfoVO> postingList = new ArrayList<PostingInfoVO>();
		for (int i = 0; i < postingRecommands.size(); i++) {
			if(postingRecommands.get(i).getPostingRecommandCountCheck() == 1) {
				postingList.add(postingMapper.getPosting(postingRecommands.get(i).getPostingNumber()));
			}
		}
		/*
		 * ArrayList<PostingInfoVO> postingRecommandList = new
		 * ArrayList<PostingInfoVO>(); for (int i = 0; i < postingRecommands.size();
		 * i++) {
		 * postingRecommandList.add(postingMapper.getPosting(postingRecommands.get(i).
		 * getPostingNumber())); }
		 */
		return postingList;
	}
	/*===========마이페이지 추천 포스팅 가져오기 서비스============*/

	/*===========마이페이지 추천 포스팅 가져오기 서비스============*/
	@Override
	public void deletePosting(String user_id, int postingNumber) {
		// TODO Auto-generated method stub
		PostingMapper postingMapper = sqlSession.getMapper(PostingMapper.class);
		PostingInfoVO posting = new PostingInfoVO();
		posting.setUserId(user_id);
		posting.setPostingNumber(postingNumber);
		postingMapper.deleteUserPosting(posting);
	}
	/*===========마이페이지 추천 포스팅 가져오기 서비스============*/
	
	/*===========마이페이지 추천 포스팅 가져오기 서비스============*/
	@Override
	public void deleteMypageBoard(int boardNumber) {
		// TODO Auto-generated method stub
		BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);
		boardMapper.deleteBoard(boardNumber);
	}	
	/*===========마이페이지 추천 포스팅 가져오기 서비스============*/

	/*===========회원탈퇴 서비스============*/
	@Override
	public void userSecession(String user_id) {
		// TODO Auto-generated method stub
		BoardJoinUserMapper boardJoinUserMapper = sqlSession.getMapper(BoardJoinUserMapper.class);
		BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);
		ChatMapper chatMapper = sqlSession.getMapper(ChatMapper.class);
		MemberMapper userMapper = sqlSession.getMapper(MemberMapper.class);
		PostingMapper postingMapper = sqlSession.getMapper(PostingMapper.class);
		PostingRecommandMapper postingRecommandMapper = sqlSession.getMapper(PostingRecommandMapper.class);
		QnaMapper qnaMapper = sqlSession.getMapper(QnaMapper.class);
		boardJoinUserMapper.userSecession(user_id);
		boardMapper.userSecession(user_id);
		chatMapper.userSecession(user_id);
		userMapper.userSecession(user_id);
		postingMapper.userSecession(user_id);
		postingRecommandMapper.userSecession(user_id);
		qnaMapper.userSecession(user_id);
	}
	/*===========회원탈퇴 서비스============*/
	
	/*===========문의사항 서비스============*/
	@Override
	public ArrayList<QnaInfoVO> getQnas(String user_id) {
		// TODO Auto-generated method stub
		QnaMapper qnaMapper = sqlSession.getMapper(QnaMapper.class);
		ArrayList<QnaInfoVO> qnaList = qnaMapper.getQnas(user_id);
		return qnaList;
	}
	/*===========문의사항 서비스============*/
	
	/*===========문의사항 등록 서비스============*/
	@Override
	public void addQna(String user_id, String qnaTitle, String qnaContent) {
		// TODO Auto-generated method stub
		QnaMapper qnaMapper = sqlSession.getMapper(QnaMapper.class);
		MemberMapper userMapper = sqlSession.getMapper(MemberMapper.class);
		UserInfoVO userInfo = userMapper.getUser(user_id);
		ArrayList<QnaInfoVO> qnaList = qnaMapper.getQnas(user_id);
		int qnaRegistNumber = 1;
		
		if(qnaList.size() == 0) {
			qnaRegistNumber = 1;
		} else {
			qnaRegistNumber = qnaList.size() + 1;
		}
		
		QnaInfoVO qnaInfo = qnaInfoTemp(user_id, qnaTitle, qnaContent, qnaRegistNumber, userInfo);
		qnaMapper.addQna(qnaInfo);
	}
	
	public QnaInfoVO qnaInfoTemp(String user_id, String qnaTitle, String qnaContent, int qnaRegistNumber, UserInfoVO userInfo) {
		QnaInfoVO qnaInfo = new QnaInfoVO();
		qnaInfo.setQnaComment("empty");
		qnaInfo.setQnaContent(qnaContent);
		qnaInfo.setQnaDate(new Date());
		qnaInfo.setQnaRegistNumber(qnaRegistNumber);
		qnaInfo.setQnaTitle(qnaTitle);
		qnaInfo.setQnaUserId(user_id);
		qnaInfo.setQnaWriter(userInfo.getUser_name());
		return qnaInfo;
	}
	/*===========문의사항 등록 서비스============*/
	
	/*===========문의사항 삭제 서비스============*/
	@Override
	public void deleteQna(int qnaNumber) {
		// TODO Auto-generated method stub
		QnaMapper qnaMapper = sqlSession.getMapper(QnaMapper.class);
		QnaInfoVO qnaInfo = qnaMapper.getQna(qnaNumber);
		ArrayList<QnaInfoVO> qnaList = qnaMapper.getQnas(qnaInfo.getQnaUserId());
		
		if(qnaInfo.getQnaRegistNumber() > 1) {
			for (int i = 0; i < qnaList.size() - qnaInfo.getQnaRegistNumber(); i++) {
				QnaInfoVO qna = modifyQna(qnaList.get(i).getQnaNumber(), qnaList.get(i).getQnaRegistNumber());
				qnaMapper.modifyQnaNumber(qna);
			}
		} else {
			for (int i = 0; i < qnaList.size() - 1; i++) {
				QnaInfoVO qna = modifyQna(qnaList.get(i).getQnaNumber(), qnaList.get(i).getQnaRegistNumber());
				qnaMapper.modifyQnaNumber(qna);
			}
		}
		
		qnaMapper.deleteQna(qnaNumber);
	}

	public QnaInfoVO modifyQna(int qnaNumber, int qnaRegistNumber) {
		// TODO Auto-generated method stub
		QnaInfoVO qna = new QnaInfoVO();
		qna.setQnaRegistNumber(qnaRegistNumber - 1);
		qna.setQnaNumber(qnaNumber);
		return qna;
	}
	/*===========문의사항 삭제 서비스============*/
	
	/*===========문의사항 보기 서비스============*/
	@Override
	public QnaInfoVO getQna(int qnaNumber) {
		// TODO Auto-generated method stub
		QnaMapper qnaMapper = sqlSession.getMapper(QnaMapper.class);
		QnaInfoVO qnaInfo = qnaMapper.getQna(qnaNumber);
		return qnaInfo;
	}
	/*===========문의사항 보기 서비스============*/
	
	/*===========문의사항 수정 서비스============*/
	@Override
	public void qnaModify(String user_id, int qnaNumber, String qnaTitle, String qnaContent) {
		// TODO Auto-generated method stub
		QnaMapper qnaMapper = sqlSession.getMapper(QnaMapper.class);
		QnaInfoVO qnaInfo = new QnaInfoVO();
		qnaInfo.setQnaUserId(user_id);
		qnaInfo.setQnaNumber(qnaNumber);
		qnaInfo.setQnaTitle(qnaTitle);
		qnaInfo.setQnaContent(qnaContent);
		qnaMapper.qnaModify(qnaInfo);
	}
	/*===========문의사항 수정 서비스============*/
	
	/*===========관리자 포스팅 삭제 서비스============*/
	@Override
	public void adminDeletePosting(int postingNumber) {
		// TODO Auto-generated method stub
		PostingMapper postingMapper = sqlSession.getMapper(PostingMapper.class);
		postingMapper.adminDeletePosting(postingNumber);
	}
	/*===========관리자 포스팅 삭제 서비스============*/
	
	/*===========관리자 게시글 삭제 서비스============*/
	@Override
	public void adminBoardDelete(int boardNumber) {
		// TODO Auto-generated method stub
		BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);
		BoardInfoVO boardInfo = boardMapper.getboard(boardNumber);
		ArrayList<BoardInfoVO> boardList = boardMapper.getBoards();
	
		if(boardInfo.getBoardRegistNumber() > 1) {
			for (int i = 0; i < boardList.size() - boardInfo.getBoardRegistNumber(); i++) {
				BoardInfoVO board = modifyBoard(boardList.get(i).getBoardNumber(), boardList.get(i).getBoardRegistNumber());
				boardMapper.modifyBoardNumber(board);
			}
		} else {
			for (int i = 0; i < boardList.size() - 1; i++) {
				BoardInfoVO board = modifyBoard(boardList.get(i).getBoardNumber(), boardList.get(i).getBoardRegistNumber());
				boardMapper.modifyBoardNumber(board);
			}
		}
		boardMapper.adminBoardDelete(boardNumber);
	}

	public BoardInfoVO modifyBoard(int boardNumber, int boardRegistNumber) {
		// TODO Auto-generated method stub
		BoardInfoVO board = new BoardInfoVO();
		board.setBoardRegistNumber(boardRegistNumber - 1);
		board.setBoardNumber(boardNumber);
		return board;
	}
	/*===========관리자 게시글 삭제 서비스============*/
	
	/*===========관리자 게시글 삭제 서비스============*/
	@Override
	public ArrayList<QnaInfoVO> getQnaInfos() {
		// TODO Auto-generated method stub
		QnaMapper qnaMapper = sqlSession.getMapper(QnaMapper.class);
		ArrayList<QnaInfoVO> qnaList = qnaMapper.getQnaInfos();
		return qnaList;
	}
	/*===========관리자 게시글 삭제 서비스============*/
	
	/*===========관리자 게시글 삭제 서비스============*/
	@Override
	public void modifyQnaComment(String qna_id, int qnaNumber, String qnaComment) {
		// TODO Auto-generated method stub
		QnaMapper qnaMapper = sqlSession.getMapper(QnaMapper.class);
		QnaInfoVO qnaInfo = new QnaInfoVO();
		qnaInfo.setQnaComment(qnaComment);
		qnaInfo.setQnaNumber(qnaNumber);
		qnaInfo.setQnaUserId(qna_id);
		qnaMapper.modifyQnaComment(qnaInfo);
		
	}
	/*===========관리자 게시글 삭제 서비스============*/
	
	/*=========== 게시글 회원 추방 서비스============*/
	@Override
	public void userBoardOut(String boardJoinUser_id, int boardNumber) {
		// TODO Auto-generated method stub
		BoardJoinUserMapper boardJoinUserMapper = sqlSession.getMapper(BoardJoinUserMapper.class);
		BoardJoinUserInfoVO boardJoinUserInfo = new BoardJoinUserInfoVO();
		boardJoinUserInfo.setBoardJoinUser_id(boardJoinUser_id);
		boardJoinUserInfo.setBoardNumber(boardNumber);
		BoardJoinUserInfoVO boardJoinUser = boardJoinUserMapper.getBoardJoinUser(boardJoinUserInfo);
		
		BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);
		BoardInfoVO board = boardMapper.getboard(boardNumber);
		String str = boardJoinUser.getBoardJoinUser_id() + "|" + boardNumber;
		String[] joins = board.getBoardJoins().split(",");
		String join = joinSubtract(joins, str);
		String[] favorites = board.getBoardFavorites().split(",");
		String favorite = favoriteSubtract(favorites, str);
		
		board.setBoardFavorites(join);
		boardMapper.modifyJoinBoard(board);
		board.setBoardFavorites(favorite);
		boardMapper.modifyFavoriteBoard(board);
		
		boardJoinUserMapper.deleteUserBoardOut(boardJoinUserInfo);
	}
	
	public String joinSubtract(String[] joins, String str) {
		String join = null;
		ArrayList<String> arrayJoins = new ArrayList<String>();
		for (int i = 0; i < joins.length; i++) { arrayJoins.add(joins[i]); }
		for (int i = 0; i < joins.length; i++) { if(arrayJoins.get(i).equals(str)) { arrayJoins.remove(str); break; } }
		for (int i = 0; i < arrayJoins.size(); i++) { if(join == null) { join = arrayJoins.get(i); } else { join += "," + arrayJoins.get(i); } }
		if(join == null) { join = "empty"; }
		return join;
	}
	
	public String favoriteSubtract(String[] favorites, String str) {
		String favorite = null;
		ArrayList<String> arrayfavorites = new ArrayList<String>();
		for (int i = 0; i < favorites.length; i++) { arrayfavorites.add(favorites[i]); }
		for (int i = 0; i < favorites.length; i++) { if(arrayfavorites.get(i).equals(str)) { arrayfavorites.remove(str); break; } }
		for (int i = 0; i < arrayfavorites.size(); i++) { if(favorite == null) { favorite = arrayfavorites.get(i); } else { favorite += "," + arrayfavorites.get(i); } }
		if(favorite == null) { favorite = "empty"; }
		return favorite;
	}
	/*=========== 게시글 회원 추방 서비스============*/
	
	/*=========== 게시글 참여자 수 낮추기 서비스============*/
	@Override
	public void boardJoinUserNumberDown(int boardNumber) {
		// TODO Auto-generated method stub
		BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);
		BoardInfoVO board = boardMapper.getboard(boardNumber);
		BoardInfoVO boardInfo = new BoardInfoVO();
		boardInfo.setBoardNumber(boardNumber);
		boardInfo.setBoardJoinUserNumber(board.getBoardJoinUserNumber() - 1);
		boardMapper.boardJoinUserNumberDown(boardInfo);
	}
	/*===========게시글  참여자 수 낮추기 서비스============*/
	
	/*===========게시글  검색 서비스============*/
	@Override
	public String getSearchBoard(String searchText) {
		// TODO Auto-generated method stub
		BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);
		ArrayList<BoardInfoVO> boardList = boardMapper.getBoards();
		String[] searchBoardList = new String[boardList.size()];
		int[] searchBoardListNumber = new int[boardList.size()]; 
		for (int i = 0; i < searchBoardListNumber.length; i++) {
			searchBoardListNumber[i] = boardList.get(i).getBoardNumber();
		}																				
																				
		String list = null;		  
		for (int i = 0; i < boardList.size(); i++) {					  
			searchBoardList[i] = boardList.get(i).getBoardTitle();
		}
		int searchLength = searchText.length();
		for (int i = 0; i < searchBoardList.length; i++) {
			for (int j = 0; j < searchBoardList[i].length(); j++) {
				String str = searchBoardList[i].substring(j, searchLength + j);
				if(searchBoardList[i].length() <= searchLength + j) {
					if(str.equals(searchText)) {
						if(list == null) {
							list = String.valueOf(boardList.get(i).getBoardNumber());
						} else {
							list += "," + String.valueOf(boardList.get(i).getBoardNumber());;
						}
						break;
					}
					break;
				}
				if(str.equals(searchText)) {
					if(list == null) {
						list = String.valueOf(boardList.get(i).getBoardNumber());
					} else {
						list += "," + String.valueOf(boardList.get(i).getBoardNumber());;
					}
					break;
				}
			}
		}
		if(list == null) {
			list = "notSearch";
		}
		return list;
	}
	
	@Override
	public ArrayList<BoardInfoVO> getSearchBoards(String searchBoardList) {
		// TODO Auto-generated method stub
		System.out.println(searchBoardList);
		BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);
		ArrayList<BoardInfoVO> boardList = new ArrayList<BoardInfoVO>();
		String[] boardNumber = searchBoardList.split(",");
		for (int i = 0; i < boardNumber.length; i++) {
			boardList.add(boardMapper.getboard(Integer.parseInt(boardNumber[i])));
		}
		
		return boardList;
	}
	/*===========게시글  검색 서비스============*/
	
	/*===========포스팅 추천 알람 서비스============*/
	@Override
	public void addAlarmPosting(String user_id, int postingNumber) {
		// TODO Auto-generated method stub
		MemberMapper userMapper = sqlSession.getMapper(MemberMapper.class);
		PostingMapper postingMapper = sqlSession.getMapper(PostingMapper.class);
		AlarmMapper alarmMapper = sqlSession.getMapper(AlarmMapper.class);
		UserInfoVO userInfo = userMapper.getUser(user_id);
		PostingInfoVO posting = postingMapper.getPosting(postingNumber);
		AlarmInfoVO alarmInfo = new AlarmInfoVO();
		alarmInfo.setAlarmContent(userInfo.getUser_name() + "님이 당신의 포스팅을 추천하였습니다!");
		alarmInfo.setAlarmDate(new Date());
		alarmInfo.setAlarmMyId(user_id);
		alarmInfo.setAlarmYouId(posting.getUserId() + ",posting," + postingNumber);
		alarmMapper.addAlarm(alarmInfo);
	}
	/*===========포스팅 추천 알람 서비스============*/
	
	/*===========알람 서비스============*/
	@Override
	public ArrayList<AlarmInfoVO> getAlarms() {
		// TODO Auto-generated method stub
		AlarmMapper alarmMapper = sqlSession.getMapper(AlarmMapper.class);
		ArrayList<AlarmInfoVO> alarmList = alarmMapper.getAlarms();
		return alarmList;
	}
	/*===========알람 서비스============*/

	/*===========게시글 참가 알람 서비스============*/
	@Override
	public void addAlarmBoard(BoardInfoVO boardInfo, UserInfoVO userInfo) {
		// TODO Auto-generated method stub
		AlarmMapper alarmMapper = sqlSession.getMapper(AlarmMapper.class);
		AlarmInfoVO alarmInfo = new AlarmInfoVO();
		alarmInfo.setAlarmContent(userInfo.getUser_name() + "님이 당신의 게시글에 참가하기를 원합니다.");
		alarmInfo.setAlarmDate(new Date());
		alarmInfo.setAlarmMyId(userInfo.getUser_id());
		alarmInfo.setAlarmYouId(boardInfo.getBoardUserId() + ",board," + boardInfo.getBoardNumber());
		alarmMapper.addAlarm(alarmInfo);
	}
	/*===========게시글 참가 알람 서비스============*/
	
	/*===========게시글 참가 성공 알람 서비스============*/
	@Override
	public void addAlarmBoardJoinSuccess(String user_id, BoardJoinUserInfoVO boardJoinUserInfo, int boardNumber) {
		// TODO Auto-generated method stub
		AlarmMapper alarmMapper = sqlSession.getMapper(AlarmMapper.class);
		BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);
		BoardInfoVO board = boardMapper.getboard(boardNumber);
		AlarmInfoVO alarmInfo = new AlarmInfoVO();
		alarmInfo.setAlarmContent(boardJoinUserInfo.getBoardJoinUser_name() + "님! 저희" + board.getBoardTitle() + "에 오신것을 환영합니다!");
		alarmInfo.setAlarmDate(new Date());
		alarmInfo.setAlarmMyId(user_id);
		alarmInfo.setAlarmYouId(boardJoinUserInfo.getBoardJoinUser_id() + ",boardSuccess," + boardNumber);
		alarmMapper.addAlarm(alarmInfo);
	}
	/*===========게시글 참가 성공 알람 서비스============*/
	
	/*===========게시글 참가 거절 알람 서비스============*/
	@Override
	public void addAlarmBoardJoinFail(String user_id, BoardJoinUserInfoVO boardJoinUserInfo, int boardNumber) {
		// TODO Auto-generated method stub
		AlarmMapper alarmMapper = sqlSession.getMapper(AlarmMapper.class);
		BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);
		BoardInfoVO board = boardMapper.getboard(boardNumber);
		AlarmInfoVO alarmInfo = new AlarmInfoVO();
		alarmInfo.setAlarmContent(boardJoinUserInfo.getBoardJoinUser_name() + "님! 저희" + board.getBoardTitle() + "에 들어오시지 못한 점 대단히 죄송합니다. 저희 모임보다 분명 더 좋은 모임을 찾으시길 바랍니다!");
		alarmInfo.setAlarmDate(new Date());
		alarmInfo.setAlarmMyId(user_id);
		alarmInfo.setAlarmYouId(boardJoinUserInfo.getBoardJoinUser_id() + ",boardSuccess," + boardNumber);
		alarmMapper.addAlarm(alarmInfo);
	}
	/*===========게시글 참가 거절 알람 서비스============*/
	
	/*===========게시글 참가 거절 알람 서비스============*/
	@Override
	public void addAlarmBoardOut(String user_id, BoardJoinUserInfoVO boardJoinUserInfo, int boardNumber) {
		// TODO Auto-generated method stub
		AlarmMapper alarmMapper = sqlSession.getMapper(AlarmMapper.class);
		BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);
		BoardInfoVO board = boardMapper.getboard(boardNumber);
		AlarmInfoVO alarmInfo = new AlarmInfoVO();
		alarmInfo.setAlarmContent(boardJoinUserInfo.getBoardJoinUser_name() + "님! 저희" + board.getBoardTitle() + "에서 불미스러운 행동을 많이 하신 것이 적발되어 더이상 모임에서 활동하실 수 없게되었습니다. 지금까지 수고하셨습니다.");
		alarmInfo.setAlarmDate(new Date());
		alarmInfo.setAlarmMyId(user_id);
		alarmInfo.setAlarmYouId(boardJoinUserInfo.getBoardJoinUser_id() + ",boardSuccess," + boardNumber);
		alarmMapper.addAlarm(alarmInfo);
	}
	/*===========게시글 참가 거절 알람 서비스============*/
	
	/*===========문의사항 답변 알람 서비스============*/
	@Override
	public void addAlarmQnaComment(String qna_id, int qnaNumber) {
		// TODO Auto-generated method stub
		AlarmMapper alarmMapper = sqlSession.getMapper(AlarmMapper.class);
		MemberMapper userMapper = sqlSession.getMapper(MemberMapper.class);
		UserInfoVO userInfo = userMapper.getUser(qna_id);
		AlarmInfoVO alarmInfo = new AlarmInfoVO();
		alarmInfo.setAlarmContent(userInfo.getUser_name() + "님이 문의하신 글에 답변을 달았습니다. 확인해주시길 바랍니다.");
		alarmInfo.setAlarmDate(new Date());
		alarmInfo.setAlarmMyId("admin");
		alarmInfo.setAlarmYouId(qna_id + ",qnaComment," + qnaNumber);
		alarmMapper.addAlarm(alarmInfo);
	}
	/*===========문의사항 답변 알람 서비스============*/
	
	/*===========마이페이지 내 게시글 삭제 알람 서비스============*/
	@Override
	public void addAlarmBoardDelete(String user_id, int boardNumber) {
		// TODO Auto-generated method stub
		AlarmMapper alarmMapper = sqlSession.getMapper(AlarmMapper.class);
		BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);
		MemberMapper userMapper = sqlSession.getMapper(MemberMapper.class);
		BoardInfoVO board = boardMapper.getboard(boardNumber);
		String[] str = board.getBoardJoins().split(",");
		for (int i = 0; i < str.length; i++) {
			AlarmInfoVO alarmInfo = new AlarmInfoVO();
			String[] id = str[i].split("|");
			UserInfoVO userInfo = userMapper.getUser(id[0]);
			alarmInfo.setAlarmContent(userInfo.getUser_name() + "님! 죄송합니다. 더 이상 모임활동을 할 수 없게 되었습니다. 자세한 사정은 얘기드릴 수 없다는 점 양해바랍니다. 저희 모임보다 더 좋은 모임을 찾으시길 바랍니다.");
			alarmInfo.setAlarmDate(new Date());
			alarmInfo.setAlarmMyId(user_id);
			alarmInfo.setAlarmYouId(id[0] + ",boardDelete," + boardNumber);
			alarmMapper.addAlarm(alarmInfo);
		}
	}
	/*===========마이페이지 내 게시글 삭제 알람 서비스============*/
	
	/*===========문의사항 등록 알람 서비스============*/
	@Override
	public void addAlarmQna(String user_id, String qnaTitle, String qnaContent) {
		// TODO Auto-generated method stub
		AlarmMapper alarmMapper = sqlSession.getMapper(AlarmMapper.class);
		QnaMapper qnaMapper = sqlSession.getMapper(QnaMapper.class);
		MemberMapper userMapper = sqlSession.getMapper(MemberMapper.class);
		QnaInfoVO qnaInfo = new QnaInfoVO();
		UserInfoVO userInfo = userMapper.getUser(user_id);
		qnaInfo.setQnaUserId(user_id);
		qnaInfo.setQnaContent(qnaContent);
		qnaInfo.setQnaTitle(qnaTitle);
		QnaInfoVO qna = qnaMapper.getQnaInfo(qnaInfo);
		AlarmInfoVO alarmInfo = new AlarmInfoVO();
		alarmInfo.setAlarmContent(userInfo.getUser_name() + "님의 문의사항이 등록되었습니다.");
		alarmInfo.setAlarmDate(new Date());
		alarmInfo.setAlarmMyId(user_id);
		alarmInfo.setAlarmYouId("admin,qna," + qna.getQnaNumber());
		alarmMapper.addAlarm(alarmInfo);
	}
	/*===========문의사항 등록 알람 서비스============*/
	
	/*===========포스팅 추천 가져오기============*/
	@Override
	public PostingRecommandInfoVO getPosting(String user_id, int postingNumber) {
		// TODO Auto-generated method stub
		PostingRecommandMapper postingRecommandMapper = sqlSession.getMapper(PostingRecommandMapper.class);
		PostingRecommandInfoVO postingRecommand = new PostingRecommandInfoVO();
		postingRecommand.setPostingNumber(postingNumber);
		postingRecommand.setUserId(user_id);
		PostingRecommandInfoVO posting = postingRecommandMapper.getPostingRc(postingRecommand);
		return posting;
	}
	/*===========포스팅 추천 가져오기============*/
}