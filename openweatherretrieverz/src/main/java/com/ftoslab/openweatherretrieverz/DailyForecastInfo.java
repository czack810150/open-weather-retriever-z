package com.ftoslab.openweatherretrieverz;

import java.util.Calendar;
import java.util.List;

public class DailyForecastInfo {
	private String weatherUnit; // Default, Metric, Imperial
	private String cityId;
	private String cityName;
	private String geoLongitude;
	private String geoLatitude;
	private String dailyAverageTemperature;
	private String dailyMaxTemperature;
	private String dailyMinTemperature;
	private List<String> weatherDescriptionList;
	private List<String> weatherIconIdLinkList;
	private String averagePressure;
	private String averageHumidity;
	private String averageWindSpeed;
	private String rainVolumeProjected;
	private String snowVolumeProjected;
	private int dataCount;
    private Calendar dateCalendar;

    public DailyForecastInfo(){
        super();
    }
    protected DailyForecastInfo(DailyForecastInfo another){
        this.weatherUnit = another.getWeatherUnit();
        this.cityId = another.getCityId();
        this.cityId = another.getCityName();
        this.geoLongitude = another.getGeoLongitude();
        this.geoLatitude = another.getGeoLatitude();
        this.dailyAverageTemperature = another.getDailyAverageTemperature();
        this.dailyMaxTemperature = another.getDailyMaxTemperature();
        this.dailyMinTemperature = another.getDailyMinTemperature();
        this.weatherDescriptionList = another.getWeatherDescriptionList(); // safe? TODO
        this.weatherIconIdLinkList = another.getWeatherIconIdLinkList();
        this.averagePressure = another.getAveragePressure();
        this.averageHumidity = another.getAverageHumidity();
        this.averageWindSpeed = another.getAverageWindSpeed();
        this.rainVolumeProjected = another.getRainVolumeProjected();
        this.snowVolumeProjected = another.getSnowVolumeProjected();
    }
	//GETTERS
	public String getWeatherUnit() {
		return weatherUnit;
	}
	public String getCityId() {
		return cityId;
	}
	public String getCityName() {
		return cityName;
	}
	public String getGeoLongitude() {
		return geoLongitude;
	}
	public String getGeoLatitude() {
		return geoLatitude;
	}
	public String getDailyAverageTemperature() {
		return dailyAverageTemperature;
	}
	public String getDailyMaxTemperature() {
		return dailyMaxTemperature;
	}
	public String getDailyMinTemperature() {
		return dailyMinTemperature;
	}
	public List<String> getWeatherDescriptionList() {
		return weatherDescriptionList;
	}
	public List<String> getWeatherIconIdLinkList() {
		return weatherIconIdLinkList;
	}
	public String getAveragePressure() {
		return averagePressure;
	}
	public String getAverageHumidity() {
		return averageHumidity;
	}
	public String getAverageWindSpeed() {
		return averageWindSpeed;
	}
	public String getRainVolumeProjected() {
		return rainVolumeProjected;
	}
	public String getSnowVolumeProjected() {
		return snowVolumeProjected;
	}
	public int getDataCount() {
		return dataCount;
	}

    public Calendar getDateCalendar() {
        return dateCalendar;
    }

    // SETTERS
	protected void setWeatherUnit(String weatherUnit) {
		this.weatherUnit = weatherUnit;
	}
	protected void setCityId(String cityId) {
		this.cityId = cityId;
	}
	protected void setCityName(String cityName) {
		this.cityName = cityName;
	}
	protected void setGeoLongitude(String geoLongitude) {
		this.geoLongitude = geoLongitude;
	}
	protected void setGeoLatitude(String geoLatitude) {
		this.geoLatitude = geoLatitude;
	}
	protected void setDailyAverageTemperature(String dailyAverageTemperature) {
		this.dailyAverageTemperature = dailyAverageTemperature;
	}
	protected void setDailyMaxTemperature(String dailyMaxTemperature) {
		this.dailyMaxTemperature = dailyMaxTemperature;
	}
	protected void setDailyMinTemperature(String dailyMinTemperature) {
		this.dailyMinTemperature = dailyMinTemperature;
	}
	protected void setWeatherDescriptionList(List<String> weatherDescriptionList) {
		this.weatherDescriptionList = weatherDescriptionList;
	}
	protected void setWeatherIconIdLinkList(List<String> weatherIconId) {
		this.weatherIconIdLinkList = weatherIconId;
	}
	protected void setAveragePressure(String averagePressure) {
		this.averagePressure = averagePressure;
	}
	protected void setAverageHumidity(String averageHumidity) {
		this.averageHumidity = averageHumidity;
	}
	protected void setAverageWindSpeed(String averageWindSpeed) {
		this.averageWindSpeed = averageWindSpeed;
	}
	protected void setRainVolumeProjected(String rainVolumeProjected) {
		this.rainVolumeProjected = rainVolumeProjected;
	}
	protected void setSnowVolumeProjected(String snowVolumeProjected) {
		this.snowVolumeProjected = snowVolumeProjected;
	}
	protected void setDataCount(int dataCount) {
		this.dataCount = dataCount;
	}
    protected void setDateCalendar(Calendar dateCalendar) {
        this.dateCalendar = dateCalendar;
    }
	
}
