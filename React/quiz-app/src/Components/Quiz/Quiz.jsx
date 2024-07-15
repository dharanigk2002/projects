import { useRef, useState } from 'react';
import questions from '../../assets/questions';
import styles from './Quiz.module.css';

const Quiz = () => {
    const [index, setIndex] = useState(0);
    const [score, setScore] = useState(0);
    const [selected, setSelected] = useState(false);
    const [scorePage, setScorePage] = useState(false);
    let optionRef = useRef([]);
    let currentQuestion = questions[index];

    const selectOption = (e, idx) => {
        if(!selected){
            if(currentQuestion.answer === idx){
                setScore(score+1);
                e.target.classList.add(styles.correct);
            }else {
                e.target.classList.add(styles.wrong);
                optionRef.current[currentQuestion.answer].classList.add(styles.correct);
            }
            setSelected(true);
        }
    }
    const nextQuestion = () => {
        setIndex(index+1);
        if(index >= questions.length)
            setScorePage(true);
        else {
            setSelected(false);
            optionRef.current.map(opt => opt && (opt.className = ""));
        }
    }
    const replayQuiz = () => {
        setIndex(0);
        setScore(0);
        setScorePage(false);
    }
  return (
    <div className={styles.quizContainer}>
        <h1>Quiz Application</h1>
        <hr />
        {scorePage === false && currentQuestion ? (
            <>
                <p className={styles.question}>{index+1}. {currentQuestion.question}</p>
                <ul>
                    {
                        currentQuestion.options.map((option, idx) => (
                            <li key={idx} ref={(el) => optionRef.current[idx] = el} onClick={e => selectOption(e, idx)}>{option}</li>
                        ))
                    }
                </ul>
                <button className={`${selected && styles.display}`} onClick={() => nextQuestion()}>Next</button>
                <b>{index+1} of {questions.length} questions</b>
            </>
        ) : (
            <>
                <p className={styles.question}>You scored {score} out of {questions.length} questions</p>
                <button onClick={() => replayQuiz()} className={styles.display}>Retry</button>
            </>
        )}
        
    </div>
  )
}

export default Quiz