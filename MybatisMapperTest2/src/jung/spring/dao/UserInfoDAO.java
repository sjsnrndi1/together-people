package jung.spring.dao;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import jung.spring.vo.BoardSympathyInfoVO;
import jung.spring.vo.BoardCommentInfoVO;
import jung.spring.vo.BoardInfoVO;
import jung.spring.vo.JoinBoardInfoVO;
import jung.spring.vo.JoinBoard_JoinUserInfoVO;
import jung.spring.vo.PopupChatInfoVO;
import jung.spring.vo.PostingInfoVO;
import jung.spring.vo.PurchaseReviewInfoVO;
import jung.spring.vo.UserInfoVO;

public interface UserInfoDAO {
	
	/********** 회원정보 **********/
	void addUser(HashMap<Object,Object> map); //회원가입
	ArrayList<UserInfoVO> getMembers(); //회원 목록 가져오기
	boolean checkUserEmail(String user_name, int user_phone); //이메일 확인
	UserInfoVO selectUserId(String user_name, int user_phone); //아이디 찾기
	boolean selectUserPassword(String user_id, String user_name, int user_phone); //비밀번호 찾기 확인
	UserInfoVO selectUserPassword(String user_id); //비밀번호 찾기
	void modifyPassword(String user_id, String user_password); //비밀번호 변경
	UserInfoVO getUser(String user_id); // 사용자 찾기
	/********** 회원정보 **********/
	
	/********** 포스팅 **********/
	ArrayList<PostingInfoVO> getPostings(); //포스팅 가져오기
	void addPosting(String content_title, String content_content, File content_picture, UserInfoVO user_id); //포스팅 등록
	String getLastPostingNumber(); //포스팅 마지막번호 가져오기
	void deletePostingFail(String posting_Number); //등록 실패지 포스팅 삭제
	/********** 포스팅 **********/
	
	/********** 팝업 창 **********/
	void addUserPopup(String user_id); //사용자 별 팝업 창  생성
	int getPopupNumber(String user_id); //팝업 번호 가져오기
	ArrayList<PopupChatInfoVO> getPopupChats(int popupNumber); // 팝업 채팅 내용 가져오기
	void addPopupUserChat(String user_id, int popupNumber, String user_chat); // 팝업 채팅 입력
	/********** 팝업 창 **********/
	
	/********** 게시글 **********/
	ArrayList<BoardInfoVO> getBoards(); //게시글 목록 가져오기
	BoardInfoVO getBoard(int boardNumber); //게시글 보기
	void addBoardSympathy(int boardNumber, String name); // 게시글 공감 생성
	void addBoardComment(int boardNumber, String name, String comment, String userName); // 게시글 댓글 생성
	void updateBoardSympathy(int boardNumber, String name, int sym_count); // 게시글 공감
	void addBoard(String name, String title, String content, String subject); //게시글 생성
	int getBoardNumber(); //게시글 자식 생성을 위환 게시글 번호 가져오기
	BoardSympathyInfoVO getBoardSympathy(int boardNumber, String name); // 사용자 공감 가져오기
	ArrayList<BoardCommentInfoVO> getBoardComments(int boardNumber); // 사용자 댓글 목록 가져오기
	void deleteBoardComment(int boardCommentNumber);//사용자 댓글 삭제
	ArrayList<BoardInfoVO> getBoardSort(String subject, String move); //게시글 정렬
	void addJoinBoard(String name, String title, String content, String subject); //참여 게시글 생성
	ArrayList<JoinBoardInfoVO> getJoinBoards(); //참여게시글 목록 가져오기
	JoinBoardInfoVO getJoinBoard(int joinBoardNumber); //참여게시글 보기
	void addJoinBoard_joinUser(String name); //참여게시글  참여인원 생성
	ArrayList<JoinBoard_JoinUserInfoVO> getJoinBoard_joinUsers(int joinBoardNumber); //참여게시글 참여인원 목록 가져오기
	void addJoinBoard_joinUser_regist(String name, int joinBoardNumber); //참여게시글 참여신청
	ArrayList<JoinBoardInfoVO> getJoinBoardSorts(String subject); //참여게시글 정렬
	void updateJoinUserAccept(int joinNumber, int joinBoardNumber); //참여게시글 수락
	void updateJoinUserRefuse(int joinNumber); //참여게시글 거절
	ArrayList<PurchaseReviewInfoVO> getPurchaseReviews(); //이용후기 목록
	void addPurchaseReview(String title, String content, File content_picture, UserInfoVO userInfo); //이용후기 생성
	String getLastPurchaseReviewNumber(); // 갓 생성한 이용후기 번호 가져오기
	void deletePurchaseReviewFail(String purchaseReviewNumber); //이용후기 삭제
	PurchaseReviewInfoVO getPurchaseReview(int purchaseReviewNumber); //이용후기 내용
	/********** 게시글 **********/
	
	/********** 마이페이지 **********/
	void updateUserInformation(HashMap<Object, Object> map); //내 정보 수정
	ArrayList<BoardInfoVO> getMyBoards(String name); //글 목록 내 글 가져오기
	void deleteBoard(String data); // 내 글 삭제
	ArrayList<JoinBoard_JoinUserInfoVO> getJoinBoard_joinUserList(); //참여신청한 인원 목록 가져오기
	ArrayList<BoardCommentInfoVO> getBoardCommentList(); //댓글 목록 가져오기
	/********** 마이페이지 **********/
}