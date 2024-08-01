import React from 'react';
import { Link } from 'react-router-dom';

const Home = () => {
    return (
        <div>
            <h1>Welcome to the Personal and Inventory Management App</h1>
            <Link to="/login">Login</Link>
            <br />
            <Link to="/register">Register</Link>
        </div>
    );
};

export default Home;
