// src/api/api.js

const BASE_URL = 'http://localhost:8080/api';

export const getCategories = async () => {
  try {
    const response = await fetch(`${BASE_URL}/categories`);
    if (!response.ok) {
      throw new Error('Impossibile ottenere le categorie.');
    }
    return await response.json();
  } catch (error) {
    console.error(error);
    return [];
  }
};

export const getMenuItemsByCategory = async (categoryId) => {
  try {
    const response = await fetch(`${BASE_URL}/menu-items/by-category/${categoryId}`);
    if (!response.ok) {
      throw new Error('Impossibile ottenere gli item del menu.');
    }
    return await response.json();
  } catch (error) {
    console.error(error);
    return [];
  }
};