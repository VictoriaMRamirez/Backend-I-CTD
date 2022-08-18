package Class5.Exercise1;

import java.util.Date;

public class Person {
    private String name;
    private String surname;
    private String dni;
    private String vaccineName;
    private Date assignedDate;

    public Person(String name, String surname, String dni, String vaccineName, Date assignedDate) {
        this.name = name;
        this.surname = surname;
        this.dni = dni;
        this.vaccineName = vaccineName;
        this.assignedDate = assignedDate;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getSurname() { return surname; }

    public void setSurname(String surname) { this.surname = surname; }

    public String getDni() { return dni; }

    public void setDni(String dni) { this.dni = dni; }

    public String getVaccineName() { return vaccineName; }

    public void setVaccineName(String vaccineName) { this.vaccineName = vaccineName; }

    public Date getAssignedDate() { return assignedDate; }

    public void setAssignedDate(Date assignedDate) { this.assignedDate = assignedDate; }
}
