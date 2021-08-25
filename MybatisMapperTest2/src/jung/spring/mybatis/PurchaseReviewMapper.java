package jung.spring.mybatis;

import java.util.ArrayList;
import java.util.HashMap;
import jung.spring.vo.PurchaseReviewInfoVO;

public interface PurchaseReviewMapper {

	ArrayList<PurchaseReviewInfoVO> getPurchaseReviews(); // 이용후기 목록

	void addPurchaseReview(HashMap<Object, Object> map); //이용후기 생성

	int getLastPurchaseReviewNumber(int i); // 갓 생성한 이용후기 번호 가져오기

	void deletePurchaseReviewFail(int parseInt); //이용후기 삭제

	PurchaseReviewInfoVO getPurchaseReview(int purchaseReviewNumber); //이용후기 내용

}