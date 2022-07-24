package africa.semicolon.trueCaller.services;

import africa.semicolon.trueCaller.dtos.requests.RegisterRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactServiceImplTest {
    private ContactService contactService;

    @BeforeEach
    void setUp() {
        contactService = new ContactServiceImpl();
    }

    @Test
    public void registerContactTest(){
        RegisterRequest request = new RegisterRequest();
        request.setEmail("Ade@email.com");
        request.setFirstName("Dee");
        request.setPhoneNumber("2209");
        request.setLastName("Adeh");
        request.setPassWord("passWord1");


        contactService.register(request);

        assertEquals(1, contactService.getNumberOfUsers());


    }
    @Test
    public void deleteContactTest(){
        RegisterRequest request = new RegisterRequest();
        request.setEmail("Ade@email.com");
        request.setFirstName("Dee");
        request.setPhoneNumber("2209");
        request.setLastName("Adeh");
        request.setPassWord("passWord1");


        contactService.register(request);
        contactService.delete(1);

        assertEquals(0, contactService.getNumberOfUsers());


    }
    @Test
    public void findContactByLastName(){
        RegisterRequest request = new RegisterRequest();
        RegisterRequest request2 = new RegisterRequest();
        ;

        request.setPhoneNumber("2209");
        request.setFirstName("Dee");
        request.setLastName("Ade");
        request.setEmail("Ade@email.com");

        request2.setPhoneNumber("0543");
        request2.setFirstName("Wonders");
        request2.setLastName("Adeh");
        request2.setEmail("Adeh@email.com");

        contactService.register(request);
        contactService.register(request2);

        assertEquals(1, contactService.getByLastName("Adeh").size());


    }
    @Test
    public void findContactByFirstName(){
        RegisterRequest request = new RegisterRequest();
        RegisterRequest request2 = new RegisterRequest();
        ;

        request.setPhoneNumber("2209");
        request.setFirstName("Dee");
        request.setLastName("Ade");
        request.setEmail("Ade@email.com");

        request2.setPhoneNumber("0543");
        request2.setFirstName("Wonders");
        request2.setLastName("Adeh");
        request2.setEmail("Adeh@email.com");

        contactService.register(request);
        contactService.register(request2);

        assertEquals(1, contactService.getByFirstName("Wonders").size());


    }
    @Test
    public void findAll(){
        RegisterRequest request = new RegisterRequest();
        RegisterRequest request2 = new RegisterRequest();
        ;

        request.setPhoneNumber("2209");
        request.setFirstName("Dee");
        request.setLastName("Ade");
        request.setEmail("Ade@email.com");

        request2.setPhoneNumber("0543");
        request2.setFirstName("Wonders");
        request2.setLastName("Adeh");
        request2.setEmail("Adeh@email.com");

        contactService.register(request);
        contactService.register(request2);

        assertEquals(2, contactService.findAll().size());


    }


}