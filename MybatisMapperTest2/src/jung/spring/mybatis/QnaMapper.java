package jung.spring.mybatis;

import java.util.ArrayList;

import jung.spring.vo.QnaInfoVO;

public interface QnaMapper {

	ArrayList<QnaInfoVO> getQnas(String user_id);

	void addQna(QnaInfoVO qnaInfo);

	void deleteQna(int qnaNumber);

	QnaInfoVO getQna(int qnaNumber);

	void qnaModify(QnaInfoVO qnaInfo);

	void userSecession(String qnaUserId);

	ArrayList<QnaInfoVO> getQnaInfos();

	void modifyQnaNumber(QnaInfoVO qna);

	void modifyQnaComment(QnaInfoVO qnaInfo);

	QnaInfoVO getQnaInfo(QnaInfoVO qnaInfo);

}