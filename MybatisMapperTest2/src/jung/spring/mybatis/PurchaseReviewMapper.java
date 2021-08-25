package jung.spring.mybatis;

import java.util.ArrayList;
import java.util.HashMap;
import jung.spring.vo.PurchaseReviewInfoVO;

public interface PurchaseReviewMapper {

	ArrayList<PurchaseReviewInfoVO> getPurchaseReviews(); // �̿��ı� ���

	void addPurchaseReview(HashMap<Object, Object> map); //�̿��ı� ����

	int getLastPurchaseReviewNumber(int i); // �� ������ �̿��ı� ��ȣ ��������

	void deletePurchaseReviewFail(int parseInt); //�̿��ı� ����

	PurchaseReviewInfoVO getPurchaseReview(int purchaseReviewNumber); //�̿��ı� ����

}