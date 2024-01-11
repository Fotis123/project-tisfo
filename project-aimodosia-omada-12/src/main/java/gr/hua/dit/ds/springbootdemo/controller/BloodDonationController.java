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
@RequestMapping("/api/blood-donation")
public class BloodDonationController {

    @Autowired
    private BloodDonationService bloodDonationService;

    @GetMapping("/citizens")
    public List<Citizen> getAllCitizens() {
        return bloodDonationService.getAllCitizens();
    }

    @GetMapping("/citizens/{id}")
    public Optional<Citizen> getCitizenById(@PathVariable int id) {
        return bloodDonationService.getCitizenById(id);
    }

    @GetMapping("/secretaries")
    public List<Secretary> getAllSecretaries() {
        return bloodDonationService.getAllSecretaries();
    }

    @GetMapping("/secretaries/{id}")
    public Optional<Secretary> getSecretaryById(@PathVariable int id) {
        return bloodDonationService.getSecretaryById(id);
    }

    @PostMapping("/citizens")
    public Citizen registerBloodDonor(@RequestBody Citizen citizen) {
        return bloodDonationService.registerBloodDonor(citizen);
    }

    @PutMapping("/process-donation/{citizenId}")
    public void processBloodDonationRequest(@PathVariable int citizenId) {
        bloodDonationService.processBloodDonationRequest(citizenId);
    }

    private List<Citizen> citizens = new ArrayList<Citizen>();
    File bloodChemistryTestFile = new File("C:\\Users\\Fotaras\\Desktop\\bloodtest1.txt");
    File bloodChemistryTestFile2 = new File("C:\\Users\\Fotaras\\Desktop\\bloodtest1.txt");
    File bloodChemistryTestFile3 = new File("C:\\Users\\Fotaras\\Desktop\\bloodtest1.txt");
    @PostConstruct
    public void setup() {
        Citizen Cit1= new Citizen(1, "Fotis", "Mikos", "0Rz-","Ifigeneias 15 , Marousi",bloodChemistryTestFile);
        Citizen Cit2= new Citizen(2, "Apostolos", "Kalamaras", "A+" ,"Kykladwn 43 Xalandri",bloodChemistryTestFile2);
        Citizen Cit3= new Citizen(2,"John", "Stone", "B+","Papaflessa 25, Xolargos",bloodChemistryTestFile3);
        citizens.add(Cit1);
        citizens.add(Cit2);
        citizens.add(Cit3);
    }

}
