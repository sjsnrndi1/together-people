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
	List<BoardInfoVO> getBoard(int boardNumber); // �Խñ� ����
	void addBoardChild(String name, int boardNumber); // �Խñ� �ڽ� ����
	void updateBoardSympathy(int boardNumber, String name, int sym_count); // �Խñ� ����
	void addBoard(String name, String title, String content, String subject); //�Խñ� ����
	int getBoardNumber(); //�Խñ� �ڽ� ������ ��ȯ �Խñ� ��ȣ ��������
	List<BoardChildInfoVO> getBoardChildList(int boardNumber); // �Խñ� ����,��� ��������
	List<BoardChildInfoVO> getBoardChilds(int boardNumber, String name); // ����� ����, ��� ��������
	/********** Ŀ�´�Ƽ **********/
}