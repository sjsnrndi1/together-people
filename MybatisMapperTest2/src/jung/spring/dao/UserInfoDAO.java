package jung.spring.dao;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import jung.spring.vo.BoardSympathyInfoVO;
import jung.spring.vo.BoardCommentInfoVO;
import jung.spring.vo.BoardInfoVO;
import jung.spring.vo.ChatInfoVO;
import jung.spring.vo.JoinBoardInfoVO;
import jung.spring.vo.PopupChatInfoVO;
import jung.spring.vo.PostingInfoVO;
import jung.spring.vo.UserInfoVO;

public interface UserInfoDAO {
	
	/********** ȸ������ **********/
	void addUser(HashMap<Object,Object> map); //ȸ������
	ArrayList<UserInfoVO> getMembers(); //ȸ�� ��� ��������
	boolean checkUserEmail(String user_name, int user_phone); //�̸��� Ȯ��
	UserInfoVO selectUserId(String user_name, int user_phone); //���̵� ã��
	boolean selectUserPassword(String user_id, String user_name, int user_phone); //��й�ȣ ã�� Ȯ��
	UserInfoVO selectUserPassword(String user_id); //��й�ȣ ã��
	void modifyPassword(String user_id, String user_password); //��й�ȣ ����
	UserInfoVO getUser(String user_id); // ����� ã��
	/********** ȸ������ **********/
	
	/********** ������ **********/
	ArrayList<PostingInfoVO> getPostings(); //������ ��������
	void addPosting(String content_title, String content_content, File content_picture, UserInfoVO user_id); //������ ���
	String getLastPostingNumber(); //������ ��������ȣ ��������
	void deletePostingFail(String posting_Number); //��� ������ ������ ����
	/********** ������ **********/
	
	/********** �˾� â **********/
	void addUserPopup(String user_id); //����� �� �˾� â  ����
	int getPopupNumber(String user_id); //�˾� ��ȣ ��������
	ArrayList<PopupChatInfoVO> getPopupChats(int popupNumber); // �˾� ä�� ���� ��������
	void addPopupUserChat(String user_id, int popupNumber, String user_chat); // �˾� ä�� �Է�
	/********** �˾� â **********/
	
	/********** �Խñ� **********/
	ArrayList<BoardInfoVO> getBoards(); //�Խñ� ��� ��������
	BoardInfoVO getBoard(int boardNumber); //�Խñ� ����
	void addBoardSympathy(int boardNumber, String name); // �Խñ� ���� ����
	void addBoardComment(int boardNumber, String name, String comment, String userName); // �Խñ� ��� ����
	void updateBoardSympathy(int boardNumber, String name, int sym_count); // �Խñ� ����
	void addBoard(String name, String title, String content, String subject); //�Խñ� ����
	int getBoardNumber(); //�Խñ� �ڽ� ������ ��ȯ �Խñ� ��ȣ ��������
	BoardSympathyInfoVO getBoardSympathy(int boardNumber, String name); // ����� ���� ��������
	ArrayList<BoardCommentInfoVO> getBoardComments(int boardNumber); // ����� ��� ��� ��������
	void deleteBoardComment(int boardCommentNumber);//����� ��� ����
	ArrayList<BoardInfoVO> getBoardSort(String subject, String move); //�Խñ� ����
	void addJoinBoard(String name, String title, String content, String subject); //���� �Խñ� ����
	ArrayList<JoinBoardInfoVO> getJoinBoards(); //�����Խñ� ��� ��������
	/********** �Խñ� **********/
}