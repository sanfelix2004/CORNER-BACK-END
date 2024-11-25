// components/MenuItemCard.js
import React from 'react';

const MenuItemCard = ({ menuItem }) => {
  return (
    <div className="menu-item-card">
      <h3>{menuItem.name}</h3>
      <p>{menuItem.description}</p>
      <p>{menuItem.price}€</p>
    </div>
  );
};

export default MenuItemCard;