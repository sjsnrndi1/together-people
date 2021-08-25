package jung.spring.svc;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import jung.spring.vo.BoardSympathyInfoVO;
import jung.spring.vo.JoinBoardInfoVO;
import jung.spring.vo.JoinBoard_JoinUserInfoVO;
import jung.spring.vo.BoardCommentInfoVO;
import jung.spring.vo.BoardInfoVO;
import jung.spring.vo.PopupChatInfoVO;
import jung.spring.vo.PostingInfoVO;
import jung.spring.vo.PurchaseReviewInfoVO;
import jung.spring.vo.UserInfoVO;

public interface UserInfoService {

	/********** ȸ������ **********/
	void addUserInfo(HashMap<Object, Object> map); //ȸ������
	List<UserInfoVO> getMembers(); //ȸ�� ��� ��������
	boolean checkUserEmail(String user_name, int user_phone); //�̸��� Ȯ��
	UserInfoVO selectUserId(String user_name, int user_phone); //���̵� ã��
	boolean selectUserPassword(String user_id, String user_name, int user_phone); //��й�ȣ ã�� Ȯ��
	UserInfoVO selectUserPassword(String user_id); //��й�ȣ ã��
	void modifyUserPassword(String user_id, String user_password); //��й�ȣ ����
	UserInfoVO getUser(String user_id); //���̵� �´� ȸ������ ��������
	/********** ȸ������ **********/
	
	/********** ������ **********/
	List<PostingInfoVO> getPostings(); //������ ��� ��������
	void addPosting(String content_title, String content_content, File content_picture, UserInfoVO userInfo); //������ ���
	String getLastPostingNumber(); //������ ��������ȣ ��������
	void deletePostingFail(String postingNumber); //��� ������ ������ ����
	/********** ������ **********/
	
	/********** �˾�â **********/
	void addUserPopup(String user_id); // ����� �� �˾� â ����
	int getPopupNumber(String user_id); // ����ڿ� �´� �� ��ȣ ��������
	List<PopupChatInfoVO> getPopupChats(int popupNumber); // ����� �˾� ä�� ���� ��������
	void addPopupUserChat(String user_id, int popupNumber, String user_chat); // ����� �˾� ä�� ���� �Է�
	/********** �˾�â **********/
	
	/********** Ŀ�´�Ƽ **********/
	List<BoardInfoVO> getBoards(); // Ŀ�´�Ƽ �Խñ� ��� ��������
	BoardInfoVO getBoard(int boardNumber); // �Խñ� ����
	void addBoardSympathy(int boardNumber, String name); // �Խñ� ���� ����
	void updateBoardSympathy(int boardNumber, String name, int sym_count); // �Խñ� ���� ����
	void addBoardComment(int boardNumber, String name, String comment, String userName); // �Խñ� ��� ����
	void addBoard(String name, String title, String content, String subject); //�Խñ� ����
	int getBoardNumber(); //�Խñ� �ڽ� ������ ��ȯ �Խñ� ��ȣ ��������
	BoardSympathyInfoVO getBoardSympathy(int boardNumber, String name); // ����� ���� ��������
	List<BoardCommentInfoVO> getBoardComments(int boardNumber); // ����� ��� ��� ��������
	void deleteBoardComment(int boardCommentNumber); //����� ��� ����
	List<BoardInfoVO> getBoardSort(String subject, String move); //�Խñ� ����
	void addJoinBoard(String name, String title, String content, String subject); //�����Խñ� ����
	List<JoinBoardInfoVO> getJoinBoards(); //�����Խñ� ��� ��������
	JoinBoardInfoVO getJoinBoard(int joinBoardNumber); //�����Խñ� ����
	void addJoinBoard_joinUser(String name); //�����Խñ� �����ο�  ����
	List<JoinBoard_JoinUserInfoVO> getJoinBoard_joinUsers(int joinBoardNumber); //�����Խñ� �����ο� ��� ��������
	void addJoinBoard_joinUser_regist(String name, int joinBoardNumber); //�����Խñ� ������û
	List<JoinBoardInfoVO> getJoinBoardSorts(String subject); //�����Խñ� ����
	void updateJoinUserAccept(int joinNumber, int joinBoardNumber); // �����Խñ� ����
	void updateJoinUserRefuse(int joinNumber); // �����Խñ� ����
	List<PurchaseReviewInfoVO> getPurchaseReviews(); //�̿��ı� ���
	void addPurchaseReview(String title, String content, File content_picture, UserInfoVO userInfo); //�̿��ı� ����
	String getLastPurchaseReviewNumber(); // �� ������ �̿��ı� ��ȣ ��������
	void deletePurchaseReviewFail(String purchaseReviewNumber); //�̿��ı� ����
	PurchaseReviewInfoVO getPurchaseReview(int purchaseReviewNumber); //�̿��ı� ���� 
	/********** Ŀ�´�Ƽ **********/
	
	/********** ���������� **********/
	void updateUserInformation(HashMap<Object, Object> map); //�� ���� ����
	List<BoardInfoVO> getMyBoards(String name); //�� ��� �� �� ��������
	void deleteBoard(String data); //�� �� ����
	List<JoinBoard_JoinUserInfoVO> getJoinBoard_joinUserList(); //������û�� �ο� ��� ��������
	List<BoardCommentInfoVO> getBoardCommentList(); //��� ��� ��������
	/********** ���������� **********/
	
}