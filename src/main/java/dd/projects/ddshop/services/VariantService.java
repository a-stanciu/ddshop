package dd.projects.ddshop.services;

import dd.projects.ddshop.dto.VariantDTO;
import dd.projects.ddshop.entities.Variant;
import dd.projects.ddshop.mappers.VariantMapper;
import dd.projects.ddshop.repositories.VariantRepository;
import dd.projects.ddshop.validators.VariantValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VariantService {
    private final VariantRepository variantRepository;
    private final VariantMapper variantMapper;
    private final VariantValidator variantValidator;

    @Autowired
    public VariantService(VariantRepository variantRepository, VariantMapper variantMapper, VariantValidator variantValidator) {
        this.variantRepository = variantRepository;
        this.variantMapper = variantMapper;
        this.variantValidator = variantValidator;
    }

    public Variant createVariant(VariantDTO variantDTO) {
        variantValidator.validate(variantDTO);
        return variantRepository.save(variantMapper.destinationToSource(variantDTO));
    }

    public Variant updateVariant(int id, VariantDTO variantDTO) {
        variantDTO.setId(id);
        variantValidator.validate(variantDTO);
        return variantRepository.save(variantMapper.destinationToSource(variantDTO));
    }

    public void deleteVariantById(int id) {
        variantRepository.deleteById(id);
    }

    public List<VariantDTO> getVariants() {
        return variantRepository
                .findAll()
                .stream()
                .map(variantMapper::sourceToDestination)
                .toList();
    }
}
