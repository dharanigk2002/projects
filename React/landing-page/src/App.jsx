import { useEffect, useState } from "react";
import Background from "./Components/Background/Background";
import Navbar from "./Components/Navbar/Navbar";
import Hero from "./Components/Hero/Hero";

const App = () => {
  const heroData = [
    { text1: "Dive into", text2: "what you love" },
    { text1: "Indulge", text2: "your passions" },
    { text1: "Give in to", text2: "your passions" },
  ];
  const [imageNo, setImage] = useState(0);
  const [playStatus, setPlayStatus] = useState(false);
  useEffect(() => {
    setInterval(() => {
        setImage((img) => (img+1) % heroData.length);
    }, 3000);
    
  }, [playStatus]);
  return (
    <>
      <Background imageNo={imageNo} playStatus={playStatus} />
      <Navbar />
      <Hero
        imageNo={imageNo}
        setImage={setImage}
        setPlayStatus={setPlayStatus}
        heroData={heroData[imageNo]}
        playStatus={playStatus}
      />
    </>
  );
};

export default App;
