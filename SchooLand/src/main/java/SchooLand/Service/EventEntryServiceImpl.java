package SchooLand.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SchooLand.Entity.EventEntry;
import SchooLand.Entity.Participant;
import SchooLand.Form.EventEntryForm;
import SchooLand.Repository.EventEntryRepository;
import SchooLand.Repository.ParticipantRepository;

@Service
public class EventEntryServiceImpl implements EventEntryService {
	
	@Autowired
	EventEntryRepository eventEntryRepository;
	@Autowired
	ParticipantRepository participantRepository;
	
	/**
	 * 指定したイベントIDに紐づく参加者の一覧を取得
	 */
	public List<Participant> findByEventId(Integer eventId){
		//指定したイベントからイベント参加者の情報を取得
		List<EventEntry> eventEntryList = 
				eventEntryRepository.findByEventId(eventId);
		
		//イベント参加者のIDを取得
		//イベント参加者は複数いる可能性あり
		List<Integer> ids = new ArrayList<Integer>();
		for(EventEntry eventEntry : eventEntryList) {
			ids.add(eventEntry.getParticipantId());
		}
		
		//イベント参加者の情報を検索して返却
		List<Participant> participantList =
				participantRepository.findAllById(ids);
		return participantList;
	}
	
	//参加者登録メソッド
	public void addParticipant(EventEntryForm eventEntryForm) {
		//参加者登録
		Participant participant = new Participant();
		participant.setParticipantName(eventEntryForm.getParticipantName());
		participantRepository.save(participant);
		
		//イベント一覧の参加者登録
		EventEntry eventEntry = new EventEntry();
		eventEntry.setEventId(eventEntryForm.getEventId());
		eventEntry.setParticipantId(participant.getParticipantId());
		eventEntryRepository.save(eventEntry);
	}
	
	
}
