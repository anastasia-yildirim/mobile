package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.AppConfig;
import config.DeviceConfig;
import config.TestEnvConfig;
import lombok.Getter;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

public class BrowserStackDriver implements WebDriverProvider {

    @Getter
    private static final TestEnvConfig testEnvConfig = ConfigFactory.create(TestEnvConfig.class, System.getProperties());
    private static final DeviceConfig deviceConfig = ConfigFactory.create(DeviceConfig.class, System.getProperties());
    public static final AppConfig appConfig = ConfigFactory.create(AppConfig.class, System.getProperties());

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {

        MutableCapabilities caps = new MutableCapabilities();

        caps.setCapability("browserstack.user", testEnvConfig.getUsername());
        caps.setCapability("browserstack.key", testEnvConfig.getPassword());

        caps.setCapability("device", deviceConfig.getDeviceName());
        caps.setCapability("os_version", deviceConfig.getPlatformVersion());
        caps.setCapability("app", appConfig.getAppUrl());

        caps.setCapability("project", "Wikipedia Mobile Tests Java Project");
        caps.setCapability("build", "browserstack-build-1");
        caps.setCapability("name", "wikipedia_tests");

        caps.setCapability("fullReset", true);

        try {
            return new RemoteWebDriver(
                    new URL(testEnvConfig.getRemoteUrl()), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}