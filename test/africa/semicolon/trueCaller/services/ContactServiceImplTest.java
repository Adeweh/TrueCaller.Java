package africa.semicolon.trueCaller.services;

import africa.semicolon.trueCaller.data.models.Contact;
import africa.semicolon.trueCaller.data.repositories.ContactRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContactServiceImplTest {
    ContactService contactService;
    ContactRepository contactRepository;
    Contact contact;

    @BeforeEach
    void setUp(){

        contactRepository = new ContactRepositoryImpl();
        contact = new Contact();
        contactService = new ContactServiceImpl(contactRepository);

        contact.setEmail("Adeweh@gmail.com");
        contact.setFirstName("Dee");
        contact.setLastName("Abang");
        contact.setPhoneNumber("07062828140");

    }
    @Test
    public void addContactTest(){

        contactService.addNewContact(contact);

        assertEquals(1, contactService.getNumberOfContacts());
    }

}