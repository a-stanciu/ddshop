package dd.projects.ddshop.controllers;

import dd.projects.ddshop.dto.VariantDTO;
import dd.projects.ddshop.services.VariantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/variant")
@CrossOrigin
public class VariantController {
    VariantService variantService;

    @Autowired
    public VariantController(VariantService variantService) {
        this.variantService = variantService;
    }

    @PostMapping("/add")
    public ResponseEntity<Object> addVariant(@RequestBody VariantDTO variantDTO) throws Exception {
        return new ResponseEntity<>(variantService.createVariant(variantDTO), HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<VariantDTO>> getVariants() {
        return new ResponseEntity<>(variantService.getVariants(), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateVariant(@PathVariable Integer id, @RequestBody VariantDTO variantDTO) throws Exception {
        return new ResponseEntity<>(variantService.updateVariant(id, variantDTO), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Integer> deleteVariant(@PathVariable Integer id) {
        variantService.deleteVariantById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
