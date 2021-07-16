package jung.spring.mybatis;

import java.util.ArrayList;
import java.util.HashMap;

import jung.spring.vo.PostingInfoVO;

public interface PostingMapper {
	
	/* ������ ��� */
	void addPosting(HashMap<Object, Object> map);
	ArrayList<PostingInfoVO> getNowRegistPosting(String user_id);
	/* ������ ��� */
	
	ArrayList<PostingInfoVO> getPostings();

	void addUserPosting(PostingInfoVO postingInfo);

	PostingInfoVO getUserPosting(int postingNumber);

	PostingInfoVO getUserPostingInfo(PostingInfoVO posting);

	void updateUserPosting(PostingInfoVO postingInfo);

	void deleteUserPosting(PostingInfoVO postingInfo);

	void updateUserPostingRecommand(PostingInfoVO postingInfo);

	PostingInfoVO getPosting(int postingNumber);

	void userSecession(String userId);

	void adminDeletePosting(int postingNumber);

}