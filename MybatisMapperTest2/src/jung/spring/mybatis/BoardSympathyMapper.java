package jung.spring.mybatis;

import java.util.ArrayList;
import java.util.HashMap;

import jung.spring.vo.BoardSympathyInfoVO;

public interface BoardSympathyMapper {

	void addBoardSympathy(HashMap<Object, Object> map); // ����� ���� ù ����

	void updateBoardSympathy(HashMap<Object, Object> map); // ����� ���� �����ϱ�

	BoardSympathyInfoVO getBoardSympathy(HashMap<Object, Object> map); // ����� ���� ��������

}