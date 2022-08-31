package africa.semicolon.trueCaller.data.repositories;


import africa.semicolon.trueCaller.data.models.Contact;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContactRepositoryImplTest {

    @Test
    public void saveContact_CountIncreasesTest(){
        ContactRepository contactRepository = new ContactRepositoryImpl();
        Contact contact = new Contact();
        contact.setPhoneNumber("2209");
        contact.setFirstName("Dee");
        contact.setLastName("Ade");
        contact.setEmail("Ade@email.com");

        contactRepository.save(contact);
        assertEquals(1, contactRepository.count());
    }
    @Test
    public void saveContact_findByIndexTest(){
        ContactRepository contactRepository = new ContactRepositoryImpl();
        Contact contact = new Contact();
        contact.setPhoneNumber("2209");
        contact.setFirstName("Dee");
        contact.setLastName("Ade");
        contact.setEmail("Ade@email.com");

        contactRepository.save(contact);
        assertEquals(1, contactRepository.count());

        Contact savedContact = contactRepository.findById(1);
        assertEquals("Dee", savedContact.getFirstName());
    }
    @Test
    public void saveContact_deleteContactByIdTest() {
        ContactRepository contactRepository = new ContactRepositoryImpl();
        Contact contact = new Contact();

        contact.setPhoneNumber("2209");
        contact.setFirstName("Dee");
        contact.setLastName("Ade");
        contact.setEmail("Ade@email.com");


        contactRepository.save(contact);

        contactRepository.delete(1);
        assertEquals(0, contactRepository.count());

    }
    @Test
    public void saveContact_deleteContactByContactName(){
        ContactRepository contactRepository = new ContactRepositoryImpl();
        Contact contact = new Contact();
        Contact contact1 = new Contact();

        contact.setPhoneNumber("2209");
        contact.setFirstName("Dee");
        contact.setLastName("Ade");
        contact.setEmail("Ade@email.com");

        contact1.setPhoneNumber("0205");
        contact1.setFirstName("Wonders");
        contact1.setLastName("Adeh");
        contact1.setEmail("Wonders@email.com");

        contactRepository.save(contact);
        contactRepository.save(contact1);


        contactRepository.delete(contact);
        assertEquals(1, contactRepository.count());

        Contact deleteContact = contactRepository.findById(1);
        assertNull(deleteContact);
    }
    @Test
    public void saveContacts_findByFirstName(){
        ContactRepository contactRepository = new ContactRepositoryImpl();
        Contact contact = new Contact();
        Contact contact1 = new Contact();
        Contact contact2 = new Contact();



        contact.setPhoneNumber("2209");
        contact.setFirstName("Dee");
        contact.setLastName("Ade");
        contact.setEmail("Ade@email.com");

        contact1.setPhoneNumber("0205");
        contact1.setFirstName("Wonders");
        contact1.setLastName("Adeh");
        contact1.setEmail("Wonders@email.com");

        contact2.setPhoneNumber("0308");
        contact2.setFirstName("Wonders");
        contact2.setLastName("John");
        contact2.setEmail("Wondy@email.com");

        contactRepository.save(contact);
        contactRepository.save(contact1);
        contactRepository.save(contact2);

        assertEquals(3, contactRepository.count());

        assertEquals(2, contactRepository.findByFirstName("Wonders").size());


    }
    @Test
    public void saveContacts_findByLastName(){
        ContactRepository contactRepository = new ContactRepositoryImpl();
        Contact contact = new Contact();
        Contact contact1 = new Contact();
        Contact contact2 = new Contact();



        contact.setPhoneNumber("2209");
        contact.setFirstName("Dee");
        contact.setLastName("Ade");
        contact.setEmail("Ade@email.com");

        contact1.setPhoneNumber("0205");
        contact1.setFirstName("Wonders");
        contact1.setLastName("Adeh");
        contact1.setEmail("Wonders@email.com");

        contact2.setPhoneNumber("0308");
        contact2.setFirstName("Wonders");
        contact2.setLastName("John");
        contact2.setEmail("Wondy@email.com");

        contactRepository.save(contact);
        contactRepository.save(contact1);
        contactRepository.save(contact2);

        assertEquals(3, contactRepository.count());

        assertEquals(1, contactRepository.findByLastName("Ade").size());


    }
    @Test
    public void saveContacts_findAllContact(){
        ContactRepository contactRepository = new ContactRepositoryImpl();
        Contact contact = new Contact();
        Contact contact1 = new Contact();
        Contact contact2 = new Contact();



        contact.setPhoneNumber("2209");
        contact.setFirstName("Dee");
        contact.setLastName("Ade");
        contact.setEmail("Ade@email.com");

        contact1.setPhoneNumber("0205");
        contact1.setFirstName("Wonders");
        contact1.setLastName("Adeh");
        contact1.setEmail("Wonders@email.com");

        contact2.setPhoneNumber("0308");
        contact2.setFirstName("Wonders");
        contact2.setLastName("John");
        contact2.setEmail("Wondy@email.com");

        contactRepository.save(contact);
        contactRepository.save(contact1);
        contactRepository.save(contact2);

     //   assertEquals(3, contactRepository.count());

        assertEquals(3, contactRepository.findAll().size());


    }
    @Test
    public void updateContact(){
        ContactRepository contactRepository = new ContactRepositoryImpl();
        Contact contact = new Contact();
        Contact contact1 = new Contact();
        Contact newContact = new Contact();

        contact.setPhoneNumber("2209");
        contact.setFirstName("Dee");
        contact.setLastName("Ade");
        contact.setEmail("Ade@email.com");

        contact1.setPhoneNumber("0205");
        contact1.setFirstName("Wonders");
        contact1.setLastName("Adeh");
        contact1.setEmail("Wonders@email.com");

        contactRepository.save(contact);
        contactRepository.save(contact1);
        assertEquals(2, contactRepository.count());

        contact.setPhoneNumber("2209");
        contact.setFirstName("Josh");

        contactRepository.save(contact);
        assertEquals(2, contactRepository.count());

        Contact updatedContact = contactRepository.findById(1);
        assertEquals("Josh", updatedContact.getFirstName());



    }

}