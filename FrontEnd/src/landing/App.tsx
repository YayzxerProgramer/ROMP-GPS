import React from 'react';
import './App.css';

function App() {
  return (
    <div className="App">
      <nav>
        <ul>
          <li><a href="#inicio">Inicio</a></li>
          <li><a href="#presentacion">Presentación</a></li>
          <li><a href="#planes">Planes</a></li>
          <li><a href="#equipo">Equipo</a></li>
          <li><a href="#contacto">Contacto</a></li>
        </ul>
      </nav>

      <section id="inicio">
        <h1>Bienvenido a nuestra Aplicación</h1>
        <p>Descripción breve de la aplicación.</p>
      </section>

      <section id="presentacion">
        <h2>Presentación</h2>
        <p>Detalles sobre la presentación de la aplicación y sus características.</p>
      </section>

      <section id="planes">
        <h2>Planes</h2>
        <p>Descripción de los diferentes planes o servicios ofrecidos.</p>
      </section>

      <section id="equipo">
        <h2>Equipo</h2>
        <p>Información sobre los miembros del equipo y sus roles.</p>
      </section>

      <section id="contacto">
        <h2>Contacto</h2>
        <p>Información de contacto y formulario de contacto.</p>
      </section>
    </div>
  );
}

export default App;