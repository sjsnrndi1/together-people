package jung.spring.mybatis;

import java.util.ArrayList;

import jung.spring.vo.ChatInfoVO;

public interface ChatMapper {

	void addChat(ChatInfoVO chat);

	ArrayList<ChatInfoVO> getChats(int boardNumber);

	void userSecession(String chatUserId);

}