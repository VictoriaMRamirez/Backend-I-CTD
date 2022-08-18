package Class11.Exercise2;

public class Dentist {
    private Long id;
    private String surname;
    private String name;
    private String registrationNumber;

    public Dentist(String surname, String name, String registrationNumber) {
        this.surname = surname;
        this.name = name;
        this.registrationNumber = registrationNumber;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getSurname() { return surname; }

    public void setSurname(String surname) { this.surname = surname; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getRegistrationNumber() { return registrationNumber; }

    public String setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
        return registrationNumber;
    }

}
