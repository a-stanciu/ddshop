package dd.projects.ddshop.controllers;

import dd.projects.ddshop.dto.CartEntryDTO;
import dd.projects.ddshop.services.CartEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cartEntry")
@CrossOrigin
public class CartEntryController {
    CartEntryService cartEntryService;

    @Autowired
    public CartEntryController(CartEntryService cartEntryService) {
        this.cartEntryService = cartEntryService;
    }

    @PostMapping("/add")
    public ResponseEntity<Object> addCartEntry(@RequestBody CartEntryDTO cartEntryDTO) {
        return new ResponseEntity<>(cartEntryService.createCartEntry(cartEntryDTO), HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<CartEntryDTO>> getCartEntries() {
        return new ResponseEntity<>(cartEntryService.getCartEntries(), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateCartEntry(@PathVariable Integer id, @RequestBody CartEntryDTO cartEntryDTO) {
        return new ResponseEntity<>(cartEntryService.updateCartEntry(id, cartEntryDTO), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Integer> deleteCartEntry(@PathVariable Integer id) {
        cartEntryService.deleteCartEntryById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
