package com.corner.menu.validation;

import com.corner.menu.dto.MenuItemDTO;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class MenuItemValidator {

    public void validate(MenuItemDTO menuItemDTO) {
        if (menuItemDTO == null) {
            throw new IllegalArgumentException("Menu item cannot be null");
        }

        // Verifica se il nome è presente
        if (menuItemDTO.getName() == null || menuItemDTO.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("Menu item name cannot be empty or null");
        }

        // Verifica se il prezzo è valido
        if (menuItemDTO.getPrice() == null) {
            throw new IllegalArgumentException("Menu item price cannot be null");
        }
        if (menuItemDTO.getPrice().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Menu item price must be greater than zero");
        }
    }
}