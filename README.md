# open-weather-retriever-z
## Introduction
This is a wrapper that makes getting weather information from OpenWeatherMap a whole lot easier. What seperates this from other wrappers is that, in addition to the basic weather information, it allows free openweathermap user to get up to 5 days of daily forecast information, which typically requires a developer account with OpenWeatherMap(180USD/month). Please note that this is not a hack, instead the library calculates the 3-hour forecast information that free users get, summarize those values, and return it as daily forecast.
## How to use this library
Step 1: Add jCenter to your repository in project's build.gradle file: 
``` 
repositories { 
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


