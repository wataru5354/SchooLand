package SchooLand.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * event_entryテーブルのEntityクラス
 */
@Data
@Entity
@Table(name = "event_entry")
public class EventEntry {
	//イベント参加ID
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "event_entry_id")
	private Integer eventEntryId;

	//イベントID
	@Column(name = "event_id")
	private Integer eventId;

	//参加者ID
	@Column(name = "participant_id")
	private Integer participantId;

}
