package dd.projects.ddshop.services;

import dd.projects.ddshop.dto.AddressDTO;
import dd.projects.ddshop.entities.Address;
import dd.projects.ddshop.mappers.AddressMapper;
import dd.projects.ddshop.repositories.AddressRepository;
import dd.projects.ddshop.validators.AddressValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;
    private final AddressValidator addressValidator;

    @Autowired
    public AddressService(AddressRepository addressRepository, AddressMapper addressMapper, AddressValidator addressValidator) {
        this.addressRepository = addressRepository;
        this.addressMapper = addressMapper;
        this.addressValidator = addressValidator;
    }

    public Address createAddress(AddressDTO addressDTO) throws Exception {
        addressValidator.validate(addressDTO);
        return addressRepository.save(addressMapper.destinationToSource(addressDTO));
    }

    public Address updateAddress(int id, AddressDTO addressDTO) throws Exception {
        addressDTO.setId(id);
        addressValidator.validate(addressDTO);
        return addressRepository.save(addressMapper.destinationToSource(addressDTO));
    }

    public void deleteAddressById(int id) {
        addressRepository.deleteById(id);
    }

    public List<AddressDTO> getAddresses() {
        return addressRepository
                .findAll()
                .stream()
                .map(addressMapper::sourceToDestination)
                .toList();
    }
}
