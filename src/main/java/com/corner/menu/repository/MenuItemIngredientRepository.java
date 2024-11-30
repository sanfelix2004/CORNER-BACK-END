package com.corner.menu.repository;

import com.corner.menu.model.MenuItemIngredient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MenuItemIngredientRepository extends JpaRepository<MenuItemIngredient, Long> {
    List<MenuItemIngredient> findByMenuItemId(Long menuItemId);
    Optional<MenuItemIngredient> findByMenuItemIdAndIngredientName(Long menuItemId, String ingredientName);
}