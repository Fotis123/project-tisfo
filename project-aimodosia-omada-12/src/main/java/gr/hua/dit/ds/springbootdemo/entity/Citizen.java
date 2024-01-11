package gr.hua.dit.ds.springbootdemo.entity;


import gr.hua.dit.ds.springbootdemo.service.BloodDonationService;
import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails;

import java.io.File;
import java.time.LocalDate;
import java.util.Date;

public class Citizen {
    //Στοιχεία του πολίτη
    private boolean bloodDonor;
    private boolean bloodDonationRequestProcessed;
    private Integer successfulDonations;
    private Integer Id;
    private String firstName;
    private String lastName;
    private String Address;
    private String bloodGroup;
    private LocalDate lastBloodDonation;
    private File BloodChemistryTest;

    //Constructor για τον πολίτη
    public Citizen(Integer id, String firstName, String lastName, String bloodGroup, String Address, File BloodChemistryTest) {
        Id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.bloodGroup = bloodGroup;
        this.Address = Address;
        this.BloodChemistryTest = BloodChemistryTest;
    }
    //Setters Getters για το κάθε πεδίο
    public LocalDate getLastBloodDonation() {
        return lastBloodDonation;
    }

    public void setLastBloodDonation(LocalDate lastBloodDonation) {
        this.lastBloodDonation = lastBloodDonation;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress(){
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public File getBloodChemistryTest() {
        return BloodChemistryTest;
    }

    public void setBloodChemistryTest(File bloodChemistryTest) {
        BloodChemistryTest = bloodChemistryTest;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }
    public void setBloodDonor(boolean bloodDonor) {
        this.bloodDonor = bloodDonor;
    }

    public void setBloodDonationRequestProcessed(boolean bloodDonationRequestProcessed) {
        this.bloodDonationRequestProcessed = bloodDonationRequestProcessed;
    }

    public int getSuccessfulDonations() {
        return successfulDonations;
    }
    // Καλεί την μέθοδο eligibleForBloodDonation του BloodDonationService
    public boolean eligibleForBloodDonation(BloodDonationService bloodDonationService) { //Έλεγχος για καταλληλότητα πολίτη για αιμοδοσία
        return bloodDonationService.eligibleForBloodDonation(this);
    }

    @Override
    public String toString() { //toString μέθοδος για ανασύνταξη των δεδομένων του πολίτη
        return "Citizen{" +
                "Id=" + Id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", bloodGroup='" + bloodGroup + '\'' +
                ", Address='" + Address + '\'' +
                ", BloodChemistryTest='" + BloodChemistryTest +
                '}';
    }
}