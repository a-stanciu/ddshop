package dd.projects.ddshop.services;

import dd.projects.ddshop.dto.CartEntryDTO;
import dd.projects.ddshop.entities.CartEntry;
import dd.projects.ddshop.mappers.CartEntryMapper;
import dd.projects.ddshop.repositories.CartEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartEntryService {
    private final CartEntryRepository cartEntryRepository;
    private final CartEntryMapper cartEntryMapper;

    @Autowired
    public CartEntryService(CartEntryRepository cartEntryRepository, CartEntryMapper cartEntryMapper) {
        this.cartEntryRepository = cartEntryRepository;
        this.cartEntryMapper = cartEntryMapper;
    }

    public CartEntry createCartEntry(CartEntryDTO cartEntryDTO) {
        return cartEntryRepository.save(cartEntryMapper.destinationToSource(cartEntryDTO));
    }

    public CartEntry updateCartEntry(CartEntryDTO cartEntryDTO) {
        return cartEntryRepository.save(cartEntryMapper.destinationToSource(cartEntryDTO));
    }

    public void deleteCartEntryById(int id) {
        cartEntryRepository.deleteById(id);
    }

    public List<CartEntryDTO> getCartEntries() {
        return cartEntryRepository
                .findAll()
                .stream()
                .map(cartEntryMapper::sourceToDestination)
                .toList();
    }

    public CartEntryRepository getCartEntryRepository() {
        return cartEntryRepository;
    }
}
