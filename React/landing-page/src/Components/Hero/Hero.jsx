import arrow from "/assets/images/arrow_btn.png";
import pause from "/assets/images/pause_icon.png";
import play from "/assets/images/play_icon.png";
import styles from "./Hero.module.css";

const Hero = ({ imageNo, setImage, setPlayStatus, heroData, playStatus }) => {
  return (
    <section className={styles.heroSection}>
      <div className={styles.textContent}>
        <h2>{heroData.text1}</h2>
        <h2>{heroData.text2}</h2>
      </div>
      <div className={styles.explore}>
        <p>Explore the features</p>
        <img src={arrow} alt="arrow" />
      </div>
      <div className={styles.footer}>
        <ul>
          {[null, null, null].map((data, i) => (
            <li
              key={i}
              onClick={() => setImage(i)}
              className={`${i === imageNo && styles.active}`}
            ></li>
          ))}
        </ul>
        <div>
          <img
            src={playStatus ? pause : play}
            alt="video-icon"
            onClick={() => setPlayStatus(!playStatus)}
          />
          <p>{playStatus ? "Pause" : "Play"} the video</p>
        </div>
      </div>
    </section>
  );
};

export default Hero;
