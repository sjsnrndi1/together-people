package jung.spring.mybatis;

import java.util.ArrayList;
import java.util.HashMap;

import jung.spring.vo.JoinBoard_JoinUserInfoVO;

public interface JoinBoard_JoinUserMapper {

	void addJoinBoard_joinUser(HashMap<Object, Object> map); // 참여게시글 참여인원 생성 and 참여 신청

	ArrayList<JoinBoard_JoinUserInfoVO> getJoinBoard_joinUsers(int joinBoardNumber); // 참여게시글 참여인원 목록 가져오기

}