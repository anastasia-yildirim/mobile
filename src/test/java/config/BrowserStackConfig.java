package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${deviceHost}.properties"
})
public interface BrowserStackConfig extends Config {

    @Key("remoteWebDriverUrl")
    String remoteWebDriverUrl();
}