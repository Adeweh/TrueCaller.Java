package africa.semicolon.trueCaller;

import africa.semicolon.trueCaller.controllers.UserController;
import africa.semicolon.trueCaller.dtos.requests.AddContactRequest;
import africa.semicolon.trueCaller.dtos.requests.RegisterRequest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication

public class Main {

    private static final Scanner userInput = new Scanner(System.in);
    private static UserController userController = new UserController();

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
        displayMenu();
        //prompt user with menu
        //if user selects a, b, c direct them
    }

    private static void displayMenu() {
        String mainMenuPrompt = """
                Welcome to Fake Caller
                1-> Create an Account
                2-> Add Contact to a user
                3-> Find contact belonging to user
                """;
        System.out.println(mainMenuPrompt);
        String input = userInput.nextLine();

        switch (input.charAt(0)) {
            case '1' -> createAnAccount();
            case '2' -> addContactToAUser();
            case '3' -> findContactBelongingToUser();
        }
    }

    private static void findContactBelongingToUser() {
        var contacts = userController.findContactsBelongingTo("Enter your email");
        for(var contact: contacts){
            display(contact.toString());
        }
        contacts.forEach(contact -> display(contact.toString()));
        displayMenu();

    }

    private static void display(String message) {
        System.out.println(message);
    }

    private static void addContactToAUser() {
        AddContactRequest contactRequest = new AddContactRequest();

        contactRequest.setFirstName(keyboardInput("Enter contacts first name"));
        contactRequest.setLastName(keyboardInput("Enter contacts last name"));
        contactRequest.setPhoneNumber(keyboardInput("Enter contact phone"));
        contactRequest.setEmail(keyboardInput("Enter contact email"));
        contactRequest.setUserEmail(keyboardInput("Enter your email"));

        userController.addContact(contactRequest);
        displayMenu();


    }

    private static void createAnAccount() {
        RegisterRequest request = new RegisterRequest();

        request.setFirstName(keyboardInput("Enter first name"));
        request.setLastName(keyboardInput("Enter last name"));
        request.setPhoneNumber(keyboardInput("Enter phone:"));
        request.setEmail(keyboardInput("Enter email"));
        request.setPassWord(keyboardInput("Enter password"));

        userController.registerUser(request);
        System.out.println("done");
        displayMenu();


    }

    public static String keyboardInput(String prompt){
        System.out.println(prompt);
        return userInput.nextLine();
    }
}
