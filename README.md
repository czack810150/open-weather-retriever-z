# open-weather-retriever-z
## Introduction
This is a wrapper that makes getting weather information from OpenWeatherMap a whole lot easier. What seperates this from other wrappers is that, in addition to the basic weather information, it allows free openweathermap user to get up to 5 days of daily forecast information, which typically requires a developer account with OpenWeatherMap(180USD/month). Please note that this is not a hack, instead the library calculates the 3-hour forecast information that free users get, summarize those values, and return it as daily forecast.
## How to use this library
### Dependency
Step 1: Add jCenter to your repository in project's build.gradle file: 
``` 
repositories {
    ...
    ...
    jcenter()
}
```
Step 2: In module's build.gradle add the following dependency:

```
dependencies {
    ... 
    ... 
    compile 'com.ftoslab:openweatherretrieverz:0.1.4'
}
```
### Functions Available
Current Weather Information:
- current temperature
- current maximum temperature
- current minimum temperature
- short and long weather description
- weather icon link from OpenWeatherMap
- pressure
- humidity
- windspeed
- 3-hour rain volume
- 3-hour snow volume

5 Day Forecast:
- daily average temperature
- daily high temperature
- daily low temperature
- weather description
- weather icon link from OpenWeatherMap
- average pressure
- average humidity
- average wind speed
- rain volume projected
- snow volume projected
Tools:
- convert all units to Metric
- convert all units to Imperial
- temperature converter

