package com.corner.menu.mapper;

import com.corner.menu.dto.CategoryDTO;
import com.corner.menu.model.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryDTO categoryToCategoryDTO(Category category);

    Category categoryDTOToCategory(CategoryDTO categoryDTO);
}