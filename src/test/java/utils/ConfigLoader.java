package utils;

import config.AuthConfig;
import config.BrowserStackConfig;
import config.DeviceConfig;
import lombok.Getter;
import org.aeonbits.owner.ConfigFactory;

public class ConfigLoader {
    @Getter
    private static final AuthConfig authConfig = ConfigFactory.create(AuthConfig.class);
    @Getter
    private static final DeviceConfig deviceConfig = ConfigFactory.create(DeviceConfig.class);
    @Getter
    private static final BrowserStackConfig browserStackConfig = ConfigFactory.create(BrowserStackConfig.class);
}