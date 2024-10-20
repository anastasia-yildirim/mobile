package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:android.properties"
})
public interface DeviceConfig extends Config {

    @Key("device.name")
    String deviceName();

    @Key("platform.version")
    String platformVersion();
}