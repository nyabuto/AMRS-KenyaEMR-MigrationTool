package ampath.co.ke.amrs_kenyaemr.repositories;

import ampath.co.ke.amrs_kenyaemr.models.AMRSGreenCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("AMRSGreenCardRepository")
public interface AMRSGreenCardRepository extends JpaRepository<AMRSGreenCard, Long> {
    List<AMRSGreenCard> findByUuid(String uuid);

    List<AMRSGreenCard> findByResponseCodeIsNull();

   List<AMRSGreenCard> findByEncounterId(String encounterId);

   @Query("SELECT amrs from AMRSGreenCard amrs  GROUP BY amrs.encounterId")
   List<AMRSGreenCard> findDistinctEncounters();
}