package com.corner.menu.service;

import com.corner.menu.model.MenuItem;
import com.corner.menu.model.MenuItemIngredient;
import com.corner.menu.repository.MenuItemIngredientRepository;
import com.corner.menu.exception.ResourceNotFoundException;
import com.corner.menu.repository.MenuItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuItemIngredientService {

    private final MenuItemIngredientRepository menuItemIngredientRepository;
    private final MenuItemRepository menuItemRepository;

    @Autowired
    public MenuItemIngredientService(MenuItemIngredientRepository menuItemIngredientRepository, MenuItemRepository menuItemRepository) {
        this.menuItemIngredientRepository = menuItemIngredientRepository;
        this.menuItemRepository = menuItemRepository;
    }

    // Ottieni tutti gli ingredienti di un MenuItem
    public List<MenuItemIngredient> getAllIngredientsByMenuItemId(Long menuItemId) {
        return menuItemIngredientRepository.findByMenuItemId(menuItemId);
    }

    // Aggiungi un ingrediente a un MenuItem
    public MenuItemIngredient addIngredient(Long menuItemId, MenuItemIngredient menuItemIngredient) {
        // Recupera il MenuItem dal database usando il suo ID
        MenuItem menuItem = menuItemRepository.findById(menuItemId)
                .orElseThrow(() -> new ResourceNotFoundException("MenuItem", "id", menuItemId));

        // Associa il MenuItem all'ingrediente
        menuItemIngredient.setMenuItem(menuItem);

        // Salva l'ingrediente
        return menuItemIngredientRepository.save(menuItemIngredient);
    }

    // Rimuovi un ingrediente da un MenuItem
    public void removeIngredient(Long menuItemId, String ingredientName) {
        MenuItemIngredient ingredient = menuItemIngredientRepository.findByMenuItemIdAndIngredientName(menuItemId, ingredientName)
                .orElseThrow(() -> new ResourceNotFoundException("Ingredient not found"));
        menuItemIngredientRepository.delete(ingredient);
    }
}