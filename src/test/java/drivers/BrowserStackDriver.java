package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.AuthConfig;
import config.BrowserStackConfig;
import config.DeviceConfig;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import utils.ConfigLoader;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

public class BrowserStackDriver implements WebDriverProvider {

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        BrowserStackConfig browserStackConfig = ConfigLoader.getBrowserStackConfig();

        MutableCapabilities caps = new MutableCapabilities();

        AuthConfig authConfig = ConfigLoader.getAuthConfig();
        caps.setCapability("browserstack.user", authConfig.username());
        caps.setCapability("browserstack.key", authConfig.password());



        DeviceConfig deviceConfig = ConfigLoader.getDeviceConfig();
        caps.setCapability("device", deviceConfig.deviceName());
        caps.setCapability("os_version", deviceConfig.platformVersion());
        caps.setCapability("app", deviceConfig.appUrl());

        caps.setCapability("project", "Wikipedia Mobile Tests Java Project");
        caps.setCapability("build", "browserstack-build-1");
        caps.setCapability("name", "wikipedia_tests");

        try {
            return new RemoteWebDriver (
                    new URL(browserStackConfig.remoteWebDriverUrl()), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}