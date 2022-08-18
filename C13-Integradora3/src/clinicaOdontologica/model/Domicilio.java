package clinicaOdontologica.model;

public class Domicilio {
    private int id;
    private String calle;
    private int numero;
    private String localidad;
    private String provincia;

    public Domicilio(int id, String calle, int numero, String localidad, String provincia) {
        this.id = id;
        this.calle = calle;
        this.numero = numero;
        this.localidad = localidad;
        this.provincia = provincia;
    }

    public Domicilio(String calle, int numero, String localidad, String provincia) {
        this.calle = calle;
        this.numero = numero;
        this.localidad = localidad;
        this.provincia = provincia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCalle() {
        return calle;
    }

    public int getNumero() {
        return numero;
    }

    public String getLocalidad() {
        return localidad;
    }

    public String getProvincia() {
        return provincia;
    }

    @Override
    public String toString() {
        return "ID: " + id + "\n" +
                "CALLE: " + calle + "\n" +
                "NÚMERO: " + numero + "\n" +
                "LOCALIDAD: " + localidad + "\n" +
                "PROVINCIA: " + provincia;
    }
}
