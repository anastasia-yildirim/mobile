package config;

import org.aeonbits.owner.Config;

@TestEnvConfig.LoadPolicy(TestEnvConfig.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:${deviceHost}.properties"
})
public interface AppConfig extends Config {

    @Key("appPackage")
    String getAppPackage();

    @Key("appActivity")
    String getAppActivity();

    @Key("appVersion")
    String getAppVersion();

    @Key("appUrl")
    String getAppUrl();

    @Key("appPath")
    String getAppPath();
}
