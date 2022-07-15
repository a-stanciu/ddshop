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
}
