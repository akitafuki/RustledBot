package com.rustled.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "twitch")
@Data
public class TwitchConfig {

    private String oAuthToken;
    private String clientId;
    private String clientSecret;
    private String channelName;
}
