package jung.spring.controller;

import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.commons.net.ftp.FTPSClient;
import org.json.simple.JSONObject;
import net.sf.json.*;

import java.util.HashMap;
import java.util.Iterator;
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
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import jung.spring.dao.UserInfoDAOImpl;
import jung.spring.svc.UserInfoService;
import jung.spring.vo.BoardSympathyInfoVO;
import jung.spring.vo.BoardCommentInfoVO;
import jung.spring.vo.BoardInfoVO;
import jung.spring.vo.ChatInfoVO;
import jung.spring.vo.JoinBoardInfoVO;
import jung.spring.vo.JoinBoard_JoinUserInfoVO;
import jung.spring.vo.PopupChatInfoVO;
import jung.spring.vo.PostingInfoVO;
import jung.spring.vo.UserInfoVO;

@Controller
@SessionAttributes("user")
public class MybatisController {

	@Autowired
	private UserInfoService userInfoService;

	/* =========== session ============ */
	public String httpServletRequest(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		String name = (String) session.getAttribute("ssVar");
		session.setAttribute("ssVar", name);

		return name;
	}

	public void httpServletRequest(HttpServletRequest request, String user_id) throws Exception {
		HttpSession session = request.getSession();
		String name = user_id;
		session.setAttribute("ssVar", name);
	}

	public void httpServletRequestOut(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		session.invalidate();
	}
	/* =========== session ============ */

	/* =========== �⺻ ȭ�� ============ */
	@RequestMapping(value = "/")
	public ModelAndView home(HttpServletRequest request) throws Exception {

		String name = httpServletRequest(request);

		ModelAndView mav = new ModelAndView();
		List<UserInfoVO> userList = userInfoService.getMembers();
		mav.addObject("userList", userList);
		List<PostingInfoVO> postingList = userInfoService.getPostings();
		mav.addObject("postingList", postingList);

		if (name != null) {
			UserInfoVO userInfo = userInfoService.getUser(name);
			mav.addObject("userInfo", userInfo);
		}

		mav.setViewName("Tp_firstView");
		return mav;
	}

	@RequestMapping(value = "/firstView")
	public ModelAndView first(HttpServletRequest request) throws Exception {

		String name = httpServletRequest(request);

		ModelAndView mav = new ModelAndView();
		List<UserInfoVO> userList = userInfoService.getMembers();
		mav.addObject("userList", userList);
		List<PostingInfoVO> postingList = userInfoService.getPostings();
		mav.addObject("postingList", postingList);

		if (name != null) {
			UserInfoVO userInfo = userInfoService.getUser(name);
			mav.addObject("userInfo", userInfo);
		}

		mav.setViewName("Tp_firstView");
		return mav;
	}
	/* =========== �⺻ ȭ�� ============ */

	/* =========== �α��� ȭ�� ============ */
	@RequestMapping("/loginView")
	public ModelAndView login() {

		ModelAndView mav = new ModelAndView();
		List<UserInfoVO> userList = userInfoService.getMembers();
		mav.addObject("userList", userList);
		mav.setViewName("Tp_loginView");
		return mav;
	}

	@RequestMapping("/user_login")
	public ModelAndView main(HttpServletRequest request, @RequestParam("user_id") String user_id,
			@RequestParam("user_password") String user_password) throws Exception {

		httpServletRequest(request, user_id);

		ModelAndView mav = new ModelAndView();
		List<UserInfoVO> userList = userInfoService.getMembers();
		mav.addObject("userList", userList);
		List<PostingInfoVO> postingList = userInfoService.getPostings();
		mav.addObject("postingList", postingList);
		UserInfoVO userInfo = userInfoService.getUser(user_id);
		mav.addObject("userInfo", userInfo);
		mav.setViewName("Tp_firstView");
		return mav;
	}
	/* =========== �α��� ȭ�� ============ */

	/* =========== �α׾ƿ� ============ */
	@RequestMapping("/user_loginOut")
	public ModelAndView loginOut(HttpServletRequest request) throws Exception {

		httpServletRequestOut(request);

		ModelAndView mav = new ModelAndView();
		List<UserInfoVO> userList = userInfoService.getMembers();
		mav.addObject("userList", userList);
		List<PostingInfoVO> postingList = userInfoService.getPostings();
		mav.addObject("postingList", postingList);

		mav.setViewName("Tp_firstView");
		return mav;
	}
	/* =========== �α׾ƿ� ============ */

	/* =========== ȸ������ ȭ�� ============ */
	@RequestMapping(value = "/userRegist")
	public ModelAndView userRegist() {

		ModelAndView mav = new ModelAndView();
		List<UserInfoVO> userList = userInfoService.getMembers();
		mav.addObject("userList", userList);
		mav.setViewName("Tp_userRegist");
		return mav;
	}

