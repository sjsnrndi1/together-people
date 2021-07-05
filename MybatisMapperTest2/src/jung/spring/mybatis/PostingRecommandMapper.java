package jung.spring.mybatis;

import java.util.ArrayList;
import jung.spring.vo.PostingRecommandInfoVO;

public interface PostingRecommandMapper {

	ArrayList<PostingRecommandInfoVO> getUserPostingRecommand(String user_id);

	void addUserPostingRecommand(PostingRecommandInfoVO postingRecommandInfo);

	void updatePostingRecommand(PostingRecommandInfoVO postingRecommandInfo3);

	PostingRecommandInfoVO getUserRecommand(PostingRecommandInfoVO postingRecommandInfo2);

	ArrayList<PostingRecommandInfoVO> getPostingRecommands(String user_id);

	void userSecession(String userId);

	PostingRecommandInfoVO getPostingRecommand(String userId, int postingNumber);

	PostingRecommandInfoVO getPostingRc(PostingRecommandInfoVO postingRecommand);
}