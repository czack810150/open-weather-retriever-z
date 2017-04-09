package com.ftoslab.openweatherretrieverz;

import java.util.Date;
import java.util.List;
import java.util.TimeZone;

public class Main {

	/**
	 * @param args
	 */
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		Date date = new Date(System.currentTimeMillis() + TimeZone.getDefault().getRawOffset());
//		System.out.println("date: " + date.toString());
//		OpenWeatherRetrieverZ retreiever = new OpenWeatherRetrieverZ("ea6ab1ca55169a961c105dd860a3d79f");
//		retreiever.updateCurrentWeatherInfo("6167865", new WeatherCallback(){
//
//			@Override
//			public void onReceiveWeatherInfo(CurrentWeatherInfo currentWeatherInfo) {
//				// TODO Auto-generated method stub
//				System.out.println("---------------------Current Weather Default---------------------");
//				System.out.println("cityName: " + currentWeatherInfo.getCityName());
//				System.out.println("cityId: " + currentWeatherInfo.getCityId());
//				System.out.println("short: " + currentWeatherInfo.getWeatherDescriptionShort());
//				System.out.println("long: " + currentWeatherInfo.getWeatherDescriptionLong());
//				System.out.println("icon: " + currentWeatherInfo.getWeatherIconId());
//				System.out.println("temp: " + currentWeatherInfo.getCurrentTemperature());
//				System.out.println("temp max: " + currentWeatherInfo.getCurrentTemperatureMax());
//				System.out.println("temp min: " + currentWeatherInfo.getCurrentTemperatureMin());
//				System.out.println("pressure: " + currentWeatherInfo.getPressure());
//				System.out.println("humidity: " + currentWeatherInfo.getHumidity());
//				System.out.println("wind speed: " + currentWeatherInfo.getWindSpeed());
//				System.out.println("snow vol: " + currentWeatherInfo.getSnowVolumeLast3hrs());
//				System.out.println("rain vol: " + currentWeatherInfo.getRainVolumeLast3hrs());
//				System.out.println("---------------------------------------------------------");
//				currentWeatherInfo = WeatherUnitConverter.convertToImperial(currentWeatherInfo);
//				System.out.println("---------------------Current Weather Imperial---------------------");
//				System.out.println("cityName: " + currentWeatherInfo.getCityName());
//				System.out.println("cityId: " + currentWeatherInfo.getCityId());
//				System.out.println("short: " + currentWeatherInfo.getWeatherDescriptionShort());
//				System.out.println("long: " + currentWeatherInfo.getWeatherDescriptionLong());
//				System.out.println("icon: " + currentWeatherInfo.getWeatherIconId());
//				System.out.println("temp: " + currentWeatherInfo.getCurrentTemperature());
//				System.out.println("temp max: " + currentWeatherInfo.getCurrentTemperatureMax());
//				System.out.println("temp min: " + currentWeatherInfo.getCurrentTemperatureMin());
//				System.out.println("pressure: " + currentWeatherInfo.getPressure());
//				System.out.println("humidity: " + currentWeatherInfo.getHumidity());
//				System.out.println("wind speed: " + currentWeatherInfo.getWindSpeed());
//				System.out.println("snow vol: " + currentWeatherInfo.getSnowVolumeLast3hrs());
//				System.out.println("rain vol: " + currentWeatherInfo.getRainVolumeLast3hrs());
//				System.out.println("---------------------------------------------------------");
//				currentWeatherInfo = WeatherUnitConverter.convertToMetric(currentWeatherInfo);
//				System.out.println("---------------------Current Weather Metric---------------------");
//				System.out.println("cityName: " + currentWeatherInfo.getCityName());
//				System.out.println("cityId: " + currentWeatherInfo.getCityId());
//				System.out.println("short: " + currentWeatherInfo.getWeatherDescriptionShort());
//				System.out.println("long: " + currentWeatherInfo.getWeatherDescriptionLong());
//				System.out.println("icon: " + currentWeatherInfo.getWeatherIconId());
//				System.out.println("temp: " + currentWeatherInfo.getCurrentTemperature());
//				System.out.println("temp max: " + currentWeatherInfo.getCurrentTemperatureMax());
//				System.out.println("temp min: " + currentWeatherInfo.getCurrentTemperatureMin());
//				System.out.println("pressure: " + currentWeatherInfo.getPressure());
//				System.out.println("humidity: " + currentWeatherInfo.getHumidity());
//				System.out.println("wind speed: " + currentWeatherInfo.getWindSpeed());
//				System.out.println("snow vol: " + currentWeatherInfo.getSnowVolumeLast3hrs());
//				System.out.println("rain vol: " + currentWeatherInfo.getRainVolumeLast3hrs());
//				System.out.println("---------------------------------------------------------");
//			}
//
//			@Override
//			public void onFailure(String error) {
//				// TODO Auto-generated method stub
//				System.err.println(error);
//			}
//
//		});
//		retreiever.updateDailyForecastInfo("6167865", TimeZone.getDefault(), new DailyForecastCallback(){
//
//			@Override
//			public void onReceiveDailyForecastInfoList(List<DailyForecastInfo> dailyForecastInfoList) {
//				// TODO Auto-generated method stub
//				System.out.println("onReceiveDailyForecastList");
//			}
//
//			@Override
//			public void onFailure(String error) {
//				// TODO Auto-generated method stub
//				//System.err.println(error);
//			}
//
//
//
//		});
//
//		//System.out.println("shouldn't be waiting");
//		// TODO Test if thread calls back
//		try {
//			Thread.sleep(100000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

}
