package SchooLand.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * participantテーブルのEntityクラス
 */
@Data
@Entity
@Table(name = "participant")
public class Participant {
	//参加者ID
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "participant_id")
	private Integer participantId;
	
	//参加者名
	@Column(name = "participant_name")
	private String participantName;
	
}
