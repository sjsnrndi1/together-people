package jung.spring.mybatis;

import java.util.ArrayList;
import java.util.HashMap;
import jung.spring.vo.PopupChatInfoVO;

public interface PopupChatMapper {
	
	ArrayList<PopupChatInfoVO> getPopupChats(int popupNumber); //����� �˾� ä�� ���� ��������

	void addPopupUserChat(HashMap<Object, Object> map); //����� �˾� ä�� �Է�
}