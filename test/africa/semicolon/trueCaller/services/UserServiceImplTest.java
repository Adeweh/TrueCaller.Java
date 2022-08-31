package africa.semicolon.trueCaller.services;


import africa.semicolon.trueCaller.data.repositories.ContactRepository;
import africa.semicolon.trueCaller.data.repositories.UserRepository;
import africa.semicolon.trueCaller.dtos.requests.AddContactRequest;
import africa.semicolon.trueCaller.dtos.requests.RegisterRequest;
import africa.semicolon.trueCaller.exceptions.UserExistsException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserServiceImplTest {
    UserService userService;
    RegisterRequest request;
    AddContactRequest addRequest;
    ContactService contactService;
    UserRepository userRepository;

    ContactRepository contactRepository;


    @BeforeEach
    void setUp() {
        contactRepository = new ContactRepositoryImpl();
        contactService = new ContactServiceImpl(contactRepository);
        userRepository = new UserRepositoryImpl();
        userService = new UserServiceImpl(userRepository, contactService);
        addRequest = new AddContactRequest();



        request = new RegisterRequest();
        request.setEmail("dee@gmail.com");
        request.setFirstName("Dee");
        request.setLastName("Adeh");
        request.setUsername("Adeweh1");
        request.setPassWord("Adeweh123");

    }

    @Test
    public void registerTest(){
        userService.register(request);
        assertEquals(1, userService.getNumberOfUsers());

        //given
        //there is a request form
        //when

        //i try to register
        //assert
        //repository size is one
    }

    @Test
    public  void duplicateEmailThrowsExceptionTest(){
        //duplicateUsers
        userService.register(request);

        RegisterRequest request1 = new RegisterRequest();

        request1.setEmail("dee@gmail.com");
        request1.setFirstName("Adeweh");
        request1.setLastName("Abang");
        request1.setUsername("Adeh");
        request1.setPassWord("Abang124");


        assertThrows(UserExistsException.class, ()-> userService.register(request1));
        assertEquals(1, userService.getNumberOfUsers());

    }
    @Test
    public void addContactTest(){
        //given that i have a user
        userService.register(request);

        addRequest.setEmail("Ade@email.com");
        addRequest.setFirstName("Dee");
        addRequest.setLastName("Adeweh");
        addRequest.setPhoneNumber("2209");
        addRequest.setUserEmail(request.getEmail());

        userService.addContact(addRequest);

        assertEquals(1, userService.findContactsBelongingTo("dee@gmail.com").size());
        assertEquals(1, contactService.getNumberOfContacts());
        //when i add a contact
        //check that contact size has increased

    }





}