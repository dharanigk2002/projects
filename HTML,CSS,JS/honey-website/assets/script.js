const header = document.querySelector('header');
const arrowTop = document.querySelector(".scroll");
const menuIcon = document.getElementById("menu-icon");
const navList = document.querySelector('.navlist');

window.addEventListener("scroll", () => {
    header.classList.toggle('sticky', window.scrollY > 80);
    arrowTop.style.display = window.scrollY > 180 ? "block" : "none";
    menuIcon.classList.remove('bx-x')
    navList.classList.remove("open");
});

menuIcon.addEventListener("click", () => {
    menuIcon.classList.toggle('bx-x')
    navList.classList.toggle("open");
});