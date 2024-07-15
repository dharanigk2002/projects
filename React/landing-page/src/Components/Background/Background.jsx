import video1 from "/assets/images/video1.mp4"
import styles from './Background.module.css';

const Background = ({ imageNo, playStatus }) => {
    if (playStatus) 
        return (
            <video className={styles.background} muted autoPlay loop>
                <source src={video1} type="video/mp4" />
            </video>
        )
    else {
        const img = `/assets/images/image${imageNo+1}.png`;
        return <img src={img} alt="image" className={styles.background} />
    }
}

export default Background;