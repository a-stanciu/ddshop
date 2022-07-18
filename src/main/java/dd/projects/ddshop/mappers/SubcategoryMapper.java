package dd.projects.ddshop.mappers;

import dd.projects.ddshop.dto.SubcategoryDTO;
import dd.projects.ddshop.entities.Subcategory;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SubcategoryMapper {
    SubcategoryDTO sourceToDestination(Subcategory subcategory);

    Subcategory destinationToSource(SubcategoryDTO subcategoryDTO);
}
