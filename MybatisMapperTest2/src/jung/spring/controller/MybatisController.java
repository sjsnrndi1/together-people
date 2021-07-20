package jung.spring.controller;

import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.commons.net.ftp.FTPSClient;

import java.util.HashMap;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.servlet.ModelAndView;
import jung.spring.svc.UserInfoService;
import jung.spring.vo.AlarmInfoVO;
import jung.spring.vo.BoardInfoVO;
import jung.spring.vo.BoardJoinUserInfoVO;
import jung.spring.vo.ChatInfoVO;
import jung.spring.vo.PopupChatInfoVO;
import jung.spring.vo.PostingInfoVO;
import jung.spring.vo.PostingRecommandInfoVO;
import jung.spring.vo.QnaInfoVO;
import jung.spring.vo.UserInfoVO;

@Controller
public class MybatisController {

	@Autowired
	private UserInfoService userInfoService;
	
	@Bean
	public MultipartResolver multipartResolver() {
	  org.springframework.web.multipart.commons.CommonsMultipartResolver multipartResolver = new org.springframework.web.multipart.commons.CommonsMultipartResolver();
	  multipartResolver.setMaxUploadSize(10485760); // 1024 * 1024 * 10
	  return multipartResolver;
	}
	
	private String togetherPeopleTitle = "http://sjsnrndi12.dothome.co.kr/images/bg.png";
	private String togetherPeopleBoard = "http://sjsnrndi12.dothome.co.kr/images/board.png";
	private String togetherPeopleMypage = "http://sjsnrndi12.dothome.co.kr/images/mypage.png";
	private String togetherPeopleNotice = "http://sjsnrndi12.dothome.co.kr/images/notice.PNG";
	private String togetherPeopleManagement = "http://sjsnrndi12.dothome.co.kr/images/management.png";
	private String togetherPeopleBeforeRecommand = "http://sjsnrndi12.dothome.co.kr/images/recommand2.png";
	private String alarmClose = "http://sjsnrndi12.dothome.co.kr/images/alarm.png";
	