	@RequestMapping(value = "/user_info_regist")
	public ModelAndView userRegistForm(@RequestParam("user_id") String user_id,
			@RequestParam("user_password") String user_password,
			@RequestParam("sample4_postcode") String sample4_postcode,
			@RequestParam("sample4_roadAddress") String sample4_roadAddress,
			@RequestParam("sample4_jibunAddress") String sample4_jibunAddress,
			@RequestParam("sample4_detailAddress") String sample4_detailAddress,
			@RequestParam("user_name") String user_name, @RequestParam("user_gender") String user_gender,
			@RequestParam("user_birthday_year") String user_birthday_year,
			@RequestParam("user_birthday_month") String user_birthday_month,
			@RequestParam("user_birthday_day") String user_birthday_day, @RequestParam("user_email") String user_email,
			@RequestParam("user_phone") String user_phone) {
		ModelAndView mav = new ModelAndView();
		HashMap<Object, Object> map = new HashMap<Object, Object>();
		map.put("user_id", user_id);
		map.put("user_password", user_password);
		map.put("user_postCode", sample4_postcode);
		map.put("user_roadAddress", sample4_roadAddress);
		map.put("user_jibunAddress", sample4_jibunAddress);
		map.put("user_detailAddress", sample4_detailAddress);
		map.put("user_name", user_name);
		map.put("user_gender", user_gender);
		map.put("user_birthday_year", user_birthday_year);
		map.put("user_birthday_month", user_birthday_month);
		map.put("user_birthday_day", user_birthday_day);
		map.put("user_email", user_email);
		map.put("user_phone", user_phone);
		map.put("user_date", new Date());
		map.put("user_picture", "");
		map.put("user_information", "");
		userInfoService.addUserInfo(map);
		userInfoService.addUserPopup(user_id);
		mav.addObject("user_name", user_name);
		
		List<UserInfoVO> userList = userInfoService.getMembers();
		List<PostingInfoVO> postingList = userInfoService.getPostings();
		mav.addObject("userList", userList);
		mav.addObject("postingList", postingList);
		mav.setViewName("Tp_firstView");
		return mav;
	}
	/* =========== ȸ������ ȭ�� ============ */

