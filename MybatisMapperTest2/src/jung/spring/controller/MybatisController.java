package jung.spring.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import jung.spring.svc.UserInfoService;
import jung.spring.vo.AlarmInfoVO;
import jung.spring.vo.BoardInfoVO;
import jung.spring.vo.BoardJoinUserInfoVO;
import jung.spring.vo.ChatInfoVO;
import jung.spring.vo.NoticeInfoVO;
import jung.spring.vo.PostingInfoVO;
import jung.spring.vo.PostingRecommandInfoVO;
import jung.spring.vo.QnaInfoVO;
import jung.spring.vo.UserInfoPasswordVO;
import jung.spring.vo.UserInfoVO;

@Controller
public class MybatisController {

	@Autowired
	private UserInfoService userInfoService;
	
	private String togetherPeopleTitle = "http://sjsnrndi12.dothome.co.kr/images/bg.png";
	private String togetherPeopleBoard = "http://sjsnrndi12.dothome.co.kr/images/board.png";
	private String togetherPeopleMypage = "http://sjsnrndi12.dothome.co.kr/images/mypage.png";
	private String togetherPeopleNotice = "http://sjsnrndi12.dothome.co.kr/images/notice.PNG";
	private String togetherPeopleManagement = "http://sjsnrndi12.dothome.co.kr/images/management.png";
	private String togetherPeopleBeforeRecommand = "http://sjsnrndi12.dothome.co.kr/images/recommand2.png";
	private String alarmClose = "http://sjsnrndi12.dothome.co.kr/images/alarm.png";
	
