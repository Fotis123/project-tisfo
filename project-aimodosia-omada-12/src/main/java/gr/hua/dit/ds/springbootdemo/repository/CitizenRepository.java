package gr.hua.dit.ds.springbootdemo.repository;

import gr.hua.dit.ds.springbootdemo.entity.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CitizenRepository extends JpaRepository<Citizen, Integer> {
    List<Citizen> findBySubmissionDateAfter(LocalDateTime submissionDate);

    List<Citizen> findByProcessBloodDonationRequestProcessedTrue();

    List<Citizen> findByBloodDonationRequestProcessedAndSubmissionDateAfter(boolean processed, LocalDateTime submissionDate);
}
