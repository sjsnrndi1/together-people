package jung.spring.mybatis;

import java.util.ArrayList;
import java.util.HashMap;

import jung.spring.vo.PostingInfoVO;

public interface PostingMapper {
	
	/* 포스팅 등록 */
	void addPosting(HashMap<Object, Object> map);
	ArrayList<PostingInfoVO> getLastPostingNumber();
	void deletePostingFail(int postingNumber);
	/* 포스팅 등록 */
	
	ArrayList<PostingInfoVO> getPostings(); // 포스팅 가져오기
}