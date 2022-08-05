package africa.semicolon.trueCaller.services;

import africa.semicolon.trueCaller.data.models.Contact;
import africa.semicolon.trueCaller.data.models.User;
import africa.semicolon.trueCaller.data.repositories.UserRepository;
import africa.semicolon.trueCaller.dtos.requests.AddContactRequest;
import africa.semicolon.trueCaller.dtos.requests.RegisterRequest;
import africa.semicolon.trueCaller.dtos.requests.responses.AddContactResponse;
import africa.semicolon.trueCaller.dtos.requests.responses.RegisterResponse;
import africa.semicolon.trueCaller.dtos.requests.responses.AllContactResponse;
import africa.semicolon.trueCaller.exceptions.UserExistsException;
import africa.semicolon.trueCaller.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired

    private final UserRepository userRepository;

    private RegisterResponse response = new RegisterResponse();

    @Autowired

    private final ContactService contactService;


    public UserServiceImpl(UserRepository userRepository, ContactService contactService){
        this.userRepository = userRepository;
        this.contactService = contactService;
    }

//    public  UserServiceImpl(){
//        this.userRepository = new UserRepositoryImpl();
//        ContactRepository contactRepository = new ContactRepositoryImpl();
//        this.contactService = new ContactServiceImpl(contactRepository);
//    }

    @Override
    public RegisterResponse register(RegisterRequest request) {
        isExist(request);

        User user = new User();
        Mapper.map(request, user);

        userRepository.save(user);

        RegisterResponse response = new RegisterResponse();
        response.setMessage("Registration successful!");

        return response;

    }
    private void isExist(RegisterRequest request) {
        User savedUser = userRepository.findByEmail(request.getEmail());
        if (savedUser != null) throw new UserExistsException(request.getEmail() + "already exists");
    }
    @Override
    public int getNumberOfUsers() {
        return (int) userRepository.count();
    }

    @Override
    public List<AllContactResponse> findContactsBelongingTo(String email) {
        User user = userRepository.findByEmail(email);
        List<Contact> userContacts = user.getAllContacts();
        List<AllContactResponse> responses = new ArrayList<>();
        userContacts.forEach(contact -> {
            AllContactResponse singleResponse = new AllContactResponse();
            Mapper.map(singleResponse, contact);
            responses.add(singleResponse);
        });
        return responses;
    }

    @Override
    public AddContactResponse addContact(AddContactRequest addRequest){
        Contact contact = new Contact();

        Mapper.map(addRequest, contact);
        Contact newContact = contactService.addNewContact(contact);

        User user = userRepository.findByEmail(addRequest.getUserEmail());
        user.getAllContacts().add(newContact);

        userRepository.save(user);
        
        AddContactResponse contactResponse = new AddContactResponse();
        contactResponse.setMessage(String.format("%s successfully added.", addRequest.getFirstName()));
        return contactResponse;
        
        
    }


}