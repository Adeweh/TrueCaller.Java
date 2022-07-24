package africa.semicolon.trueCaller.services;

import africa.semicolon.trueCaller.data.models.Contact;
import africa.semicolon.trueCaller.dtos.requests.RegisterRequest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public interface ContactService {
    RegisterRequest register(RegisterRequest request);

    int getNumberOfUsers();

    void delete(int request);

    List<Contact> getByLastName(String lastName);

    List<Contact> getByFirstName(String firstName);

    List<Contact> findAll();
}
