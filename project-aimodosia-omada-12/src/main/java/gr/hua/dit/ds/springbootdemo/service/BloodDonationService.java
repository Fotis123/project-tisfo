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
    private CitizenRepository citizenRepository;

    @Autowired
    private SecretaryRepository secretaryRepository;

    // Εδώ μπορείτε να προσθέσετε την λογική για την αιμοδοσία

    public List<Citizen> getAllCitizens() {
        return citizenRepository.findAll();
    }

    public Optional<Citizen> getCitizenById(int id) {
        return citizenRepository.findById(id);
    }

    public List<Secretary> getAllSecretaries() {
        return secretaryRepository.findAll();
    }

    public Optional<Secretary> getSecretaryById(int id) {
        return secretaryRepository.findById(id);
    }

    public Citizen registerBloodDonor(Citizen citizen) {
        // Ελέγχουμε αν ο πολίτης πληροί τις προϋποθέσεις για να γίνει αιμοδότης
        if (eligibleForBloodDonation(citizen)) {
            // Ορίζουμε τον πολίτη ως αιμοδότη
            citizen.setBloodDonor(true);
            // Ενημερώνουμε το CitizenRepository με τα νέα δεδομένα
            return citizenRepository.save(citizen);
        } else {
            // Αν ο πολίτης δεν είναι επιλέξιμος για αιμοδότη, μπορείτε να υλοποιήσετε κατάλληλη λογική
            // π.χ., να επιστρέφουμε null ή να εμφανίζουμε ένα μήνυμα σφάλματος
            return null;
        }
    }
    public void LastDonation (Citizen citizen) {
         Scanner scanner = new Scanner(System.in);
         System.out.print("Enter the year: ");
         int year = scanner.nextInt();
         System.out.print("Enter the month: ");
         int month = scanner.nextInt();
         System.out.print("Enter the day: ");
         int day = scanner.nextInt();
         LocalDate LastDonationDate = LocalDate.of(year,month,day);
         citizen.setLastBloodDonation(LastDonationDate);
    }
    public void processBloodDonationRequest(int citizenId) {
        // Εδώ μπορείτε να προσθέσετε τη λογική για την επεξεργασία του αιτήματος αιμοδοσίας
        // Ενδεικτικά, μπορείτε να ενημερώσετε τον πολίτη ότι το αίτημα έχει επεξεργαστεί
        Optional<Citizen> optionalCitizen = citizenRepository.findById(citizenId);
        if (optionalCitizen.isPresent()) {
            Citizen citizen = optionalCitizen.get();
            citizen.setBloodDonationRequestProcessed(true);
            citizenRepository.save(citizen);
        }
    }
    public boolean eligibleForBloodDonation(Citizen citizen) {
        // Εδώ μπορείτε να προσθέσετε τους ελέγχους που κρίνετε απαραίτητους
        // Παράδειγμα: Εάν ο πολίτης έχει πραγματοποιήσει επιτυχημένες αιμοδοσίες στο παρελθόν
        LocalDate thirtyDaysAgo = LocalDate.now().minusDays(30);
        if (citizen.getLastBloodDonation().isBefore(thirtyDaysAgo)) {
            return true;
        }
        return false;
    }
}