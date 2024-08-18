import { StrictMode } from "react";
import { createRoot } from "react-dom/client";
import App from "./App.jsx";
import { BrowserRouter } from "react-router-dom";
import "./index.css";
import CartContext from "./components/context/CartContext.jsx";

createRoot(document.getElementById("root")).render(
  <StrictMode>
    <CartContext>
      <BrowserRouter>
        <App />
      </BrowserRouter>
    </CartContext>
  </StrictMode>
);
