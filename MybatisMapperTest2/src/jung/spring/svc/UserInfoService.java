package jung.spring.svc;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import jung.spring.vo.BoardChildInfoVO;
import jung.spring.vo.BoardInfoVO;
import jung.spring.vo.PopupChatInfoVO;
import jung.spring.vo.PostingInfoVO;
import jung.spring.vo.UserInfoVO;

public interface UserInfoService {

	/********** 회원정보 **********/
	void addUserInfo(HashMap<Object, Object> map); //회원가입
	List<UserInfoVO> getMembers(); //회원 목록 가져오기
	boolean checkUserEmail(String user_name, int user_phone); //이메일 확인
	UserInfoVO selectUserId(String user_name, int user_phone); //아이디 찾기
	boolean selectUserPassword(String user_id, String user_name, int user_phone); //비밀번호 찾기 확인
	UserInfoVO selectUserPassword(String user_id); //비밀번호 찾기
	void modifyUserPassword(String user_id, String user_password); //비밀번호 변경
	UserInfoVO getUser(String user_id); //아이디에 맞는 회원정보 가져오기
	/********** 회원정보 **********/
	
	/********** 포스팅 **********/
	List<PostingInfoVO> getPostings(); //포스팅 목록 가져오기
	void addPosting(String content_title, String content_content, File content_picture, UserInfoVO userInfo); //포스팅 등록
	String getLastPostingNumber(); //포스팅 마지막번호 가져오기
	void deletePostingFail(String postingNumber); //등록 실패지 포스팅 삭제
	/********** 포스팅 **********/
	
	/********** 팝업창 **********/
	void addUserPopup(String user_id); // 사용자 별 팝업 창 생성
	int getPopupNumber(String user_id); // 사용자에 맞는 톡 번호 가져오기
	List<PopupChatInfoVO> getPopupChats(int popupNumber); // 사용자 팝업 채팅 내용 가져오기
	void addPopupUserChat(String user_id, int popupNumber, String user_chat); // 사용자 팝업 채팅 내용 입력
	/********** 팝업창 **********/
	
	/********** 커뮤니티 **********/
	List<BoardInfoVO> getBoards(); // 커뮤니티 게시글 목록 가져오기
	List<BoardInfoVO> getBoard(int boardNumber); // 게시글 보기
	void addBoardChild(String name, int boardNumber); // 게시글 자식 생성
	void updateBoardSympathy(int boardNumber, String name, int sym_count); // 게시글 공감
	void addBoard(String name, String title, String content, String subject); //게시글 생성
	int getBoardNumber(); //게시글 자식 생성을 위환 게시글 번호 가져오기
	List<BoardChildInfoVO> getBoardChildList(int boardNumber); // 게시글 공감,댓글 가져오기
	List<BoardChildInfoVO> getBoardChilds(int boardNumber, String name); // 사용자 공감, 댓글 가져오기
	/********** 커뮤니티 **********/
}