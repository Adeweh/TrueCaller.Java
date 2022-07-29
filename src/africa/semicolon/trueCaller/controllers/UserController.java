package africa.semicolon.trueCaller.controllers;

import africa.semicolon.trueCaller.data.models.Contact;
import africa.semicolon.trueCaller.dtos.requests.AddContactRequest;
import africa.semicolon.trueCaller.dtos.requests.RegisterRequest;
import africa.semicolon.trueCaller.dtos.requests.responses.AddContactResponse;
import africa.semicolon.trueCaller.dtos.requests.responses.RegisterResponse;
import africa.semicolon.trueCaller.services.UserService;
import africa.semicolon.trueCaller.services.UserServiceImpl;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Component
@RestController
public class UserController {

    private UserService userService = new UserServiceImpl();

    @PostMapping("/user")
    public RegisterResponse registerUser(@RequestBody RegisterRequest registerRequest){
        return  userService.register(registerRequest);
    }
    @PatchMapping("/user")
    public AddContactResponse addContact(@RequestBody AddContactRequest addContactRequest){
        return userService.addContact(addContactRequest);
    }

    @GetMapping("/user/{emails}")
    public List<Contact> findContactsBelongingTo(@PathVariable("emails") String email){
        return  userService.findContactsBelongingTo(email);
    }

}
