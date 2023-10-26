# weather-app
Weather App using openweathermap.org free API

## API
- https://api.openweathermap.org/data/2.5/forecast
  - Query: lat & lon (auto detect city based on latitute and longitute)
  - Query: city (user's input in search bar)

## Tech
This app uses:
- Kotlin (Language)
- Hilt (Dependency Injection)
- Coroutines (Asynchronous programming)
- Retrofit (Network)
- AndroidX Compose (UI)
- Material 3 (UI)
- Moshi (Parse JSON data)
- JUnit4 (Unit test)
- MockK (Mocking)

## Architecture
- MVI (Model-View-Intent), a bit similar with MVVM
- Clean architecture

## How to Run the App
- Clone this project
- Run the project, this require any Android device with API level 21 and above
- Give permission to Location

## Recording
[Screen_recording_20231026_184638.webm](https://github.com/estermel/weather-app/assets/18325015/91fc9a89-4ee7-4038-9374-85c91e61b52a)
