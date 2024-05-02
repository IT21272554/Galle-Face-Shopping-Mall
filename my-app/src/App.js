import React, { useState } from 'react';
import Item from './components/item';
import Shop from './components/shop';

function App() {
  const [currentPage, setCurrentPage] = useState('item');

  const handlePageChange = (page) => {
    setCurrentPage(page);
  };

  return (
    <div className="App">
      <header>
        <button onClick={() => handlePageChange('item')}>Items</button>
        <button onClick={() => handlePageChange('shop')}>Shops</button>
      </header>
      <main>
        {currentPage === 'item' && <Item />}
        {currentPage === 'shop' && <Shop />}
      </main>
    </div>
  );
}

export default App;
