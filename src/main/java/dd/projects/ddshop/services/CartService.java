package dd.projects.ddshop.services;

import dd.projects.ddshop.dto.CartDTO;
import dd.projects.ddshop.entities.Cart;
import dd.projects.ddshop.mappers.CartMapper;
import dd.projects.ddshop.repositories.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    private final CartRepository cartRepository;
    private final CartMapper cartMapper;

    @Autowired
    public CartService(CartRepository cartRepository, CartMapper cartMapper) {
        this.cartRepository = cartRepository;
        this.cartMapper = cartMapper;
    }

    public Cart createCart(CartDTO cartDTO) {
        return cartRepository.save(cartMapper.destinationToSource(cartDTO));
    }

    public Cart updateCart(CartDTO cartDTO) {
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

    public CartRepository getCartRepository() {
        return cartRepository;
    }
}
