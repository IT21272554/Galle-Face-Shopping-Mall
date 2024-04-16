import React, { useState } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom'; // Updated import

const LoginForm = () => {
  const navigate = useNavigate(); // Updated initialization
  const [formData, setFormData] = useState({
    email: '',
    password: '',
  });
  const [error, setError] = useState(null);
  const [successMessage, setSuccessMessage] = useState(null);

  const handleChange = (event) => {
    setFormData({ ...formData, [event.target.name]: event.target.value });
  };

  const handleSubmit = async (event) => {
    event.preventDefault();

    try {
      const response = await axios.post('http://localhost:8090/signin/signin', formData);

      if (response.status === 200) {
        // Handle successful login (e.g., redirect to secured area or store a token)
        console.log('Login successful!');
        setError(null); // Clear any previous errors
        setSuccessMessage('Login successful!'); // Set success message
        setFormData({ email: '', password: '' }); // Reset the form data
        setTimeout(() => {
          setSuccessMessage(null); // Clear success message after a few seconds
        }, 3000); // 3 seconds
      } else {
        setError(response.data.message || 'Oopss!!Invalid email or password');
      }
    } catch (error) {
      console.error('Login error:', error);
      setError('Invalid email or password!');
    }
  };

  return (
    <div className="login-container">
      <h1>SIGN IN</h1>
      {error && <div className="error-message">{error}</div>}
      {successMessage && <div className="success-message">{successMessage}</div>}
      <form onSubmit={handleSubmit}>
        <div>
          <label htmlFor="email">Enter email:</label>
          <input
            type="email"
            name="email"
            placeholder='example@gmail.com'
            id="email"
            value={formData.email}
            onChange={handleChange}
            required
          />
        </div>
        <div>
          <label htmlFor="password">Enter password:</label>
          <input
            type="password"
            name="password"
            placeholder='Password'
            id="password"
            value={formData.password}
            onChange={handleChange}
            required
          />
        </div>
        <button type="submit">Log In</button>
        <div>
          <p>If you didn't have an account?</p>
          <button type='signup' onClick={() => navigate('/signup')}>Create</button> {/* Updated navigation */}
        </div>
        
      </form>
    </div>
  );
};

export default LoginForm;








