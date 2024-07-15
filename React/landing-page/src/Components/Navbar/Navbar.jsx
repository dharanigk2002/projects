import styles from './Navbar.module.css';

const Navbar = () => {
  return (
    <nav className={styles.navbar}>
      <h2 className={styles.logo}>EV-olution</h2>
      <ul className={styles.menuItems}>
        <li>Home</li>
        <li>Explore</li>
        <li>About</li>
        <li className={styles.active}>Contact</li>
      </ul>
    </nav>
  )
}

export default Navbar