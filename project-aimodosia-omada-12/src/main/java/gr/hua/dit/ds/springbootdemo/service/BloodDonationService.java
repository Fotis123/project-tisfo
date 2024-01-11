package gr.hua.dit.ds.springbootdemo.service;
import gr.hua.dit.ds.springbootdemo.entity.Citizen;
import gr.hua.dit.ds.springbootdemo.entity.Secretary;
import gr.hua.dit.ds.springbootdemo.repository.CitizenRepository;
import gr.hua.dit.ds.springbootdemo.repository.SecretaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Service
public class BloodDonationService {


    @Autowired
    private CitizenRepository citizenRepository; //ενσωμάτωση του citizenRepository

    @Autowired
    private SecretaryRepository secretaryRepository; //ενσωμάτωση του secretaryRepository

    public List<Citizen> getAllCitizens() {
        return citizenRepository.findAll();
    } //επιστροφή λίστας με τους εγγεγραμμένους πολίτες

    public Optional<Citizen> getCitizenById(int id) {
        return citizenRepository.findById(id);
    } //επιστροφή πληροφοριών πολίτη με βάση το id

    public List<Secretary> getAllSecretaries() {
        return secretaryRepository.findAll();
    } //επιστροφή λίστας των εγγεγραμμένων γραμματέων

    public Optional<Secretary> getSecretaryById(int id) {
        return secretaryRepository.findById(id);
    } //επιστροφή πληροφοριών γραμματέα με βάση το id

    public Citizen registerBloodDonor(Citizen citizen) {
        // Ελέγχουμε αν ο πολίτης πληροί τις προϋποθέσεις για να γίνει αιμοδότης
        if (eligibleForBloodDonation(citizen)) {
            // Ορίζουμε τον πολίτη ως αιμοδότη
            citizen.setBloodDonor(true);

            // Ενημερώνουμε το CitizenRepository με τα νέα δεδομένα
            citizenRepository.save(citizen);

            // Ενημερώνουμε την ημερομηνία τελευταίας αιμοδοσίας
            LastDonation(citizen);

            return citizen;
        } else {
            // Αν ο πολίτης δεν είναι επιλέξιμος για αιμοδότη
            return null;
        }
    }
    public void LastDonation (Citizen citizen) { //Δημιουργία scanner και input του χρήστη για τη τελευταία αιμοδοσία
         Scanner scanner = new Scanner(System.in);
         System.out.print("Enter the year: ");
         int year = scanner.nextInt();
         System.out.print("Enter the month: ");
         int month = scanner.nextInt();
         System.out.print("Enter the day: ");
         int day = scanner.nextInt();
         LocalDate LastDonationDate = LocalDate.of(year,month,day);
         citizen.setLastBloodDonation(LastDonationDate);
         scanner.close();
    }
    public void processBloodDonationRequest(int citizenId) {
        // λογική για την επεξεργασία του αιτήματος αιμοδοσίας
        Optional<Citizen> optionalCitizen = citizenRepository.findById(citizenId);
        if (optionalCitizen.isPresent()) {
            Citizen citizen = optionalCitizen.get();
            citizen.setBloodDonationRequestProcessed(true);
            citizenRepository.save(citizen);
        }
    }
    public boolean eligibleForBloodDonation(Citizen citizen) {
        //Εάν ο πολίτης έχει πραγματοποιήσει επιτυχημένες αιμοδοσίες στο παρελθόν
        LocalDate thirtyDaysAgo = LocalDate.now().minusDays(30);
        if (citizen.getLastBloodDonation().isBefore(thirtyDaysAgo)) {
            return true;
        }
        return false;
    }
}