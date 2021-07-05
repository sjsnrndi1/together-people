package jung.spring.mybatis;

import java.util.ArrayList;

import jung.spring.vo.PostingInfoVO;

public interface PostingMapper {

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