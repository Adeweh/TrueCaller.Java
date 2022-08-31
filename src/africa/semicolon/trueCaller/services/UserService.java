package africa.semicolon.trueCaller.services;

import africa.semicolon.trueCaller.dtos.requests.AddContactRequest;
import africa.semicolon.trueCaller.dtos.requests.RegisterRequest;
import africa.semicolon.trueCaller.dtos.requests.responses.AddContactResponse;
import africa.semicolon.trueCaller.dtos.requests.responses.AllContactResponse;
import africa.semicolon.trueCaller.dtos.requests.responses.RegisterResponse;

import java.util.List;

public interface UserService {

    RegisterResponse register(RegisterRequest request);

    AddContactResponse addContact(AddContactRequest addRequest);



    int getNumberOfUsers();

    List<AllContactResponse> findContactsBelongingTo(String email);

}
