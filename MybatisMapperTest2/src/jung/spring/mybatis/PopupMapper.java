package jung.spring.mybatis;

public interface PopupMapper {

	int getPopupNumber(String user_id); // ����� �˾� â ��ȣ ��������

	void addUserPopup(String user_id); // ����� �˾� â ����

}