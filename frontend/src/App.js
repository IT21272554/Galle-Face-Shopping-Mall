import './App.css';
import Home from './Pages/Home';
import React from 'react';
import Signup from './Pages/Signup';
import LoginForm from './Pages/LoginForm';

function App() {
  return (
    <div className="App">
      <Home/>
      <Signup/>
       <LoginForm />
    </div>
  );
}

export default App;
