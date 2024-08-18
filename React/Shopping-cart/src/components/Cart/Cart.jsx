import { useEffect, useState } from "react";
import { useCart } from "../context/CartContext";
import Product from "../Product/Product";
import styles from "./cart.module.css";

const Cart = () => {
  const { cart } = useCart();
  const [total, setTotal] = useState(null);
  useEffect(() => {
    const total = cart.reduce((acc, item) => acc + parseInt(item.price), 0);
    setTotal(total);
  }, [cart]);
  return (
    <>
      {cart.length > 0 ?
        (<section className={styles.cartSection}>
          <h5>Total price: Rs.{total}</h5>
          {cart.map((product) => {
            return <Product key={product.id} product={product} />;
          })}
        </section>) : (<h3 style={{textAlign: 'center', marginTop: '15%',}}>No items to display in cart</h3>)
      }
    </>
  );
};

export default Cart;
