package config;

import org.aeonbits.owner.Config;

@TestEnvConfig.LoadPolicy(TestEnvConfig.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:${deviceHost}.properties"
})
public interface TestEnvConfig extends Config {

    @Key("remoteUrl")
    String getRemoteUrl();

    @Key("username")
    String getUsername();

    @Key("password")
    String getPassword();
}