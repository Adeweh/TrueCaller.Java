package africa.semicolon.trueCaller.data.repositories;

import africa.semicolon.trueCaller.data.models.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryImplTest {

    @Test
    public void saveUser_CountIncreasesTest(){
        UserRepository userRepository = new UserRepositoryImpl();
        User user = new User();
        user.setPhoneNumber("2209");
        user.setFirstName("Dee");
        user.setLastName("Ade");
        user.setEmail("Ade@email.com");

        userRepository.save(user);
        assertEquals(1, userRepository.count());
    }
    @Test
    public void saveUser_findByIndexTest(){
        UserRepository userRepository = new UserRepositoryImpl();
        User user = new User();
        user.setPhoneNumber("2209");
        user.setFirstName("Dee");
        user.setLastName("Ade");
        user.setEmail("Ade@email.com");

        userRepository.save(user);

        User savedUser = userRepository.findById(1);
        assertEquals("Ade", savedUser.getLastName());

    }
    @Test
    public void deleteUSer_CountDecreasesTest(){
        UserRepository userRepository = new UserRepositoryImpl();
        User user = new User();
        user.setPhoneNumber("2209");
        user.setFirstName("Dee");
        user.setLastName("Ade");
        user.setEmail("Ade@email.com");

        userRepository.save(user);

        userRepository.delete(user);
        assertEquals(0, userRepository.count());

    }
    @Test
    public void deleteUser_byIndexTest(){
        UserRepository userRepository = new UserRepositoryImpl();
        User user = new User();
        user.setPhoneNumber("2209");
        user.setFirstName("Dee");
        user.setLastName("Ade");
        user.setEmail("Ade@email.com");

        userRepository.save(user);

        userRepository.delete(1);

        User savedUser = userRepository.findById(1);
        assertEquals(0, userRepository.count());

    }
    @Test
    public void deleteUser_byContactTest(){
        UserRepository userRepository = new UserRepositoryImpl();
        User user = new User();
        User user1 = new User();

        user.setPhoneNumber("2209");
        user.setFirstName("Dee");
        user.setLastName("Ade");
        user.setEmail("Ade@email.com");

        user1.setPhoneNumber("0543");
        user1.setFirstName("Wonders");
        user1.setLastName("Adeh");
        user1.setEmail("Adeh@email.com");

        userRepository.save(user);
        userRepository.save(user1);

        userRepository.delete(user1);
        assertEquals(1, userRepository.count());

        User deleteUser = userRepository.findById(2);
        assertNull(deleteUser);

    }
    @Test
    public void findUser_byFirstNameTest(){
        UserRepository userRepository = new UserRepositoryImpl();
        User user = new User();
        User user1 = new User();

        user.setPhoneNumber("2209");
        user.setFirstName("Dee");
        user.setLastName("Ade");
        user.setEmail("Ade@email.com");

        user1.setPhoneNumber("0543");
        user1.setFirstName("Wonders");
        user1.setLastName("Adeh");
        user1.setEmail("Adeh@email.com");

        userRepository.save(user);
        userRepository.save(user1);

        assertEquals(1, userRepository.findByFirstName("Dee").size());

    }
    @Test
    public void findUser_byLastNameTest(){
        UserRepository userRepository = new UserRepositoryImpl();
        User user = new User();
        User user1 = new User();

        user.setPhoneNumber("2209");
        user.setFirstName("Dee");
        user.setLastName("Ade");
        user.setEmail("Ade@email.com");

        user1.setPhoneNumber("0543");
        user1.setFirstName("Wonders");
        user1.setLastName("Adeh");
        user1.setEmail("Adeh@email.com");

        userRepository.save(user);
        userRepository.save(user1);

        assertEquals(1, userRepository.findByLastName("Adeh").size());

    }
    @Test
    public void findAllUsers(){
        UserRepository userRepository = new UserRepositoryImpl();
        User user = new User();
        User user1 = new User();

        user.setPhoneNumber("2209");
        user.setFirstName("Dee");
        user.setLastName("Ade");
        user.setEmail("Ade@email.com");

        user1.setPhoneNumber("0543");
        user1.setFirstName("Wonders");
        user1.setLastName("Adeh");
        user1.setEmail("Adeh@email.com");

        userRepository.save(user);
        userRepository.save(user1);

        assertEquals(2, userRepository.findAll().size());

    }
    @Test
    public void updateUsers(){
        UserRepository userRepository = new UserRepositoryImpl();
        User user = new User();
        User user1 = new User();

        user.setPhoneNumber("2209");
        user.setFirstName("Dee");
        user.setLastName("Ade");
        user.setEmail("Ade@email.com");

        user1.setPhoneNumber("0543");
        user1.setFirstName("Wonders");
        user1.setLastName("Adeh");
        user1.setEmail("Adeh@email.com");

        userRepository.save(user);
        userRepository.save(user1);

        user.setPhoneNumber("0543");
        user.setLastName("Josh");

        userRepository.save(user);
        assertEquals(2, userRepository.count());

        User updatedUser = userRepository.findById(1);
        assertEquals("Josh", updatedUser.getLastName());

    }








}