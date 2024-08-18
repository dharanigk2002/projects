import * as R from "react";
import { useCart } from "../context/CartContext";
import styles from "./Product.module.css";

const Product = ({ product }) => {
  const { cart, setCart } = useCart();
  return (
    <div className={styles.product}>
      <div className={styles.productContent}>
        <img src={product.image} alt={product.title} />
        <div className={styles.productDesc}>
          <h4>{product.title.split(" ").slice(0, 3).join(" ")}</h4>
          <p>Rs.{parseInt(product.price)}</p>
        </div>
      </div>
      {cart.find(c => c.id === product.id) ? (
        <button
          onClick={() => setCart(cart.filter((c) => c.id !== product.id))}
        >
          Remove from cart
        </button>
      ) : (
        <button onClick={() => setCart([...cart, product])}>Add to cart</button>
      )}
    </div>
  );
};

export default Product;
