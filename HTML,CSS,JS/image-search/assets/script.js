const inputForm = document.querySelector('.input-field');
const input = document.querySelector('input');
const searchButton = document.querySelector('button');
const gallery = document.querySelector('.gallery');
const showMore = document.querySelector('.show-more');
const CLIENT_ID = "dDo485OFctj8QjIu0HSsy4y0qFliYRY5_F9C59u04qY";
let page = 12;
let query = "";

const fetchImage = async () => {
    const API = `https://api.unsplash.com/search/photos?page=${page}&per_page=12&query=${query}&client_id=${CLIENT_ID}`;
    const response = await fetch(API);
    const data = await response.json();
    const results = data.results;
    results.forEach(result => {
        const image = document.createElement('img');
        image.src = result.urls.small;
        image.alt = result.id;
        const imageLink = document.createElement('a');
        imageLink.href = result.links.html;
        imageLink.target = '_target';
        imageLink.appendChild(image);
        gallery.appendChild(imageLink);
    });
    if(gallery.hasChildNodes() === true){
        showMore.style.display = 'none';
        console.log("Hi");
    }
}

inputForm.addEventListener('submit', e => {
    e.preventDefault();
    query = input.value;
    gallery.innerHTML = input.value = "";
    fetchImage();
    showMore.style.display = "block";
})

showMore.addEventListener('click', () => {
    page++;
    fetchImage();
})