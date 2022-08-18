package Class17;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Contact contact1 = new Contact("Victoria", "victoria@gmail.com", 12345);
        Contact contact2 = new Contact("Micaela", "micaela@gmail.com", 67891);
        Contact contact3 = new Contact("Leonel", "leonel@gmail.com", 23456);
        List<Contact> contacts = new ArrayList<>();

        contacts.add(contact1);
        contacts.add(contact2);
        contacts.add(contact3);

        System.out.println(contacts);

        File contactsFile = new File("contactsFile.txt");

        try(FileOutputStream fileOutputStream = new FileOutputStream("contactsFile.txt", true);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
                objectOutputStream.writeObject(contacts);
        } catch(IOException ex) {
                ex.printStackTrace();
        }

        try {
            FileInputStream fileInputStream = new FileInputStream("contactsFile.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            System.out.println(objectInputStream.readObject());
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}
