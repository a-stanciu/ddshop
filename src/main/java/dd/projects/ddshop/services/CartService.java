package dd.projects.ddshop.services;

import dd.projects.ddshop.dto.CartDTO;
import dd.projects.ddshop.entities.Cart;
import dd.projects.ddshop.mappers.CartMapper;
import dd.projects.ddshop.repositories.CartRepository;
import dd.projects.ddshop.validators.CartValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    private final CartRepository cartRepository;
    private final CartMapper cartMapper;
    private final CartValidator cartValidator;

    @Autowired
    public CartService(CartRepository cartRepository, CartMapper cartMapper, CartValidator cartValidator) {
        this.cartRepository = cartRepository;
        this.cartMapper = cartMapper;
        this.cartValidator = cartValidator;
    }

    public Cart createCart(CartDTO cartDTO) {
        cartValidator.validate(cartDTO);
        return cartRepository.save(cartMapper.destinationToSource(cartDTO));
    }

    public Cart updateCart(int id, CartDTO cartDTO) {
        cartDTO.setId(id);
        cartValidator.validate(cartDTO);
        return cartRepository.save(cartMapper.destinationToSource(cartDTO));
    }

    public void deleteCartById(int id) {
        cartRepository.deleteById(id);
    }

    public List<CartDTO> getCarts() {
        return cartRepository
                .findAll()
                .stream()
                .map(cartMapper::sourceToDestination)
                .toList();
    }
}
