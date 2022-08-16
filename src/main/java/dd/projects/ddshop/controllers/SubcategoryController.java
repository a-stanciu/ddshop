package dd.projects.ddshop.controllers;

import dd.projects.ddshop.dto.SubcategoryDTO;
import dd.projects.ddshop.services.SubcategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subcategory")
@CrossOrigin
public class SubcategoryController {
    SubcategoryService subcategoryService;

    @Autowired
    public SubcategoryController(SubcategoryService subcategoryService) {
        this.subcategoryService = subcategoryService;
    }

    @PostMapping("/add")
    public ResponseEntity<Object> addSubcategory(@RequestBody SubcategoryDTO subcategoryDTO) throws Exception {
        return new ResponseEntity<>(subcategoryService.createSubcategory(subcategoryDTO), HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<SubcategoryDTO>> getSubcategory() {
        return new ResponseEntity<>(subcategoryService.getSubcategories(), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateSubcategory(@PathVariable Integer id, @RequestBody SubcategoryDTO subcategoryDTO) throws Exception {
        return new ResponseEntity<>(subcategoryService.updateSubcategory(id, subcategoryDTO), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Integer> deleteSubcategory(@PathVariable Integer id) {
        subcategoryService.deleteSubcategoryById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
