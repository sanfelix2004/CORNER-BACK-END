import React, { useState, useEffect } from 'react';
import { getCategories, getMenuItemsByCategory } from './api/api';
import './styles/App.css'; // Importazione del CSS
import CategoryList from './components/CategoryList';
import MenuItemsList from './components/MenuItemsList';

const App = () => {
  const [categories, setCategories] = useState([]);
  const [menuItems, setMenuItems] = useState([]);
  const [selectedCategory, setSelectedCategory] = useState(null);

  useEffect(() => {
    const fetchCategories = async () => {
      const categories = await getCategories();
      setCategories(categories);
    };

    fetchCategories();
  }, []);

  const handleCategorySelect = async (categoryId) => {
    setSelectedCategory(categoryId);
    const items = await getMenuItemsByCategory(categoryId);
    setMenuItems(items);
  };

  return (
    <div className="App">
      <div className="categories-container">
        {categories.map((category) => (
          <div
            key={category.id}
            className={`category-item ${selectedCategory === category.id ? 'selected' : ''}`}
            onClick={() => handleCategorySelect(category.id)}
          >
            {category.name}
          </div>
        ))}
      </div>

      {selectedCategory && (
        <>
          <h2 className="menu-title">Menu Items</h2>
          <div className="menu-items-container">
            {menuItems.map((item) => (
              <div className="menu-item" key={item.id}>
                <h3>{item.name}</h3>
                <p>{item.description}</p>
                <p><strong>{item.price} €</strong></p>
              </div>
            ))}
          </div>
        </>
      )}
    </div>
  );
};

export default App;