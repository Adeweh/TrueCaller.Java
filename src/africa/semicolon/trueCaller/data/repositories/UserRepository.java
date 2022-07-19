package africa.semicolon.trueCaller.data.repositories;

import africa.semicolon.trueCaller.data.models.Contact;
import africa.semicolon.trueCaller.data.models.User;

import java.util.List;

public interface UserRepository {
    User save(User user);
    void delete(User user);
    void  delete(int id);
    User findById(int id);

    List<User> findByFirstName(String firstName);
    List<User> findByLastName(String lastName);
    List<User> findAll();

    int count();

}
