package gr.hua.dit.ds.springbootdemo.repository;

import gr.hua.dit.ds.springbootdemo.entity.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CitizenRepository extends JpaRepository<Citizen, Integer> {
    List<Citizen> findBySubmissionDateAfter(LocalDateTime submissionDate); // επιστροφή λίστας πολιτών που η ημερομηνία υποβολής τους είναι μετά από την καθορισμένη submissionDate

    List<Citizen> findByProcessBloodDonationRequestProcessedTrue(); // επιστροφή λίστας πολιτών με επεξεργασμένο αίτημα αιμοδοσίας

    List<Citizen> findByBloodDonationRequestProcessedAndSubmissionDateAfter(boolean processed, LocalDateTime submissionDate);
    ////επιστροφή λίστας πολιτών που έχουν επεξεργασμένο αίτημα αιμοδοσίας και η ημερομηνία υποβολής τους είναι μετά από την καθορισμένη submissionDate.
}
