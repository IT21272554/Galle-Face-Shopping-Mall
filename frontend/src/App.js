import { BrowserRouter, Route, Routes } from 'react-router-dom';
import './App.css';
import Category from './Pages/Category';
import Find from './Pages/Find';
import Home from './Pages/Home';
import Item from './Pages/Item';

function App() {
  return (
    <div className="App">
      <BrowserRouter>
      <Routes>
        <Route path="/" element={<Home/>}/>
        <Route path="/find" element={<Find/>}/>
        <Route path="/category/:id" element={<Category/>}/>
        <Route path="/item/:id" element={<Item/>}/>
      </Routes>
      </BrowserRouter>
      
   
    </div>
  );
}

export default App;
