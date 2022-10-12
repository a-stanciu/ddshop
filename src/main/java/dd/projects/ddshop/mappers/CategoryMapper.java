package dd.projects.ddshop.mappers;

import dd.projects.ddshop.dto.CategoryDTO;
import dd.projects.ddshop.entities.Category;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoryMapper {
    CategoryDTO sourceToDestination(Category category);

    Category destinationToSource(CategoryDTO categoryDTO);
}
