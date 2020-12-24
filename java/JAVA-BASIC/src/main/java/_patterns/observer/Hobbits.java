package _patterns.observer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Hobbits implements WeatherObserver {

    private static final Logger LOGGER = LoggerFactory.getLogger(Hobbits.class);

    @Override
    public void update(WeatherType currentWeather) {
        LOGGER.info("The orcs are facing " + currentWeather.getDescription() + " weather now");
    }

}
