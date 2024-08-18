const API_KEY = "668c60064295bb32cb42ad0fd7ecca14";
const URL = `https://api.openweathermap.org/data/2.5/weather?&appid=${API_KEY}&units=metric&q=`;
const searchBox = document.querySelector(".search input");
const searchBtn = document.querySelector(".search button");
const weatherIcon = document.querySelector('.weather img');
const weather = document.querySelector('.weather');
async function checkWeather(city) {
    const response = await fetch(URL + city);
    if (response.status == '404') {
        document.querySelector('.error').style.display = 'block';
        weather.style.display = 'none';
    } else {
        var data = await response.json();
        document.querySelector('.city-name').textContent = data.name;
        document.querySelector('.temp').textContent = Math.round(data.main.temp) + '°C';
        document.querySelector('.humidity').textContent = data.main.humidity + '%';
        document.querySelector('.wind').textContent = data.wind.speed + ' km/hr';
        switch (data.weather[0].main) {
            case 'Clouds':
                weatherIcon.src = "assets/images/clouds.png";
                break;
            case 'Rain':
                weatherIcon.src = "assets/images/rain.png";
                break;
            case 'Drizzle':
                weatherIcon.src = "assets/images/drizzle.png";
                break;
            case 'Mist':
                weatherIcon.src = "assets/images/mist.png";
                break;
            default:
                weatherIcon.src = "assets/images/clear.png";
        }
        document.querySelector('.error').style.display = 'none';
        weather.style.display = 'block';
    }
}

searchBtn.addEventListener("click", () => {
    checkWeather(searchBox.value);
})