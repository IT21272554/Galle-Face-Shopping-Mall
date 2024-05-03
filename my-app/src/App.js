import React, { useState } from 'react';
import Item from './components/item';
import Shop from './components/shop';
import './App.css'; // Assuming you have a CSS file for styling

function App() {
  const [currentPage, setCurrentPage] = useState('item');

  const handlePageChange = (page) => {
    setCurrentPage(page);
  };

  return (
    <div className="App">
      <header>
        <button
          className={currentPage === 'item' ? 'active' : ''}
          onClick={() => handlePageChange('item')}
        >
          Items
        </button>
        <button
          className={currentPage === 'shop' ? 'active' : ''}
          onClick={() => handlePageChange('shop')}
        >
          Shops
        </button>
      </header>
      <main>
        {currentPage === 'item' && <Item />}
        {currentPage === 'shop' && <Shop />}
      </main>
    </div>
  );
}

export default App;
