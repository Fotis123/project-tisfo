package gr.hua.dit.ds.springbootdemo.controller;
import gr.hua.dit.ds.springbootdemo.entity.Citizen;
import gr.hua.dit.ds.springbootdemo.entity.Secretary;
import gr.hua.dit.ds.springbootdemo.service.BloodDonationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    // Εδώ μπορώ να προσθέσω και άλλες μεθόδους  για την αιμοδοσία
}
