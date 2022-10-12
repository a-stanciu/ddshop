package dd.projects.ddshop.mappers;

import dd.projects.ddshop.dto.ProductDTO;
import dd.projects.ddshop.entities.Product;
import dd.projects.ddshop.entities.Subcategory;
import dd.projects.ddshop.services.SubcategoryService;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class ProductMapper {

    @Autowired
    SubcategoryService subcategoryService;

    public abstract ProductDTO sourceToDestination(Product product);

    public abstract Product destinationToSource(ProductDTO productDTO);

    protected Integer fromIntegerToSubcategory(Subcategory value) {
        return subcategoryService.getSubcategoryId(value);
    }

    protected Subcategory fromSubcategoryToInteger(Integer value) {
        return subcategoryService.getSubcategoryById(value);
    }
}
