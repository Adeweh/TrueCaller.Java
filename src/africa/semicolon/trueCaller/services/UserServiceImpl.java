package africa.semicolon.trueCaller.services;

import africa.semicolon.trueCaller.data.models.Contact;
import africa.semicolon.trueCaller.data.models.User;
import africa.semicolon.trueCaller.data.repositories.UserRepository;
import africa.semicolon.trueCaller.dtos.requests.AddContactRequest;
import africa.semicolon.trueCaller.dtos.requests.RegisterRequest;
import africa.semicolon.trueCaller.dtos.requests.responses.AddContactResponse;
import africa.semicolon.trueCaller.dtos.requests.responses.RegisterResponse;
import africa.semicolon.trueCaller.exceptions.UserExistsException;
import africa.semicolon.trueCaller.utils.Mapper;


import java.util.List;


public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private ContactService contactService;


    public UserServiceImpl(UserRepository userRepository, ContactService contactService){
        this.userRepository = userRepository;
        this.contactService = contactService;
    }

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
        return userRepository.count();
    }

    @Override
    public List<Contact> findContactsBelongingTo(String email) {
        User user = userRepository.findByEmail(email);
        return user.getAllContacts();
    }

    @Override
    public AddContactResponse addContact(AddContactRequest addRequest){
        Contact contact = new Contact();

        Mapper.map(addRequest, contact);
        Contact newContact = contactService.addNewContact(contact);

        User user = userRepository.findByEmail(addRequest.getUserEmail());
        user.getAllContacts().add(newContact);

        userRepository.save(user);
        return null;
    }


}