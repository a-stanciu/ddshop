package dd.projects.ddshop.controllers;

import dd.projects.ddshop.dto.AddressDTO;
import dd.projects.ddshop.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
@CrossOrigin
public class AddressController {
    AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping("/add")
    public ResponseEntity<Object> addAddress(@RequestBody AddressDTO addressDTO) {
        return new ResponseEntity<>(addressService.createAddress(addressDTO), HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<AddressDTO>> getAddresses() {
        return new ResponseEntity<>(addressService.getAddresses(), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateAddress(@PathVariable Integer id, @RequestBody AddressDTO addressDTO) {
        return new ResponseEntity<>(addressService.updateAddress(id, addressDTO), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Integer> deleteAddress(@PathVariable Integer id) {
        addressService.deleteAddressById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<Object> deleteAllAddresses() {
        addressService.deleteAllAddresses();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
