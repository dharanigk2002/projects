const generateText = document.querySelector('button');
const inputText = document.querySelector('input');
const qrCode = document.querySelector('.qr-code');

function generateQR(data) {
    let image = document.createElement('img');
    image.src = "https://api.qrserver.com/v1/create-qr-code/?size=150x150&data=" + data;
    image.alt = inputText.value;
    if(qrCode.hasChildNodes())
        qrCode.removeChild(qrCode.firstChild)
    qrCode.appendChild(image);
}

generateText.addEventListener('click', () => {
    if(inputText.value.length > 0) {
        generateQR(inputText.value);
        qrCode.classList.add('show-image');
        inputText.value = '';
    }
})