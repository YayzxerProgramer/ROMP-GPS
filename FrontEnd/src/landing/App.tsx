import "../App.css";
import Gradient from "../reactbits/Gradient.tsx";
import TextType from "../reactbits/TextType.tsx";
import { Header } from "./Header.tsx";
import GooeyNav from "../reactbits/GoovyNav.tsx";

function App() {
  const navItems = [
    { label: "Presentación", href: "#presentacion" },
    { label: "Planes", href: "#planes" },
    { label: "Equipo", href: "#equipo" },
    { label: "Contacto", href: "#contacto" },
  ];

  return (
    <>
      <Header />
      <GooeyNav items={navItems} />
      <div className="inicio">
        <div style={{ width: "100%", height: "80vh", position: "relative" }}>
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
      </div>
    </>
  );
}

export default App;
