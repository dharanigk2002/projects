const toDoItem = document.querySelector('input');
const addButton = document.querySelector('button');
const taskItems = document.querySelector('.task-items');

window.onload = () => {
    taskItems.innerHTML = localStorage.getItem('data')
}

const addItem = () => {
    let li = document.createElement('li');
    li.textContent = toDoItem.value;
    let span = document.createElement('span')
    span.innerHTML = '&times;';
    li.appendChild(span);
    taskItems.appendChild(li);
    saveData();
}

addButton.addEventListener('click', () => {
    if (toDoItem.value === '')
        alert("Please enter some value");
    else {
        addItem();
        toDoItem.value = '';
    }
})

taskItems.addEventListener('click', e => {
    if (e.target.tagName === 'LI')
        e.target.classList.toggle('checked')
    else if (e.target.tagName === 'SPAN')
        e.target.parentElement.remove();
    saveData();
})

function saveData() {
    localStorage.setItem('data', taskItems.innerHTML)
}