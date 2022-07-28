package africa.semicolon.trueCaller.data.repositories;

import africa.semicolon.trueCaller.data.models.Contact;
import africa.semicolon.trueCaller.data.models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserRepositoryImpl implements UserRepository {
    private int counter;

    private ArrayList<User> allUsers = new ArrayList<>();
    @Override
    public User save(User user) {
        for (var update: allUsers) {
            if (user.getId() == update.getId()) {
                update = user;
                return update;
            }
        }
            counter++;
            user.setId(counter);
            allUsers.add(user);
            return user;
        }

    @Override
    public void delete(User user) {
        allUsers.remove(user);

    }

    @Override
    public void delete(int id) {
        User foundUser = findById(id);
        allUsers.remove(foundUser);

    }

    @Override
    public User findById(int id) {
        for(var user: allUsers) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    @Override
    public List<User> findByFirstName(String firstName) {
        List<User> firstNameUser = new ArrayList<>();
        for (var findUser: allUsers){
            if(Objects.equals(findUser.getFirstName(), firstName)){
                firstNameUser.add(findUser);
            }

        }
        return firstNameUser;
    }

    @Override
    public List<User> findByLastName(String lastName) {
        List<User> lastNameUser = new ArrayList<>();
        for (var findUser: allUsers){
            if(Objects.equals(findUser.getLastName(), lastName)){
                lastNameUser.add(findUser);
            }

        }
        return lastNameUser;
    }

    @Override
    public List<User> findAll() {
        return allUsers;
    }

    @Override
    public int count() {
        return allUsers.size();
    }

    @Override
    public User findByEmail(String email) {
        for (var user: allUsers) {
            if (user.getEmail().equalsIgnoreCase(email)){
                return user;
        }
        }
        return null;
    }
}
