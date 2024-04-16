import './App.css';
import Home from './Pages/Home';
import React from 'react';
import Signup from './Pages/Signup';
import LoginForm from './Pages/LoginForm';

import {BrowserRouter, Route, Routes} from 'react-router-dom';

function App() {
  return (
    <div className="App">
      <BrowserRouter>
              
          <Routes>
            <Route path="/" element={<Home/>}/>
            <Route path="/signup" element={<Signup/>}/>
            <Route path="/signin" element={<LoginForm/>}/>
            
          </Routes>
      </BrowserRouter>
      
    </div>
  );
}

export default App;
