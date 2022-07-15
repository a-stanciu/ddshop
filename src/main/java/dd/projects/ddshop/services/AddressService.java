package dd.projects.ddshop.services;

import dd.projects.ddshop.dto.AddressDTO;
import dd.projects.ddshop.entities.Address;
import dd.projects.ddshop.mappers.AddressMapper;
import dd.projects.ddshop.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;

    @Autowired
    public AddressService(AddressRepository addressRepository, AddressMapper addressMapper) {
        this.addressRepository = addressRepository;
        this.addressMapper = addressMapper;
    }

    public Address createAddress(AddressDTO addressDTO) {
        return addressRepository.save(addressMapper.destinationToSource(addressDTO));
    }

    public Address updateAddress(AddressDTO addressDTO) {
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

    public AddressRepository getAddressRepository() {
        return addressRepository;
    }
}
