package africa.semicolon.trueCaller.services;

import africa.semicolon.trueCaller.data.models.Contact;
import africa.semicolon.trueCaller.data.models.User;
import africa.semicolon.trueCaller.data.repositories.UserRepository;
import africa.semicolon.trueCaller.data.repositories.UserRepositoryImpl;
import africa.semicolon.trueCaller.dtos.requests.RegisterRequest;
import africa.semicolon.trueCaller.dtos.requests.responses.RegisterResponse;
import africa.semicolon.trueCaller.exceptions.UserExistsException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserServiceImpl implements UserService {

    private UserRepository userRepository = new UserRepositoryImpl();
    @Override
    public RegisterResponse register(RegisterRequest request) {
        //check if email exists in repository and throw exception
        //create a new user
        //copy fields from request to new user
        //save new user into repository
        User savedUser = userRepository.findByEmail(request.getEmail());
        if (savedUser != null) throw new UserExistsException(request.getEmail() + "already exists");
        User user = new User();

        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        user.setPhoneNumber(request.getPhoneNumber());
        user.setPassWord(request.getPassWord());

        userRepository.save(user);

        return null;

    }
    @Override
    public int getNumberOfUsers() {

        return userRepository.count();
    }

    @Override
    public void delete(int request) {
        User foundUser = userRepository.findById(request);
        userRepository.delete(foundUser);

    }

    @Override
    public List<User> getByFirstName(String firstName) {
        userRepository.findByFirstName(firstName);
        for (var findFirstName: userRepository.findAll()) {
            if (Objects.equals(findFirstName.getFirstName(), firstName)){
                return userRepository.findByFirstName(firstName);
            }
        }

        return userRepository.findAll();
    }

    @Override
    public List<User> getByLastName(String lastName) {
        userRepository.findByFirstName(lastName);
        for (var findLastName: userRepository.findAll()) {
            if (Objects.equals(findLastName.getLastName(), lastName)){
                return userRepository.findByLastName(lastName);
            }
        }

        return userRepository.findAll();

    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
