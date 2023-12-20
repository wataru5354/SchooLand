package SchooLand.Service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SchooLand.Entity.Event;
import SchooLand.Form.EventForm;
import SchooLand.Repository.EventRepository;

@Service
public class EventServiceImpl implements EventService{
	@Autowired
	EventRepository eventRepository;
	
	//Event一覧表示メソッド
	public List<Event> findAll(){
		return eventRepository.findAll();
	}
	
	//Eventメソッドの処理内容
	public void createEvent(EventForm eventForm){
			Event event = new Event();
			event.setEventName(eventForm.getEventName());
			event.setEventDate(Date.valueOf(eventForm.getEventDate()));
			event.setEventVenue(eventForm.getEventVenue());
			eventRepository.save(event);
	}
	
	public List<Event> findByEventId(Integer eventId){
		List<Event> event = 
				eventRepository.findByEventId(eventId);
		return event;
	}
}
