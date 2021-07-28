package jung.spring.mybatis;

import java.util.ArrayList;
import java.util.HashMap;

import jung.spring.vo.BoardChildInfoVO;

public interface BoardChildMapper {

	void addBoardChild(HashMap<Object, Object> map);

	void updateBoardSympathy(HashMap<Object, Object> map);

	ArrayList<BoardChildInfoVO> getBoardChildList(int boardNumber);

	ArrayList<BoardChildInfoVO> getBoardChilds(HashMap<Object, Object> map);

}