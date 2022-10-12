package dd.projects.ddshop.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDTO {
    private int id;

    private String streetLine;

    private String postalCode;

    private String city;

    private String county;

    private String country;
}
