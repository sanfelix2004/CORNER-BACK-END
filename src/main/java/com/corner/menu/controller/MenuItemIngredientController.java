package com.corner.menu.controller;

import com.corner.menu.dto.MenuItemIngredientDTO;
import com.corner.menu.mapper.MenuItemIngredientMapper;
import com.corner.menu.model.MenuItemIngredient;
import com.corner.menu.service.MenuItemIngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/menu-items/{menuItemId}/ingredients")
public class MenuItemIngredientController {

    private final MenuItemIngredientService menuItemIngredientService;
    private final MenuItemIngredientMapper menuItemIngredientMapper;

    @Autowired
    public MenuItemIngredientController(MenuItemIngredientService menuItemIngredientService, MenuItemIngredientMapper menuItemIngredientMapper) {
        this.menuItemIngredientService = menuItemIngredientService;
        this.menuItemIngredientMapper = menuItemIngredientMapper;
    }

    // Ottieni tutti gli ingredienti di un MenuItem
    @GetMapping
    public ResponseEntity<List<MenuItemIngredientDTO>> getAllIngredients(@PathVariable Long menuItemId) {
        List<MenuItemIngredient> ingredients = menuItemIngredientService.getAllIngredientsByMenuItemId(menuItemId);
        List<MenuItemIngredientDTO> ingredientDTOs = ingredients.stream()
                .map(menuItemIngredientMapper::menuItemIngredientToMenuItemIngredientDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(ingredientDTOs);
    }

    // Aggiungi un ingrediente a un MenuItem
    @PostMapping
    public ResponseEntity<MenuItemIngredientDTO> addIngredient(@PathVariable Long menuItemId, @RequestBody MenuItemIngredientDTO menuItemIngredientDTO) {
        MenuItemIngredient menuItemIngredient = menuItemIngredientMapper.menuItemIngredientDTOToMenuItemIngredient(menuItemIngredientDTO);
        menuItemIngredient = menuItemIngredientService.addIngredient(menuItemId, menuItemIngredient);
        MenuItemIngredientDTO result = menuItemIngredientMapper.menuItemIngredientToMenuItemIngredientDTO(menuItemIngredient);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    // Rimuovi un ingrediente da un MenuItem
    @DeleteMapping("/{ingredientName}")
    public ResponseEntity<Void> removeIngredient(@PathVariable Long menuItemId, @PathVariable String ingredientName) {
        menuItemIngredientService.removeIngredient(menuItemId, ingredientName);
        return ResponseEntity.noContent().build();
    }
}