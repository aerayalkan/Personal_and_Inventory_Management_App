import React, { useEffect, useState } from 'react';
import api from './api';

function Dashboard() {
    const [personalData, setPersonalData] = useState([]);

    useEffect(() => {
        api.get('/personal')
            .then((response) => {
                setPersonalData(response.data);
            })
            .catch((error) => {
                console.error('Veriler alınırken bir hata oluştu', error);
            });
    }, []);

    return (
        <div>
            <h1>Dashboard</h1>
            <ul>
                {personalData.map((person) => (
                    <li key={person.id}>{person.name} {person.surname}</li>
                ))}
            </ul>
        </div>
    );
}

export default Dashboard;
