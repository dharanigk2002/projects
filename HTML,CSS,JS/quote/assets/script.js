const tweet = document.querySelector('.tweet');

tweet.addEventListener('click', () => {
    window.open("https://twitter.com/intent/tweet?text=Hello%20world", "", "width=600, height=300")
})