package com.corner.menu.mapper;

import com.corner.menu.dto.MenuItemDTO;
import com.corner.menu.model.MenuItem;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MenuItemMapper {

    MenuItemDTO menuItemToMenuItemDTO(MenuItem menuItem);

    MenuItem menuItemDTOToMenuItem(MenuItemDTO menuItemDTO);
}