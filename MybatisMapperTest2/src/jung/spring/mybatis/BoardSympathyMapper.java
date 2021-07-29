package jung.spring.mybatis;

import java.util.ArrayList;
import java.util.HashMap;

import jung.spring.vo.BoardSympathyInfoVO;

public interface BoardSympathyMapper {

	void addBoardSympathy(HashMap<Object, Object> map);

	void updateBoardSympathy(HashMap<Object, Object> map);

	ArrayList<BoardSympathyInfoVO> getBoardSympathys(HashMap<Object, Object> map);

}