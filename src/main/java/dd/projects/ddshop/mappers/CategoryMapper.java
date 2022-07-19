package dd.projects.ddshop.mappers;

import dd.projects.ddshop.dto.CategoryDTO;
import dd.projects.ddshop.entities.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryDTO sourceToDestination(Category category);

    Category destinationToSource(CategoryDTO categoryDTO);
}
