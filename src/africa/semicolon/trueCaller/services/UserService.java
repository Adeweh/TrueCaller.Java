package africa.semicolon.trueCaller.services;

import africa.semicolon.trueCaller.data.models.Contact;
import africa.semicolon.trueCaller.data.models.User;
import africa.semicolon.trueCaller.dtos.requests.RegisterRequest;
import africa.semicolon.trueCaller.dtos.requests.responses.RegisterResponse;

import java.util.Collection;
import java.util.List;

public interface UserService {

    RegisterResponse register(RegisterRequest request);


    int getNumberOfUsers();

    void delete(int id);

    List<User> getByFirstName(String firstName);

    List<User> getByLastName(String lastName);

    List<User> findAll();
}
