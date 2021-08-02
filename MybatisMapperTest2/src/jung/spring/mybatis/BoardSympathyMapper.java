package jung.spring.mybatis;

import java.util.ArrayList;
import java.util.HashMap;

import jung.spring.vo.BoardSympathyInfoVO;

public interface BoardSympathyMapper {

	void addBoardSympathy(HashMap<Object, Object> map); // 사용자 공감 첫 생성

	void updateBoardSympathy(HashMap<Object, Object> map); // 사용자 공감 수정하기

	BoardSympathyInfoVO getBoardSympathy(HashMap<Object, Object> map); // 사용자 공감 가져오기

}