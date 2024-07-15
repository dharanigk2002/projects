const question = document.querySelector(".question");
const buttons = document.querySelector(".buttons");
const nextButton = document.querySelector(".next-btn");
let currentQuestionIndex = 0;
let score = 0;

const questions = [
    {
        "question": "The Centre for Cellular and Molecular Biology is situated at",
        "answers": [
            { "text": "Patna", "correct": false },
            { "text": "Jaipur", "correct": false },
            { "text": "Hyderabad", "correct": true },
            { "text": "New Delhi", "correct": false }
        ]
    },
    {
        "question": "Where is the Railway Staff College located?",
        "answers": [
            { "text": "Pune", "correct": false },
            { "text": "Allahabad", "correct": false },
            { "text": "Vadodara", "correct": true },
            { "text": "Delhi", "correct": false }
        ]
    },
    {
        "question": "The famous Dilwara Temples are situated in",
        "answers": [
            { "text": "Uttar Pradesh", "correct": false },
            { "text": "Rajasthan", "correct": true },
            { "text": "Maharashtra", "correct": false },
            { "text": "Madhya Pradesh", "correct": false }
        ]
    },
    {
        "question": "Wadia Institute of Himalayan Geology is located at",
        "answers": [
            { "text": "Delhi", "correct": false },
            { "text": "Shimla", "correct": false },
            { "text": "Dehradun", "correct": true },
            { "text": "Kulu", "correct": false }
        ]
    },
    {
        "question": "Bijapur is known for its",
        "answers": [
            { "text": "severe drought condition", "correct": false },
            { "text": "Gol Gumbaz", "correct": true },
            { "text": "heavy rainfall", "correct": false },
            { "text": "statue of Gomateswara", "correct": false }
        ]
    }
];

const startQuiz = () => {
    currentQuestionIndex = 0;
    score = 0;
    nextButton.textContent = "Next";
    showQuestion();
}

const showQuestion = () => {
    resetState();
    const currentQuestion = questions[currentQuestionIndex];
    let questionNo = currentQuestionIndex + 1;
    question.textContent = questionNo + ". " + currentQuestion.question;
    currentQuestion.answers.forEach(answer => {
        let button = document.createElement("button");
        button.textContent = answer.text;
        answer.correct && (button.dataset.correct = answer.correct);
        button.addEventListener('click', selectedAnswer);
        buttons.appendChild(button);
    })
}

const selectedAnswer = e => {
    const currentAnswer = e.target;
    if (currentAnswer.dataset.correct) {
        currentAnswer.classList.add("correct");
        score++;
    }
    else
        currentAnswer.classList.add("wrong");
    nextButton.style.display = 'block';
    Array.from(buttons.children).forEach(btn => {
        btn.dataset.correct && (btn.classList.add("correct"));
        btn.disabled = true;
    })
}

nextButton.addEventListener('click', () => {
    if (currentQuestionIndex < questions.length)
        handleNextButton();
    else
        startQuiz();
})

const resetState = () => {
    nextButton.style.display = 'none';
    while (buttons.firstChild)
        buttons.removeChild(buttons.firstChild);
}

const showScore = () => {
    resetState();
    question.textContent = `You scored ${score} out of ${questions.length}`;
    nextButton.style.display = "block";
    nextButton.textContent = "Play again";
}

const handleNextButton = () => {
    currentQuestionIndex++;
    if (currentQuestionIndex < questions.length)
        showQuestion();
    else
        showScore();
}

startQuiz();