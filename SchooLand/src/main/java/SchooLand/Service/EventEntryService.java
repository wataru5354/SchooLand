package SchooLand.Service;

import java.util.List;

import SchooLand.Entity.Participant;
import SchooLand.Form.EventEntryForm;

public interface EventEntryService {
	
	/**
	 * 指定したイベントIDに紐づく参加者の一覧を取得
	 * @param eventId
	 * @return
	 */
	public List<Participant> findByEventId(Integer eventId);
	
	public void addParticipant(EventEntryForm eventEntryForm);
}
