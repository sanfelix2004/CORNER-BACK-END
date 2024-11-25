package com.corner.menu.mapper;

import com.corner.menu.dto.MenuItemIngredientDTO;
import com.corner.menu.model.MenuItemIngredient;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MenuItemIngredientMapper {

    MenuItemIngredientDTO menuItemIngredientToMenuItemIngredientDTO(MenuItemIngredient menuItemIngredient);

    MenuItemIngredient menuItemIngredientDTOToMenuItemIngredient(MenuItemIngredientDTO menuItemIngredientDTO);
}