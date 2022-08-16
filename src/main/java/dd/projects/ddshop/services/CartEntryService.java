package dd.projects.ddshop.services;

import dd.projects.ddshop.dto.CartEntryDTO;
import dd.projects.ddshop.entities.CartEntry;
import dd.projects.ddshop.mappers.CartEntryMapper;
import dd.projects.ddshop.repositories.CartEntryRepository;
import dd.projects.ddshop.validators.CartEntryValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartEntryService {
    private final CartEntryRepository cartEntryRepository;
    private final CartEntryMapper cartEntryMapper;
    private final CartEntryValidator cartEntryValidator;

    @Autowired
    public CartEntryService(CartEntryRepository cartEntryRepository, CartEntryMapper cartEntryMapper, CartEntryValidator cartEntryValidator) {
        this.cartEntryRepository = cartEntryRepository;
        this.cartEntryMapper = cartEntryMapper;
        this.cartEntryValidator = cartEntryValidator;
    }

    public CartEntry createCartEntry(CartEntryDTO cartEntryDTO) throws Exception {
        cartEntryValidator.validate(cartEntryDTO);
        return cartEntryRepository.save(cartEntryMapper.destinationToSource(cartEntryDTO));
    }

    public CartEntry updateCartEntry(int id, CartEntryDTO cartEntryDTO) throws Exception {
        cartEntryDTO.setId(id);
        cartEntryValidator.validate(cartEntryDTO);
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
}
