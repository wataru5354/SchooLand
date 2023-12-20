package SchooLand.Service;

import java.util.List;

import SchooLand.Entity.Event;
import SchooLand.Form.EventForm;

public interface EventService {
	//Event一覧表示
	public List<Event> findAll();
	//Event作成メソッド
	public void createEvent(EventForm eventForm);
	
	//イベントID取得メソッド
	public List<Event> findByEventId(Integer eventId);
}