	/* =========== ���̵� ã�� ȭ�� ============ */
	@RequestMapping(value = "/findID")
	public ModelAndView FindId() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("Tp_findID");
		return mav;
	}

	@RequestMapping(value = "/find_user_id")
	public ModelAndView FindIDResult(@RequestParam("user_name") String user_name,
			@RequestParam("user_phone") int user_phone) {
		ModelAndView mav = new ModelAndView();
		boolean idCheck = userInfoService.checkUserEmail(user_name, user_phone);
		if (idCheck) {
			UserInfoVO userInfo = userInfoService.selectUserId(user_name, user_phone);
			mav.addObject("userInfo", userInfo);
			mav.setViewName("Tp_findIDResult");
		} else {
			mav.setViewName("Tp_findIDFailResult");
		}
		return mav;
	}
	/* =========== ���̵� ã�� ȭ�� ============ */

	/* =========== ��й�ȣ ã�� ȭ�� ============ */
	@RequestMapping(value = "/findPassword")
	public ModelAndView FindPassword() {
		ModelAndView mav = new ModelAndView();
		List<UserInfoVO> userList = userInfoService.getMembers();
		mav.addObject("userList", userList);
		mav.setViewName("Tp_findPassword");
		return mav;
	}

	@RequestMapping(value = "/find_user_password")
	public ModelAndView FindPasswordResult(@RequestParam("user_id") String user_id,
			@RequestParam("user_name") String user_name, @RequestParam("user_phone") int user_phone) {
		ModelAndView mav = new ModelAndView();
		boolean pwCheck = userInfoService.selectUserPassword(user_id, user_name, user_phone);
		mav.addObject("user_id", user_id);
		if (pwCheck) {
			mav.setViewName("Tp_modifyPassword");
		} else {
			mav.setViewName("Tp_findPassword");
		}
		return mav;
	}

	@RequestMapping(value = "/modify_user_password")
	public ModelAndView ModifyPassword(@RequestParam("user_id") String user_id,
			@RequestParam("user_password") String user_password) {
		ModelAndView mav = new ModelAndView();
		userInfoService.modifyUserPassword(user_password, user_id);
		mav.addObject("user_id", user_id);
		mav.setViewName("Tp_findPasswordResult");
		return mav;
	}
	/* =========== ��й�ȣ ã�� ȭ�� ============ */

	/* =========== ������ ��� ȭ�� ============ */
	@RequestMapping(value = "/user_posting_regist")
	public ModelAndView UserPostingRegist(@RequestParam("ct_ti") String content_title,
			@RequestParam("ct_ct") String content_content, @RequestParam("ct_pt") File content_picture,
			@RequestParam("user_posting_id") String user_id, HttpServletRequest request)
			throws Exception, SocketException, IOException {

		String name = httpServletRequest(request);

		ModelAndView mav = new ModelAndView();
		UserInfoVO userInfo = userInfoService.getUser(user_id);
		userInfoService.addPosting(content_title, content_content, content_picture, userInfo);
		String postingNumber = userInfoService.getLastPostingNumber();

		if (name != null) {
			mav.addObject("userInfo", userInfo);
		}

		FTPSClient ftps = null;
		try {
			ftps = new FTPSClient("TLS", false);
			ftps.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out)));
			ftps.connect("192.168.1.178", 2121);
			int reply = 0;
			reply = ftps.getReplyCode();
			if (!FTPReply.isPositiveCompletion(reply)) {
				ftps.disconnect();
			} else {
				Date from = new Date();
				// ���ݽð�
				// SimpleDateFormat nowDateHHmmss = new SimpleDateFormat ("HHmmss");
				SimpleDateFormat nowDateymd = new SimpleDateFormat("yyyyMMdd");

				// String nowHHmmss = nowDateHHmmss.format(from);
				String nowymd = nowDateymd.format(from);

				// �α���
				ftps.login("sjsnrndi12", "tkfkd465!@");
				showServerReply(ftps);

				// ������ ����
				ftps.execPBSZ(0);
				ftps.execPROT("P");

				// ftp ���͸� ����
				ftps.makeDirectory("/user_posting_pictures/" + nowymd);
				showServerReply(ftps);

				ftps.makeDirectory("/user_posting_pictures/" + nowymd + "/" + postingNumber);// nowHHmmss
				showServerReply(ftps);

				// ftp ���͸� ����
				ftps.changeWorkingDirectory("/user_posting_pictures/" + nowymd + "/" + postingNumber);// nowHHmmss
				showServerReply(ftps);

				// Active Mode -> PassiveMode�� ����
				ftps.enterLocalPassiveMode();
				showServerReply(ftps);

				FileInputStream fis = null;
				fis = new FileInputStream(content_picture);
				showServerReply(ftps);

				ftps.setFileType(FTP.BINARY_FILE_TYPE);
				showServerReply(ftps);

				ftps.setFileTransferMode(FTP.STREAM_TRANSFER_MODE);
				showServerReply(ftps);

				// ftps�� ���� ���ε�
				boolean isSuccess = ftps.storeFile(content_picture.getName(), fis);
				showServerReply(ftps);

				// ���ε� ���� ��
				if (isSuccess) {
					System.out.println("���ε� ����");
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (SocketException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ftps.isConnected()) {
					ftps.logout();
					ftps.disconnect();
				}
			} catch (IOException ex) {
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
		if (replies != null && replies.length > 0) {
			for (String aReply : replies) {
				System.out.println("SERVER: " + aReply);
			}
		}
	}
	/* =========== ������ ��� ȭ�� ============ */

	/* ����, ����, ��õ, ��� */

	/* =========== �Ұ�(CEO) ȭ�� ============ */
	@RequestMapping(value = "/noticeView")
	public ModelAndView NoticeView(HttpServletRequest request) throws Exception {
		String name = httpServletRequest(request);
		ModelAndView mav = new ModelAndView();
		if (name != null) {
			UserInfoVO userInfo = userInfoService.getUser(name);
			mav.addObject("userInfo", userInfo);
		}
		mav.setViewName("Tp_noticeView");
		return mav;
	}
	/* =========== �Ұ�(CEO) ȭ�� ============ */

	/* =========== ���ô� �� ȭ�� ============ */
	@RequestMapping(value = "/noticeAccessView")
	public ModelAndView NoticeAccessView(HttpServletRequest request) throws Exception {
		String name = httpServletRequest(request);
		ModelAndView mav = new ModelAndView();
		if (name != null) {
			UserInfoVO userInfo = userInfoService.getUser(name);
			mav.addObject("userInfo", userInfo);
		}
		mav.setViewName("Tp_noticeAccessView");
		return mav;
	}
	/* =========== ���ô� �� ȭ�� ============ */

	/* =========== �̿��� ȭ�� ============ */
	@RequestMapping(value = "/userTpView")
	public ModelAndView UserTpView(HttpServletRequest request) throws Exception {
		String name = httpServletRequest(request);
		ModelAndView mav = new ModelAndView();
		if (name != null) {
			UserInfoVO userInfo = userInfoService.getUser(name);
			mav.addObject("userInfo", userInfo);
		}
		mav.setViewName("Tp_userTpView");
		return mav;
	}
	/* =========== �̿��� ȭ�� ============ */

	/* =========== ȸ������ �� �α��� ���̵� ȭ�� ============ */
	@RequestMapping(value = "/userRegistAndLogin")
	public ModelAndView UserRistAndLogin(HttpServletRequest request) throws Exception {
		String name = httpServletRequest(request);
		ModelAndView mav = new ModelAndView();
		if (name != null) {
			UserInfoVO userInfo = userInfoService.getUser(name);
			mav.addObject("userInfo", userInfo);
		}
		mav.setViewName("Tp_userRegistAndLogin");
		return mav;
	}
	/* =========== ȸ������ �� �α��� ȭ�� ============ */

	/* =========== �˾� â ���� ȭ�� ============ */
	@RequestMapping(value = "/popup")
	public ModelAndView Popup(HttpServletRequest request) throws Exception {

		String name = httpServletRequest(request);

		ModelAndView mav = new ModelAndView();
		int popupNumber = userInfoService.getPopupNumber(name);
		List<PopupChatInfoVO> popupChatList = userInfoService.getPopupChats(popupNumber);
		mav.addObject("user_id", name);
		mav.addObject("popupChatList", popupChatList);
		if (name != null) {
			UserInfoVO userInfo = userInfoService.getUser(name);
			mav.addObject("userInfo", userInfo);
		}
		ArrayList<Object> yMd_list = new ArrayList<Object>();
		ArrayList<Object> yMd_list_Result = new ArrayList<Object>();
		for (int i = 0; i < popupChatList.size(); i++) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			yMd_list.add(sdf.format(popupChatList.get(i).getChat_date()));
			if (yMd_list.size() > 1) {
				if (yMd_list.get(i - 1).equals(yMd_list.get(i))) {
					yMd_list_Result.add("noDate");
				} else {
					yMd_list_Result.add(sdf.format(popupChatList.get(i).getChat_date()));
				}
			} else {
				yMd_list_Result.add(sdf.format(popupChatList.get(i).getChat_date()));
			}
		}

		HashMap<Object, ArrayList<Object>> yMd_listMap = new HashMap<Object, ArrayList<Object>>();
		yMd_listMap.put("yMdDate", yMd_list);

		HashMap<Object, ArrayList<Object>> yMd_list_ResultMap = new HashMap<Object, ArrayList<Object>>();
		yMd_list_ResultMap.put("yMd_Result_Date", yMd_list_Result);

		mav.addObject("yMd_listMap", yMd_listMap);
		mav.addObject("yMd_list_ResultMap", yMd_list_ResultMap);

		mav.setViewName("Tp_popup");
		return mav;
	}
	/* =========== �˾� â ���� ȭ�� ============ */

	/* =========== �˾� â ���� ����� �Է� ============ */
	@RequestMapping(value = "/popup_user_chat_input_form")
	public ModelAndView Popup_user_chat_input_form(@RequestParam("user_chat") String user_chat,
			@RequestParam("user_id") String user_id, HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView();

		String name = httpServletRequest(request);
		if (name != null) {
			UserInfoVO userInfo = userInfoService.getUser(name);
			mav.addObject("userInfo", userInfo);
		}
		int popupNumber = userInfoService.getPopupNumber(user_id);
		userInfoService.addPopupUserChat(user_id, popupNumber, user_chat);
		List<PopupChatInfoVO> popupChatList = userInfoService.getPopupChats(popupNumber);
		mav.addObject("user_id", user_id);
		mav.addObject("popupChatList", popupChatList);
		mav.setViewName("redirect:/popup");
		return mav;
	}
	/* =========== �˾� â ���� ����� �Է� ============ */

	/* =========== Ŀ�´�Ƽ ȭ�� =========== */
	@RequestMapping(value = "/communityView")
	public ModelAndView CommunityView(HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView();

		String name = httpServletRequest(request);
		if (name != null) {
			UserInfoVO userInfo = userInfoService.getUser(name);
			mav.addObject("userInfo", userInfo);
		}
		
		List<BoardInfoVO> boardList = userInfoService.getBoards();
		mav.addObject("page_check_Number", 1);
		mav.addObject("pageNumber", 0);
		mav.addObject("boardList", boardList);
		mav.setViewName("Tp_communityView");
		return mav;
	}
	/* =========== Ŀ�´�Ƽ ȭ�� =========== */

	/* =========== Ŀ�´�Ƽ �Խñ� ���� =========== */
		@RequestMapping(value = "/communityCreateBoard")
		public ModelAndView CommunityCreateBoard(HttpServletRequest request) throws Exception {
			ModelAndView mav = new ModelAndView();
			
			String name = httpServletRequest(request);
			if (name != null) {
				UserInfoVO userInfo = userInfoService.getUser(name);
				mav.addObject("userInfo", userInfo);
			}
			mav.setViewName("Tp_communityCreateBoard");
			return mav;
		}
		
		@RequestMapping(value = "/commu_create_board_submit")
		public ModelAndView Commu_create_board_submit(HttpServletRequest request, @RequestParam("title") String title, 
				@RequestParam("content") String content, @RequestParam("subject") String subject) throws Exception {
			ModelAndView mav = new ModelAndView();
			
			String name = httpServletRequest(request);
			if (name != null) {
				UserInfoVO userInfo = userInfoService.getUser(name);
				mav.addObject("userInfo", userInfo);
			}
			
			userInfoService.addBoard(name, title, content, subject);
			List<BoardInfoVO> boardList = userInfoService.getBoards();
			
			mav.addObject("boardList", boardList);
			mav.setViewName("Tp_communityView");
			return mav;
		}
	
	/* =========== Ŀ�´�Ƽ �Խñ� ���� =========== */
	
	/* =========== Ŀ�´�Ƽ �Խñ� ȭ�� =========== */
	@RequestMapping(value = "/communityContentView")
	public ModelAndView CommunityContentView(HttpServletRequest request, @RequestParam("boardNumber") int boardNumber) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		String name = httpServletRequest(request);
		if (name != null) {
			UserInfoVO userInfo = userInfoService.getUser(name);
			mav.addObject("userInfo", userInfo);
			BoardSympathyInfoVO boardSympathyInfo = userInfoService.getBoardSympathy(boardNumber, name);
			
			if(boardSympathyInfo == null) {
				userInfoService.addBoardSympathy(boardNumber, name);
				BoardSympathyInfoVO boardSympathyInfo_result = userInfoService.getBoardSympathy(boardNumber, name);
				mav.addObject("boardSympathy", boardSympathyInfo_result.getBoardSympathy());
			} else {
				mav.addObject("boardSympathy", boardSympathyInfo.getBoardSympathy());
			}
		}
		
		List<BoardCommentInfoVO> boardComments = userInfoService.getBoardComments(boardNumber);
		mav.addObject("boardCommentList", boardComments);
		
		BoardInfoVO boardInfo = userInfoService.getBoard(boardNumber);
		String boardContent = boardInfo.getBoardContent().replace("\r\n", "<br>");
		mav.addObject("boardContent", boardContent);
		mav.addObject("boardInfo", boardInfo);
		mav.setViewName("Tp_communityContentView");
		return mav;
	}
	/* =========== Ŀ�´�Ƽ �Խñ� ȭ�� =========== */
	
	/* =========== Ŀ�´�Ƽ �Խñ� ���� =========== */
	@ResponseBody
	@RequestMapping(value = "sympathy_count", method = RequestMethod.POST)
	public void memberRegi(int boardNumber, int sym_count, HttpServletRequest request) throws Exception {
		// sym_count = 0   =>   ���� ���� ��   / sym_count = 1  =>  ���� Ǭ ��
		String name = httpServletRequest(request);
		userInfoService.updateBoardSympathy(boardNumber, name, sym_count);
	}
	/* =========== Ŀ�´�Ƽ �Խñ� ���� =========== */
	
	/* =========== Ŀ�´�Ƽ �Խñ� ��� =========== */
	@ResponseBody
	@RequestMapping(value = "comment_insert", method = RequestMethod.POST)
	public void Comment_Insert(HttpServletRequest request, String comment, int boardNumber) throws Exception {
		
		String name = httpServletRequest(request);
		if (name != null) {
			UserInfoVO userInfo = userInfoService.getUser(name);
			String userName = userInfo.getUser_name();
			userInfoService.addBoardComment(boardNumber, name, comment, userName);
		}

	}
	
	@ResponseBody
	@RequestMapping(value = "comment_delete", method = RequestMethod.POST)
	public void Comment_Delete(int boardCommentNumber) {
		
		userInfoService.deleteBoardComment(boardCommentNumber);
		
	}
	/* =========== Ŀ�´�Ƽ �Խñ� ��� =========== */

	/* =========== Ŀ�´�Ƽ �Խñ� ���� =========== */
	@RequestMapping(value = "/communityView_sort")
	public ModelAndView CommunityView_sort(HttpServletRequest request, @RequestParam("subject") String subject, @RequestParam("pageNumber") int pageNumber) throws Exception {
		ModelAndView mav = new ModelAndView();
		String name = httpServletRequest(request);
		if (name != null) {
			UserInfoVO userInfo = userInfoService.getUser(name);
			mav.addObject("userInfo", userInfo);
		}
		String move = "default";
		List<BoardInfoVO> boardList = userInfoService.getBoardSort(subject, move);
		int page = (pageNumber * 10) - 10;
		mav.addObject("pageNumber", page);
		mav.addObject("page_check_Number", pageNumber);
		mav.addObject("subject", subject);
		mav.addObject("boardList", boardList);
		mav.setViewName("Tp_communityView");
		return mav;
	}
	/* =========== Ŀ�´�Ƽ �Խñ� ���� =========== */
	
	/* =========== Ŀ�´�Ƽ ������ �̵� =========== */
	@RequestMapping(value = "/page_move")
	public ModelAndView Page_Move(HttpServletRequest request, @RequestParam("pageNumber") int pageNumber, @RequestParam("subject") String subject) throws Exception {
		ModelAndView mav = new ModelAndView();

		String name = httpServletRequest(request);
		if (name != null) {
			UserInfoVO userInfo = userInfoService.getUser(name);
			mav.addObject("userInfo", userInfo);
		}
		String move = "default";
		List<BoardInfoVO> boardList = userInfoService.getBoardSort(subject, move);
		int page = (pageNumber * 10) - 10;
		mav.addObject("page_check_Number", pageNumber);
		mav.addObject("subject", subject);
		mav.addObject("pageNumber", page);
		mav.addObject("boardList", boardList);
		mav.setViewName("Tp_communityView");
		return mav;
	}
	
	@RequestMapping(value = "/page_move_left_right")
	public ModelAndView Page_Move_Left_Right(HttpServletRequest request, @RequestParam("pageNumber") int pageNumber, @RequestParam("move") String move,
			@RequestParam("subject") String subject) throws Exception {
		ModelAndView mav = new ModelAndView();
		String name = httpServletRequest(request);
		if (name != null) {
			UserInfoVO userInfo = userInfoService.getUser(name);
			mav.addObject("userInfo", userInfo);
		}
		List<BoardInfoVO> boardList = userInfoService.getBoardSort(subject, move);
		int page = 0;
		if(move.equals("left")) {
			page = (pageNumber * 10) - 20;
			if(page < 0) {
				page = 0;
				pageNumber = 1;
				mav.addObject("page_check_Number", 1);
			} else {
				pageNumber -= 1;
				mav.addObject("page_check_Number", pageNumber);
			}
		} else if(move.equals("right")) {
			page = ((pageNumber + 1) * 10) - 10;
			if(boardList.size()/10 < page/10) { //   1 < 2
				page -= 10;
				mav.addObject("page_check_Number", pageNumber);
			} else {
				pageNumber += 1;
				mav.addObject("page_check_Number", pageNumber);
			}
		}
		mav.addObject("subject", subject);
		mav.addObject("pageNumber", page);
		mav.addObject("boardList", boardList);
		mav.setViewName("Tp_communityView");
		return mav;
	}
	/* =========== Ŀ�´�Ƽ ������ �̵� =========== */
	
	/* =========== Ŀ�´�Ƽ �����Խ��� �̵� =========== */
	
	public List<String> subjects_gether() {
		String[] subjects = {"�/������", "�ι���/å/��", "�ܱ�/���", "��ȭ/����/����", "����/�Ǳ�", "����/�����", "��/����",
				"����Ȱ��", "��ü����", "��/�������", "����/����", "�߱�����", "����/����", "�丮/����", "�ݷ�����", "�米/�θ�"};
		List<String> subjectList = new ArrayList<String>();
		for (int i = 0; i < subjects.length; i++) {
			subjectList.add(subjects[i]);
		}
		return subjectList;		
	}
	@RequestMapping(value = "/joinView")
	public ModelAndView JoinView(HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView();

		String name = httpServletRequest(request);
		if (name != null) {
			UserInfoVO userInfo = userInfoService.getUser(name);
			mav.addObject("userInfo", userInfo);
		}
		List<JoinBoardInfoVO> joinBoardList = userInfoService.getJoinBoards();
		mav.addObject("page_check_Number", 1);
		mav.addObject("pageNumber", 0);
		mav.addObject("joinBoardList", joinBoardList);
		mav.addObject("subjectList", subjects_gether());
		mav.setViewName("Tp_joinView");
		return mav;
	}
	/* =========== Ŀ�´�Ƽ �����Խ��� �̵� =========== */
	
	/* =========== Ŀ�´�Ƽ �����Խ��� ���� =========== */
	@RequestMapping(value = "/joinView_sort")
	public ModelAndView JoinView_sort(HttpServletRequest request, @RequestParam("subject") String subject) throws Exception {
		ModelAndView mav = new ModelAndView();
		String name = httpServletRequest(request);
		if (name != null) {
			UserInfoVO userInfo = userInfoService.getUser(name);
			mav.addObject("userInfo", userInfo);
		}
		List<JoinBoardInfoVO> joinBoardSortList = userInfoService.getJoinBoardSorts(subject);
		mav.addObject("subject", subject);
		mav.addObject("joinBoardList", joinBoardSortList);
		mav.addObject("subjectList", subjects_gether());
		mav.setViewName("Tp_joinView");
		return mav;
	}
	/* =========== Ŀ�´�Ƽ �����Խ��� ���� =========== */
	
	/* =========== Ŀ�´�Ƽ �Խñ� ���� =========== */
	@RequestMapping(value = "/joinCreateBoard")
	public ModelAndView JoinCreateBoard(HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		String name = httpServletRequest(request);
		if (name != null) {
			UserInfoVO userInfo = userInfoService.getUser(name);
			mav.addObject("userInfo", userInfo);
		}
		mav.setViewName("Tp_joinCreateBoard");
		return mav;
	}
	
	@RequestMapping(value = "/join_create_board_submit")
	public ModelAndView Join_create_board_submit(HttpServletRequest request, @RequestParam("title") String title, 
			@RequestParam("content") String content, @RequestParam("subject") String subject) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		String name = httpServletRequest(request);
		if (name != null) {
			UserInfoVO userInfo = userInfoService.getUser(name);
			mav.addObject("userInfo", userInfo);
		}
		
		userInfoService.addJoinBoard(name, title, content, subject);
		
		userInfoService.addJoinBoard_joinUser(name);
		List<JoinBoardInfoVO> joinBoardList = userInfoService.getJoinBoards();
		mav.addObject("page_check_Number", 1);
		mav.addObject("pageNumber", 0);
		mav.addObject("subjectList", subjects_gether());
		mav.addObject("joinBoardList", joinBoardList);
		mav.setViewName("Tp_joinView");
		return mav;
	}

	/* =========== Ŀ�´�Ƽ �Խñ� ���� =========== */
	
	/* =========== Ŀ�´�Ƽ �����Խñ� ȭ�� =========== */
	@RequestMapping(value = "/joinContentView")
	public ModelAndView JoinContentView(HttpServletRequest request, @RequestParam("joinBoardNumber") int joinBoardNumber) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		String name = httpServletRequest(request);
		if (name != null) {
			UserInfoVO userInfo = userInfoService.getUser(name);
			mav.addObject("userInfo", userInfo);
		}
		
		JoinBoardInfoVO joinBoardInfo = userInfoService.getJoinBoard(joinBoardNumber);
		List<JoinBoard_JoinUserInfoVO> JoinBoard_JoinUserList = userInfoService.getJoinBoard_joinUsers(joinBoardNumber);
		String joinBoardContent = joinBoardInfo.getJoinBoardContent().replace("\r\n", "<br>");
		String check = "noApplication";
		for (int i = 0; i < JoinBoard_JoinUserList.size(); i++) {
			if(JoinBoard_JoinUserList.get(i).getJoinBoard_userId().equals(name)) {
				if(JoinBoard_JoinUserList.get(i).getVerified() == 1) {
					check = "participation";
				} else {
					check = "wait";
				}
			}
		}
		
		mav.addObject("check", check);
		mav.addObject("joinBoardContent", joinBoardContent);
		mav.addObject("joinBoardInfo", joinBoardInfo);
		mav.addObject("JoinBoard_JoinUserList", JoinBoard_JoinUserList);
		mav.setViewName("Tp_joinContentView");
		return mav;
	}
	/* =========== Ŀ�´�Ƽ �����Խñ� ȭ�� =========== */
	
	/* =========== Ŀ�´�Ƽ �����Խñ� ������û =========== */
	@RequestMapping(value = "/joinBoard_joinUser_regist")
	public ModelAndView JoinBoard_joinUser_regist(HttpServletRequest request, @RequestParam("joinBoardNumber") int joinBoardNumber) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		String name = httpServletRequest(request);
		if (name != null) {
			UserInfoVO userInfo = userInfoService.getUser(name);
			mav.addObject("userInfo", userInfo);
		}
		
		userInfoService.addJoinBoard_joinUser_regist(name, joinBoardNumber);
				
		return JoinContentView(request, joinBoardNumber);
	}
	/* =========== Ŀ�´�Ƽ �����Խñ� ������û =========== */
	
	/* =========== ���������� ȭ�� =========== */
	@RequestMapping(value = "/myPageView")
	public ModelAndView MypageView(HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		String name = httpServletRequest(request);
		UserInfoVO userInfo = userInfoService.getUser(name);
		mav.addObject("userInfo", userInfo);
		int month = 0;
		switch (userInfo.getUser_birthday_month()) {
			case "january": month = 1; break;
			case "february": month = 2; break;
			case "march": month = 3; break;
			case "april": month = 4; break;
			case "may": month = 5; break;
			case "june": month = 6; break;
			case "july": month = 7; break;
			case "augest": month = 8; break;
			case "september": month = 9; break;
			case "october": month = 10; break;
			case "november": month = 11; break;
			case "december": month = 12; break;
		}
		mav.addObject("month", month);
		
		String phoneNumber = Integer.toString(userInfo.getUser_phone());
		mav.addObject("middle_phoneNumber", phoneNumber.substring(2, 6));
		mav.addObject("last_phoneNumber", phoneNumber.substring(6, 10));
		
		mav.setViewName("Tp_mypageView");
		return mav;
	}
	/* =========== ���������� ȭ�� =========== */
	
	/* =========== ���������� �� ���� ���� ȭ�� =========== */
	@RequestMapping(value = "/mypage_information_update")
	public ModelAndView Mypage_information_update(HttpServletRequest request, @RequestParam("user_name") String user_name, @RequestParam("sample4_postcode") String sample4_postcode,
			@RequestParam("user_phone") String user_phone, @RequestParam("sample4_roadAddress") String sample4_roadAddress, @RequestParam("user_email") String user_email,
			  @RequestParam("sample4_jibunAddress") String sample4_jibunAddress, @RequestParam("sample4_detailAddress") String sample4_detailAddress,
			  @RequestParam("user_information") String user_information) throws Exception {
		ModelAndView mav = new ModelAndView();
		String name = httpServletRequest(request);
		UserInfoVO userInfo = userInfoService.getUser(name);
		
		int sample4_postcode_result = 0;
		int user_phone_result = 0;
		if(user_name.equals("")) { user_name = userInfo.getUser_name(); }
		if(sample4_postcode.equals("")) { sample4_postcode_result = userInfo.getUser_postCode(); } else { sample4_postcode_result = Integer.parseInt(sample4_postcode); }
		if(user_phone.equals("")) { user_phone_result = userInfo.getUser_phone(); } else { user_phone_result = Integer.parseInt(user_phone); }
		if(sample4_roadAddress.equals("")) { sample4_roadAddress = userInfo.getUser_roadAddress(); }
		if(user_email.equals("")) { user_email = userInfo.getUser_email(); }
		if(sample4_jibunAddress.equals("")) { sample4_jibunAddress = userInfo.getUser_jibunAddress(); }
		if(sample4_detailAddress.equals("")) { sample4_detailAddress = userInfo.getUser_detailAddress(); }
		if(user_information.equals("")) { user_information = userInfo.getUser_information(); }
		
		HashMap<Object, Object> map = new HashMap<Object, Object>();
		map.put("user_postCode", sample4_postcode_result); map.put("user_roadAddress", sample4_roadAddress); map.put("user_jibunAddress", sample4_jibunAddress);
		map.put("user_detailAddress", sample4_detailAddress); map.put("user_id", name); map.put("user_email", user_email); map.put("user_phone", user_phone_result);
		map.put("user_information", user_information); map.put("user_name", user_name);
		
		userInfoService.updateUserInformation(map);
		
		UserInfoVO userInfo2 = userInfoService.getUser(name);
		mav.addObject("userInfo", userInfo2);
		
		int month = 0;
		switch (userInfo.getUser_birthday_month()) {
			case "january": month = 1; break; case "february": month = 2; break; case "march": month = 3; break; case "april": month = 4; break; case "may": month = 5; break;
			case "june": month = 6; break; case "july": month = 7; break; case "augest": month = 8; break; case "september": month = 9; break; case "october": month = 10; break;
			case "november": month = 11; break; case "december": month = 12; break;
		}
		mav.addObject("month", month);
		
		String phoneNumber = Integer.toString(userInfo.getUser_phone());
		mav.addObject("middle_phoneNumber", phoneNumber.substring(2, 6));
		mav.addObject("last_phoneNumber", phoneNumber.substring(6, 10));
		mav.setViewName("Tp_mypageView");
		return mav;
	}
	/* =========== ���������� �� ���� ���� ȭ�� =========== */
	
	/* =========== ���������� �� ��� ȭ�� =========== */
	@RequestMapping(value = "/mypageCommunityView")
	public ModelAndView MypageCommunityView(HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		String name = httpServletRequest(request);
		UserInfoVO userInfo = userInfoService.getUser(name);
		mav.addObject("userInfo", userInfo);
		
		List<BoardInfoVO> myBoardList = userInfoService.getMyBoards(name);
		
		mav.addObject("myBoardList", myBoardList);
		mav.setViewName("Tp_mypageCommunityView");
		return mav;
	}
	/* =========== ���������� �� ��� ȭ�� =========== */
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/* =========== ���������� ������ ��� ȭ�� =========== */
	@RequestMapping(value = "/mypagePostingView")
	public ModelAndView MypagePostingView(HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		String name = httpServletRequest(request);
		UserInfoVO userInfo = userInfoService.getUser(name);
		mav.addObject("userInfo", userInfo);
		
		mav.setViewName("Tp_mypagePostingView");
		return mav;
	}
	/* =========== ���������� ������ ��� ȭ�� =========== */
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * =========== ä��â ============
	 * 
	 * @RequestMapping(value = "/chat") public ModelAndView Chat(HttpServletResponse
	 * response, @RequestParam("id") String user_id,
	 * 
	 * @RequestParam("number") int boardNumber) { ModelAndView mav = new
	 * ModelAndView(); UserInfoVO userInfo =
	 * userInfoService.selectUserPassword(user_id); BoardInfoVO boardInfo =
	 * userInfoService.getboard(boardNumber); List<ChatInfoVO> chatList =
	 * userInfoService.getChats(boardNumber); boolean chatJoinCheck = true;
	 * userInfoService.chatJoin(boardNumber, user_id, chatJoinCheck);
	 * List<BoardJoinUserInfoVO> boardJoinUserList =
	 * userInfoService.getBoardJoinUsers(); List<AlarmInfoVO> alarmList =
	 * userInfoService.getAlarms(); List<AlarmInfoVO> alarms = new
	 * ArrayList<AlarmInfoVO>(); for (int i = 0; i < alarmList.size(); i++) {
	 * String[] str = alarmList.get(i).getAlarmYouId().split(","); if
	 * (str[0].equals(user_id)) { alarms.add(alarmList.get(i)); } }
	 * mav.addObject("alarms", alarms); mav.addObject("userInfo", userInfo);
	 * mav.addObject("boardInfo", boardInfo); mav.addObject("chatList", chatList);
	 * mav.addObject("boardJoinUserList", boardJoinUserList);
	 * mav.setViewName("chat"); return mav; }
	 * 
	 * @RequestMapping(value = "/chatSave") public String
	 * ChatSave(@RequestParam("user_id") String
	 * user_id, @RequestParam("boardNumber") int boardNumber,
	 * 
	 * @RequestParam("inputMessage") String content) { if (content.equals("")) { }
	 * else { userInfoService.addChat(user_id, boardNumber, content); } return
	 * "redirect:/chat?id=" + user_id + "&number=" + boardNumber; } =========== ä��â
	 * ============
	 * 
	 * =========== ä��â���� ���� ��============
	 * 
	 * @RequestMapping(value = "/chatJoinClose") public ModelAndView
	 * ChatJoinClose(@RequestParam("id") String user_id, @RequestParam("number") int
	 * boardNumber) { ModelAndView mav = new ModelAndView();
	 * List<BoardJoinUserInfoVO> boardJoinUserList =
	 * userInfoService.getBoardJoinUsers(); BoardJoinUserInfoVO boardJoinUserInfo =
	 * userInfoService.getBoardJoinUser(boardNumber, user_id); BoardInfoVO boardInfo
	 * = userInfoService.getboard(boardNumber); UserInfoVO userInfo =
	 * userInfoService.selectUserPassword(user_id);
	 * mav.addObject("boardJoinUserInfo", boardJoinUserInfo);
	 * mav.addObject("boardJoinUserList", boardJoinUserList);
	 * mav.addObject("userInfo", userInfo); mav.addObject("boardInfo", boardInfo);
	 * //String[] favorites = boardInfo.getBoardFavorites().split(",");// c|2 b|2
	 * String favorite = "fail"; for (int i = 0; i < favorites.length; i++) { if
	 * (favorites[i].equals("")) {
	 * 
	 * } else { String[] temp = favorites[i].split("|"); if (user_id.equals(temp[0])
	 * && String.valueOf(boardNumber).equals(temp[2])) { favorite = "success";
	 * break; } else { favorite = "fail"; } } } mav.addObject("favorite", favorite);
	 * boolean chatJoinCheck = false; userInfoService.chatJoin(boardNumber, user_id,
	 * chatJoinCheck); List<AlarmInfoVO> alarmList = userInfoService.getAlarms();
	 * List<AlarmInfoVO> alarms = new ArrayList<AlarmInfoVO>(); for (int i = 0; i <
	 * alarmList.size(); i++) { String[] str =
	 * alarmList.get(i).getAlarmYouId().split(","); if (str[0].equals(user_id)) {
	 * alarms.add(alarmList.get(i)); } } mav.addObject("alarms", alarms);
	 * mav.addObject("togetherPeopleTitle", togetherPeopleTitle);
	 * mav.addObject("togetherPeopleBoard", togetherPeopleBoard);
	 * mav.addObject("togetherPeopleMypage", togetherPeopleMypage);
	 * mav.addObject("togetherPeopleNotice", togetherPeopleNotice);
	 * mav.addObject("togetherPeopleManagement", togetherPeopleManagement);
	 * mav.addObject("alarmClose", alarmClose); mav.setViewName("boardOpen"); return
	 * mav; }
	 * 
	 * @RequestMapping("/chatJoinCloseLoginView") public String
	 * ChatJoinCloseLoginView(@RequestParam("id") String
	 * user_id, @RequestParam("number") int boardNumber) { boolean chatJoinCheck =
	 * false; userInfoService.chatJoin(boardNumber, user_id, chatJoinCheck); return
	 * "redirect:/loginView"; }
	 * 
	 * @RequestMapping(value = "/chatJoinCloseNoticeView") public String
	 * ChatJoinCloseNoticeView(@RequestParam("id") String
	 * user_id, @RequestParam("number") int boardNumber) { boolean chatJoinCheck =
	 * false; userInfoService.chatJoin(boardNumber, user_id, chatJoinCheck); return
	 * "redirect:/noticeView?id" + "user_id"; }
	 * 
	 * @RequestMapping(value = "/chatJoinCloseMypageView") public String
	 * ChatJoinCloseMypageView(@RequestParam("id") String
	 * user_id, @RequestParam("number") int boardNumber) { boolean chatJoinCheck =
	 * false; userInfoService.chatJoin(boardNumber, user_id, chatJoinCheck); return
	 * "redirect:/mypageView?id" + "user_id"; }
	 * 
	 * @RequestMapping(value = "/chatJoinCloseBoardView") public ModelAndView
	 * BoardView(@RequestParam("id") String user_id, @RequestParam("number") int
	 * boardNumber,
	 * 
	 * @RequestParam("subject") String subject) { ModelAndView mav = new
	 * ModelAndView(); if (subject.equals("all")) { List<BoardInfoVO> boardList =
	 * userInfoService.getBoards(); mav.addObject("boardList", boardList); } else {
	 * List<BoardInfoVO> boardList = userInfoService.getBoardOthers(subject);
	 * mav.addObject("boardList", boardList); } UserInfoVO userInfo =
	 * userInfoService.selectUserPassword(user_id); boolean chatJoinCheck = false;
	 * userInfoService.chatJoin(boardNumber, user_id, chatJoinCheck);
	 * List<AlarmInfoVO> alarmList = userInfoService.getAlarms(); List<AlarmInfoVO>
	 * alarms = new ArrayList<AlarmInfoVO>(); for (int i = 0; i < alarmList.size();
	 * i++) { String[] str = alarmList.get(i).getAlarmYouId().split(","); if
	 * (str[0].equals(user_id)) { alarms.add(alarmList.get(i)); } }
	 * mav.addObject("alarms", alarms); mav.addObject("userInfo", userInfo);
	 * mav.addObject("togetherPeopleTitle", togetherPeopleTitle);
	 * mav.addObject("togetherPeopleBoard", togetherPeopleBoard);
	 * mav.addObject("togetherPeopleMypage", togetherPeopleMypage);
	 * mav.addObject("togetherPeopleNotice", togetherPeopleNotice);
	 * mav.addObject("togetherPeopleManagement", togetherPeopleManagement);
	 * mav.addObject("alarmClose", alarmClose); mav.setViewName("boardView"); return
	 * mav; } =========== ä��â ���� ��============
	 * 
	 * =========== ä��â ȸ�� ����============
	 * 
	 * @RequestMapping(value = "/chatProfile") public ModelAndView
	 * Profile(@RequestParam("id") String user_id, @RequestParam("number") int
	 * boardNumber) { ModelAndView mav = new ModelAndView(); UserInfoVO userInfo =
	 * userInfoService.selectUserPassword(user_id); BoardInfoVO boardInfo =
	 * userInfoService.getboard(boardNumber); List<BoardJoinUserInfoVO>
	 * boardJoinUsers = userInfoService.getJoinUsers(boardNumber);
	 * mav.addObject("boardInfo", boardInfo); mav.addObject("userInfo", userInfo);
	 * mav.addObject("boardJoinUsers", boardJoinUsers);
	 * mav.addObject("togetherPeopleTitle", togetherPeopleTitle);
	 * mav.setViewName("chatProfile"); return mav; } =========== ä��â ȸ��
	 * ����============
	 */

}