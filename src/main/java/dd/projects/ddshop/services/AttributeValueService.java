package dd.projects.ddshop.services;

import dd.projects.ddshop.dto.AttributeValueDTO;
import dd.projects.ddshop.entities.AttributeValue;
import dd.projects.ddshop.mappers.AttributeValueMapper;
import dd.projects.ddshop.repositories.AttributeValueRepository;
import dd.projects.ddshop.validators.AttributeValueValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttributeValueService {
    private final AttributeValueRepository attributeValueRepository;
    private final AttributeValueMapper attributeValueMapper;
    private final AttributeValueValidator attributeValueValidator;

    @Autowired
    public AttributeValueService(AttributeValueRepository attributeValueRepository, AttributeValueMapper attributeValueMapper, AttributeValueValidator attributeValueValidator) {
        this.attributeValueRepository = attributeValueRepository;
        this.attributeValueMapper = attributeValueMapper;
        this.attributeValueValidator = attributeValueValidator;
    }

    public AttributeValue createAttributeValue(AttributeValueDTO attributeValueDTO) throws Exception {
        attributeValueValidator.validate(attributeValueDTO);
        return attributeValueRepository.save(attributeValueMapper.destinationToSource(attributeValueDTO));
    }

    public AttributeValue updateAttributeValue(int id, AttributeValueDTO attributeValueDTO) throws Exception {
        attributeValueDTO.setId(id);
        attributeValueValidator.validate(attributeValueDTO);
        return attributeValueRepository.save(attributeValueMapper.destinationToSource(attributeValueDTO));
    }

    public void deleteAttributeValueById(int id) {
        attributeValueRepository.deleteById(id);
    }

    public List<AttributeValueDTO> getAttributeValues() {
        return attributeValueRepository
                .findAll()
                .stream()
                .map(attributeValueMapper::sourceToDestination)
                .toList();
    }
}
