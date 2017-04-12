package com.ftoslab.openweatherretrieverz;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class OpenWeatherRetrieverZ {
	private final String apiKey;
	
	private final String weatherRequestByCityIdFormattedUrl = "http://api.openweathermap.org/data/2.5/weather?id=%s&APPID=%s";
	private final String dailyForecastByCityIdFormattedUrl = "http://api.openweathermap.org/data/2.5/forecast?id=%s&APPID=%s";
	private final String weatherRequestByGeoLocationFormattedUrl = "http://api.openweathermap.org/data/2.5/weather?lat=%s&lon=%s&APPID=%s";
	private final String dailyForecastByGeoLocationFormattedUrl = "http://api.openweathermap.org/data/2.5/forecast?lat=%s&lon=%s&APPID=%s";
    private final String weatherIconFormattedUrl = "http://openweathermap.org/img/w/%s.png";
	
	
	
	// Public functions
	public OpenWeatherRetrieverZ(String apiKey){
		super();
		this.apiKey = apiKey;
	}
	public void updateCurrentWeatherInfo(String cityId, WeatherCallback callback){
		String weatherRequestByCityIdUrl = String.format(weatherRequestByCityIdFormattedUrl, cityId, apiKey);
		new ProcessWeatherAsyncTask(weatherRequestByCityIdUrl, callback).execute();
	}
	public void updateCurrentWeatherInfo(double geoLat, double geoLong, WeatherCallback callback){
		String weatherRequestByGeoLocationUrl = String.format(weatherRequestByGeoLocationFormattedUrl, geoLat, geoLong, apiKey);
        new ProcessWeatherAsyncTask(weatherRequestByGeoLocationUrl, callback).execute();
	}
	public void updateDailyForecastInfo(String cityId, DailyForecastCallback callback){
		String dailyForecastRequestByCityIdUrl = String.format(dailyForecastByCityIdFormattedUrl, cityId, apiKey);
		new ProcessForecastAsyncTask(dailyForecastRequestByCityIdUrl, callback).execute();
	}
	public void updateDailyForecastInfo(double geoLat, double geoLong, DailyForecastCallback callback){
		String dailyForecastByGeoLocationUrl = String.format(dailyForecastByGeoLocationFormattedUrl, geoLat, geoLong, apiKey);
        new ProcessForecastAsyncTask(dailyForecastByGeoLocationUrl, callback).execute();
	}
	
	// Private functions
	private CurrentWeatherInfo processWeatherInfo(String url) throws IOException, ParseException{
		JSONObject weatherJson = readJsonFromUrl(url);
		CurrentWeatherInfo currentWeatherInfo = new CurrentWeatherInfo();
		
		currentWeatherInfo.setGeoLongtitude(String.valueOf((((JSONObject)weatherJson.get("coord")).get("lon"))));
		currentWeatherInfo.setGeoLatitude(String.valueOf((((JSONObject)weatherJson.get("coord")).get("lat"))));
		currentWeatherInfo.setCityId(String.valueOf((Long)weatherJson.get("id")));
		currentWeatherInfo.setCityName((String)weatherJson.get("name"));
		JSONArray jArry = (JSONArray)weatherJson.get("weather");
		if (!jArry.isEmpty()){
			JSONObject j =  (JSONObject)jArry.get(0);
			currentWeatherInfo.setWeatherDescriptionShort((String)j.get("main"));
			currentWeatherInfo.setWeatherDescriptionLong((String)j.get("description"));
			currentWeatherInfo.setWeatherIconLink(String.format(weatherIconFormattedUrl, (String)j.get("icon")));
		}
		currentWeatherInfo.setWeatherUnit(WeatherUnit.UNIT_DEFAULT);
		JSONObject j = (JSONObject)weatherJson.get("main");
		currentWeatherInfo.setCurrentTemperature(String.valueOf(j.get("temp")));
		currentWeatherInfo.setCurrentTemperatureMax(String.valueOf(j.get("temp_max")));
		currentWeatherInfo.setCurrentTemperatureMin(String.valueOf(j.get("temp_min")));
		currentWeatherInfo.setPressure(String.valueOf(j.get("pressure")));
		currentWeatherInfo.setHumidity(String.valueOf(j.get("humidity")));
		JSONObject jWind = (JSONObject)weatherJson.get("wind");
		JSONObject jRain = (JSONObject)weatherJson.get("rain");
		JSONObject jSnow = (JSONObject)weatherJson.get("snow");
		if (jWind != null){
			currentWeatherInfo.setWindSpeed(String.valueOf(jWind.get("speed")));
		}
		if (jRain != null){
			currentWeatherInfo.setRainVolumeLast3hrs(String.valueOf(jRain.get("3h")));
		}
		if (jSnow != null){
			currentWeatherInfo.setSnowVolumeLast3hrs(String.valueOf(jSnow.get("3h")));
		}
		return currentWeatherInfo;
	}
    
	private List<DailyForecastInfo> processDailyForecastInfo(String url) throws IOException, ParseException{
			JSONObject forecastJson = readJsonFromUrl(url);
			List<DailyForecastInfo> dailyForecastInfoList = new ArrayList<DailyForecastInfo>();
            Map<String, String> weatherDescriptionIconMap = new HashMap<String, String>();
			// These fields are same across List
			String weatherUnit = WeatherUnit.UNIT_DEFAULT;
			String cityName = (String)((JSONObject)forecastJson.get("city")).get("name");
			String cityId = String.valueOf((Long)((JSONObject)forecastJson.get("city")).get("id"));
			String geoLat = String.valueOf(((JSONObject)((JSONObject)forecastJson.get("city")).get("coord")).get("lat"));
			String geoLon = String.valueOf(((JSONObject)((JSONObject)forecastJson.get("city")).get("coord")).get("lon"));
			// Now get the json array
			JSONArray jForecastArry = (JSONArray)forecastJson.get("list");
			Iterator<JSONObject> iterator = jForecastArry.iterator();
			int i = 0;
			while (iterator.hasNext()){
                // TODO add a logic to filter out forecast that's in the past!!
				i += 1;
				int sameDayDataCount = 0;
				double sumTemp = 0;
				double dailyHigh = 0;
				double dailyLow = 999;
				long sumHumidity = 0;
				double sumPressure = 0;
				double sumWindSpeed = 0;
				double sumRainVolume = 0;
				double sumSnowVolume = 0;
                Calendar dateCalendar = Calendar.getInstance();
				Map<String, Integer> weatherDescriptionCountMap = new HashMap<String, Integer>();
				//Date date = null;
                Calendar cal = Calendar.getInstance();
				int currentDay = -1;
				do{
					if (!iterator.hasNext()){
						break;
					}

					JSONObject j = iterator.next();
                    cal.setTimeInMillis(((Long)j.get("dt")*1000));
					//date = new Date(((Long)j.get("dt")*1000));
					if (currentDay == -1){
						//currentDay = date.getDay();
                        currentDay = cal.get(Calendar.DAY_OF_WEEK);
						dateCalendar.setTimeInMillis(cal.getTimeInMillis());
					}
                    if (cal.before(Calendar.getInstance())){
                        // If the weather data is from before current time, skip
                        continue;
                    }
					sameDayDataCount += 1;
					JSONObject jMain = (JSONObject)j.get("main");
					JSONObject jWind = (JSONObject)j.get("wind");
					JSONObject jRain = (JSONObject)j.get("rain");
					JSONObject jSnow = (JSONObject)j.get("snow");
					JSONArray jWeatherArry = (JSONArray) j.get("weather");
					if (!jWeatherArry.isEmpty()){
						JSONObject jWeatherDes = (JSONObject)jWeatherArry.get(0);
						String key = (String)jWeatherDes.get("main");
						if (weatherDescriptionCountMap.containsKey(key)){
							int previousCount = weatherDescriptionCountMap.get(key);
							weatherDescriptionCountMap.put(key, previousCount+1);
						} else {
							weatherDescriptionCountMap.put(key, 1);
						}
						if (!weatherDescriptionIconMap.containsKey(key)){
							weatherDescriptionIconMap.put(key, (String)jWeatherDes.get("icon"));
						}
					}
					double temp = Double.parseDouble(String.valueOf(jMain.get("temp")));
					sumTemp += temp;
					if (temp > dailyHigh){
						dailyHigh = temp;
					}
					if (temp < dailyLow){
						dailyLow = temp;
					}
					sumHumidity += Long.parseLong(String.valueOf(jMain.get("humidity")));
					sumPressure += Double.parseDouble(String.valueOf(jMain.get("pressure")));
					if (jWind != null){
						if (jWind.get("speed") != null){
							sumWindSpeed += Double.parseDouble(String.valueOf(jWind.get("speed")));
						}
					}
					if (jRain != null){
						if (jRain.get("3h") != null){
							sumRainVolume += Double.parseDouble(String.valueOf(jRain.get("3h")));
						}
					}
					if (jSnow != null){
						if (jSnow.get("3h") != null){
							sumSnowVolume += Double.parseDouble(String.valueOf(jSnow.get("3h")));
						}
					}
                    Log.d("CHECK CHECK CHECK", "Date: " + cal.get(Calendar.DAY_OF_WEEK) + "; hour: " + cal.get(Calendar.HOUR_OF_DAY));
				}
                while(cal.get(Calendar.DAY_OF_WEEK) == currentDay);

				DailyForecastInfo daily = new DailyForecastInfo();
				daily.setCityId(cityId);
				daily.setCityName(cityName);
				daily.setWeatherUnit(weatherUnit);
				daily.setGeoLatitude(geoLat);
				daily.setGeoLongitude(geoLon);
				daily.setDailyMaxTemperature(String.format(Locale.getDefault(), "%.1f", dailyHigh));
				daily.setDailyMinTemperature(String.format(Locale.getDefault(), "%.1f", dailyLow));
				daily.setDailyAverageTemperature(String.format(Locale.getDefault(), "%.1f", sumTemp/sameDayDataCount));
				daily.setAverageHumidity(String.format(Locale.getDefault(), "%.1f", ((double)(sumHumidity/sameDayDataCount))));
				daily.setAveragePressure(String.format(Locale.getDefault(), "%.1f", (double)(sumPressure/sameDayDataCount)));
				daily.setAverageWindSpeed(String.format(Locale.getDefault(), "%.1f", sumWindSpeed/sameDayDataCount));
				daily.setRainVolumeProjected(String.format(Locale.getDefault(), "%.1f", sumRainVolume));
				daily.setSnowVolumeProjected(String.format(Locale.getDefault(), "%.1f", sumSnowVolume));
				daily.setDataCount(sameDayDataCount);
                daily.setDateCalendar(dateCalendar);
                if (dateCalendar == null){
                    Log.e("Weird", "date calendar is null");
                }
				int maxCount = 0;
				List<String> weatherDescriptionList = new ArrayList<String>();
                List<String> weatherIconLinkList = new ArrayList<String>();
				for (String key : weatherDescriptionCountMap.keySet()){
					int count = weatherDescriptionCountMap.get(key);
					if (count > maxCount){
						maxCount = count;
						weatherDescriptionList.clear();
                        weatherIconLinkList.clear();
						weatherDescriptionList.add(key);
                        weatherIconLinkList.add(String.format(weatherIconFormattedUrl, weatherDescriptionIconMap.get(key)));
					}else if (count == maxCount){
						weatherDescriptionList.add(key);
                        weatherIconLinkList.add(String.format(weatherIconFormattedUrl, weatherDescriptionIconMap.get(key)));
					}
				}
				daily.setWeatherDescriptionList(weatherDescriptionList);
                daily.setWeatherIconIdLinkList(weatherIconLinkList);
				dailyForecastInfoList.add(daily);
                Log.d("Divider", "---------------------------------------------------");
            }
			return dailyForecastInfoList;
	}
	
	private JSONObject readJsonFromUrl(String url) throws IOException, ParseException{
	    InputStream is = new URL(url).openStream();
	    try {
	      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
	      JSONParser jParser = new JSONParser();
	      return (JSONObject) jParser.parse(rd);
	    } finally {
	      is.close();
	    }
	}
	
	//ASYNC Tasks
    private class ProcessWeatherAsyncTask extends AsyncTask<Void, Void, Void> {
        private String url;
        private WeatherCallback callback;
        private CurrentWeatherInfo weatherInfo;

        private ProcessWeatherAsyncTask(String url, WeatherCallback weathercallback){
            this.url = url;
            this.callback = weathercallback;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... objects) {
            try {
                this.weatherInfo = processWeatherInfo(this.url);
            } catch (IOException|ParseException e) {
                e.printStackTrace();
                callback.onFailure(e.toString());
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            callback.onReceiveWeatherInfo(weatherInfo);
        }
    }

    private class ProcessForecastAsyncTask extends AsyncTask<Object, Void, Void> {
        private String url;
        private DailyForecastCallback callback;
        private List<DailyForecastInfo> dailyForecastInfoList;

        private ProcessForecastAsyncTask(String url, DailyForecastCallback callback){
            this.url = url;
            this.callback = callback;
        }
        @Override
        protected Void doInBackground(Object... objects) {
            try {
                dailyForecastInfoList = processDailyForecastInfo(url);
            } catch (IOException|ParseException e) {
                e.printStackTrace();
                callback.onFailure(e.toString());
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            callback.onReceiveDailyForecastInfoList(dailyForecastInfoList);
        }
    }

}