	/*=========== �⺻ ȭ�� ============*/
	@RequestMapping(value="/")
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView();
		List<PostingInfoVO> postingList = userInfoService.getPostings();
		mav.addObject("togetherPeopleTitle", togetherPeopleTitle);
		mav.addObject("postingList", postingList);
		mav.setViewName("firstView");
		return mav;
	}
	
	@RequestMapping(value="/firstView")
	public ModelAndView first() {
		ModelAndView mav = new ModelAndView();
		List<PostingInfoVO> postingList = userInfoService.getPostings();
		mav.addObject("postingList", postingList);
		mav.addObject("togetherPeopleTitle", togetherPeopleTitle);
		mav.setViewName("firstView");
		return mav;
	}
	
	@RequestMapping(value="/loginMainView")
	public ModelAndView loginFirst(@RequestParam("id") String user_id) {
		ModelAndView mav = new ModelAndView();
		List<PostingInfoVO> postingList = userInfoService.getPostings();
		mav.addObject("postingList", postingList);
		UserInfoVO userInfo = userInfoService.getUser(user_id);
		mav.addObject("userInfo", userInfo);
		mav.addObject("togetherPeopleTitle", togetherPeopleTitle);
		mav.setViewName("loginMainView");
		return mav;
	}
	/*=========== �⺻ ȭ�� ============*/
	
	/*=========== �α��� ȭ�� ============*/
	@RequestMapping("/loginView")
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView();
		List<UserInfoVO> userList = userInfoService.getMembers();
		mav.addObject("userList", userList);
		mav.addObject("togetherPeopleTitle", togetherPeopleTitle);
		mav.setViewName("loginView");
		return mav;
	}
	@RequestMapping("/user_login")
	public ModelAndView main(@RequestParam("user_id") String user_id, @RequestParam("user_password") String user_password) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("togetherPeopleTitle", togetherPeopleTitle);
		List<PostingInfoVO> postingList = userInfoService.getPostings();
		mav.addObject("postingList", postingList);
		UserInfoVO userInfo = userInfoService.getUser(user_id);
		mav.addObject("userInfo", userInfo);
		mav.setViewName("loginMainView");
		return mav;
	}
	/*=========== �α��� ȭ�� ============*/
	
	/*=========== ���� ȭ�� ============*/
	/*@RequestMapping("/mainView")
	public ModelAndView mainView(@RequestParam("id") String user_id) {
		ModelAndView mav = new ModelAndView();
		UserInfoVO userInfo = userInfoService.getUser(user_id);
		List<PostingInfoVO> postingList = userInfoService.getPostings();
		List<AlarmInfoVO> alarmList = userInfoService.getAlarms();
		List<AlarmInfoVO> alarms = new ArrayList<AlarmInfoVO>();
		for (int i = 0; i < alarmList.size(); i++) {
			String[] str = alarmList.get(i).getAlarmYouId().split(",");
			if(str[0].equals(user_id)) {
				alarms.add(alarmList.get(i));
			}
		}
		mav.addObject("userInfo", userInfo);
		mav.addObject("postingList", postingList);
		mav.addObject("alarms", alarms);
		mav.addObject("togetherPeopleTitle", togetherPeopleTitle);
		mav.addObject("togetherPeopleBoard", togetherPeopleBoard);
		mav.addObject("togetherPeopleMypage", togetherPeopleMypage);
		mav.addObject("togetherPeopleNotice", togetherPeopleNotice);
		mav.addObject("togetherPeopleManagement", togetherPeopleManagement);
		mav.addObject("togetherPeopleBeforeRecommand", togetherPeopleBeforeRecommand);
		mav.addObject("alarmClose", alarmClose);
		mav.setViewName("mainView");
		return mav;
	}
	
	@RequestMapping("/mainViewAlarm")
	public String mainViewAlarm(@RequestParam("id") String user_id) {
		//�˶� �� ���� ����
		return "redirect:/mainView?id=" + user_id;
	}*/
	/*=========== ���� ȭ�� ============*/
	
	/*=========== ȸ������ ȭ�� ============*/
	@RequestMapping(value = "/userRegist")
	public ModelAndView userRegist() {
		ModelAndView mav = new ModelAndView();
		List<UserInfoVO> userList = userInfoService.getMembers();
		mav.addObject("userList", userList);
		mav.addObject("togetherPeopleTitle", togetherPeopleTitle);
		mav.setViewName("userRegist");
		return mav;
	}
	
	@RequestMapping(value = "/user_info_regist")
	public ModelAndView userRegistForm(UserInfoVO userInfo) {
		ModelAndView mav = new ModelAndView();
		userInfoService.addUserInfo(userInfo);
		UserInfoVO user = userInfoService.getUser(userInfo.getUser_id());
		mav.addObject("user", user);
		mav.addObject("togetherPeopleTitle", togetherPeopleTitle);
		mav.setViewName("userRegistResult");
		return mav;
	}
	
	@RequestMapping(value = "/selectAddress")
	public ModelAndView SelectAddressForm() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("togetherPeopleTitle", togetherPeopleTitle);
		mav.setViewName("selectAddress");
		return mav;
	}
	/*=========== ȸ������ ȭ�� ============*/
	
	/*=========== ���̵� ã�� ȭ�� ============*/
	@RequestMapping(value = "/findID")
	public ModelAndView FindId() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("togetherPeopleTitle", togetherPeopleTitle);
		mav.setViewName("findID");
		return mav;
	}

	@RequestMapping(value = "/find_user_id")
	public ModelAndView FindIDResult(@RequestParam("user_name") String user_name, @RequestParam("user_phone") int user_phone) {
		ModelAndView mav = new ModelAndView();
		boolean idCheck = userInfoService.checkUserEmail(user_name, user_phone);
		if(idCheck) {
			UserInfoVO userInfo = userInfoService.selectUserId(user_name, user_phone);
			mav.addObject("userInfo", userInfo);
			mav.setViewName("findIDResult");			
		} else {
			mav.setViewName("findIDFailResult");
		}
		mav.addObject("togetherPeopleTitle", togetherPeopleTitle);
		return mav;
	}
	/*=========== ���̵� ã�� ȭ�� ============*/
	
	/*=========== ��й�ȣ ã�� ȭ�� ============*/
	@RequestMapping(value = "/findPassword")
	public ModelAndView FindPassword() {
		ModelAndView mav = new ModelAndView();
		List<UserInfoVO> userList = userInfoService.getMembers();
		mav.addObject("userList", userList);
		mav.addObject("togetherPeopleTitle", togetherPeopleTitle);
		mav.setViewName("findPassword");
		return mav;
	}

	@RequestMapping(value = "/find_user_password")
	public ModelAndView FindPasswordResult(@RequestParam("user_id") String user_id, @RequestParam("user_name") String user_name, @RequestParam("user_phone") int user_phone) {
		ModelAndView mav = new ModelAndView();
		boolean pwCheck = userInfoService.selectUserPassword(user_id, user_name, user_phone);
		mav.addObject("user_id", user_id);
		if(pwCheck) {
			mav.setViewName("modifyPassword");
		} else {
			mav.setViewName("findPassword");
		}
		mav.addObject("togetherPeopleTitle", togetherPeopleTitle);
		return mav;
	}
	
	@RequestMapping(value = "/modify_user_password")
	public ModelAndView ModifyPassword(@RequestParam("user_id") String user_id, @RequestParam("user_password") String user_password) {
		ModelAndView mav = new ModelAndView();
		userInfoService.modifyUserPassword(user_password, user_id);
		mav.addObject("user_id", user_id);
		mav.addObject("togetherPeopleTitle", togetherPeopleTitle);
		mav.setViewName("findPasswordResult");
		return mav;
	}
	/*=========== ��й�ȣ ã�� ȭ�� ============*/
	
	/*=========== ������ ��� ȭ�� ============*/
	@RequestMapping(value = "/postingRegist")
	public ModelAndView PostingRegist(@RequestParam("id") String user_id) {
		ModelAndView mav = new ModelAndView();
		UserInfoVO userInfo = userInfoService.selectUserPassword(user_id);
		mav.addObject("userInfo", userInfo);
		mav.addObject("togetherPeopleTitle", togetherPeopleTitle);
		mav.setViewName("postingRegist");
		return mav;
	}
	
	@RequestMapping(value = "/postingRegistForm")
	public String PostingRegistForm(@RequestParam("user_id") String user_id, 
			@RequestParam("user_name") String user_name, @RequestParam("postingContent") String postingContent) {
		PostingInfoVO postingInfo = userInfoService.addUserPostingInfo(user_id, user_name, postingContent);
		if(postingContent.equals("")) {
			return "redirect:/postingRegist?id=" + user_id;
		} else {
			userInfoService.addUserPosting(postingInfo);
			return "redirect:/mainView?id=" + user_id;
		}
	}
	/*=========== ������ ��� ȭ�� ============*/
	
	/*=========== ������ ���� ȭ�� ============*/
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
	/*=========== ������ ���� ȭ�� ============*/
	
	/*=========== ������ ���� ȭ�� ============*/
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
	/*=========== ������ ���� ȭ�� ============*/
	
	/*=========== ������ ��õ ȭ�� ============*/
	@RequestMapping(value = "/postingRecommandCount")
	public String PostingRecommandCount(@RequestParam("id") String user_id, @RequestParam("number") int postingNumber) {
		userInfoService.createUserPostingRecommand(user_id, postingNumber);
		PostingRecommandInfoVO posting = userInfoService.getPosting(user_id, postingNumber);
		if(posting.getPostingRecommandCountCheck() == 1) {
			userInfoService.addAlarmPosting(user_id, postingNumber);
		}
		return "redirect:/mainView?id=" + user_id;
	}
	/*=========== ������ ��õ ȭ�� ============*/
	
	/*=========== �������� ȭ�� ============*/
	@RequestMapping(value = "/noticeView")
	public ModelAndView NoticeView(@RequestParam("id") String user_id) {
		ModelAndView mav = new ModelAndView();
		List<NoticeInfoVO> noticeList = userInfoService.getNotices();
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
		mav.addObject("noticeList", noticeList);
		mav.addObject("togetherPeopleTitle", togetherPeopleTitle);
		mav.addObject("togetherPeopleBoard", togetherPeopleBoard);
		mav.addObject("togetherPeopleMypage", togetherPeopleMypage);
		mav.addObject("togetherPeopleNotice", togetherPeopleNotice);
		mav.addObject("togetherPeopleManagement", togetherPeopleManagement);
		mav.addObject("alarmClose", alarmClose);
		mav.setViewName("noticeView");
		return mav;
	}
	/*=========== �������� ȭ�� ============*/
	
	/*=========== �������� ��� ȭ�� ============*/
	@RequestMapping(value = "/noticeRegist")
	public ModelAndView NoticeRegist(@RequestParam("id") String user_id) {
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
		mav.setViewName("noticeRegist");
		return mav;
	}
	
	@RequestMapping(value = "/noticeRegistForm")
	public String NoticeRegistForm(@RequestParam("writer") String noticeWriter, @RequestParam("user_id") String user_id,
			@RequestParam("subject") String noticeTitle, @RequestParam("content") String noticeContent) {
		if(noticeTitle.equals("")) {
			return "redirect:/noticeRegist?id=" + user_id;
		} else if(noticeContent.equals("")) {
			return "redirect:/noticeRegist?id=" + user_id;
		} else {
			userInfoService.addNotice(noticeWriter, noticeTitle, noticeContent);
			return "redirect:/noticeView?id=" + user_id;
		}
	}
	/*=========== �������� ��� ȭ�� ============*/
	
	/*=========== �������� ���� ȭ�� ============*/
	@RequestMapping(value = "/noticeOpen")
	public ModelAndView NoticeOpen(@RequestParam("number") int noticeNumber, @RequestParam("id") String user_id) {
		ModelAndView mav = new ModelAndView();
		NoticeInfoVO noticeInfo = userInfoService.getNotice(noticeNumber);
		UserInfoVO userInfo = userInfoService.selectUserPassword(user_id);
		userInfoService.modifyNoticeReadCount(noticeNumber);
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
		mav.addObject("noticeInfo", noticeInfo);
		mav.addObject("togetherPeopleTitle", togetherPeopleTitle);
		mav.addObject("togetherPeopleBoard", togetherPeopleBoard);
		mav.addObject("togetherPeopleMypage", togetherPeopleMypage);
		mav.addObject("togetherPeopleNotice", togetherPeopleNotice);
		mav.addObject("togetherPeopleManagement", togetherPeopleManagement);
		mav.addObject("alarmClose", alarmClose);
		mav.setViewName("noticeOpen");
		return mav;
	}
	/*=========== �������� ���� ȭ�� ============*/
	
	/*=========== �������� ���� ȭ�� ============*/
	@RequestMapping(value = "/noticeModify")
	public ModelAndView NoticeModify(@RequestParam("number") int noticeNumber, @RequestParam("id") String user_id) {
		ModelAndView mav = new ModelAndView();
		NoticeInfoVO noticeInfo = userInfoService.getNotice(noticeNumber);
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
		mav.addObject("noticeInfo", noticeInfo);
		mav.addObject("userInfo", userInfo);
		mav.addObject("togetherPeopleTitle", togetherPeopleTitle);
		mav.addObject("togetherPeopleBoard", togetherPeopleBoard);
		mav.addObject("togetherPeopleMypage", togetherPeopleMypage);
		mav.addObject("togetherPeopleNotice", togetherPeopleNotice);
		mav.addObject("togetherPeopleManagement", togetherPeopleManagement);
		mav.addObject("alarmClose", alarmClose);
		mav.setViewName("noticeModify");
		return mav;
	}
	
	@RequestMapping(value = "/noticeModifyForm")
	public String NoticeModifyForm(@RequestParam("title") String noticeTitle, @RequestParam("user_id") String user_id, 
			@RequestParam("noticeNumber") int noticeNumber, @RequestParam("content") String noticeContent) {
		userInfoService.modifyNotice(noticeTitle, noticeNumber, noticeContent);
		return "redirect:/noticeView?id=" + user_id;
	}
	/*=========== �������� ���� ȭ�� ============*/
	
	/*=========== �������� ���� ȭ�� ============*/
	@RequestMapping(value = "/noticeDelete")
	public ModelAndView NoticeDelete(@RequestParam("number") int noticeNumber, @RequestParam("id") String user_id) {
		ModelAndView mav = new ModelAndView();
		NoticeInfoVO noticeInfo = userInfoService.getNotice(noticeNumber);
		UserInfoVO userInfo = userInfoService.selectUserPassword(user_id);
		mav.addObject("userInfo", userInfo);
		mav.addObject("noticeInfo", noticeInfo);
		mav.addObject("togetherPeopleTitle", togetherPeopleTitle);
		mav.setViewName("noticeDelete");
		return mav;
	}

	@RequestMapping(value = "/noticeDeleteForm")
	public void NoticeDeleteForm(@RequestParam("noticeNumber") int noticeNumber, @RequestParam("user_id") String user_id) {
		userInfoService.deleteNotice(noticeNumber);
	}
	/*=========== �������� ���� ȭ�� ============*/
	
	/*=========== �Խ��� ȭ�� ============*/
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
	/*=========== �Խ��� ȭ�� ============*/
	
	/*=========== �Խ��� ��� ȭ�� ============*/
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
	/*=========== �Խ��� ��� ȭ�� ============*/
	
	/*=========== �Խñ� ���� ȭ�� ============*/
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
	/*=========== �Խñ� ���� ȭ�� ============*/
	
	/*=========== �Խñ� ���� ============*/
	@RequestMapping(value = "/boardJoin")
	public String BoardJoin(@RequestParam("number") int boardNumber, @RequestParam("id") String user_id) {
		BoardInfoVO boardInfo = userInfoService.getboard(boardNumber);
		UserInfoVO userInfo = userInfoService.selectUserPassword(user_id);
		userInfoService.sendBoardJoin(boardInfo, userInfo);
		userInfoService.addAlarmBoard(boardInfo, userInfo);
		return "redirect:/boardOpen?number=" + boardNumber + "&id=" + user_id;
	}
	/*=========== �Խñ� ���� ============*/

	/*=========== �Խñ� ���� ��� ============*/
	@RequestMapping(value = "/boardJoinCancel")
	public String BoardJoinCancel(@RequestParam("number") int boardNumber, @RequestParam("id") String user_id) {
		BoardJoinUserInfoVO boardJoinUserInfo = userInfoService.getBoardJoinUser(boardNumber, user_id);
		userInfoService.sendCancelBoardJoin(boardJoinUserInfo);
		return "redirect:/boardOpen?number=" + boardNumber + "&id=" + user_id;
	}
	/*=========== �Խñ� ���� ��� ============*/
	
	/*=========== �Խñ� ������ ���� ���� ============*/
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
	/*=========== �Խñ� ������ ���� ����============*/
	
	/*=========== �Խñ� ������ ���� ============*/
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
	/*=========== �Խñ� ������ ���� ============*/
		
	/*=========== �Խñ� ������ ���� ============*/
	@RequestMapping(value = "/failJoinUser")
	public String FailJoinUser(@RequestParam("user_id") String user_id, @RequestParam("boardJoinUser_id") String boardJoinUser_id,
			@RequestParam("number") int boardNumber) {
		BoardJoinUserInfoVO boardJoinUserInfo = userInfoService.getBoardJoinUser(boardNumber, boardJoinUser_id);
		userInfoService.deleteBoardJoinUserInfo(boardJoinUserInfo);
		userInfoService.addAlarmBoardJoinFail(user_id, boardJoinUserInfo, boardNumber);
		return "redirect:/boardJoinUserList?number=" + boardNumber + "&id=" + user_id;
	}
	/*=========== �Խñ� ������ ���� ============*/
	
	/*=========== �Խñ� ���� ============*/
	//�Խñ� ������ ����
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
	/*=========== �Խñ� ���� ============*/
	
	/*=========== �Խñ� ���� ============*/
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
	/*=========== �Խñ� ���� ============*/
	
	/*=========== �Խñ� �з� ============*/
	@RequestMapping(value = "/allBoard")
	public String AllBoard(@RequestParam("id") String user_id) {
		return "redirect:/boardView?id=" + user_id;
	}
	/*=========== �Խñ� �з� ============*/
	
	/*=========== ä��â ============*/
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
	/*=========== ä��â ============*/
	
	/*=========== ä��â���� ���� ��============*/
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
	/*=========== ä��â ���� ��============*/
	
	/*=========== ä��â ȸ�� ����============*/
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
	/*=========== ä��â ȸ�� ����============*/
	
	/*=========== �Խñ� ���ã��============*/
	@RequestMapping(value = "/favoriteBoard")
	public String FavoriteBoard(@RequestParam("id") String user_id, @RequestParam("number") int boardNumber) {
		userInfoService.addFavoriteBoard(user_id, boardNumber);
		return "redirect:/boardOpen?number=" + boardNumber + "&id=" + user_id;
	}
	/*=========== �Խñ� ���ã��============*/
	
	/*=========== �Խñ� ���ã�� ���============*/
	@RequestMapping(value = "/favoriteBoardCancel")
	public String FavoriteBoardCancel(@RequestParam("id") String user_id, @RequestParam("number") int boardNumber) {
		userInfoService.modifyFavoriteBoard(user_id, boardNumber);
		return "redirect:/boardOpen?number=" + boardNumber + "&id=" + user_id;
	}
	/*=========== �Խñ� ���ã�� ���============*/

	/*=========== ���� ������ ���� ============*/
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
	/*=========== ���� ������ ���� ============*/
	
	/*=========== ���� ������ ȸ�� ���� ���� ============*/
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
		if(user_passwordQuestion.equals("����")) {
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
	/*=========== ���� ������ ȸ�� ���� ���� ============*/
	
	/*=========== ���������� ���ã�� ��� ============*/
	@RequestMapping(value = "/mypageFavoriteCancel")
	public String MypageFavoriteCancel(@RequestParam("id") String user_id, @RequestParam("number") int boardNumber) {
		userInfoService.modifyFavoriteBoard(user_id, boardNumber);
		return "redirect:/mypageView?id=" + user_id;
	}
	/*=========== ���������� ���ã�� ��� ============*/

	/*=========== ���������� ������ ���� ============*/
	@RequestMapping(value = "/mypageDeletePosting")
	public String MypageDeletePosting(@RequestParam("user_id") String user_id, @RequestParam("check") List<String> postingNumber) {
		if(!postingNumber.get(0).equals("empty")) {
			userInfoService.deletePosting(user_id, Integer.parseInt(postingNumber.get(0)));			
		}
		return "redirect:/mypageView?id=" + user_id;
	}
	/*=========== ���������� ������ ���� ============*/
	
	/*=========== ���������� �� �Խñ� ���� ============*/
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
	/*=========== ���������� �� �Խñ� ���� ============*/

	/*=========== ���������� �� �Խñ� ���� ============*/
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
	/*=========== ���������� �� �Խñ� ���� ============*/
	
	/*=========== ȸ��Ż�� ============*/
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
	/*=========== ȸ��Ż�� ============*/
	
	/*=========== ���ǻ��� ============*/
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
	/*=========== ���ǻ��� ============*/

	/*=========== ���ǻ��� ��� ============*/
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
	/*=========== ���ǻ��� ��� ============*/
	
	/*=========== ���ǻ��� ���� ============*/
	@RequestMapping(value = "/qnaDelete")
	public String QnaDelete(@RequestParam("id") String user_id, @RequestParam("number") int qnaNumber) {
		userInfoService.deleteQna(qnaNumber);
		return "redirect:/qnaView?id=" + user_id;
	}
	/*=========== ���ǻ��� ���� ============*/
	
	/*=========== ���ǻ��� ���� ============*/
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
	/*=========== ���ǻ��� ���� ============*/
	
	/*=========== ���ǻ��� ���� ============*/
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
	/*=========== ���ǻ��� ���� ============*/

	/*=========== ������ ������ ���� ============*/
	@RequestMapping(value = "/adminDeletePosting")
	public String AdminDeletePosting(@RequestParam("id") String user_id, @RequestParam("number") int postingNumber) {
		userInfoService.adminDeletePosting(postingNumber);
		return "redirect:/mainView?id=" + user_id;
	}
	/*=========== ������ ������ ���� ============*/
	
	/*=========== ������ �Խñ� �˻�/���� ============*/
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
	/*=========== ������ �Խñ� �˻�/���� ============*/
	
	/*=========== ���� ============*/
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
	/*=========== ���� ============*/

	/*=========== ȸ�� �߹� ============*/
	@RequestMapping(value = "/adminUserExile")
	public String AdminUserExile(@RequestParam("check") List<String> user_idList) {
		if(user_idList.size() == 1) {
		} else {
			userInfoService.userSecession(user_idList.get(1));
		}
		return "redirect:/managementView";
	}
	/*=========== ȸ�� �߹� ============*/

	/*=========== ������ ���ǻ��� ���� ============*/
	@RequestMapping(value = "/adminQnaDelete")
	public String AdminQnaDelete(@RequestParam("check") List<String> qnaNumberList) {
		if(qnaNumberList.size() == 1) {
		} else {
			userInfoService.deleteQna(Integer.parseInt(qnaNumberList.get(1)));
		}
		return "redirect:/managementView";
	}
	/*=========== ������ ���ǻ��� ���� ============*/
	
	/*=========== ������ ���ǻ��� ���� ============*/
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
	/*=========== ������ ���ǻ��� ���� ============*/
	
	/*=========== ������ ���ǻ��� �亯 �ޱ� ============*/
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
	/*=========== ������ ���ǻ��� �亯 �ޱ� ============*/
	
	/*=========== �Խñ� ȸ�� �߹� ============*/
	@RequestMapping(value = "/userBoardOut")
	public String UserBoardOut(@RequestParam("id") String user_id, @RequestParam("boardJoinUser_id") String boardJoinUser_id,
			@RequestParam("number") int boardNumber) {
		BoardJoinUserInfoVO boardJoinUserInfo = userInfoService.getBoardJoinUser(boardNumber, boardJoinUser_id);
		userInfoService.userBoardOut(boardJoinUser_id, boardNumber);
		userInfoService.boardJoinUserNumberDown(boardNumber);
		userInfoService.addAlarmBoardOut(user_id, boardJoinUserInfo, boardNumber);
		return "redirect:/chatProfile?id=" + user_id + "&number=" + boardNumber;
	}
	/*=========== �Խñ� ȸ�� �߹� ============*/
}