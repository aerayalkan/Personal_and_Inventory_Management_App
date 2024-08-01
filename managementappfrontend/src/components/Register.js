import React, { useState } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

const Register = () => {
    const [formData, setFormData] = useState({
        name: '',
        surname: '',
        gender: '',
        birthdayDate: '',
        maritalStatus: '',
        tckn: '',
        employeeNumber: '',
        educationalStatus: '',
        department: '',
        position: '',
        stillWork: true,
        profilePicture: '',
        password: '',
        role: 'ROLE_USER'
    });

    const navigate = useNavigate();

    const handleChange = (e) => {
        setFormData({
            ...formData,
            [e.target.name]: e.target.value
        });
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            await axios.post('http://localhost:8080/api/auth/register', formData);
            navigate('/login');
        } catch (error) {
            console.error(error);
        }
    };

    return (
        <div>
            <h2>Register</h2>
            <form onSubmit={handleSubmit}>
                <input type="text" name="name" placeholder="Name" onChange={handleChange} required/>
                <input type="text" name="surname" placeholder="Surname" onChange={handleChange} required/>
                <input type="text" name="gender" placeholder="Gender" onChange={handleChange} required/>
                <input type="date" name="birthdayDate" placeholder="Birthday Date" onChange={handleChange} required/>
                <input type="text" name="maritalStatus" placeholder="Marital Status" onChange={handleChange} required/>
                <input type="text" name="tckn" placeholder="TCKN" onChange={handleChange} required/>
                <input type="text" name="employeeNumber" placeholder="Employee Number" onChange={handleChange}
                       required/>
                <input type="text" name="educationalStatus" placeholder="Educational Status" onChange={handleChange}
                       required/>
                <input type="text" name="department" placeholder="Department" onChange={handleChange} required/>
                <input type="text" name="position" placeholder="Position" onChange={handleChange} required/>
                <select name="role" onChange={handleChange} required>
                    <option value="ROLE_USER">User</option>
                    <option value="ROLE_BOSS">Boss</option>
                    <option value="ROLE_ADMIN">Admin</option>
                </select>
                <input type="password" name="password" placeholder="Password" onChange={handleChange} required/>
                <button type="submit">Register</button>
            </form>
        </div>
    );
};

export default Register;
