// src/components/CategoryList.js
import React, { useEffect, useState } from 'react';
import { getCategories } from '../api/api';

const CategoryList = ({ onSelectCategory }) => {
  const [categories, setCategories] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    const fetchCategories = async () => {
      try {
        const data = await getCategories();
        setCategories(data);
      } catch (err) {
        setError('Errore nel caricamento delle categorie');
      } finally {
        setLoading(false);
      }
    };

    fetchCategories();
  }, []);

  if (loading) return <p>Caricamento categorie...</p>;
  if (error) return <p>{error}</p>;

  return (
    <div className="category-list">
      <h2>Categorie</h2>
      {categories.length === 0 ? (
        <p>Nessuna categoria disponibile.</p>
      ) : (
        <ul>
          {categories.map((category) => (
            <li key={category.id} onClick={() => onSelectCategory(category.id)}>
              {category.name}
            </li>
          ))}
        </ul>
      )}
    </div>
  );
};

export default CategoryList;