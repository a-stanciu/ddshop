package dd.projects.ddshop.controllers;

import dd.projects.ddshop.dto.AttributeValueDTO;
import dd.projects.ddshop.services.AttributeValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/attributeValue")
@CrossOrigin
public class AttributeValueController {
    AttributeValueService attributeValueService;

    @Autowired
    public AttributeValueController(AttributeValueService attributeValueService) {
        this.attributeValueService = attributeValueService;
    }

    @PostMapping("/add")
    public ResponseEntity<Object> addAttributeValue(@RequestBody AttributeValueDTO attributeValueDTO) {
        return new ResponseEntity<>(attributeValueService.createAttributeValue(attributeValueDTO), HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<AttributeValueDTO>> getAttributeValues() {
        return new ResponseEntity<>(attributeValueService.getAttributeValues(), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateAttributeValue(@PathVariable Integer id, @RequestBody AttributeValueDTO attributeValueDTO) {
        return new ResponseEntity<>(attributeValueService.updateAttributeValue(id, attributeValueDTO), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Integer> deleteAttributeValue(@PathVariable Integer id) {
        attributeValueService.deleteAttributeValueById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
