import React from "react";

export const Header: React.FC = () => {
    return (
        <header>
            <div style={{ width: "50px" }}>{/* Espacio para logo */}</div>
            <h2>
                <a href="/">ROMP GPS</a>
            </h2>
            <nav>
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
