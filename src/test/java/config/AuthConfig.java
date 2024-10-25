package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:auth.properties",
        "system:env"
})
public interface AuthConfig extends Config {

    @Key("username")
    String username();

    @Key("password")
    String password();
}