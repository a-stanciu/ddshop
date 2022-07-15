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
}
