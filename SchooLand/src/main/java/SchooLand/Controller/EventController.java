package SchooLand.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import SchooLand.Entity.Event;
import SchooLand.Entity.Participant;
import SchooLand.Form.EventEntryForm;
import SchooLand.Form.EventForm;
import SchooLand.Service.EventEntryService;
import SchooLand.Service.EventService;

@Controller
public class EventController {

	@Autowired
	EventService eventService;
	@Autowired
	EventEntryService eventEntryService;

	/**
	 * トップページに遷移するための処理
	 * @return "eventlist.html"
	 */
	@GetMapping("/")
	public String index(Model model) {
		List<Event> eventList = eventService.findAll();
		model.addAttribute("eventList", eventList);
		return "eventlist";
	}
	
	/**
	 * Event登録画面への遷移
	 * @return "regist.html"
	 */
	@GetMapping("regist")
	public String regist() {
		return "regist";
	}

	@PostMapping("eventregist")
	public String eventRegist(@ModelAttribute EventForm eventForm) {
		eventService.createEvent(eventForm);
		return "redirect:/";
	}
	
	//イベント詳細画面の遷移
	@GetMapping("entry/{eventId}")
	public String entry(@PathVariable("eventId") Integer eventId,
				Model model) {
		//引数で受け取ったイベントIDからイベントの情報を取得
		//イベントの情報は1件の前提で処理
		List<Event> event = eventService.findByEventId(eventId);
		
		//modelに結果をセット
		model.addAttribute("event",event.get(0));
		
		//イベントIDから参加者を取得
		List<Participant> participantList = 
				eventEntryService.findByEventId(eventId);
		
		//modelに結果をセット
		model.addAttribute("participantList",participantList);
		
		//詳細画面に遷移
		return "eventdetail";
	}
	
	//参加者登録
	@PostMapping("entry/add")
	public String add(@ModelAttribute EventEntryForm eventEntryForm) {
		eventEntryService.addParticipant(eventEntryForm);
		return "redirect:/entry/" + eventEntryForm.getEventId();
	}
	

}
