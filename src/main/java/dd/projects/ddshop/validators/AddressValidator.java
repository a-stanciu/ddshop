package dd.projects.ddshop.validators;

import dd.projects.ddshop.dto.AddressDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
@RequiredArgsConstructor
public class AddressValidator {
    private final MessageSource messageSource;

    public void validate(AddressDTO addressDTO) throws Exception {
        if (addressDTO.getStreetLine() == null) {
            throw new Exception(messageSource.getMessage("validator.error.street.null", null, Locale.ENGLISH));
        }

        if (addressDTO.getPostalCode() == null) {
            throw new Exception(messageSource.getMessage("validator.error.postal.code.null", null, Locale.ENGLISH));
        }

        try {
            Integer.parseInt(addressDTO.getPostalCode());
        } catch (NumberFormatException e) {
            throw new Exception(messageSource.getMessage("validator.error.postal.code.invalid", null, Locale.ENGLISH));
        }

        if (addressDTO.getCity() == null) {
            throw new Exception(messageSource.getMessage("validator.error.city.null", null, Locale.ENGLISH));
        }

        if (addressDTO.getCounty() == null) {
            throw new Exception(messageSource.getMessage("validator.error.county.null", null, Locale.ENGLISH));
        }

        if (addressDTO.getCountry() == null) {
            throw new Exception(messageSource.getMessage("validator.error.country.null", null, Locale.ENGLISH));
        }
    }
}
