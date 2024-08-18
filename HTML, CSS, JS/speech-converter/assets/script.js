const speech = new SpeechSynthesisUtterance();
const textField = document.querySelector('textarea');
const listen = document.querySelector('button');
const selectField = document.querySelector('select');
let voices = [];

window.speechSynthesis.onvoiceschanged = () => {
    voices = window.speechSynthesis.getVoices();
    voices.map((v, i) => {
        const { name } = v;
        selectField.options[i] = new Option(name, i)
    })
}

listen.addEventListener('click', () => {
    const toSpeak = textField.value;
    speech.text = toSpeak;
    speech.volume = 1;
    speech.pitch = 1;
    speech.rate = 1;
    speech.voice = voices[selectField.value]
    console.log(voices[selectField.value]);
    window.speechSynthesis.speak(speech);
})