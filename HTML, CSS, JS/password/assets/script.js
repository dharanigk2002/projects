const inputField = document.querySelector('input');
const span = document.querySelector('span');

span.addEventListener('click', () => {
    if (inputField.value) {
        if (inputField.type === "password") {
            inputField.type = 'text';
            span.textContent = "hide";
        }
        else {
            inputField.type = 'password';
            span.textContent = "show";
        }
    }
})