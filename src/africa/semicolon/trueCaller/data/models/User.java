package africa.semicolon.trueCaller.data.models;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Document

public class User {

    @Id
    private String id;
    private String firstName;
    private String lastName;

    private String username;

    private String email;

    private String password;

    @DBRef
    private List<Contact> allContacts = new ArrayList<>();



//    public void addContact(Contact contact){
//        allContacts.add(contact);
//    }
//
//    public void deleteContact(Contact contact){
//        allContacts.remove(contact);
//    }
//
//    public List<Contact> getAllContacts() {
//        return allContacts;
//    }
//
//    public int getId() {
//        return id;
//    }
//    public void setId(int id) {
//        this.id = id;
//    }
//
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//    public void setPassWord(String passWord) {
//        this.password = passWord;
//    }
//
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//
//    @Override
//    public String toString() {
//        return "User{" +
//                "id=" + id +
//                ", firstName='" + firstName + '\'' +
//                ", lastName='" + lastName + '\'' +
//                ", username='" + username + '\'' +
//                ", email='" + email + '\'' +
//                ", password='" + password + '\'' +
//                ", allContacts=" + allContacts +
//                '}';
//    }
}
