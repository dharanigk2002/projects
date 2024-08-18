import { NavLink } from 'react-router-dom'
import styles from './Header.module.css'
import { useCart } from '../context/CartContext'

const Header = () => {
  const { cart } = useCart();
  return <header className={styles.header}>
    <h1>Shopping cart</h1>
    <ul className={styles.navbar}>
        <li><NavLink to='/'>Home</NavLink></li>
        <li><NavLink to='cart'>Cart{cart.length > 0 && `(${cart.length})`}</NavLink></li>
    </ul>
  </header>
}

export default Header