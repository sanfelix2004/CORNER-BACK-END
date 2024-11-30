package com.corner.menu.controller;

import com.corner.menu.dto.MenuItemDTO;
import com.corner.menu.mapper.MenuItemMapper;
import com.corner.menu.model.MenuItem;
import com.corner.menu.service.MenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/menu-items")
public class MenuItemController {

    private final MenuItemService menuItemService;
    private final MenuItemMapper menuItemMapper;

    @Autowired
    public MenuItemController(MenuItemService menuItemService, MenuItemMapper menuItemMapper) {
        this.menuItemService = menuItemService;
        this.menuItemMapper = menuItemMapper;
    }

    @GetMapping("/{id}")
    public ResponseEntity<MenuItemDTO> getMenuItem(@PathVariable Long id) {
        MenuItem menuItem = menuItemService.getMenuItem(id);
        MenuItemDTO menuItemDTO = menuItemMapper.menuItemToMenuItemDTO(menuItem);
        return ResponseEntity.ok(menuItemDTO);
    }

    @GetMapping
    public ResponseEntity<List<MenuItemDTO>> getAllMenuItems() {
        List<MenuItem> menuItems = menuItemService.getAllMenuItems();
        List<MenuItemDTO> menuItemDTOs = menuItems.stream()
                .map(menuItemMapper::menuItemToMenuItemDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(menuItemDTOs);
    }

    @PostMapping
    public ResponseEntity<MenuItemDTO> createMenuItem(@RequestBody MenuItemDTO menuItemDTO) {
        MenuItem menuItem = menuItemMapper.menuItemDTOToMenuItem(menuItemDTO);
        menuItem = menuItemService.createMenuItem(menuItem);
        MenuItemDTO result = menuItemMapper.menuItemToMenuItemDTO(menuItem);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MenuItemDTO> updateMenuItem(@PathVariable Long id, @RequestBody MenuItemDTO menuItemDTO) {
        MenuItem menuItem = menuItemMapper.menuItemDTOToMenuItem(menuItemDTO);
        menuItem = menuItemService.updateMenuItem(id, menuItem);
        MenuItemDTO result = menuItemMapper.menuItemToMenuItemDTO(menuItem);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMenuItem(@PathVariable Long id) {
        menuItemService.deleteMenuItem(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/by-category/{categoryId}")
    public ResponseEntity<List<MenuItemDTO>> getMenuItemsByCategory(@PathVariable Long categoryId) {
        List<MenuItem> menuItems = menuItemService.getMenuItemsByCategoryId(categoryId);
        List<MenuItemDTO> menuItemDTOs = menuItems.stream()
                .map(menuItemMapper::menuItemToMenuItemDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(menuItemDTOs);
    }
}