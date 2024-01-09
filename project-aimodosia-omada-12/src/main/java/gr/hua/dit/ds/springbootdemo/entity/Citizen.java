package gr.hua.dit.ds.springbootdemo.entity;


import gr.hua.dit.ds.springbootdemo.service.BloodDonationService;

public class Citizen {
    private boolean bloodDonor;
    private boolean bloodDonationRequestProcessed;
    private int successfulDonations;
    private Integer Id;
    private String firstName;
    private String lastName;
    private String bloodGroup; // Προσθήκη πεδίου για την ομάδα αίματος
    // Άλλα πεδία που μπορεί να χρειάζεστε για τον πολίτη

    public Citizen(Integer id, String firstName, String lastName, String bloodGroup) {
        Id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.bloodGroup = bloodGroup;
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
    public boolean eligibleForBloodDonation(BloodDonationService bloodDonationService) {
        return bloodDonationService.eligibleForBloodDonation(this);
    }

    @Override
    public String toString() {
        return "Citizen{" +
                "Id=" + Id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", bloodGroup='" + bloodGroup + '\'' +
                // Προσθήκη πεδίων στο toString
                '}';
    }
}