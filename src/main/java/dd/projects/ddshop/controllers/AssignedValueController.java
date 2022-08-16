package dd.projects.ddshop.controllers;

import dd.projects.ddshop.dto.AssignedValueDTO;
import dd.projects.ddshop.services.AssignedValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assignedValue")
@CrossOrigin
public class AssignedValueController {
    AssignedValueService assignedValueService;

    @Autowired
    public AssignedValueController(AssignedValueService assignedValueService) {
        this.assignedValueService = assignedValueService;
    }

    @PostMapping("/add")
    public ResponseEntity<Object> addAssignedValue(@RequestBody AssignedValueDTO assignedValueDTO) throws Exception {
        return new ResponseEntity<>(assignedValueService.createAssignedValue(assignedValueDTO), HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<AssignedValueDTO>> getAssignedValues() {
        return new ResponseEntity<>(assignedValueService.getAssignedValues(), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateAssignedValue(@PathVariable Integer id, @RequestBody AssignedValueDTO assignedValueDTO) throws Exception {
        return new ResponseEntity<>(assignedValueService.updateAssignedValue(id, assignedValueDTO), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Integer> deleteAssignedValue(@PathVariable Integer id) {
        assignedValueService.deleteAssignedValueById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
