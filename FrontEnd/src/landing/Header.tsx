import React from "react";

export const Header: React.FC = () => {
  return (
    <header className="main-header">
      <div className="header-logo">
        {/* Puedes agregar tu logo aquí */}
        <img src="/logo.png" alt="Logo" />
      </div>
      <h2 className="header-title">
        <a href="/">ROMP GPS</a>
      </h2>
      <nav className="header-nav">
        <ul>
          <li>
            <a href="#presentacion">Presentación</a>
          </li>
          <li>
            <a href="#planes">Planes</a>
          </li>
          <li>
            <a href="#equipo">Equipo</a>
          </li>
          <li>
            <a href="#contacto">Contacto</a>
          </li>
        </ul>
      </nav>
    </header>
  );
};
