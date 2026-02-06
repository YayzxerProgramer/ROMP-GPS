import React, { useState } from 'react';
import './App.css'; // Assuming styles are kept in App.css

const App = () => {
    const [activeSection, setActiveSection] = useState('');

    const handleSectionClick = (section) => {
        setActiveSection(section);
        // Logic to scroll to the section goes here
    };

    return (
        <div className="app">
            <nav className="navbar">
                <ul>
                    <li className={activeSection === 'home' ? 'active' : ''} onClick={() => handleSectionClick('home')}>Home</li>
                    <li className={activeSection === 'about' ? 'active' : ''} onClick={() => handleSectionClick('about')}>About</li>
                    <li className={activeSection === 'services' ? 'active' : ''} onClick={() => handleSectionClick('services')}>Services</li>
                    <li className={activeSection === 'contact' ? 'active' : ''} onClick={() => handleSectionClick('contact')}>Contact</li>
                </ul>
            </nav>
            <section id="home"> {/* Home section */} </section>
            <section id="about"> {/* About section */} </section>
            <section id="services"> {/* Services section */} </section>
            <section id="contact"> {/* Contact section */} </section>
        </div>
    );
};

export default App;