package jung.spring.mybatis;

import java.util.ArrayList;
import java.util.HashMap;

import jung.spring.vo.JoinBoard_JoinUserInfoVO;

public interface JoinBoard_JoinUserMapper {

	void addJoinBoard_joinUser(HashMap<Object, Object> map); // 참여게시글 참여인원 생성 and 참여 신청

	ArrayList<JoinBoard_JoinUserInfoVO> getJoinBoard_joinUsers(int joinBoardNumber); // 참여게시글 참여인원 목록 가져오기

	void deleteJoinBoard_joinUser(HashMap<Object, Object> map); // 내 글 참여인원 삭제

	ArrayList<JoinBoard_JoinUserInfoVO> getJoinBoard_joinUserList(); //참여신청한 인원 목록 가져오기

}