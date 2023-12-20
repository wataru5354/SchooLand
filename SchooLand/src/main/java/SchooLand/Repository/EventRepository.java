package SchooLand.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import SchooLand.Entity.Event;

public interface EventRepository extends JpaRepository<Event,Integer> {
	/**
	 * 指定したイベントIDからイベントの情報を検索
	 * @param eventId
	 * @return　イベント一覧
	 */
	public List<Event> findByEventId(Integer eventId);
}
