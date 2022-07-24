package africa.semicolon.trueCaller.services;

import africa.semicolon.trueCaller.data.models.Contact;
import africa.semicolon.trueCaller.data.repositories.ContactRepository;
import africa.semicolon.trueCaller.data.repositories.ContactRepositoryImpl;
import africa.semicolon.trueCaller.dtos.requests.RegisterRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ContactServiceImpl implements ContactService{

    private ContactRepository contactRepository = new ContactRepositoryImpl();
    @Override
    public RegisterRequest register(RegisterRequest request) {
        Contact contact = new Contact();

        contact.setFirstName(request.getFirstName());
        contact.setLastName(request.getLastName());
        contact.setEmail(request.getEmail());
        contact.setPhoneNumber(request.getPhoneNumber());

        contactRepository.save(contact);

        return null;
    }

    @Override
    public int getNumberOfUsers() {
        return contactRepository.count();
    }

    @Override
    public void delete(int id) {
        contactRepository.delete(id);
        for (var findContact: contactRepository.findAll()) {
            if (id == findContact.getId()){
                contactRepository.delete(id);
            }
        }

    }

    @Override
    public List<Contact> getByLastName(String lastName) {
        contactRepository.findByLastName(lastName);
        for (var findLastName: contactRepository.findAll()){
            if(Objects.equals(lastName, findLastName.getLastName())){
                return contactRepository.findByLastName(lastName);
            }

        }
        return contactRepository.findAll();
    }

    @Override
    public List<Contact> getByFirstName(String firstName) {
        contactRepository.findByFirstName(firstName);
        for (var findFirstName: contactRepository.findAll()){
            if(Objects.equals(firstName, findFirstName.getFirstName())){
                return contactRepository.findByFirstName(firstName);
            }

        }
        return contactRepository.findAll();
    }

    @Override
    public List<Contact> findAll() {
        return contactRepository.findAll();
    }

}
