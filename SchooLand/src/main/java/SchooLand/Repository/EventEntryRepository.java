package SchooLand.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import SchooLand.Entity.EventEntry;

public interface EventEntryRepository extends JpaRepository<EventEntry,Integer> {
	/**
	 * 指定したイベントIDからイベント参加者の情報を検索
	 * @param eventId
	 * @return イベント参加者一覧
	 */
	public List<EventEntry> findByEventId(Integer eventId);
}
