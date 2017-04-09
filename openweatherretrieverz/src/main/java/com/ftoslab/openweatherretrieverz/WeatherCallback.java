package com.ftoslab.openweatherretrieverz;

public abstract class WeatherCallback {
	public abstract void onReceiveWeatherInfo(CurrentWeatherInfo currentWeatherInfo);
	public abstract void onFailure(String error);
}
