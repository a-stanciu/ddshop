package dd.projects.ddshop.controllers;

import dd.projects.ddshop.dto.ProductAttributeDTO;
import dd.projects.ddshop.services.ProductAttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productAttribute")
@CrossOrigin
public class ProductAttributeController {
    ProductAttributeService productAttributeService;

    @Autowired
    public ProductAttributeController(ProductAttributeService productAttributeService) {
        this.productAttributeService = productAttributeService;
    }

    @PostMapping("/add")
    public ResponseEntity<Object> addProductAttribute(@RequestBody ProductAttributeDTO productAttributeDTO) {
        return new ResponseEntity<>(productAttributeService.createProductAttribute(productAttributeDTO), HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<ProductAttributeDTO>> getProductAttributes() {
        return new ResponseEntity<>(productAttributeService.getProductAttributes(), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateProductAttribute(@PathVariable Integer id, @RequestBody ProductAttributeDTO productAttributeDTO) {
        return new ResponseEntity<>(productAttributeService.updateProductAttribute(id, productAttributeDTO), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Integer> deleteProductAttribute(@PathVariable Integer id) {
        productAttributeService.deleteProductAttributeById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
