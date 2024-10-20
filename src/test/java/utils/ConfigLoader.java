package utils;

import config.AuthConfig;
import config.BrowserStackConfig;
import config.DeviceConfig;
import org.aeonbits.owner.ConfigFactory;

public class ConfigLoader {
    private static final AuthConfig authConfig = ConfigFactory.create(AuthConfig.class);
    private static final DeviceConfig deviceConfig = ConfigFactory.create(DeviceConfig.class);
    private static final BrowserStackConfig browserStackConfig = ConfigFactory.create(BrowserStackConfig.class);

    public static AuthConfig getAuthConfig() {
        return authConfig;
    }

    public static DeviceConfig getDeviceConfig() {
        return deviceConfig;
    }

    public static BrowserStackConfig getBrowserStackConfig() {
        return browserStackConfig;
    }
}