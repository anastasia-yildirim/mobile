package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "system:env",
        "classpath:browserstack.properties"
})
public interface BrowserStackConfig extends Config {

    @Key("appUrl")
    String appUrl();

    @Key("remoteWebDriverUrl")
    String remoteWebDriverUrl();
}