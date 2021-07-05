package jung.spring.mybatis;

import java.util.ArrayList;

import jung.spring.vo.AlarmInfoVO;

public interface AlarmMapper {

	void addAlarm(AlarmInfoVO alarmInfo);

	ArrayList<AlarmInfoVO> getAlarms();

}