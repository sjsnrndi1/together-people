package jung.spring.mybatis;

import java.util.ArrayList;
import java.util.HashMap;
import jung.spring.vo.PopupChatInfoVO;

public interface PopupChatMapper {
	
	ArrayList<PopupChatInfoVO> getPopupChats(int popupNumber); //사용자 팝업 채팅 내용 가져오기

	void addPopupUserChat(HashMap<Object, Object> map); //사용자 팝업 채팅 입력
}