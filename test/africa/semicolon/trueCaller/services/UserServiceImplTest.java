package africa.semicolon.trueCaller.services;

import africa.semicolon.trueCaller.data.models.User;
import africa.semicolon.trueCaller.data.repositories.UserRepository;
import africa.semicolon.trueCaller.data.repositories.UserRepositoryImpl;
import africa.semicolon.trueCaller.dtos.requests.RegisterRequest;
import africa.semicolon.trueCaller.exceptions.UserExistsException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserServiceImplTest {
    private UserService userService;

    @BeforeEach
    void setUp() {
        userService = new UserServiceImpl();

    }

    @Test
    public void registerTest(){

        //given
        //there is a request form
        RegisterRequest request = new RegisterRequest();
        request.setEmail("Ade@email.com");
        request.setFirstName("Dee");
        request.setPhoneNumber("2209");
        request.setLastName("Adeh");
        request.setPassWord("passWord1");
        //when

        userService.register(request);
        //i try to register
        //assert
        //repository size is one
        assertEquals(1, userService.getNumberOfUsers());
    }

    @Test
    public  void duplicateEmailThrowsExceptionTest(){
        //duplicateUsers
        RegisterRequest request = new RegisterRequest();

        request.setEmail("Ade@email.com");
        request.setFirstName("Dee");
        request.setPhoneNumber("2209");
        request.setLastName("Adeh");
        request.setPassWord("passWord1");

        userService.register(request);


        assertThrows(UserExistsException.class, ()-> userService.register(request));
        assertEquals(1, userService.getNumberOfUsers());

    }
    @Test
    public void deleteTest(){
        RegisterRequest request = new RegisterRequest();
        request.setEmail("Ade@email.com");
        request.setFirstName("Dee");
        request.setPhoneNumber("2209");
        request.setLastName("Adeh");
        request.setPassWord("passWord1");

        userService.register(request);

        userService.delete(1);

        assertEquals(0, userService.getNumberOfUsers());

    }
    @Test
    public void registerMultipleTest(){

        //given
        //there is a request form
        RegisterRequest request = new RegisterRequest();
        request.setEmail("Ade@email.com");
        request.setFirstName("Dee");
        request.setPhoneNumber("2209");
        request.setLastName("Adeh");
        request.setPassWord("passWord1");

        RegisterRequest request2 = new RegisterRequest();
        request2.setEmail("Adeh@email.com");
        request2.setFirstName("Wonders");
        request2.setPhoneNumber("0205");
        request2.setLastName("Adeweh");
        request2.setPassWord("passWord2");
        //when

        userService.register(request);
        userService.register(request2);
        //i try to register
        //assert
        //repository size is one
        assertEquals(2, userService.getNumberOfUsers());
    }
    @Test
    public void findUserByFirstName(){
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

        userService.register(request);
        userService.register(request2);

        assertEquals(1, userService.getByFirstName("Dee").size());



    }
    @Test
    public void findUserByLastName(){
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

        userService.register(request);
        userService.register(request2);

        assertEquals(1, userService.getByLastName("Adeh").size());


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

        userService.register(request);
        userService.register(request2);

        assertEquals(2, userService.findAll().size());


    }



}