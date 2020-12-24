package _patterns.observer;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class Weather {

    private static final Logger LOGGER = LoggerFactory.getLogger(Weather.class);

    private WeatherType currentWeather;
    private final List<WeatherObserver> observers;

    public Weather(){
        observers = new ArrayList<>();
        currentWeather = WeatherType.SUNNY;
    }

    public void addObserver(WeatherObserver obs) {
        observers.add(obs);
    }

    public void removeObserver(WeatherObserver obs) {
        observers.remove(obs);
    }

    public void timePasses() {
        WeatherType[] weatherType = WeatherType.values();
        currentWeather = weatherType[(currentWeather.ordinal() + 1) % weatherType.length];
        LOGGER.info("The weather changed to {}.", currentWeather);
        notifyObservers();
    }

    private void notifyObservers() {
        for (WeatherObserver  observer : observers) {
            observer.update(currentWeather);
        }
    }

    public static void main(String[] args) {
        Weather weather = new Weather();
        weather.addObserver(new Orcs());
        weather.addObserver(new Hobbits());
        weather.timePasses();
        weather.timePasses();
        weather.timePasses();
        weather.timePasses();
    }

}
