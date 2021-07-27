package jung.spring.mybatis;

import java.util.ArrayList;
import java.util.HashMap;

import jung.spring.vo.PostingInfoVO;

public interface PostingMapper {
	
	/* ������ ��� */
	void addPosting(HashMap<Object, Object> map);
	ArrayList<PostingInfoVO> getLastPostingNumber();
	void deletePostingFail(int postingNumber);
	/* ������ ��� */
	
	ArrayList<PostingInfoVO> getPostings(); // ������ ��������
}