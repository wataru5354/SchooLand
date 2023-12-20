package SchooLand.Entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

//evetテーブルのためのEntityクラス
@Data
@Entity
@Table(name = "event")
public class Event {
	//イベントID
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "event_id")
	private Integer eventId;

	//イベント名
	@Column(name = "event_name")
	private String eventName;

	//イベント開催場所
	@Column(name = "event_venue")
	private String eventVenue;

	//イベント日時
	@Column(name = "event_date")
	private Date eventDate;

}
