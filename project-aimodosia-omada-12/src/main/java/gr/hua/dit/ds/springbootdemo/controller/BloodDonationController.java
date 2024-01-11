package gr.hua.dit.ds.springbootdemo.controller;
import gr.hua.dit.ds.springbootdemo.entity.Citizen;
import gr.hua.dit.ds.springbootdemo.entity.Secretary;
import gr.hua.dit.ds.springbootdemo.service.BloodDonationService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/blood-donation") //URL Path
public class BloodDonationController {

    @Autowired
    private BloodDonationService bloodDonationService; //Ενσωμάτωση του BloodDonationService

    @GetMapping("/citizens")
    public List<Citizen> getAllCitizens() {
        return bloodDonationService.getAllCitizens();
    } //HTTP GET αίτημα για επιστροφή λίστας πολιτών

    @GetMapping("/citizens/{id}")
    public Optional<Citizen> getCitizenById(@PathVariable int id) {
        return bloodDonationService.getCitizenById(id);
    } //HTTP GET αίτημα για επιστροφή πληροφοριών του πολίτη βάσει του id

    @GetMapping("/secretaries")
    public List<Secretary> getAllSecretaries() {
        return bloodDonationService.getAllSecretaries();
    } //HTTP GET αίτημα για επιστροφή λίστας των γραμματέων μέσω του bloodDonationService.

    @GetMapping("/secretaries/{id}")
    public Optional<Secretary> getSecretaryById(@PathVariable int id) {
        return bloodDonationService.getSecretaryById(id);
    } //HTTP GET αίτημα για πληροφορίες του-της γραμματέα βάσει του id

    @PostMapping("/citizens")
    public Citizen registerBloodDonor(@RequestBody Citizen citizen) {
        return bloodDonationService.registerBloodDonor(citizen);
    } //HTTP POST αίτημα για την εγγραφή νέου πολίτη/αιμοδότη

    @PutMapping("/process-donation/{citizenId}")
    public void processBloodDonationRequest(@PathVariable int citizenId) {
        bloodDonationService.processBloodDonationRequest(citizenId);
    } //HTTP PUT αίτημα γθα επεξεργασία αιτήματος αιμοδοσίας για τον πολίτη με βάση το id

    private List<Citizen> citizens = new ArrayList<Citizen>(); //Δημιουργία τριών αρχείων με ψευδο-δεδομένα
    File bloodChemistryTestFile = new File("C:\\Users\\Fotaras\\Desktop\\bloodtest1.txt");
    File bloodChemistryTestFile2 = new File("C:\\Users\\Fotaras\\Desktop\\bloodtest1.txt");
    File bloodChemistryTestFile3 = new File("C:\\Users\\Fotaras\\Desktop\\bloodtest1.txt");
    @PostConstruct
    public void setup() { //Αρχικοποίηση των πολιτών
        Citizen Cit1= new Citizen(1, "Fotis", "Mikos", "0Rz-","Ifigeneias 15 , Marousi",bloodChemistryTestFile);
        Citizen Cit2= new Citizen(2, "Apostolos", "Kalamaras", "A+" ,"Kykladwn 43 Xalandri",bloodChemistryTestFile2);
        Citizen Cit3= new Citizen(2,"John", "Stone", "B+","Papaflessa 25, Xolargos",bloodChemistryTestFile3);
        citizens.add(Cit1);
        citizens.add(Cit2);
        citizens.add(Cit3);
    }

}
