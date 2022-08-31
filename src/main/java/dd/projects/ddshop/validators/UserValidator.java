package dd.projects.ddshop.validators;

import dd.projects.ddshop.dto.UserDTO;
import dd.projects.ddshop.exceptions.IllegalInputException;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class UserValidator {
    private boolean emailValidator(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);

        return pattern.matcher(email).matches();
    }

    public void validate(UserDTO userDTO) throws IllegalInputException {
        if (userDTO.getFirstName() == null) {
            throw new IllegalInputException("First name cannot be null");
        }

        if (userDTO.getLastName() == null) {
            throw new IllegalInputException("Last name cannot be null");
        }

        if (userDTO.getEmail() == null) {
            throw new IllegalInputException("Email cannot be null");
        }

        if (!emailValidator(userDTO.getEmail())) {
            throw new IllegalInputException("Email is not valid");
        }

        if (userDTO.getPhoneNumber() == null) {
            throw new IllegalInputException("Phone number cannot be null");
        }

        try {
            Integer.parseInt(userDTO.getPhoneNumber());
        } catch (NumberFormatException e) {
            throw new IllegalInputException("Phone number can only contain digits");
        }

        if (userDTO.getPassword() == null) {
            throw new IllegalInputException("Password cannot be null");
        }
    }
}
