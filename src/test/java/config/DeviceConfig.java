package config;

import org.aeonbits.owner.Config;

@TestEnvConfig.LoadPolicy(TestEnvConfig.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:${deviceHost}.properties"
})
public interface DeviceConfig extends Config {

    @Key("deviceName")
    String getDeviceName();

    @Key("platformVersion")
    String getPlatformVersion();
}