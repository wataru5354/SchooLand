package SchooLand.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import SchooLand.Entity.Participant;

public interface ParticipantRepository extends JpaRepository<Participant,Integer> {

}
