package Class5.Exercise1;

public class VaccineRecord implements Record {

    @Override
    public String shot(Person person) {
        System.out.println("Checking information received...");
        return "Dni " + person.getDni() + " has been registered as a vaccinated person with " + person.getVaccineName();
    }
}
