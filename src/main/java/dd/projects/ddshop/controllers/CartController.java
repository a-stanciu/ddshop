package dd.projects.ddshop.controllers;

import dd.projects.ddshop.dto.CartDTO;
import dd.projects.ddshop.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
@CrossOrigin
public class CartController {
    CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/add")
    public ResponseEntity<Object> addCart(@RequestBody CartDTO cartDTO) {
        return new ResponseEntity<>(cartService.createCart(cartDTO), HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<CartDTO>> getCarts() {
        return new ResponseEntity<>(cartService.getCarts(), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateCart(@PathVariable Integer id, @RequestBody CartDTO cartDTO) {
        return new ResponseEntity<>(cartService.updateCart(id, cartDTO), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Integer> deleteCart(@PathVariable Integer id) {
        cartService.deleteCartById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
