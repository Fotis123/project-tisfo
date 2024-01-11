package gr.hua.dit.ds.springbootdemo.entity;

public class Secretary {
    //πεδία για τον/την γραμματέα
    private Integer Id;
    private String firstName;
    private String lastName;

    //Constructor του/της γραμματέα
    public Secretary(Integer id, String firstName, String lastName) {
        Id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    //Getters Setters για το κάθε πεδίο
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

    @Override
    public String toString() { //toString μέθοδος για ανασύνταξη των δεδομένων
        return "Secretary{" +
                "Id=" + Id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
