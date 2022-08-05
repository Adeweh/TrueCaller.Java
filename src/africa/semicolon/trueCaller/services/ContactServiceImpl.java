package africa.semicolon.trueCaller.services;


import africa.semicolon.trueCaller.data.models.Contact;
import africa.semicolon.trueCaller.data.repositories.ContactRepository;
import africa.semicolon.trueCaller.data.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactServiceImpl implements ContactService{
    @Autowired

    private final ContactRepository contactRepository;

    public ContactServiceImpl(ContactRepository contactRepository){
        this.contactRepository = contactRepository;

    }


    @Override
    public Contact addNewContact(Contact contact) {
        return  contactRepository.save(contact);
    }

    @Override
    public int getNumberOfContacts() {
        return (int) contactRepository.count();
    }
}
