package com.rustled.application;

import com.github.philippheuer.credentialmanager.domain.OAuth2Credential;
import com.github.twitch4j.TwitchClient;
import com.github.twitch4j.TwitchClientBuilder;

import javax.inject.Singleton;

@Singleton
public class RustledTwitchClient {

    private static final String channelName = System.getenv("CHANNEL_NAME");
    private static final String accessToken = System.getenv("ACCESS_TOKEN");

    private TwitchClient twitchClient = buildclient();

    private TwitchClient buildclient() {
        OAuth2Credential credential = new OAuth2Credential("twitch", accessToken);

        com.github.twitch4j.TwitchClient twitchClient = TwitchClientBuilder.builder()
                .withEnableHelix(true)
                .withEnableChat(true)
                .withChatAccount(credential)
                .build();

        twitchClient.getChat().joinChannel(channelName);

        return twitchClient;
    }

    public TwitchClient getTwitchClient() {
        return twitchClient;
    }

    public void setTwitchClient(TwitchClient twitchClient) {
        this.twitchClient = twitchClient;
    }
}
