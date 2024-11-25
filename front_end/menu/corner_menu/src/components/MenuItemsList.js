// src/components/MenuItemsList.js
import React, { useEffect, useState } from 'react';
import { getMenuItemsByCategory } from '../api/api';

const MenuItemsList = ({ categoryId }) => {
  const [menuItems, setMenuItems] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    const fetchMenuItems = async () => {
      if (!categoryId) return;
      try {
        const items = await getMenuItemsByCategory(categoryId);
        setMenuItems(items);
      } catch (err) {
        setError('Errore nel caricamento degli item del menu');
      } finally {
        setLoading(false);
      }
    };

    fetchMenuItems();
  }, [categoryId]);

  if (loading) return <p>Caricamento menu...</p>;
  if (error) return <p>{error}</p>;

  return (
    <div className="menu-items-list">
      <h3>Menu</h3>
      {menuItems.length === 0 ? (
        <p>Nessun elemento disponibile per questa categoria.</p>
      ) : (
        <ul>
          {menuItems.map((item) => (
            <li key={item.id}>
              <h4>{item.name}</h4>
              <p>{item.description}</p>
              <p>Prezzo: {item.price}€</p>
            </li>
          ))}
        </ul>
      )}
    </div>
  );
};

export default MenuItemsList;