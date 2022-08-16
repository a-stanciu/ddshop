package dd.projects.ddshop.services;

import dd.projects.ddshop.dto.AssignedValueDTO;
import dd.projects.ddshop.entities.AssignedValue;
import dd.projects.ddshop.mappers.AssignedValueMapper;
import dd.projects.ddshop.repositories.AssignedValueRepository;
import dd.projects.ddshop.validators.AssignedValueValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssignedValueService {
    private final AssignedValueRepository assignedValueRepository;
    private final AssignedValueMapper assignedValueMapper;
    private final AssignedValueValidator assignedValueValidator;

    @Autowired
    public AssignedValueService(AssignedValueRepository assignedValueRepository, AssignedValueMapper assignedValueMapper, AssignedValueValidator assignedValueValidator) {
        this.assignedValueRepository = assignedValueRepository;
        this.assignedValueMapper = assignedValueMapper;
        this.assignedValueValidator = assignedValueValidator;
    }

    public AssignedValue createAssignedValue(AssignedValueDTO assignedValueDTO) throws Exception {
        assignedValueValidator.validate(assignedValueDTO);
        return assignedValueRepository.save(assignedValueMapper.destinationToSource(assignedValueDTO));
    }

    public AssignedValue updateAssignedValue(int id, AssignedValueDTO assignedValueDTO) throws Exception {
        assignedValueDTO.setId(id);
        assignedValueValidator.validate(assignedValueDTO);
        return assignedValueRepository.save(assignedValueMapper.destinationToSource(assignedValueDTO));
    }

    public void deleteAssignedValueById(int id) {
        assignedValueRepository.deleteById(id);
    }

    public List<AssignedValueDTO> getAssignedValues() {
        return assignedValueRepository
                .findAll()
                .stream()
                .map(assignedValueMapper::sourceToDestination)
                .toList();
    }
}
