package Class17;

import java.io.Serializable;

public class Contact implements Serializable {
    private String name;
    private String email;
    private Integer telephone;

    public Contact(String name, String email, Integer telephone) {
        this.name = name;
        this.email = email;
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", telephone=" + telephone +
                '}';
    }
}
