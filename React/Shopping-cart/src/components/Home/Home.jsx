import { useEffect, useState } from "react";
import api from "../../api/products";
import styles from "./Home.module.css";
import Product from "../Product/Product";

const Home = () => {
  const [products, setProducts] = useState(null);

  useEffect(() => {
    const loadData = async () => {
      try {
        const response = await api.get("/products");
        if (response && response.data) setProducts(response.data);
      } catch (error) {
        console.log(error.message);
      }
    };
    loadData();
  }, []);

  return (
    <main className={styles.productPage}>
      {products &&
        products.slice(0, 4).map((product) => (
          <Product key={product.id} product={product} />
        ))}
    </main>
  );
};

export default Home;
