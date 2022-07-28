package africa.semicolon.trueCaller.utils;

import africa.semicolon.trueCaller.data.models.Contact;
import africa.semicolon.trueCaller.data.models.User;
import africa.semicolon.trueCaller.dtos.requests.AddContactRequest;
import africa.semicolon.trueCaller.dtos.requests.RegisterRequest;

public class Mapper {
    public static void map(RegisterRequest request, User user) {

        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        user.setPassWord(request.getPassWord());
    }
    public static void map(AddContactRequest addRequest, Contact contact) {

        contact.setEmail(addRequest.getEmail());
        contact.setPhoneNumber(addRequest.getPhoneNumber());
        contact.setFirstName(addRequest.getFirstName());
        contact.setLastName(addRequest.getLastName());

    }

}
