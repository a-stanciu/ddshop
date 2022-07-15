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
}
