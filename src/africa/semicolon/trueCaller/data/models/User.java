package africa.semicolon.trueCaller.data.models;

import java.util.ArrayList;
import java.util.List;

public class User {

    private int id;
    private String firstName;
    private String lastName;

    private String username;

    private String email;

    private String password;

    private final List<Contact> allContacts = new ArrayList<>();



    public void addContact(Contact contact){
        allContacts.add(contact);
    }

    public void deleteContact(Contact contact){
        allContacts.remove(contact);
    }

    public List<Contact> getAllContacts() {
        return allContacts;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassWord(String passWord) {
        this.password = passWord;
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


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
