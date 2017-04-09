package com.ftoslab.openweatherretrieverz;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class WeatherUnitConverter {
	
	// BULK UNIT CONVERSIONS
	public static CurrentWeatherInfo convertToImperial(CurrentWeatherInfo currentWeatherInfo){
        CurrentWeatherInfo currentWeatherInfoImperial = new CurrentWeatherInfo(currentWeatherInfo);
		double curMaxTemp = Double.parseDouble(currentWeatherInfo.getCurrentTemperatureMax());
		double curMinTemp = Double.parseDouble(currentWeatherInfo.getCurrentTemperatureMin());
		double curTemp = Double.parseDouble(currentWeatherInfo.getCurrentTemperature());
		double wind = Double.parseDouble(currentWeatherInfo.getWindSpeed());
		if (WeatherUnit.UNIT_DEFAULT.equals(currentWeatherInfo.getWeatherUnit())){
            currentWeatherInfoImperial.setCurrentTemperatureMax(String.format(Locale.getDefault(), "%.1f", convertKelvinToFahrenheit(curMaxTemp)));
            currentWeatherInfoImperial.setCurrentTemperatureMin(String.format(Locale.getDefault(), "%.1f", convertKelvinToFahrenheit(curMinTemp)));
            currentWeatherInfoImperial.setCurrentTemperature(String.format(Locale.getDefault(), "%.1f", convertKelvinToFahrenheit(curTemp)));
		}else if (WeatherUnit.UNIT_METRIC.equals(currentWeatherInfo.getWeatherUnit())){
            currentWeatherInfoImperial.setCurrentTemperatureMax(String.format(Locale.getDefault(), "%.1f", convertCelsiusToFahrenheit(curMaxTemp)));
            currentWeatherInfoImperial.setCurrentTemperatureMin(String.format(Locale.getDefault(), "%.1f", convertCelsiusToFahrenheit(curMinTemp)));
            currentWeatherInfoImperial.setCurrentTemperature(String.format(Locale.getDefault(), "%.1f", convertCelsiusToFahrenheit(curTemp)));
		}
        currentWeatherInfoImperial.setWindSpeed(String.format(Locale.getDefault(), "%.1f", convertMetersPerSecToMilesPerHour(wind)));
        currentWeatherInfoImperial.setWeatherUnit(WeatherUnit.UNIT_IMPERIAL);
        // CLONE UNCHANGED FIELDS

		return currentWeatherInfoImperial;
	}
	public static List<DailyForecastInfo> convertToImperial(List<DailyForecastInfo> dailyForecastInfoList){
        List<DailyForecastInfo> dailyForecastInfoListImperial = new ArrayList<DailyForecastInfo>();
        for (DailyForecastInfo d : dailyForecastInfoList){
            DailyForecastInfo dailyForecastInfoImperial = new DailyForecastInfo(d);
			double curMaxTemp = Double.parseDouble(d.getDailyMaxTemperature());
			double curMinTemp = Double.parseDouble(d.getDailyMinTemperature());
			double avrTemp = Double.parseDouble(d.getDailyAverageTemperature());
			double wind = Double.parseDouble(d.getAverageWindSpeed());
			if (WeatherUnit.UNIT_DEFAULT.equals(d.getWeatherUnit())){
                dailyForecastInfoImperial.setDailyMaxTemperature(String.format(Locale.getDefault(), "%.1f", convertKelvinToFahrenheit(curMaxTemp)));
                dailyForecastInfoImperial.setDailyMinTemperature(String.format(Locale.getDefault(), "%.1f", convertKelvinToFahrenheit(curMinTemp)));
                dailyForecastInfoImperial.setDailyAverageTemperature(String.format(Locale.getDefault(), "%.1f", convertKelvinToFahrenheit(avrTemp)));
			}else if (WeatherUnit.UNIT_METRIC.equals(d.getWeatherUnit())){
                dailyForecastInfoImperial.setDailyMaxTemperature(String.format(Locale.getDefault(), "%.1f", convertCelsiusToFahrenheit(curMaxTemp)));
                dailyForecastInfoImperial.setDailyMinTemperature(String.format(Locale.getDefault(), "%.1f", convertCelsiusToFahrenheit(curMinTemp)));
                dailyForecastInfoImperial.setDailyAverageTemperature(String.format(Locale.getDefault(), "%.1f", convertCelsiusToFahrenheit(avrTemp)));
			}
            dailyForecastInfoImperial.setAverageWindSpeed(String.format(Locale.getDefault(), "%.1f", convertMetersPerSecToMilesPerHour(wind)));
            dailyForecastInfoImperial.setWeatherUnit(WeatherUnit.UNIT_IMPERIAL);
            dailyForecastInfoListImperial.add(dailyForecastInfoImperial);
		}
		return dailyForecastInfoListImperial;
	}
	public static CurrentWeatherInfo convertToMetric(CurrentWeatherInfo currentWeatherInfo){
        CurrentWeatherInfo currentWeatherInfoMetric = new CurrentWeatherInfo(currentWeatherInfo);
        double curMaxTemp = Double.parseDouble(currentWeatherInfo.getCurrentTemperatureMax());
		double curMinTemp = Double.parseDouble(currentWeatherInfo.getCurrentTemperatureMin());
		double curTemp = Double.parseDouble(currentWeatherInfo.getCurrentTemperature());
		double wind = Double.parseDouble(currentWeatherInfo.getWindSpeed());
		if (WeatherUnit.UNIT_DEFAULT.equals(currentWeatherInfo.getWeatherUnit())){
            currentWeatherInfoMetric.setCurrentTemperatureMax(String.format(Locale.getDefault(), "%.1f", convertKelvinToCelsius(curMaxTemp)));
            currentWeatherInfoMetric.setCurrentTemperatureMin(String.format(Locale.getDefault(), "%.1f", convertKelvinToCelsius(curMinTemp)));
            currentWeatherInfoMetric.setCurrentTemperature(String.format(Locale.getDefault(), "%.1f", convertKelvinToCelsius(curTemp)));
		}else if (WeatherUnit.UNIT_IMPERIAL.equals(currentWeatherInfo.getWeatherUnit())){
            currentWeatherInfoMetric.setCurrentTemperatureMax(String.format(Locale.getDefault(), "%.1f", convertFahrenheitToCelsius(curMaxTemp)));
            currentWeatherInfoMetric.setCurrentTemperatureMin(String.format(Locale.getDefault(), "%.1f", convertFahrenheitToCelsius(curMinTemp)));
            currentWeatherInfoMetric.setCurrentTemperature(String.format(Locale.getDefault(), "%.1f", convertFahrenheitToCelsius(curTemp)));
            currentWeatherInfoMetric.setWindSpeed(String.format(Locale.getDefault(), "%.1f", convertMilesPerHourToMetersPerSec(wind)));
		}
        currentWeatherInfoMetric.setWeatherUnit(WeatherUnit.UNIT_METRIC);
		return currentWeatherInfoMetric;
	}
	public static List<DailyForecastInfo> convertToMetric(List<DailyForecastInfo> dailyForecastInfoList){
        List<DailyForecastInfo> dailyForecastInfoListMetric = new ArrayList<DailyForecastInfo>();
        for (DailyForecastInfo d : dailyForecastInfoList){
            DailyForecastInfo dailyForecastInfoImperial = new DailyForecastInfo(d);
			double curMaxTemp = Double.parseDouble(d.getDailyMaxTemperature());
			double curMinTemp = Double.parseDouble(d.getDailyMinTemperature());
			double avrTemp = Double.parseDouble(d.getDailyAverageTemperature());
			double wind = Double.parseDouble(d.getAverageWindSpeed());
			if (WeatherUnit.UNIT_DEFAULT.equals(d.getWeatherUnit())){
                dailyForecastInfoImperial.setDailyMaxTemperature(String.format(Locale.getDefault(), "%.1f", convertKelvinToCelsius(curMaxTemp)));
                dailyForecastInfoImperial.setDailyMinTemperature(String.format(Locale.getDefault(), "%.1f", convertKelvinToCelsius(curMinTemp)));
                dailyForecastInfoImperial.setDailyAverageTemperature(String.valueOf(convertKelvinToCelsius(avrTemp)));
			}else if (WeatherUnit.UNIT_IMPERIAL.equals(d.getWeatherUnit())){
                dailyForecastInfoImperial.setDailyMaxTemperature(String.format(Locale.getDefault(), "%.1f", convertFahrenheitToCelsius(curMaxTemp)));
                dailyForecastInfoImperial.setDailyMinTemperature(String.format(Locale.getDefault(), "%.1f", convertFahrenheitToCelsius(curMinTemp)));
                dailyForecastInfoImperial.setDailyAverageTemperature(String.format(Locale.getDefault(), "%.1f", convertFahrenheitToCelsius(avrTemp)));
                dailyForecastInfoImperial.setAverageWindSpeed(String.format(Locale.getDefault(), "%.1f", convertMilesPerHourToMetersPerSec(wind)));
			}
            dailyForecastInfoImperial.setWeatherUnit(WeatherUnit.UNIT_METRIC);
            dailyForecastInfoListMetric.add(dailyForecastInfoImperial);
		}
		return dailyForecastInfoListMetric;
	}
	public static CurrentWeatherInfo convertToDefault(CurrentWeatherInfo currentWeatherInfo){
        CurrentWeatherInfo currentWeatherInfoDefault = new CurrentWeatherInfo(currentWeatherInfo);
		double curMaxTemp = Double.parseDouble(currentWeatherInfo.getCurrentTemperatureMax());
		double curMinTemp = Double.parseDouble(currentWeatherInfo.getCurrentTemperatureMin());
		double curTemp = Double.parseDouble(currentWeatherInfo.getCurrentTemperature());
		double wind = Double.parseDouble(currentWeatherInfo.getWindSpeed());
		if (WeatherUnit.UNIT_METRIC.equals(currentWeatherInfo.getWeatherUnit())){
            currentWeatherInfoDefault.setCurrentTemperatureMax(String.format(Locale.getDefault(), "%.1f", convertCelsiusToKelvin(curMaxTemp)));
            currentWeatherInfoDefault.setCurrentTemperatureMin(String.format(Locale.getDefault(), "%.1f", convertCelsiusToKelvin(curMinTemp)));
            currentWeatherInfoDefault.setCurrentTemperature(String.format(Locale.getDefault(), "%.1f", convertCelsiusToKelvin(curTemp)));
		}else if (WeatherUnit.UNIT_IMPERIAL.equals(currentWeatherInfo.getWeatherUnit())){
            currentWeatherInfoDefault.setCurrentTemperatureMax(String.format(Locale.getDefault(), "%.1f", convertFahrenheitToKelvin(curMaxTemp)));
            currentWeatherInfoDefault.setCurrentTemperatureMin(String.format(Locale.getDefault(), "%.1f", convertFahrenheitToKelvin(curMinTemp)));
            currentWeatherInfoDefault.setCurrentTemperature(String.format(Locale.getDefault(), "%.1f", convertFahrenheitToKelvin(curTemp)));
            currentWeatherInfoDefault.setWindSpeed(String.format(Locale.getDefault(), "%.1f", convertMilesPerHourToMetersPerSec(wind)));
		}
        currentWeatherInfoDefault.setWeatherUnit(WeatherUnit.UNIT_DEFAULT);
		return currentWeatherInfo;
	}
	public static List<DailyForecastInfo> convertToDefault(List<DailyForecastInfo> dailyForecastInfoList){
        List<DailyForecastInfo> dailyForecastInfoListDefault = new ArrayList<DailyForecastInfo>();
        for (DailyForecastInfo d : dailyForecastInfoList){
            DailyForecastInfo dailyForecastInfoDefault = new DailyForecastInfo(d);
			double curMaxTemp = Double.parseDouble(d.getDailyMaxTemperature());
			double curMinTemp = Double.parseDouble(d.getDailyMinTemperature());
			double avrTemp = Double.parseDouble(d.getDailyAverageTemperature());
			double wind = Double.parseDouble(d.getAverageWindSpeed());
			if (WeatherUnit.UNIT_METRIC.equals(d.getWeatherUnit())){
                dailyForecastInfoDefault.setDailyMaxTemperature(String.format(Locale.getDefault(), "%.1f", convertCelsiusToKelvin(curMaxTemp)));
                dailyForecastInfoDefault.setDailyMinTemperature(String.format(Locale.getDefault(), "%.1f", convertCelsiusToKelvin(curMinTemp)));
                dailyForecastInfoDefault.setDailyAverageTemperature(String.valueOf(convertCelsiusToKelvin(avrTemp)));
			}else if (WeatherUnit.UNIT_IMPERIAL.equals(d.getWeatherUnit())){
                dailyForecastInfoDefault.setDailyMaxTemperature(String.format(Locale.getDefault(), "%.1f", convertFahrenheitToKelvin(curMaxTemp)));
                dailyForecastInfoDefault.setDailyMinTemperature(String.format(Locale.getDefault(), "%.1f", convertFahrenheitToKelvin(curMinTemp)));
                dailyForecastInfoDefault.setDailyAverageTemperature(String.format(Locale.getDefault(), "%.1f", convertFahrenheitToKelvin(avrTemp)));
                dailyForecastInfoDefault.setAverageWindSpeed(String.format(Locale.getDefault(), "%.1f", convertMilesPerHourToMetersPerSec(wind)));
			}
            dailyForecastInfoDefault.setWeatherUnit(WeatherUnit.UNIT_DEFAULT);
            dailyForecastInfoListDefault.add(dailyForecastInfoDefault);
		}
		return dailyForecastInfoList;
	}
	
	// SINGLE UNIT CONVERSIONS
	public static double convertFahrenheitToCelsius(double temp){
		return (temp-32)*5/9;
	}
	public static double convertCelsiusToFahrenheit(double temp){
		return temp*9/5+32;
	}
	public static double convertKelvinToCelsius(double temp){
		return temp-273.15;
	}
	public static double convertCelsiusToKelvin(double temp){
		return temp+273.15;
	}
	public static double convertKelvinToFahrenheit(double temp){
		return temp*9/5-459.67;
	}
	public static double convertFahrenheitToKelvin(double temp){
		return (temp+459.67)*5/9;
	}
	public static double convertMetersPerSecToMilesPerHour(double temp){
		return temp*3600/1600;
	}
	public static double convertMilesPerHourToMetersPerSec(double temp){
		return temp*1600/3600;
	}
}
