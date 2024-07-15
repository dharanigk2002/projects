const gallery = document.querySelector('.container');
const nextBtn = document.querySelector('.next-btn');
const backBtn = document.querySelector('.back-btn');

gallery.addEventListener('wheel', e => {
    e.preventDefault();
    gallery.scrollLeft += e.deltaY;
    gallery.style.scrollBehaviour = 'auto'
})

nextBtn.addEventListener('click', e => {
    gallery.scrollLeft += 900;
})

backBtn.addEventListener('click', e => {
    gallery.scrollLeft -= 900;
})