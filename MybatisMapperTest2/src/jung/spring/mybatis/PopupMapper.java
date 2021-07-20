package jung.spring.mybatis;

public interface PopupMapper {

	int getPopupNumber(String user_id); // 사용자 팝업 창 번호 가져오기

	void addUserPopup(String user_id); // 사용자 팝업 창 생성

}