	/*=========== 기본 화면 ============*/
	@RequestMapping(value="/")
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView();
		List<UserInfoVO> userList = userInfoService.getMembers();
		List<PostingInfoVO> postingList = userInfoService.getPostings();
		mav.addObject("userList", userList);
		mav.addObject("postingList", postingList);
		mav.setViewName("Tp_firstView");
		return mav;
	}
	
	@RequestMapping(value="/firstView")
	public ModelAndView first() {
		ModelAndView mav = new ModelAndView();
		List<UserInfoVO> userList = userInfoService.getMembers();
		mav.addObject("userList", userList);
		List<PostingInfoVO> postingList = userInfoService.getPostings();
		mav.addObject("postingList", postingList);
		mav.setViewName("Tp_firstView");
		return mav;
	}
	
	@RequestMapping(value="/loginMainView")
	public ModelAndView loginFirst(@RequestParam("id") String user_id) {
		ModelAndView mav = new ModelAndView();
		List<PostingInfoVO> postingList = userInfoService.getPostings();
		mav.addObject("postingList", postingList);
		UserInfoVO userInfo = userInfoService.getUser(user_id);
		mav.addObject("userInfo", userInfo);
		mav.setViewName("Tp_loginMainView");
		
		return mav;
	}
	/*=========== 기본 화면 ============*/
	
	/*=========== 로그인 화면 ============*/
	@RequestMapping("/loginView")
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView();
		List<UserInfoVO> userList = userInfoService.getMembers();
		mav.addObject("userList", userList);
		mav.setViewName("Tp_loginView");
		return mav;
	}
	@RequestMapping("/user_login")
	public ModelAndView main(@RequestParam("user_id") String user_id, @RequestParam("user_password") String user_password) {
		ModelAndView mav = new ModelAndView();
		List<PostingInfoVO> postingList = userInfoService.getPostings();
		mav.addObject("postingList", postingList);
		UserInfoVO userInfo = userInfoService.getUser(user_id);
		mav.addObject("userInfo", userInfo);
		mav.setViewName("Tp_loginMainView");
		return mav;
	}
	/*=========== 로그인 화면 ============*/
	
	/*=========== 회원가입 화면 ============*/
	@RequestMapping(value = "/userRegist")
	public ModelAndView userRegist() {
		ModelAndView mav = new ModelAndView();
		List<UserInfoVO> userList = userInfoService.getMembers();
		mav.addObject("userList", userList);
		mav.setViewName("Tp_userRegist");
		return mav;
	}
	
	@RequestMapping(value = "/user_info_regist")
	public ModelAndView userRegistForm(@RequestParam("user_id") String user_id, @RequestParam("user_password") String user_password, @RequestParam("sample4_postcode") String sample4_postcode,
			@RequestParam("sample4_roadAddress") String sample4_roadAddress, @RequestParam("sample4_jibunAddress") String sample4_jibunAddress,
			@RequestParam("sample4_detailAddress") String sample4_detailAddress, @RequestParam("user_name") String user_name, @RequestParam("user_gender") String user_gender,
			@RequestParam("user_birthday_year") String user_birthday_year, @RequestParam("user_birthday_month") String user_birthday_month,
			@RequestParam("user_birthday_day") String user_birthday_day, @RequestParam("user_email") String user_email, @RequestParam("user_phone") String user_phone) {
		ModelAndView mav = new ModelAndView();
		HashMap<Object, Object> map = new HashMap<Object, Object>();
		map.put("user_id", user_id); map.put("user_password", user_password); map.put("user_postCode", sample4_postcode); map.put("user_roadAddress", sample4_roadAddress);
		map.put("user_jibunAddress", sample4_jibunAddress); map.put("user_detailAddress", sample4_detailAddress); map.put("user_name", user_name); map.put("user_gender", user_gender);
		map.put("user_birthday_year", user_birthday_year); map.put("user_birthday_month", user_birthday_month); map.put("user_birthday_day", user_birthday_day);
		map.put("user_email", user_email); map.put("user_phone", user_phone); map.put("user_date", new Date());
		boolean check = userInfoService.addUserInfo(map);
		userInfoService.addUserPopup(user_id);
		mav.addObject("check", check);
		mav.addObject("user_name", user_name);
		mav.setViewName("Tp_userRegistResult");
		return mav;
	}
	/*=========== 회원가입 화면 ============*/
	
	/*=========== 아이디 찾기 화면 ============*/
	@RequestMapping(value = "/findID")
	public ModelAndView FindId() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("Tp_findID");
		return mav;
	}

	@RequestMapping(value = "/find_user_id")
	public ModelAndView FindIDResult(@RequestParam("user_name") String user_name, @RequestParam("user_phone") int user_phone) {
		ModelAndView mav = new ModelAndView();
		boolean idCheck = userInfoService.checkUserEmail(user_name, user_phone);
		if(idCheck) {
			UserInfoVO userInfo = userInfoService.selectUserId(user_name, user_phone);
			mav.addObject("userInfo", userInfo);
			mav.setViewName("Tp_findIDResult");			
		} else {
			mav.setViewName("Tp_findIDFailResult");
		}
		return mav;
	}
	/*=========== 아이디 찾기 화면 ============*/
	
	/*=========== 비밀번호 찾기 화면 ============*/
	@RequestMapping(value = "/findPassword")
	public ModelAndView FindPassword() {
		ModelAndView mav = new ModelAndView();
		List<UserInfoVO> userList = userInfoService.getMembers();
		mav.addObject("userList", userList);
		mav.setViewName("Tp_findPassword");
		return mav;
	}

	@RequestMapping(value = "/find_user_password")
	public ModelAndView FindPasswordResult(@RequestParam("user_id") String user_id, @RequestParam("user_name") String user_name, @RequestParam("user_phone") int user_phone) {
		ModelAndView mav = new ModelAndView();
		boolean pwCheck = userInfoService.selectUserPassword(user_id, user_name, user_phone);
		mav.addObject("user_id", user_id);
		if(pwCheck) {
			mav.setViewName("Tp_modifyPassword");
		} else {
			mav.setViewName("Tp_findPassword");
		}
		return mav;
	}
	
	@RequestMapping(value = "/modify_user_password")
	public ModelAndView ModifyPassword(@RequestParam("user_id") String user_id, @RequestParam("user_password") String user_password) {
		ModelAndView mav = new ModelAndView();
		userInfoService.modifyUserPassword(user_password, user_id);
		mav.addObject("user_id", user_id);
		mav.setViewName("Tp_findPasswordResult");
		return mav;
	}
	/*=========== 비밀번호 찾기 화면 ============*/
	
	/*=========== 포스팅 등록 화면 ============*/
	@RequestMapping(value = "/user_posting_regist")
	public ModelAndView UserPostingRegist(@RequestParam("ct_ti") String content_title, @RequestParam("ct_ct") String content_content, @RequestParam("ct_pt") File content_picture,
	@RequestParam("user_posting_id") String user_id) throws SocketException, IOException {
		ModelAndView mav = new ModelAndView();
		UserInfoVO userInfo = userInfoService.getUser(user_id);
		userInfoService.addPosting(content_title, content_content, content_picture, userInfo);
		String postingNumber = userInfoService.getLastPostingNumber();
		
		FTPSClient ftps = null;
		try {
			ftps = new FTPSClient("TLS", false);
			ftps.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out)));
			ftps.connect("192.168.1.178", 2121);
			int reply = 0;
			reply = ftps.getReplyCode();
			if(!FTPReply.isPositiveCompletion(reply)) {
				ftps.disconnect();
			} else {
				Date from = new Date();
				//지금시간
				//SimpleDateFormat nowDateHHmmss = new SimpleDateFormat ("HHmmss");
				SimpleDateFormat nowDateymd = new SimpleDateFormat ("yyyyMMdd");
				
				//String nowHHmmss = nowDateHHmmss.format(from);
				String nowymd = nowDateymd.format(from);
				
				//로그인
				ftps.login("sjsnrndi12", "tkfkd465!@");
				showServerReply(ftps);
				
				//데이터 보안
				ftps.execPBSZ(0);
				ftps.execPROT("P");
				
				//ftp 디렉터리 생성
				ftps.makeDirectory("/user_posting_pictures/"+nowymd);
				showServerReply(ftps);
				
				ftps.makeDirectory("/user_posting_pictures/"+nowymd+"/"+postingNumber);//nowHHmmss
				showServerReply(ftps);
				
				//ftp 디렉터리 변경
				ftps.changeWorkingDirectory("/user_posting_pictures/"+nowymd+"/"+postingNumber);//nowHHmmss
				showServerReply(ftps);
				
				//Active Mode -> PassiveMode로 변경
				ftps.enterLocalPassiveMode();
				showServerReply(ftps);
				
				FileInputStream fis = null;
				fis = new FileInputStream(content_picture);
				showServerReply(ftps);
				
				ftps.setFileType(FTP.BINARY_FILE_TYPE);
				showServerReply(ftps);
				
				ftps.setFileTransferMode(FTP.STREAM_TRANSFER_MODE);
				showServerReply(ftps);
				
				//ftps에 파일 업로드
				boolean isSuccess = ftps.storeFile(content_picture.getName(), fis);
				showServerReply(ftps);
				
				//업로드 성공 시
				if(isSuccess) {
					System.out.println("업로드 성공");
				}
			}
		} catch (FileNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (SocketException e) {
			e.printStackTrace();
		} finally {
			try
	        {
	            if (ftps.isConnected())
	            {
	                ftps.logout();
	                ftps.disconnect();
	            }
	        }
	        catch (IOException ex)
	        {
	        	userInfoService.deletePostingFail(postingNumber);
	            ex.printStackTrace();
	        }
		}
		List<UserInfoVO> userList = userInfoService.getMembers();
		mav.addObject("userList", userList);
		List<PostingInfoVO> postingList = userInfoService.getPostings();
		mav.addObject("postingList", postingList);
		mav.setViewName("Tp_firstView");
		return mav;
	}
	
	private static void showServerReply(FTPSClient ftps) {
		String[] replies = ftps.getReplyStrings();
		if(replies != null && replies.length > 0) {
			for(String aReply : replies) {
				System.out.println("SERVER: " + aReply);
			}
		}
	}
	/*=========== 포스팅 등록 화면 ============*/
	
	/*=========== 포스팅 수정 화면 ============*/
	@RequestMapping(value = "/modifyPosting")
	public ModelAndView ModifyPosting(@RequestParam("id") String user_id, @RequestParam("number") int postingNumber) {
		ModelAndView mav = new ModelAndView();
		UserInfoVO userInfo = userInfoService.selectUserPassword(user_id);
		PostingInfoVO postingInfo = userInfoService.getUserPostingInfo(user_id, postingNumber);
		mav.addObject("userInfo", userInfo);
		mav.addObject("postingInfo", postingInfo);
		mav.addObject("togetherPeopleTitle", togetherPeopleTitle);
		mav.setViewName("modifyPosting");
		return mav;
	}
	
	@RequestMapping(value = "/modifyPostingForm")
	public void ModifyPosting(@RequestParam("user_id") String user_id, 
			@RequestParam("user_name") String user_name, @RequestParam("postingContent") String postingContent, 
			@RequestParam("postingNumber") int postingNumber, 
			@RequestParam("postingRecommandCount") int postingRecommandCount) {
		userInfoService.updateUserPostingInfo(user_id, postingContent, user_name, postingNumber, postingRecommandCount);
	}
	/*=========== 포스팅 수정 화면 ============*/
	
	/*=========== 포스팅 삭제 화면 ============*/
	@RequestMapping(value = "/deletePosting")
	public ModelAndView DeletePosting(@RequestParam("id") String user_id, @RequestParam("number") int postingNumber) {
		ModelAndView mav = new ModelAndView();
		UserInfoVO userInfo = userInfoService.selectUserPassword(user_id);
		PostingInfoVO postingInfo = userInfoService.getUserPostingInfo(user_id, postingNumber);
		mav.addObject("userInfo", userInfo);
		mav.addObject("postingInfo", postingInfo);
		mav.addObject("togetherPeopleTitle", togetherPeopleTitle);
		mav.setViewName("deletePosting");
		return mav;
	}
	
	@RequestMapping(value = "/deletePostingForm")
	public void DeletePostingForm(@RequestParam("user_id") String user_id, 
			@RequestParam("user_name") String user_name, @RequestParam("postingContent") String postingContent, 
			@RequestParam("postingNumber") int postingNumber, 
			@RequestParam("postingRecommandCount") int postingRecommandCount) {
		userInfoService.deleteUserPostingInfo(user_id, postingContent, user_name, postingNumber, postingRecommandCount);
	}
	/*=========== 포스팅 삭제 화면 ============*/
	
	/*=========== 포스팅 추천 화면 ============*/
	@RequestMapping(value = "/postingRecommandCount")
	public String PostingRecommandCount(@RequestParam("id") String user_id, @RequestParam("number") int postingNumber) {
		userInfoService.createUserPostingRecommand(user_id, postingNumber);
		PostingRecommandInfoVO posting = userInfoService.getPosting(user_id, postingNumber);
		if(posting.getPostingRecommandCountCheck() == 1) {
			userInfoService.addAlarmPosting(user_id, postingNumber);
		}
		return "redirect:/mainView?id=" + user_id;
	}
	/*=========== 포스팅 추천 화면 ============*/
	
	/*=========== 소개(CEO) 화면 ============*/
	@RequestMapping(value = "/noticeView")
	public ModelAndView NoticeView() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("Tp_noticeView");
		return mav;
	}
	/*=========== 소개(CEO) 화면 ============*/
	
	/*=========== 오시는 길 화면 ============*/
	@RequestMapping(value = "/noticeAccessView")
	public ModelAndView NoticeAccessView() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("Tp_noticeAccessView");
		return mav;
	}
	/*=========== 오시는 길 화면 ============*/
	
	/*=========== 이용방법 화면 ============*/
	@RequestMapping(value="/userTpView")
	public ModelAndView UserTpView() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("Tp_userTpView");
		return mav;
	}
	/*=========== 이용방법 화면 ============*/
	
	/*=========== 회원가입 및 로그인 화면 ============*/
	@RequestMapping(value="/userRegistAndLogin")
	public ModelAndView UserRistAndLogin() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("Tp_userRegistAndLogin");
		return mav;
	}
	/*=========== 회원가입 및 로그인 화면 ============*/
	
	/*=========== 팝업 창 톡톡 화면 ============*/
	@RequestMapping(value="/popup")
	public ModelAndView Popup(@RequestParam("user_id") String user_id) {
		ModelAndView mav = new ModelAndView();
		int popupNumber = userInfoService.getPopupNumber(user_id); 
		List<PopupChatInfoVO> popupChatList = userInfoService.getPopupChats(popupNumber);
		mav.addObject("user_id", user_id);
		mav.addObject("popupChatList", popupChatList);
		mav.setViewName("Tp_popup");
		return mav;
	}
	/*=========== 팝업 창 톡톡 화면 ============*/
	
	/*=========== 팝업 창 톡톡 사용자 입력 ============*/
	@RequestMapping(value="/popup_user_chat_input_form")
	public ModelAndView Popup_user_chat_input_form(@RequestParam("user_chat") String user_chat, @RequestParam("user_id") String user_id) {
		ModelAndView mav = new ModelAndView();
		int popupNumber = userInfoService.getPopupNumber(user_id);
		userInfoService.addPopupUserChat(user_id, popupNumber, user_chat);
		List<PopupChatInfoVO> popupChatList = userInfoService.getPopupChats(popupNumber);
		mav.addObject("user_id", user_id);
		mav.addObject("popupChatList", popupChatList);
		mav.setViewName("Tp_popup");
		return mav;
	}
	/*=========== 팝업 창 톡톡 사용자 입력 ============*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*=========== 게시판 화면 ============*/
	@RequestMapping(value = "/boardView")
	public ModelAndView BoardView(@RequestParam("id") String user_id, @RequestParam("subject") String subject) {
		ModelAndView mav = new ModelAndView();
		if(subject.equals("all")) {
			List<BoardInfoVO> boardList = userInfoService.getBoards();			
			mav.addObject("boardList", boardList);
		} else {
			List<BoardInfoVO> boardList = userInfoService.getBoardOthers(subject);						
			mav.addObject("boardList", boardList);
		}
		UserInfoVO userInfo = userInfoService.selectUserPassword(user_id);
		List<AlarmInfoVO> alarmList = userInfoService.getAlarms();
		List<AlarmInfoVO> alarms = new ArrayList<AlarmInfoVO>();
		for (int i = 0; i < alarmList.size(); i++) {
			String[] str = alarmList.get(i).getAlarmYouId().split(",");
			if(str[0].equals(user_id)) { 
				alarms.add(alarmList.get(i));
			}
		}
		mav.addObject("alarms", alarms);
		mav.addObject("userInfo", userInfo);
		mav.addObject("subject", subject);
		mav.addObject("togetherPeopleTitle", togetherPeopleTitle);
		mav.addObject("togetherPeopleBoard", togetherPeopleBoard);
		mav.addObject("togetherPeopleMypage", togetherPeopleMypage);
		mav.addObject("togetherPeopleNotice", togetherPeopleNotice);
		mav.addObject("togetherPeopleManagement", togetherPeopleManagement);
		mav.addObject("alarmClose", alarmClose);
		mav.setViewName("boardView");
		return mav;
	}
	
	@RequestMapping(value = "/searchBoardView")
	public ModelAndView SearchBoardView(@RequestParam("id") String user_id, @RequestParam("list") String searchBoardList) {
		ModelAndView mav = new ModelAndView();
		System.out.println(searchBoardList);
		UserInfoVO userInfo = userInfoService.selectUserPassword(user_id);
		List<BoardInfoVO> boardList = userInfoService.getSearchBoards(searchBoardList);
		List<AlarmInfoVO> alarmList = userInfoService.getAlarms();
		List<AlarmInfoVO> alarms = new ArrayList<AlarmInfoVO>();
		for (int i = 0; i < alarmList.size(); i++) {
			String[] str = alarmList.get(i).getAlarmYouId().split(",");
			if(str[0].equals(user_id)) { 
				alarms.add(alarmList.get(i));
			}
		}
		mav.addObject("alarms", alarms);
		mav.addObject("userInfo", userInfo);
		mav.addObject("boardList", boardList);
		mav.addObject("togetherPeopleTitle", togetherPeopleTitle);
		mav.addObject("togetherPeopleBoard", togetherPeopleBoard);
		mav.addObject("togetherPeopleMypage", togetherPeopleMypage);
		mav.addObject("togetherPeopleNotice", togetherPeopleNotice);
		mav.addObject("togetherPeopleManagement", togetherPeopleManagement);
		mav.addObject("alarmClose", alarmClose);
		mav.setViewName("boardView");
		return mav;
	}
	/*=========== 게시판 화면 ============*/
	
	/*=========== 게시판 등록 화면 ============*/
	@RequestMapping(value = "/boardRegist")
	public ModelAndView BoardRegist(@RequestParam("id") String user_id) {
		ModelAndView mav = new ModelAndView();
		UserInfoVO userInfo = userInfoService.selectUserPassword(user_id);
		List<AlarmInfoVO> alarmList = userInfoService.getAlarms();
		List<AlarmInfoVO> alarms = new ArrayList<AlarmInfoVO>();
		for (int i = 0; i < alarmList.size(); i++) {
			String[] str = alarmList.get(i).getAlarmYouId().split(",");
			if(str[0].equals(user_id)) { 
				alarms.add(alarmList.get(i));
			}
		}
		mav.addObject("alarms", alarms);
		mav.addObject("userInfo", userInfo);
		mav.addObject("togetherPeopleTitle", togetherPeopleTitle);
		mav.addObject("togetherPeopleBoard", togetherPeopleBoard);
		mav.addObject("togetherPeopleMypage", togetherPeopleMypage);
		mav.addObject("togetherPeopleNotice", togetherPeopleNotice);
		mav.addObject("togetherPeopleManagement", togetherPeopleManagement);
		mav.setViewName("boardRegist");
		return mav;
	}
	
	@RequestMapping(value = "/boardRegistForm")
	public String BoardRegistForm(@RequestParam("writer") String boardWriter, @RequestParam("user_id") String user_id,
			@RequestParam("subject") String boardTitle, @RequestParam("content") String boardContent, 
			@RequestParam("selectBoard") String selectBoard) {
		if(boardTitle.equals("")) {
			return "redirect:/boardRegist?id=" + user_id;
		} else if(boardContent.equals("")) {
			return "redirect:/boardRegist?id=" + user_id;
		} else if(selectBoard.equals("")) {
			return "redirect:/boardRegist?id=" + user_id;
		} else {
			userInfoService.addBoard(boardWriter, boardTitle, boardContent, selectBoard, user_id);
			return "redirect:/boardView?id=" + user_id + "&subject=all";
		}
	}
	/*=========== 게시판 등록 화면 ============*/
	
	/*=========== 게시글 보기 화면 ============*/
	@RequestMapping(value = "/boardOpen")
	public ModelAndView BoardOpen(@RequestParam("number") int boardNumber, @RequestParam("id") String user_id) {
		ModelAndView mav = new ModelAndView();
		List<BoardJoinUserInfoVO> boardJoinUserList = userInfoService.getBoardJoinUsers();
		BoardJoinUserInfoVO boardJoinUserInfo = userInfoService.getBoardJoinUser(boardNumber, user_id);
		BoardInfoVO boardInfo = userInfoService.getboard(boardNumber);
		UserInfoVO userInfo = userInfoService.selectUserPassword(user_id);
		String str = user_id + "|" + boardNumber;
		String[] favorites = boardInfo.getBoardFavorites().split(",");
		String[] joins = boardInfo.getBoardJoins().split(",");
		String favorite = favoritesFailSuccess(favorites, str);
		String join = joinsFailSuccess(joins, str);
		List<AlarmInfoVO> alarmList = userInfoService.getAlarms();
		List<AlarmInfoVO> alarms = new ArrayList<AlarmInfoVO>();
		for (int i = 0; i < alarmList.size(); i++) {
			String[] str3 = alarmList.get(i).getAlarmYouId().split(",");
			if(str3[0].equals(user_id)) { 
				alarms.add(alarmList.get(i));
			}
		}
		mav.addObject("alarms", alarms);		
		mav.addObject("favorite", favorite);
		mav.addObject("join", join);
		mav.addObject("boardJoinUserInfo", boardJoinUserInfo);
		mav.addObject("boardJoinUserList", boardJoinUserList);
		mav.addObject("userInfo", userInfo);
		mav.addObject("boardInfo", boardInfo);
		mav.addObject("togetherPeopleTitle", togetherPeopleTitle);
		mav.addObject("togetherPeopleBoard", togetherPeopleBoard);
		mav.addObject("togetherPeopleMypage", togetherPeopleMypage);
		mav.addObject("togetherPeopleNotice", togetherPeopleNotice);
		mav.addObject("togetherPeopleManagement", togetherPeopleManagement);
		mav.addObject("alarmClose", alarmClose);
		mav.setViewName("boardOpen");
		return mav;
	}
	
	public String favoritesFailSuccess(String[] favorites, String str) {
		String favorite = "fail";
		for (int i = 0; i < favorites.length; i++) { if(favorites[i].equals(str)) { favorite = "success"; break; } }
		return favorite;
	}
	
	public String joinsFailSuccess(String[] joins, String str) {
		String join = "fail";
		for (int i = 0; i < joins.length; i++) { if(joins[i].equals(str)) { join = "success"; break; } }
		return join;
	}
	/*=========== 게시글 보기 화면 ============*/
	
	/*=========== 게시글 참여 ============*/
	@RequestMapping(value = "/boardJoin")
	public String BoardJoin(@RequestParam("number") int boardNumber, @RequestParam("id") String user_id) {
		BoardInfoVO boardInfo = userInfoService.getboard(boardNumber);
		UserInfoVO userInfo = userInfoService.selectUserPassword(user_id);
		userInfoService.sendBoardJoin(boardInfo, userInfo);
		userInfoService.addAlarmBoard(boardInfo, userInfo);
		return "redirect:/boardOpen?number=" + boardNumber + "&id=" + user_id;
	}
	/*=========== 게시글 참여 ============*/

	/*=========== 게시글 참여 취소 ============*/
	@RequestMapping(value = "/boardJoinCancel")
	public String BoardJoinCancel(@RequestParam("number") int boardNumber, @RequestParam("id") String user_id) {
		BoardJoinUserInfoVO boardJoinUserInfo = userInfoService.getBoardJoinUser(boardNumber, user_id);
		userInfoService.sendCancelBoardJoin(boardJoinUserInfo);
		return "redirect:/boardOpen?number=" + boardNumber + "&id=" + user_id;
	}
	/*=========== 게시글 참여 취소 ============*/
	
	/*=========== 게시글 참여자 명단 보기 ============*/
	@RequestMapping(value = "/boardJoinUserList")
	public ModelAndView BoardJoinUserList(@RequestParam("number") int boardNumber, @RequestParam("id") String user_id) {
		ModelAndView mav = new ModelAndView();
		List<BoardJoinUserInfoVO> boardJoinUserList = userInfoService.getBoardJoinUsers();
		BoardInfoVO boardInfo = userInfoService.getboard(boardNumber);
		UserInfoVO userInfo = userInfoService.selectUserPassword(user_id);
		mav.addObject("boardJoinUserList", boardJoinUserList);
		mav.addObject("boardInfo", boardInfo);
		mav.addObject("userInfo", userInfo);
		mav.addObject("togetherPeopleTitle", togetherPeopleTitle);
		mav.setViewName("boardJoinUserList");
		return mav;
	}
	/*=========== 게시글 참여지 명단 보기============*/
	
	/*=========== 게시글 참여자 수락 ============*/
	@RequestMapping(value = "/successJoinUser")
	public String SuccessJoinUser(@RequestParam("user_id") String user_id, @RequestParam("boardJoinUser_id") String boardJoinUser_id,
			@RequestParam("number") int boardNumber) {
		BoardJoinUserInfoVO boardJoinUserInfo = userInfoService.getBoardJoinUser(boardNumber, boardJoinUser_id);
		BoardInfoVO boardInfo = userInfoService.getboard(boardNumber);
		userInfoService.modifyBoardJoinUserInfo(boardJoinUserInfo);
		userInfoService.modifyBoardJoinUserNumber(boardInfo);
		userInfoService.addAlarmBoardJoinSuccess(user_id, boardJoinUserInfo, boardNumber);
		return "redirect:/boardJoinUserList?number=" + boardNumber + "&id=" + user_id;
	}
	/*=========== 게시글 참여자 수락 ============*/
		
	/*=========== 게시글 참여자 거절 ============*/
	@RequestMapping(value = "/failJoinUser")
	public String FailJoinUser(@RequestParam("user_id") String user_id, @RequestParam("boardJoinUser_id") String boardJoinUser_id,
			@RequestParam("number") int boardNumber) {
		BoardJoinUserInfoVO boardJoinUserInfo = userInfoService.getBoardJoinUser(boardNumber, boardJoinUser_id);
		userInfoService.deleteBoardJoinUserInfo(boardJoinUserInfo);
		userInfoService.addAlarmBoardJoinFail(user_id, boardJoinUserInfo, boardNumber);
		return "redirect:/boardJoinUserList?number=" + boardNumber + "&id=" + user_id;
	}
	/*=========== 게시글 참여자 거절 ============*/
	
	/*=========== 게시글 수정 ============*/
	//게시글 정보만 수정
	@RequestMapping(value = "/boardModify")
	public ModelAndView BoardModify(@RequestParam("id") String user_id, @RequestParam("number") int boardNumber) {
		ModelAndView mav = new ModelAndView();
		UserInfoVO userInfo = userInfoService.selectUserPassword(user_id);
		BoardInfoVO boardInfo = userInfoService.getboard(boardNumber);
		List<AlarmInfoVO> alarmList = userInfoService.getAlarms();
		List<AlarmInfoVO> alarms = new ArrayList<AlarmInfoVO>();
		for (int i = 0; i < alarmList.size(); i++) {
			String[] str = alarmList.get(i).getAlarmYouId().split(",");
			if(str[0].equals(user_id)) { 
				alarms.add(alarmList.get(i));
			}
		}
		mav.addObject("alarms", alarms);
		mav.addObject("userInfo", userInfo);
		mav.addObject("boardInfo", boardInfo);
		mav.addObject("togetherPeopleTitle", togetherPeopleTitle);
		mav.addObject("togetherPeopleBoard", togetherPeopleBoard);
		mav.addObject("togetherPeopleMypage", togetherPeopleMypage);
		mav.addObject("togetherPeopleNotice", togetherPeopleNotice);
		mav.addObject("togetherPeopleManagement", togetherPeopleManagement);
		mav.addObject("alarmClose", alarmClose);
		mav.setViewName("boardModify");
		return mav;
	}

	@RequestMapping(value = "/boardModifyForm")
	public ModelAndView BoardModifyForm(@RequestParam("user_id") String user_id, @RequestParam("boardNumber") int boardNumber,
			@RequestParam("subject") String boardTitle, @RequestParam("content") String boardContent) {
		userInfoService.modifyBoard(user_id, boardNumber, boardTitle, boardContent);
		ModelAndView mav = new ModelAndView();
		List<BoardJoinUserInfoVO> boardJoinUserList = userInfoService.getBoardJoinUsers();
		BoardJoinUserInfoVO boardJoinUserInfo = userInfoService.getBoardJoinUser(boardNumber, user_id);
		BoardInfoVO boardInfo = userInfoService.getboard(boardNumber);
		UserInfoVO userInfo = userInfoService.selectUserPassword(user_id);
		String[] favorites = boardInfo.getBoardFavorites().split(",");// c|2  b|2
		String favorite = "fail";
		for (int i = 0; i < favorites.length; i++) {
			if(favorites[i].equals("")) {
				
			} else {
				String[] temp = favorites[i].split("|");
				if(user_id.equals(temp[0]) && String.valueOf(boardNumber).equals(temp[2])) {
					favorite = "success";
					break;
				} else {
					favorite = "fail";
				}
			}
		}
		List<AlarmInfoVO> alarmList = userInfoService.getAlarms();
		List<AlarmInfoVO> alarms = new ArrayList<AlarmInfoVO>();
		for (int i = 0; i < alarmList.size(); i++) {
			String[] str = alarmList.get(i).getAlarmYouId().split(",");
			if(str[0].equals(user_id)) { 
				alarms.add(alarmList.get(i));
			}
		}
		mav.addObject("alarms", alarms);
		mav.addObject("favorite", favorite);
		mav.addObject("boardJoinUserInfo", boardJoinUserInfo);
		mav.addObject("boardJoinUserList", boardJoinUserList);
		mav.addObject("userInfo", userInfo);
		mav.addObject("boardInfo", boardInfo);
		mav.addObject("togetherPeopleTitle", togetherPeopleTitle);
		mav.addObject("togetherPeopleBoard", togetherPeopleBoard);
		mav.addObject("togetherPeopleMypage", togetherPeopleMypage);
		mav.addObject("togetherPeopleNotice", togetherPeopleNotice);
		mav.addObject("togetherPeopleManagement", togetherPeopleManagement);
		mav.addObject("alarmClose", alarmClose);
		mav.setViewName("boardOpen");
		return mav;
	}
	
	@RequestMapping(value = "/boardModifyClose")
	public ModelAndView BoardModifyClose(@RequestParam("id") String user_id, @RequestParam("number") int boardNumber) {
		ModelAndView mav = new ModelAndView();
		List<BoardJoinUserInfoVO> boardJoinUserList = userInfoService.getBoardJoinUsers();
		BoardJoinUserInfoVO boardJoinUserInfo = userInfoService.getBoardJoinUser(boardNumber, user_id);
		BoardInfoVO boardInfo = userInfoService.getboard(boardNumber);
		UserInfoVO userInfo = userInfoService.selectUserPassword(user_id);
		String[] favorites = boardInfo.getBoardFavorites().split(",");// c|2  b|2
		String favorite = "fail";
		for (int i = 0; i < favorites.length; i++) {
			if(favorites[i].equals("")) {
				
			} else {
				String[] temp = favorites[i].split("|");
				if(user_id.equals(temp[0]) && String.valueOf(boardNumber).equals(temp[2])) {
					favorite = "success";
					break;
				} else {
					favorite = "fail";
				}
			}
		}
		List<AlarmInfoVO> alarmList = userInfoService.getAlarms();
		List<AlarmInfoVO> alarms = new ArrayList<AlarmInfoVO>();
		for (int i = 0; i < alarmList.size(); i++) {
			String[] str = alarmList.get(i).getAlarmYouId().split(",");
			if(str[0].equals(user_id)) { 
				alarms.add(alarmList.get(i));
			}
		}
		mav.addObject("alarms", alarms);
		mav.addObject("boardJoinUserInfo", boardJoinUserInfo);
		mav.addObject("boardJoinUserList", boardJoinUserList);
		mav.addObject("userInfo", userInfo);
		mav.addObject("boardInfo", boardInfo);
		mav.addObject("favorite", favorite);
		mav.addObject("togetherPeopleTitle", togetherPeopleTitle);
		mav.addObject("togetherPeopleBoard", togetherPeopleBoard);
		mav.addObject("togetherPeopleMypage", togetherPeopleMypage);
		mav.addObject("togetherPeopleNotice", togetherPeopleNotice);
		mav.addObject("togetherPeopleManagement", togetherPeopleManagement);
		mav.addObject("alarmClose", alarmClose);
		mav.setViewName("boardOpen");
		return mav;
	}
	/*=========== 게시글 수정 ============*/
	
	/*=========== 게시글 삭제 ============*/
	@RequestMapping(value = "/boardDelete")
	public ModelAndView BoardDelete(@RequestParam("id") String user_id, @RequestParam("number") int boardNumber) {
		ModelAndView mav = new ModelAndView();
		UserInfoVO userInfo = userInfoService.selectUserPassword(user_id);
		BoardInfoVO boardInfo = userInfoService.getboard(boardNumber);
		List<AlarmInfoVO> alarmList = userInfoService.getAlarms();
		List<AlarmInfoVO> alarms = new ArrayList<AlarmInfoVO>();
		for (int i = 0; i < alarmList.size(); i++) {
			String[] str = alarmList.get(i).getAlarmYouId().split(",");
			if(str[0].equals(user_id)) { 
				alarms.add(alarmList.get(i));
			}
		}
		mav.addObject("alarms", alarms);
		mav.addObject("userInfo", userInfo);
		mav.addObject("boardInfo", boardInfo);
		mav.addObject("togetherPeopleTitle", togetherPeopleTitle);
		mav.addObject("togetherPeopleBoard", togetherPeopleBoard);
		mav.addObject("togetherPeopleMypage", togetherPeopleMypage);
		mav.addObject("togetherPeopleNotice", togetherPeopleNotice);
		mav.addObject("togetherPeopleManagement", togetherPeopleManagement);
		mav.addObject("alarmClose", alarmClose);
		mav.setViewName("boardDelete");
		return mav;
	}
	
	@RequestMapping(value = "/boardDeleteForm")
	public String BoardDeleteForm(@RequestParam("user_id") String user_id, @RequestParam("boardNumber") int boardNumber) {
		UserInfoVO userInfo = userInfoService.selectUserPassword(user_id);
		BoardInfoVO boardInfo = userInfoService.getboard(boardNumber);
		userInfoService.addAlarmBoardDelete(user_id, boardNumber);
		userInfoService.deleteBoard(userInfo, boardInfo);
		return "redirect:/boardView?id=" + user_id + "&subject=all";
	}
	/*=========== 게시글 삭제 ============*/
	
	/*=========== 게시글 분류 ============*/
	@RequestMapping(value = "/allBoard")
	public String AllBoard(@RequestParam("id") String user_id) {
		return "redirect:/boardView?id=" + user_id;
	}
	/*=========== 게시글 분류 ============*/
	
	/*=========== 채팅창 ============*/
	@RequestMapping(value = "/chat")
	public ModelAndView Chat(HttpServletResponse response, @RequestParam("id") String user_id, @RequestParam("number") int boardNumber) {
		ModelAndView mav = new ModelAndView();
		UserInfoVO userInfo = userInfoService.selectUserPassword(user_id);
		BoardInfoVO boardInfo = userInfoService.getboard(boardNumber);
		List<ChatInfoVO> chatList = userInfoService.getChats(boardNumber);
		boolean chatJoinCheck = true;
		userInfoService.chatJoin(boardNumber, user_id, chatJoinCheck);
		List<BoardJoinUserInfoVO> boardJoinUserList = userInfoService.getBoardJoinUsers();
		List<AlarmInfoVO> alarmList = userInfoService.getAlarms();
		List<AlarmInfoVO> alarms = new ArrayList<AlarmInfoVO>();
		for (int i = 0; i < alarmList.size(); i++) {
			String[] str = alarmList.get(i).getAlarmYouId().split(",");
			if(str[0].equals(user_id)) { 
				alarms.add(alarmList.get(i));
			}
		}
		mav.addObject("alarms", alarms);
		mav.addObject("userInfo", userInfo);
		mav.addObject("boardInfo", boardInfo);
		mav.addObject("chatList", chatList);
		mav.addObject("boardJoinUserList", boardJoinUserList);
		mav.addObject("togetherPeopleTitle", togetherPeopleTitle);
		mav.addObject("togetherPeopleBoard", togetherPeopleBoard);
		mav.addObject("togetherPeopleMypage", togetherPeopleMypage);
		mav.addObject("togetherPeopleNotice", togetherPeopleNotice);
		mav.addObject("togetherPeopleManagement", togetherPeopleManagement);
		mav.addObject("alarmClose", alarmClose);
		mav.setViewName("chat");
		return mav;
	}
	
	@RequestMapping(value = "/chatSave")
	public String ChatSave(@RequestParam("user_id") String user_id, @RequestParam("boardNumber") int boardNumber, 
			@RequestParam("inputMessage") String content) {
		if(content.equals("")) {
		} else {			
			userInfoService.addChat(user_id, boardNumber, content);			
		}
		return "redirect:/chat?id=" + user_id + "&number=" + boardNumber;
	}
	/*=========== 채팅창 ============*/
	
	/*=========== 채팅창에서 나갈 때============*/
	@RequestMapping(value = "/chatJoinClose")
	public ModelAndView ChatJoinClose(@RequestParam("id") String user_id, @RequestParam("number") int boardNumber) {
		ModelAndView mav = new ModelAndView();
		List<BoardJoinUserInfoVO> boardJoinUserList = userInfoService.getBoardJoinUsers();
		BoardJoinUserInfoVO boardJoinUserInfo = userInfoService.getBoardJoinUser(boardNumber, user_id);
		BoardInfoVO boardInfo = userInfoService.getboard(boardNumber);
		UserInfoVO userInfo = userInfoService.selectUserPassword(user_id);
		mav.addObject("boardJoinUserInfo", boardJoinUserInfo);
		mav.addObject("boardJoinUserList", boardJoinUserList);
		mav.addObject("userInfo", userInfo);
		mav.addObject("boardInfo", boardInfo);
		String[] favorites = boardInfo.getBoardFavorites().split(",");// c|2  b|2
		String favorite = "fail";
		for (int i = 0; i < favorites.length; i++) {
			if(favorites[i].equals("")) {
				
			} else {
				String[] temp = favorites[i].split("|");
				if(user_id.equals(temp[0]) && String.valueOf(boardNumber).equals(temp[2])) {
					favorite = "success";
					break;
				} else {
					favorite = "fail";
				}
			}
		}
		mav.addObject("favorite", favorite);
		boolean chatJoinCheck = false;
		userInfoService.chatJoin(boardNumber, user_id, chatJoinCheck);
		List<AlarmInfoVO> alarmList = userInfoService.getAlarms();
		List<AlarmInfoVO> alarms = new ArrayList<AlarmInfoVO>();
		for (int i = 0; i < alarmList.size(); i++) {
			String[] str = alarmList.get(i).getAlarmYouId().split(",");
			if(str[0].equals(user_id)) { 
				alarms.add(alarmList.get(i));
			}
		}
		mav.addObject("alarms", alarms);
		mav.addObject("togetherPeopleTitle", togetherPeopleTitle);
		mav.addObject("togetherPeopleBoard", togetherPeopleBoard);
		mav.addObject("togetherPeopleMypage", togetherPeopleMypage);
		mav.addObject("togetherPeopleNotice", togetherPeopleNotice);
		mav.addObject("togetherPeopleManagement", togetherPeopleManagement);
		mav.addObject("alarmClose", alarmClose);
		mav.setViewName("boardOpen");
		return mav;
	}
	
	@RequestMapping("/chatJoinCloseLoginView")
	public String ChatJoinCloseLoginView(@RequestParam("id") String user_id, @RequestParam("number") int boardNumber) {
		boolean chatJoinCheck = false;
		userInfoService.chatJoin(boardNumber, user_id, chatJoinCheck);
		return "redirect:/loginView";
	}
	
	@RequestMapping(value = "/chatJoinCloseNoticeView")
	public String ChatJoinCloseNoticeView(@RequestParam("id") String user_id, @RequestParam("number") int boardNumber) {
		boolean chatJoinCheck = false;
		userInfoService.chatJoin(boardNumber, user_id, chatJoinCheck);
		return "redirect:/noticeView?id" + "user_id";
	}
	
	@RequestMapping(value = "/chatJoinCloseMypageView")
	public String ChatJoinCloseMypageView(@RequestParam("id") String user_id, @RequestParam("number") int boardNumber) {
		boolean chatJoinCheck = false;
		userInfoService.chatJoin(boardNumber, user_id, chatJoinCheck);
		return "redirect:/mypageView?id" + "user_id";
	}
	
	@RequestMapping(value = "/chatJoinCloseBoardView")
	public ModelAndView BoardView(@RequestParam("id") String user_id, @RequestParam("number") int boardNumber, 
			@RequestParam("subject") String subject) {
		ModelAndView mav = new ModelAndView();
		if(subject.equals("all")) {
			List<BoardInfoVO> boardList = userInfoService.getBoards();			
			mav.addObject("boardList", boardList);
		} else {
			List<BoardInfoVO> boardList = userInfoService.getBoardOthers(subject);						
			mav.addObject("boardList", boardList);
		}
		UserInfoVO userInfo = userInfoService.selectUserPassword(user_id);
		boolean chatJoinCheck = false;
		userInfoService.chatJoin(boardNumber, user_id, chatJoinCheck);
		List<AlarmInfoVO> alarmList = userInfoService.getAlarms();
		List<AlarmInfoVO> alarms = new ArrayList<AlarmInfoVO>();
		for (int i = 0; i < alarmList.size(); i++) {
			String[] str = alarmList.get(i).getAlarmYouId().split(",");
			if(str[0].equals(user_id)) { 
				alarms.add(alarmList.get(i));
			}
		}
		mav.addObject("alarms", alarms);
		mav.addObject("userInfo", userInfo);
		mav.addObject("togetherPeopleTitle", togetherPeopleTitle);
		mav.addObject("togetherPeopleBoard", togetherPeopleBoard);
		mav.addObject("togetherPeopleMypage", togetherPeopleMypage);
		mav.addObject("togetherPeopleNotice", togetherPeopleNotice);
		mav.addObject("togetherPeopleManagement", togetherPeopleManagement);
		mav.addObject("alarmClose", alarmClose);
		mav.setViewName("boardView");
		return mav;
	}
	/*=========== 채팅창 나갈 때============*/
	
	/*=========== 채팅창 회원 정보============*/
	@RequestMapping(value = "/chatProfile")
	public ModelAndView Profile(@RequestParam("id") String user_id, @RequestParam("number") int boardNumber) {
		ModelAndView mav = new ModelAndView();
		UserInfoVO userInfo = userInfoService.selectUserPassword(user_id);
		BoardInfoVO boardInfo = userInfoService.getboard(boardNumber);
		List<BoardJoinUserInfoVO> boardJoinUsers = userInfoService.getJoinUsers(boardNumber);
		mav.addObject("boardInfo", boardInfo);
		mav.addObject("userInfo", userInfo);
		mav.addObject("boardJoinUsers", boardJoinUsers);
		mav.addObject("togetherPeopleTitle", togetherPeopleTitle);
		mav.setViewName("chatProfile");
		return mav;
	}
	/*=========== 채팅창 회원 정보============*/
	
	/*=========== 게시글 즐겨찾기============*/
	@RequestMapping(value = "/favoriteBoard")
	public String FavoriteBoard(@RequestParam("id") String user_id, @RequestParam("number") int boardNumber) {
		userInfoService.addFavoriteBoard(user_id, boardNumber);
		return "redirect:/boardOpen?number=" + boardNumber + "&id=" + user_id;
	}
	/*=========== 게시글 즐겨찾기============*/
	
	/*=========== 게시글 즐겨찾기 취소============*/
	@RequestMapping(value = "/favoriteBoardCancel")
	public String FavoriteBoardCancel(@RequestParam("id") String user_id, @RequestParam("number") int boardNumber) {
		userInfoService.modifyFavoriteBoard(user_id, boardNumber);
		return "redirect:/boardOpen?number=" + boardNumber + "&id=" + user_id;
	}
	/*=========== 게시글 즐겨찾기 취소============*/

	/*=========== 마이 페이지 보기 ============*/
	@RequestMapping(value = "/mypageView")
	public ModelAndView MypageView(@RequestParam("id") String user_id) {
		ModelAndView mav = new ModelAndView();
		UserInfoVO userInfo = userInfoService.selectUserPassword(user_id);
		List<PostingInfoVO> postingList = userInfoService.getPostings();
		List<BoardInfoVO> boardList = userInfoService.getUserBoard(user_id);
		List<PostingInfoVO> postingRecommandList = userInfoService.getPostingRecommands(user_id);
		String str = "recommand";
		List<AlarmInfoVO> alarmList = userInfoService.getAlarms();
		List<AlarmInfoVO> alarms = new ArrayList<AlarmInfoVO>();
		for (int i = 0; i < alarmList.size(); i++) {
			String[] str3 = alarmList.get(i).getAlarmYouId().split(",");
			if(str3[0].equals(user_id)) { 
				alarms.add(alarmList.get(i));
			}
		}
		mav.addObject("alarms", alarms);
		mav.addObject("userInfo", userInfo);
		mav.addObject("postingList", postingList);
		mav.addObject("boardList", boardList);
		mav.addObject("postingRecommandList", postingRecommandList);
		mav.addObject("recommand", str);
		mav.addObject("togetherPeopleTitle", togetherPeopleTitle);
		mav.addObject("togetherPeopleBoard", togetherPeopleBoard);
		mav.addObject("togetherPeopleMypage", togetherPeopleMypage);
		mav.addObject("togetherPeopleNotice", togetherPeopleNotice);
		mav.addObject("togetherPeopleManagement", togetherPeopleManagement);
		mav.addObject("alarmClose", alarmClose);
		mav.setViewName("mypageView");
		return mav;
	}
	/*=========== 마이 페이지 보기 ============*/
	
	/*=========== 마이 페이지 회원 정보 수정 ============*/
	@RequestMapping(value = "/userInfoModify")
	public ModelAndView UserInfoModify(@RequestParam("id") String user_id) {
		ModelAndView mav = new ModelAndView();
		UserInfoVO userInfo = userInfoService.selectUserPassword(user_id);
		List<AlarmInfoVO> alarmList = userInfoService.getAlarms();
		List<AlarmInfoVO> alarms = new ArrayList<AlarmInfoVO>();
		for (int i = 0; i < alarmList.size(); i++) {
			String[] str = alarmList.get(i).getAlarmYouId().split(",");
			if(str[0].equals(user_id)) { 
				alarms.add(alarmList.get(i));
			}
		}
		mav.addObject("alarms", alarms);
		mav.addObject("userInfo", userInfo);
		mav.addObject("togetherPeopleTitle", togetherPeopleTitle);
		mav.addObject("togetherPeopleBoard", togetherPeopleBoard);
		mav.addObject("togetherPeopleMypage", togetherPeopleMypage);
		mav.addObject("togetherPeopleNotice", togetherPeopleNotice);
		mav.addObject("togetherPeopleManagement", togetherPeopleManagement);
		mav.addObject("alarmClose", alarmClose);
		mav.setViewName("mypageUserInfoModify");
		return mav;
	}

	@RequestMapping(value = "/userInfoModifyForm")
	public String UserInfoModifyForm(@RequestParam("user_name") String user_name, @RequestParam("user_postNumber") String user_postNumber,
			@RequestParam("user_address") String user_address, @RequestParam("user_detailAddress") String user_detailAddress, 
			@RequestParam("user_email") String user_email, @RequestParam("user_phone") int user_phone, @RequestParam("user_id") String user_id,
			@RequestParam("user_passwordQuestion") String user_passwordQuestion, @RequestParam("user_answer") String user_answer) {
		if(user_passwordQuestion.equals("질문")) {
			return "redirect:/userInfoModifyError?id=" + user_id;
		} else {
			userInfoService.modifyUserInfo(user_name, user_detailAddress, user_email, user_phone, user_id);
			return "redirect:/mypageView?id=" + user_id;
		}
	}
	
	@RequestMapping(value = "/userInfoModifyError")
	public String UserInfoModifyError(@RequestParam("id") String user_id) {
		return "redirect:/userInfoModify?id=" + user_id;
	}
	/*=========== 마이 페이지 회원 정보 수정 ============*/
	
	/*=========== 마이페이지 즐겨찾기 취소 ============*/
	@RequestMapping(value = "/mypageFavoriteCancel")
	public String MypageFavoriteCancel(@RequestParam("id") String user_id, @RequestParam("number") int boardNumber) {
		userInfoService.modifyFavoriteBoard(user_id, boardNumber);
		return "redirect:/mypageView?id=" + user_id;
	}
	/*=========== 마이페이지 즐겨찾기 취소 ============*/

	/*=========== 마이페이지 포스팅 삭제 ============*/
	@RequestMapping(value = "/mypageDeletePosting")
	public String MypageDeletePosting(@RequestParam("user_id") String user_id, @RequestParam("check") List<String> postingNumber) {
		if(!postingNumber.get(0).equals("empty")) {
			userInfoService.deletePosting(user_id, Integer.parseInt(postingNumber.get(0)));			
		}
		return "redirect:/mypageView?id=" + user_id;
	}
	/*=========== 마이페이지 포스팅 삭제 ============*/
	
	/*=========== 마이페이지 내 게시글 보기 ============*/
	@RequestMapping(value = "/mypageUserBoard")
	public ModelAndView MypageUserBoard(@RequestParam("id") String user_id) {
		ModelAndView mav = new ModelAndView();
		UserInfoVO userInfo = userInfoService.selectUserPassword(user_id);
		List<PostingInfoVO> postingList = userInfoService.getPostings();
		List<BoardInfoVO> boardList = userInfoService.getBoards();
		List<PostingInfoVO> postingRecommandList = userInfoService.getPostingRecommands(user_id);
		String str = "myBoard";
		List<AlarmInfoVO> alarmList = userInfoService.getAlarms();
		List<AlarmInfoVO> alarms = new ArrayList<AlarmInfoVO>();
		for (int i = 0; i < alarmList.size(); i++) {
			String[] str3 = alarmList.get(i).getAlarmYouId().split(",");
			if(str3[0].equals(user_id)) { 
				alarms.add(alarmList.get(i));
			}
		}
		mav.addObject("alarms", alarms);
		mav.addObject("userInfo", userInfo);
		mav.addObject("postingList", postingList);
		mav.addObject("boardList", boardList);
		mav.addObject("postingRecommandList", postingRecommandList);
		mav.addObject("recommand", str);
		mav.addObject("togetherPeopleTitle", togetherPeopleTitle);
		mav.addObject("togetherPeopleBoard", togetherPeopleBoard);
		mav.addObject("togetherPeopleMypage", togetherPeopleMypage);
		mav.addObject("togetherPeopleNotice", togetherPeopleNotice);
		mav.addObject("togetherPeopleManagement", togetherPeopleManagement);
		mav.addObject("alarmClose", alarmClose);
		mav.setViewName("mypageView");
		return mav;
	}
	/*=========== 마이페이지 내 게시글 보기 ============*/

	/*=========== 마이페이지 내 게시글 삭제 ============*/
	@RequestMapping(value = "/mypageBoardDelete")
	public ModelAndView MypageBoardDelete(@RequestParam("user_id") String user_id, @RequestParam("check") List<String> boardNumber) {
		ModelAndView mav = new ModelAndView();
		if(boardNumber.get(0).equals("empty")) {
			
		} else {
			userInfoService.addAlarmBoardDelete(user_id, Integer.parseInt(boardNumber.get(0)));
			userInfoService.deleteMypageBoard(Integer.parseInt(boardNumber.get(0)));
		}
		UserInfoVO userInfo = userInfoService.selectUserPassword(user_id);
		List<PostingInfoVO> postingList = userInfoService.getPostings();
		List<BoardInfoVO> boardList = userInfoService.getBoards();
		List<PostingInfoVO> postingRecommandList = userInfoService.getPostingRecommands(user_id);
		String str = "myBoard";
		List<AlarmInfoVO> alarmList = userInfoService.getAlarms();
		List<AlarmInfoVO> alarms = new ArrayList<AlarmInfoVO>();
		for (int i = 0; i < alarmList.size(); i++) {
			String[] str3 = alarmList.get(i).getAlarmYouId().split(",");
			if(str3[0].equals(user_id)) { 
				alarms.add(alarmList.get(i));
			}
		}
		mav.addObject("alarms", alarms);
		mav.addObject("userInfo", userInfo);
		mav.addObject("postingList", postingList);
		mav.addObject("boardList", boardList);
		mav.addObject("postingRecommandList", postingRecommandList);
		mav.addObject("recommand", str);
		mav.addObject("togetherPeopleTitle", togetherPeopleTitle);
		mav.addObject("togetherPeopleBoard", togetherPeopleBoard);
		mav.addObject("togetherPeopleMypage", togetherPeopleMypage);
		mav.addObject("togetherPeopleNotice", togetherPeopleNotice);
		mav.addObject("togetherPeopleManagement", togetherPeopleManagement);
		mav.addObject("alarmClose", alarmClose);
		mav.setViewName("mypageView");
		return mav;
	}
	/*=========== 마이페이지 내 게시글 삭제 ============*/
	
	/*=========== 회원탈퇴 ============*/
	@RequestMapping(value = "/userSecession")
	public ModelAndView UserSecession(@RequestParam("id") String user_id) {
		ModelAndView mav = new ModelAndView();
		UserInfoVO userInfo = userInfoService.getUser(user_id);
		mav.addObject("userInfo", userInfo);
		mav.addObject("togetherPeopleTitle", togetherPeopleTitle);
		mav.setViewName("userSecession");
		return mav;
	}
	
	@RequestMapping(value = "/userSecessionForm")
	public void UserSecessionForm(@RequestParam("user_id") String user_id) {
		userInfoService.userSecession(user_id);
	}
	/*=========== 회원탈퇴 ============*/
	
	/*=========== 문의사항 ============*/
	@RequestMapping(value = "/qnaView")
	public ModelAndView MypageQnaView(@RequestParam("id") String user_id) {
		ModelAndView mav = new ModelAndView();
		UserInfoVO userInfo = userInfoService.getUser(user_id);
		List<QnaInfoVO> qnaList = userInfoService.getQnas(user_id);
		List<AlarmInfoVO> alarmList = userInfoService.getAlarms();
		List<AlarmInfoVO> alarms = new ArrayList<AlarmInfoVO>();
		for (int i = 0; i < alarmList.size(); i++) {
			String[] str = alarmList.get(i).getAlarmYouId().split(",");
			if(str[0].equals(user_id)) { 
				alarms.add(alarmList.get(i));
			}
		}
		mav.addObject("alarms", alarms);
		mav.addObject("userInfo", userInfo);
		mav.addObject("qnaList", qnaList);
		mav.addObject("togetherPeopleTitle", togetherPeopleTitle);
		mav.addObject("togetherPeopleBoard", togetherPeopleBoard);
		mav.addObject("togetherPeopleMypage", togetherPeopleMypage);
		mav.addObject("togetherPeopleNotice", togetherPeopleNotice);
		mav.addObject("togetherPeopleManagement", togetherPeopleManagement);
		mav.addObject("alarmClose", alarmClose);
		mav.setViewName("qnaView");
		return mav;
	}
	/*=========== 문의사항 ============*/

	/*=========== 문의사항 등록 ============*/
	@RequestMapping(value = "/qnaRegist")
	public ModelAndView QnaRegist(@RequestParam("id") String user_id) {
		ModelAndView mav = new ModelAndView();
		UserInfoVO userInfo = userInfoService.getUser(user_id);
		List<AlarmInfoVO> alarmList = userInfoService.getAlarms();
		List<AlarmInfoVO> alarms = new ArrayList<AlarmInfoVO>();
		for (int i = 0; i < alarmList.size(); i++) {
			String[] str = alarmList.get(i).getAlarmYouId().split(",");
			if(str[0].equals(user_id)) { 
				alarms.add(alarmList.get(i));
			}
		}
		mav.addObject("alarms", alarms);
		mav.addObject("userInfo", userInfo);
		mav.addObject("togetherPeopleTitle", togetherPeopleTitle);
		mav.addObject("togetherPeopleBoard", togetherPeopleBoard);
		mav.addObject("togetherPeopleMypage", togetherPeopleMypage);
		mav.addObject("togetherPeopleNotice", togetherPeopleNotice);
		mav.addObject("togetherPeopleManagement", togetherPeopleManagement);
		mav.addObject("alarmClose", alarmClose);
		mav.setViewName("qnaRegist");
		return mav;
	}
	
	@RequestMapping(value = "/qnaRegistForm")
	public String QnaRegistForm(@RequestParam("user_id") String user_id, @RequestParam("subject") String qnaTitle, 
			@RequestParam("content") String qnaContent) {
		if(qnaTitle.equals("")) {
			return "redirect:/qnaRegist?id=" + user_id;
		} else if(qnaContent.equals("")) {
			return "redirect:/qnaRegist?id=" + user_id;
		} else {
			userInfoService.addQna(user_id, qnaTitle, qnaContent);
			userInfoService.addAlarmQna(user_id, qnaTitle, qnaContent);
			return "redirect:/qnaView?id=" + user_id;
		}
	}
	/*=========== 문의사항 등록 ============*/
	
	/*=========== 문의사항 삭제 ============*/
	@RequestMapping(value = "/qnaDelete")
	public String QnaDelete(@RequestParam("id") String user_id, @RequestParam("number") int qnaNumber) {
		userInfoService.deleteQna(qnaNumber);
		return "redirect:/qnaView?id=" + user_id;
	}
	/*=========== 문의사항 삭제 ============*/
	
	/*=========== 문의사항 보기 ============*/
	@RequestMapping(value = "/qnaOpen")
	public ModelAndView QnaOpen(@RequestParam("id") String user_id, @RequestParam("number") int qnaNumber) {
		ModelAndView mav = new ModelAndView();
		QnaInfoVO qnaInfo = userInfoService.getQna(qnaNumber);
		UserInfoVO userInfo = userInfoService.getUser(user_id);
		if(qnaInfo.getQnaComment().equals("empty")) {
			qnaInfo.setQnaComment("no answer");
		}
		List<AlarmInfoVO> alarmList = userInfoService.getAlarms();
		List<AlarmInfoVO> alarms = new ArrayList<AlarmInfoVO>();
		for (int i = 0; i < alarmList.size(); i++) {
			String[] str = alarmList.get(i).getAlarmYouId().split(",");
			if(str[0].equals(user_id)) { 
				alarms.add(alarmList.get(i));
			}
		}
		mav.addObject("alarms", alarms);
		mav.addObject("qnaInfo", qnaInfo);
		mav.addObject("userInfo", userInfo);
		mav.addObject("togetherPeopleTitle", togetherPeopleTitle);
		mav.addObject("togetherPeopleBoard", togetherPeopleBoard);
		mav.addObject("togetherPeopleMypage", togetherPeopleMypage);
		mav.addObject("togetherPeopleNotice", togetherPeopleNotice);
		mav.addObject("togetherPeopleManagement", togetherPeopleManagement);
		mav.addObject("alarmClose", alarmClose);
		mav.setViewName("qnaOpen");
		return mav;
	}
	/*=========== 문의사항 보기 ============*/
	
	/*=========== 문의사항 수정 ============*/
	@RequestMapping(value = "/qnaModify")
	public ModelAndView QnaModify(@RequestParam("id") String user_id, @RequestParam("number") int qnaNumber) {
		ModelAndView mav = new ModelAndView();
		QnaInfoVO qnaInfo = userInfoService.getQna(qnaNumber);
		UserInfoVO userInfo = userInfoService.getUser(user_id);
		List<AlarmInfoVO> alarmList = userInfoService.getAlarms();
		List<AlarmInfoVO> alarms = new ArrayList<AlarmInfoVO>();
		for (int i = 0; i < alarmList.size(); i++) {
			String[] str = alarmList.get(i).getAlarmYouId().split(",");
			if(str[0].equals(user_id)) { 
				alarms.add(alarmList.get(i));
			}
		}
		mav.addObject("alarms", alarms);
		mav.addObject("qnaInfo", qnaInfo);
		mav.addObject("userInfo", userInfo);
		mav.addObject("togetherPeopleTitle", togetherPeopleTitle);
		mav.addObject("togetherPeopleBoard", togetherPeopleBoard);
		mav.addObject("togetherPeopleMypage", togetherPeopleMypage);
		mav.addObject("togetherPeopleNotice", togetherPeopleNotice);
		mav.addObject("togetherPeopleManagement", togetherPeopleManagement);
		mav.addObject("alarmClose", alarmClose);
		mav.setViewName("qnaModify");
		return mav;
	}
	
	@RequestMapping(value = "/qnaModifyForm")
	public String QnaModifyForm(@RequestParam("user_id") String user_id, @RequestParam("qnaNumber") int qnaNumber, 
			@RequestParam("subject") String qnaTitle, @RequestParam("content") String qnaContent) {
		userInfoService.qnaModify(user_id, qnaNumber, qnaTitle, qnaContent);
		return "redirect:/qnaView?id=" + user_id;
	}
	/*=========== 문의사항 수정 ============*/

	/*=========== 관리자 포스팅 삭제 ============*/
	@RequestMapping(value = "/adminDeletePosting")
	public String AdminDeletePosting(@RequestParam("id") String user_id, @RequestParam("number") int postingNumber) {
		userInfoService.adminDeletePosting(postingNumber);
		return "redirect:/mainView?id=" + user_id;
	}
	/*=========== 관리자 포스팅 삭제 ============*/
	
	/*=========== 관리자 게시글 검색/삭제 ============*/
	@RequestMapping(value = "/adminBoardDelete")
	public String AdminBoardDelete(@RequestParam("user_id") String user_id, @RequestParam("check") List<String> boardNumber, 
			@RequestParam("subject") String subject, @RequestParam("searchText") String searchText) {
		if(boardNumber.get(0).equals("empty")) {
			
		} else {
			userInfoService.adminBoardDelete(Integer.parseInt(boardNumber.get(0)));
		}
		if(searchText.equals("")) {
		} else { 
			String searchBoardList = userInfoService.getSearchBoard(searchText);
			if(searchBoardList.equals("notSearch")){
			} else {
				return "redirect:/searchBoardView?id=" + user_id + "&list=" + searchBoardList;
			}
		}
		return "redirect:/boardView?id=" + user_id + "&subject=" + subject;
	}
	/*=========== 관리자 게시글 검색/삭제 ============*/
	
	/*=========== 관리 ============*/
	@RequestMapping(value = "/managementView")
	public ModelAndView ManagementView() {
		ModelAndView mav = new ModelAndView();
		UserInfoVO userInfo = userInfoService.getUser("admin");
		List<UserInfoVO> userList = userInfoService.getMembers();
		List<QnaInfoVO> qnaList = userInfoService.getQnaInfos();
		List<AlarmInfoVO> alarmList = userInfoService.getAlarms();
		List<AlarmInfoVO> alarms = new ArrayList<AlarmInfoVO>();
		for (int i = 0; i < alarmList.size(); i++) {
			String[] str = alarmList.get(i).getAlarmYouId().split(",");
			if(str[0].equals("admin")) { 
				alarms.add(alarmList.get(i));
			}
		}
		mav.addObject("alarms", alarms);
		mav.addObject("userList", userList);
		mav.addObject("qnaList", qnaList);
		mav.addObject("userInfo", userInfo);
		mav.addObject("togetherPeopleTitle", togetherPeopleTitle);
		mav.addObject("togetherPeopleBoard", togetherPeopleBoard);
		mav.addObject("togetherPeopleMypage", togetherPeopleMypage);
		mav.addObject("togetherPeopleNotice", togetherPeopleNotice);
		mav.addObject("togetherPeopleManagement", togetherPeopleManagement);
		mav.addObject("alarmClose", alarmClose);
		mav.setViewName("managementView");
		return mav;
	}
	/*=========== 관리 ============*/

	/*=========== 회원 추방 ============*/
	@RequestMapping(value = "/adminUserExile")
	public String AdminUserExile(@RequestParam("check") List<String> user_idList) {
		if(user_idList.size() == 1) {
		} else {
			userInfoService.userSecession(user_idList.get(1));
		}
		return "redirect:/managementView";
	}
	/*=========== 회원 추방 ============*/

	/*=========== 관리자 문의사항 삭제 ============*/
	@RequestMapping(value = "/adminQnaDelete")
	public String AdminQnaDelete(@RequestParam("check") List<String> qnaNumberList) {
		if(qnaNumberList.size() == 1) {
		} else {
			userInfoService.deleteQna(Integer.parseInt(qnaNumberList.get(1)));
		}
		return "redirect:/managementView";
	}
	/*=========== 관리자 문의사항 삭제 ============*/
	
	/*=========== 관리자 문의사항 보기 ============*/
	@RequestMapping(value = "/adminQnaOpen")
	public ModelAndView AdminQnaOpen(@RequestParam("id") String user_id, @RequestParam("number") int qnaNumber) {
		ModelAndView mav = new ModelAndView();
		QnaInfoVO qnaInfo = userInfoService.getQna(qnaNumber);
		UserInfoVO userInfo = userInfoService.getUser(user_id);
		if(qnaInfo.getQnaComment().equals("empty")) {
			qnaInfo.setQnaComment(" ");
		}
		List<AlarmInfoVO> alarmList = userInfoService.getAlarms();
		List<AlarmInfoVO> alarms = new ArrayList<AlarmInfoVO>();
		for (int i = 0; i < alarmList.size(); i++) {
			String[] str = alarmList.get(i).getAlarmYouId().split(",");
			if(str[0].equals(user_id)) { 
				alarms.add(alarmList.get(i));
			}
		}
		mav.addObject("alarms", alarms);
		mav.addObject("admin", "admin");
		mav.addObject("qnaInfo", qnaInfo);
		mav.addObject("userInfo", userInfo);
		mav.addObject("togetherPeopleTitle", togetherPeopleTitle);
		mav.addObject("togetherPeopleBoard", togetherPeopleBoard);
		mav.addObject("togetherPeopleMypage", togetherPeopleMypage);
		mav.addObject("togetherPeopleNotice", togetherPeopleNotice);
		mav.addObject("togetherPeopleManagement", togetherPeopleManagement);
		mav.addObject("alarmClose", alarmClose);
		mav.setViewName("qnaOpen");
		return mav;
	}
	/*=========== 관리자 문의사항 보기 ============*/
	
	/*=========== 관리자 문의사항 답변 달기 ============*/
	@RequestMapping(value = "/commentInput")
	public String CommentInput(@RequestParam("qna_id") String qna_id, @RequestParam("qna_qnaNumber") int qnaNumber,
			@RequestParam("ta") String qnaComment) {
		if(qnaComment.equals("")) {
			qnaComment = "empty";
		}
		userInfoService.modifyQnaComment(qna_id, qnaNumber, qnaComment);
		userInfoService.addAlarmQnaComment(qna_id, qnaNumber);
		return "redirect:/managementView";
	}
	/*=========== 관리자 문의사항 답변 달기 ============*/
	
	/*=========== 게시글 회원 추방 ============*/
	@RequestMapping(value = "/userBoardOut")
	public String UserBoardOut(@RequestParam("id") String user_id, @RequestParam("boardJoinUser_id") String boardJoinUser_id,
			@RequestParam("number") int boardNumber) {
		BoardJoinUserInfoVO boardJoinUserInfo = userInfoService.getBoardJoinUser(boardNumber, boardJoinUser_id);
		userInfoService.userBoardOut(boardJoinUser_id, boardNumber);
		userInfoService.boardJoinUserNumberDown(boardNumber);
		userInfoService.addAlarmBoardOut(user_id, boardJoinUserInfo, boardNumber);
		return "redirect:/chatProfile?id=" + user_id + "&number=" + boardNumber;
	}
	/*=========== 게시글 회원 추방 ============*/
}