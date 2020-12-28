package _patterns.observer.generic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import _patterns.observer.WeatherType;

public class GHobbits implements Race {

    private static final Logger LOGGER = LoggerFactory.getLogger(GHobbits.class);

    @Override
    public void update(GWeather weather, WeatherType weatherType) {
        LOGGER.info("The hobbits are facing " + weatherType.getDescription() + " weather now");
    }

}
