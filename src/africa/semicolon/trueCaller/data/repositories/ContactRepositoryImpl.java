package africa.semicolon.trueCaller.data.repositories;

import africa.semicolon.trueCaller.data.models.Contact;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ContactRepositoryImpl implements ContactRepository{
    private int counter;

    private List<Contact> contacts = new ArrayList<>();
    @Override
    public Contact save(Contact contact) {
        for(var update: contacts){
            if (contact.getId() == update.getId()){
                update = contact;
                return update;
            }

        }
//        Contact foundContact = findById(contact.getId());
//        if (foundContact != null){
//            foundContact.setPhoneNumber(contact.getPhoneNumber());
//
//    }
        counter++;
        contact.setId(counter);
        contacts.add(contact);
        return contact;
    }

    @Override
    public void delete(Contact contact) {
        contacts.remove(contact);

    }

    @Override
    public void delete(int id) {
        Contact foundContact = findById(id);
        contacts.remove(foundContact);
      // contacts.remove(id - 1);

    }

    @Override
    public Contact findById(int id) {
        for(var contact: contacts){
            if (contact.getId() == id){
            return contact;
            }
        }
        return null;
    }

    @Override
    public List<Contact> findByFirstName(String firstName) {
        List<Contact> firstNameContacts = new ArrayList<>();
        for (var findContacts: contacts){
            if(Objects.equals(findContacts.getFirstName(), firstName)){
                firstNameContacts.add(findContacts);
            }

        }
        return firstNameContacts;
    }

    @Override
    public List<Contact> findByLastName(String lastName) {
        List<Contact> lastNameContacts = new ArrayList<>();
        for (var findContacts: contacts) {
            if(Objects.equals(findContacts.getLastName(), lastName)){
                lastNameContacts.add(findContacts);
            }

        }
        return lastNameContacts;
    }

    @Override
    public List<Contact> findAll() {
        return contacts;
    }

    @Override
    public int count() {
        return contacts.size();
    }
}
