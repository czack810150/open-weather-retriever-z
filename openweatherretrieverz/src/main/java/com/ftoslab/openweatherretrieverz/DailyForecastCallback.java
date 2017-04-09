package com.ftoslab.openweatherretrieverz;

import java.util.List;

public abstract class DailyForecastCallback {
	public abstract void onReceiveDailyForecastInfoList(List<DailyForecastInfo> dailyForecastInfoList);
	public abstract void onFailure(String error);
}
