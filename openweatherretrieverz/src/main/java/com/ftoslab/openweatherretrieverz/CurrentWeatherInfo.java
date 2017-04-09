package com.ftoslab.openweatherretrieverz;

public class CurrentWeatherInfo {
	private String weatherUnit; // Default, Metric, Imperial
	private String cityId;
	private String cityName;
	private String geoLongtitude;
	private String geoLatitude;
	private String currentTemperature;
	private String currentTemperatureMax;
	private String currentTemperatureMin;
	private String weatherDescriptionShort;
	private String weatherDescriptionLong;
	private String weatherIconLink;
	private String pressure;
	private String humidity;
	private String windSpeed;
	private String rainVolumeLast3hrs;
	private String snowVolumeLast3hrs;

    public CurrentWeatherInfo(){
        super();
    }
    protected CurrentWeatherInfo(CurrentWeatherInfo another){
        this.weatherUnit = another.getWeatherUnit();
        this.cityId = another.getCityId();
        this.cityName = another.getCityName();
        this.geoLongtitude = another.getGeoLongtitude();
        this.geoLatitude = another.getGeoLatitude();
        this.currentTemperature = another.getCurrentTemperature();
        this.currentTemperatureMax = another.getCurrentTemperatureMax();
        this.currentTemperatureMin = another.getCurrentTemperatureMin();
        this.weatherDescriptionShort = another.getWeatherDescriptionShort();
        this.weatherDescriptionLong = another.getWeatherDescriptionLong();
        this.weatherIconLink = another.getWeatherIconLink();
        this.pressure = another.getPressure();
        this.humidity = another.getHumidity();
        this.windSpeed = another.getWindSpeed();
        this.rainVolumeLast3hrs = another.getRainVolumeLast3hrs();
        this.snowVolumeLast3hrs = another.getSnowVolumeLast3hrs();
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
	public String getGeoLongtitude() {
		return geoLongtitude;
	}
	public String getGeoLatitude() {
		return geoLatitude;
	}
	public String getCurrentTemperature() {
		return currentTemperature;
	}
	public String getCurrentTemperatureMax() {
		return currentTemperatureMax;
	}
	public String getCurrentTemperatureMin() {
		return currentTemperatureMin;
	}
	public String getWeatherDescriptionShort() {
		return weatherDescriptionShort;
	}
	public String getWeatherDescriptionLong() {
		return weatherDescriptionLong;
	}

    public String getWeatherIconLink() {
        return weatherIconLink;
    }

    public String getPressure() {
		return pressure;
	}
	public String getHumidity() {
		return humidity;
	}
	public String getWindSpeed() {
		return windSpeed;
	}
	public String getRainVolumeLast3hrs() {
		return rainVolumeLast3hrs;
	}
	public String getSnowVolumeLast3hrs() {
		return snowVolumeLast3hrs;
	}
	
	//SETTERS
	protected void setWeatherUnit(String weatherUnit) {
		this.weatherUnit = weatherUnit;
	}
	protected void setCityId(String cityId) {
		this.cityId = cityId;
	}
	protected void setCityName(String cityName) {
		this.cityName = cityName;
	}
	protected void setGeoLongtitude(String geoLongtitude) {
		this.geoLongtitude = geoLongtitude;
	}
	protected void setGeoLatitude(String geoLatitude) {
		this.geoLatitude = geoLatitude;
	}
	protected void setCurrentTemperature(String currentTemperature) {
		this.currentTemperature = currentTemperature;
	}
	protected void setCurrentTemperatureMax(String currentTemperatureMax) {
		this.currentTemperatureMax = currentTemperatureMax;
	}
	protected void setCurrentTemperatureMin(String currentTemperatureMin) {
		this.currentTemperatureMin = currentTemperatureMin;
	}
	protected void setWeatherDescriptionShort(String weatherDescriptionShort) {
		this.weatherDescriptionShort = weatherDescriptionShort;
	}
	protected void setWeatherDescriptionLong(String weatherDescriptionLong) {
		this.weatherDescriptionLong = weatherDescriptionLong;
	}
    protected void setWeatherIconLink(String weatherIconLink) {
        this.weatherIconLink = weatherIconLink;
    }
	protected void setPressure(String pressure) {
		this.pressure = pressure;
	}
	protected void setHumidity(String humidity) {
		this.humidity = humidity;
	}
	protected void setWindSpeed(String windSpeed) {
		this.windSpeed = windSpeed;
	}
	protected void setRainVolumeLast3hrs(String rainVolumeLast3hrs) {
		this.rainVolumeLast3hrs = rainVolumeLast3hrs;
	}
	protected void setSnowVolumeLast3hrs(String snowVolumeLast3hrs) {
		this.snowVolumeLast3hrs = snowVolumeLast3hrs;
	}
	
}
