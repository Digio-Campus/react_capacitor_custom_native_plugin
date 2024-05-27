import './App.css';
import React from 'react';
import plugin from "./PluginRegistration";


function App() {
  const handleClick = async () => {
    await plugin.openNativeView();
  }

  return (
      <div className="home">
        <h1>Vista React</h1>
        <button onClick={handleClick}>Navegar a vista nativa</button>
      </div>
  );
}

export default App;
