import { useState } from "react";
import "../App.css";
import Gradient from "../reactbits/Gradient.tsx";
import TextType from "../reactbits/TextType.tsx";

function App() {
  const [activeSection, setActiveSection] = useState("inicio");

  const scrollToSection = (sectionId: string) => {
    setActiveSection(sectionId);
    const element = document.getElementById(sectionId);
    element?.scrollIntoView({ behavior: "smooth" });
  };

  return (
    <>
      {/* HEADER CON NAVEGACIÓN */}
      <header>
        <img src="" alt="Logo ROMP GPS" />
        <h2>
          <a href="#inicio" onClick={() => scrollToSection("inicio")}>
            ROMP GPS
          </a>
        </h2>
        <nav>
          <ul>
            <li>
              <a onClick={() => scrollToSection("presentacion")}>Presentación</a>
            </li>
            <li>
              <a onClick={() => scrollToSection("planes")}>Planes</a>
            </li>
            <li>
              <a onClick={() => scrollToSection("equipo")}>Equipo</a>
            </li>
            <li>
              <a onClick={() => scrollToSection("contacto")}>Contacto</a>
            </li>
          </ul>
        </nav>
      </header>

      {/* SECCIÓN INICIO */}
      <section id="inicio" className="inicio">
        <div style={{ width: "100%", height: "100vh", position: "relative" }}>
          <Gradient
            color1="#000000"
            color2="#31ff03"
            color3="#011801"
            timeSpeed={0.25}
            colorBalance={0}
            warpStrength={1}
            warpFrequency={5}
            warpSpeed={2}
            warpAmplitude={50}
            blendAngle={0}
            blendSoftness={0.05}
            rotationAmount={500}
            noiseScale={2}
            grainAmount={0.1}
            grainScale={2}
            grainAnimated={false}
            contrast={1.5}
            gamma={1}
            saturation={1}
            centerX={0}
            centerY={0}
            zoom={0.9}
          />
          <div className="texto-inicio">
            <TextType
              text={["ROMP GPS", "Revolutionary Off-road Mapping Platform"]}
              typingSpeed={100}
              pauseDuration={1500}
              showCursor
              cursorCharacter="_"
              deletingSpeed={50}
              variableSpeed={{ min: 60, max: 120 }}
              cursorBlinkDuration={0.5}
            />
          </div>
        </div>
      </section>

      {/* SECCIÓN PRESENTACIÓN */}
      <section id="presentacion" className="section presentacion">
        <div className="container">
          <h2>¿Qué es ROMP GPS?</h2>
          <p>
            ROMP GPS es una plataforma revolucionaria de mapeo para vehículos
            todoterreno. Utiliza tecnología de punta para proporcionar
            navegación precisa en terrenos difíciles donde el GPS tradicional
            falla.
          </p>
          <div className="features-grid">
            <div className="feature-card">
              <h3>🛰️ Precisión</h3>
              <p>Navegación exacta en cualquier terreno</p>
            </div>
            <div className="feature-card">
              <h3>🗺️ Mapeo</h3>
              <p>Mapas detallados de rutas todoterreno</p>
            </div>
            <div className="feature-card">
              <h3>⚡ Velocidad</h3>
              <p>Actualizaciones en tiempo real</p>
            </div>
            <div className="feature-card">
              <h3>🔒 Seguridad</h3>
              <p>Tus datos protegidos con encriptación</p>
            </div>
          </div>
        </div>
      </section>

      {/* SECCIÓN PLANES */}
      <section id="planes" className="section planes">
        <div className="container">
          <h2>Nuestros Planes</h2>
          <div className="planes-grid">
            <div className="plan-card">
              <h3>Plan Básico</h3>
              <p className="precio">$9.99/mes</p>
              <ul className="plan-features">
                <li>✓ Acceso básico a mapas</li>
                <li>✓ Navegación estándar</li>
                <li>✓ Soporte por email</li>
              </ul>
              <button>Comenzar</button>
            </div>

            <div className="plan-card destacado">
              <h3>Plan Pro</h3>
              <p className="precio">$29.99/mes</p>
              <p className="popular">MÁS POPULAR</p>
              <ul className="plan-features">
                <li>✓ Acceso completo a mapas</li>
                <li>✓ Navegación avanzada</li>
                <li>✓ Tracking en tiempo real</li>
                <li>✓ Soporte prioritario</li>
              </ul>
              <button>Comenzar</button>
            </div>

            <div className="plan-card">
              <h3>Plan Enterprise</h3>
              <p className="precio">Personalizado</p>
              <ul className="plan-features">
                <li>✓ Solución completamente personalizada</li>
                <li>✓ Integración con sistemas</li>
                <li>✓ Soporte 24/7</li>
                <li>✓ Consultoría dedicada</li>
              </ul>
              <button>Contactar</button>
            </div>
          </div>
        </div>
      </section>

      {/* SECCIÓN EQUIPO */}
      <section id="equipo" className="section equipo">
        <div className="container">
          <h2>Nuestro Equipo</h2>
          <div className="team-grid">
            <div className="team-member">
              <div className="member-avatar">👨‍💼</div>
              <h4>Carlos García</h4>
              <p className="role">CTO & Co-Founder</p>
              <p className="description">
                Experto en tecnología GPS y sistemas de navegación
              </p>
            </div>

            <div className="team-member">
              <div className="member-avatar">👩‍💻</div>
              <h4>María López</h4>
              <p className="role">Lead Developer</p>
              <p className="description">
                Especialista en desarrollo de aplicaciones móviles
              </p>
            </div>

            <div className="team-member">
              <div className="member-avatar">👨‍🔧</div>
              <h4>Juan Martínez</h4>
              <p className="role">DevOps Engineer</p>
              <p className="description">
                Responsable de infraestructura y escalabilidad
              </p>
            </div>

            <div className="team-member">
              <div className="member-avatar">👩‍🎨</div>
              <h4>Sofia Rodríguez</h4>
              <p className="role">Product Designer</p>
              <p className="description">
                Diseñadora de experiencia de usuario
              </p>
            </div>
          </div>
        </div>
      </section>

      {/* SECCIÓN CONTACTO */}
      <section id="contacto" className="section contacto">
        <div className="container">
          <h2>Contacto</h2>
          <div className="contact-content">
            <div className="contact-info">
              <div className="info-item">
                <h4>📧 Email</h4>
                <p>
                  <a href="mailto:info@rompgps.com">info@rompgps.com</a>
                </p>
              </div>

              <div className="info-item">
                <h4>📱 Teléfono</h4>
                <p>
                  <a href="tel:+34912345678">+34 91 234 5678</a>
                </p>
              </div>

              <div className="info-item">
                <h4>📍 Ubicación</h4>
                <p>Madrid, España</p>
              </div>

              <div className="social-links">
                <h4>Síguenos</h4>
                <div className="social-icons">
                  <a href="#" className="social-link">
                    🐦 Twitter
                  </a>
                  <a href="#" className="social-link">
                    📱 Instagram
                  </a>
                  <a href="#" className="social-link">
                    💼 LinkedIn
                  </a>
                </div>
              </div>
            </div>

            <form className="contact-form">
              <div className="form-group">
                <label htmlFor="nombre">Nombre</label>
                <input
                  type="text"
                  id="nombre"
                  placeholder="Tu nombre"
                  required
                />
              </div>

              <div className="form-group">
                <label htmlFor="email">Email</label>
                <input
                  type="email"
                  id="email"
                  placeholder="tu@email.com"
                  required
                />
              </div>

              <div className="form-group">
                <label htmlFor="asunto">Asunto</label>
                <input
                  type="text"
                  id="asunto"
                  placeholder="Asunto del mensaje"
                  required
                />
              </div>

              <div className="form-group">
                <label htmlFor="mensaje">Mensaje</label>
                <textarea
                  id="mensaje"
                  placeholder="Tu mensaje"
                  rows={5}
                  required
                />
              </div>

              <button type="submit" className="btn-submit">
                Enviar Mensaje
              </button>
            </form>
          </div>
        </div>
      </section>

      {/* FOOTER */}
      <footer className="footer">
        <div className="container">
          <p>&copy; 2026 ROMP GPS. Todos los derechos reservados.</p>
          <p>
            Hecho con ❤️ para los aventureros del terreno todoterreno.
          </p>
        </div>
      </footer>
    </>
  );
}

export default App;