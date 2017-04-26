# open-weather-retriever-z

This is a wrapper that makes getting weather information from OpenWeatherMap a whole lot easier. What seperates this from other wrappers is that, in addition to the basic weather information, it allows free openweathermap user to get up to 5 days of daily forecast information, which typically requires a developer account with OpenWeatherMap(180USD/month). Please note that this is not a hack, instead the library calculates the 3-hour forecast information that free users get, summarize those values, and return it as daily forecast.
## Getting Started
### Dependency
Step 1: Add jcenter to your repository in project's build.gradle file: 
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
### Available Information
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

### Initialization
``` JAVA
// Initialize OpenWeatherRetrieverZ by passing in  your openweathermap api key
OpenWeatherRetrieverZ retriever = new OpenWeatherRetrieverZ(API_KEY);
/*
You can retrieve weather information with either OpenWeatherMap cityID or geolocation(Latitude, Logitude)
*/
retriever.updateCurrentWeatherInfo("6167865", new WeatherCallback() {
  @Override
  public void onReceiveWeatherInfo(CurrentWeatherInfo currentWeatherInfo) {
  	// Your code here
  }
  
  @Override
  public void onFailure(String error) {
    // Your code here
  }
});
retriever.updateDailyForecastInfo("6167865", new DailyForecastCallback() {
  @Override
  public void onReceiveDailyForecastInfoList(List<DailyForecastInfo> dailyForecastInfoList) {
  	// Your code here
  }
  
  @Override
  public void onFailure(String error) {
  	// Your code here
  }
});
```
Both updateCurrentWeatherInfo and updateDailyForecastInfo are async, which means the main thread won't hang there and wait for the operation to finish. Instead, callback functions will be called when the information became available or when something went wrong.

## Example
You can find an example app [here](https://github.com/czack810150/open-weather-retriever-z-example)

## Notes
The ArrayList you get from updateDailyForecastInfo starts from the same day you request it (index 0, day 1), and you will be able to get forecast up until day 6 around the same time, which means the forecast on day 6 might not cover the whole day. This is because as a free user, you only get 40 pieces of 3-hour forecast information (5 days starting from the time you request it). To check how many pieces of 3-hour data for a particular day, you can make use of the function getDataCount() on DailyForecastInfo. 

## Contribution
The project is still in its preliminary phase, any contribution is welcomed and appreciated. I will review all the pull requests.
If you find any bug or just wanna throw in a thought, feel free to create an issue!

## License
```
Copyright 2017 FTOSLab.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
