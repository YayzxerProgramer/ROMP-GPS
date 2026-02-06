import React, { useState } from 'react';

const App = () => {
    const [activeSection, setActiveSection] = useState('home');

    const handleSectionChange = (section) => {
        setActiveSection(section);
    };

    return (
        <div>
            <nav>
                <ul>
                    <li className={activeSection === 'home' ? 'active' : ''} onClick={() => handleSectionChange('home')}>Home</li>
                    <li className={activeSection === 'about' ? 'active' : ''} onClick={() => handleSectionChange('about')}>About</li>
                    <li className={activeSection === 'contact' ? 'active' : ''} onClick={() => handleSectionChange('contact')}>Contact</li>
                </ul>
            </nav>
            <section className="content">
                {activeSection === 'home' && <h1>Welcome to Home</h1>}
                {activeSection === 'about' && <h1>About Us</h1>}
                {activeSection === 'contact' && <h1>Contact Us</h1>}
            </section>
        </div>
    );
};

export default App;