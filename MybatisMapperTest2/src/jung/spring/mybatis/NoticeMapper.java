package jung.spring.mybatis;

import java.util.ArrayList;

import jung.spring.vo.NoticeInfoVO;

public interface NoticeMapper {

	ArrayList<NoticeInfoVO> getNotices();

	void addNotice(NoticeInfoVO noticeRegist);

	NoticeInfoVO getNotice(int noticeNumber);

	void modifyNotice(NoticeInfoVO noticeModify);

	void modifyNoticeNumber(NoticeInfoVO notice);

	void deleteNotice(int noticeNumber);

	void modifyNoticeReadCount(NoticeInfoVO modifyNoticeInfo);

}