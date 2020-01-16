package com.rustled.application;

import com.github.philippheuer.credentialmanager.domain.OAuth2Credential;
import com.github.philippheuer.events4j.EventManager;
import com.github.twitch4j.TwitchClient;
import com.github.twitch4j.TwitchClientBuilder;
import com.github.twitch4j.chat.events.channel.ChannelMessageEvent;

import javax.inject.Singleton;

@Singleton
public class RustledTwitchClient {

    private static final String channelName = System.getenv("CHANNEL_NAME");
    private static final String accessToken = System.getenv("ACCESS_TOKEN");

    private TwitchClient twitchClient = buildclient();

    private TwitchClient buildclient() {
        EventManager eventManager = new EventManager();
        // Don't forget to refactor this.
        eventManager.onEvent(ChannelMessageEvent.class).subscribe(event ->
                {
                    System.out.println("RAW: " + event.getMessage());
                }
        );

        OAuth2Credential credential = new OAuth2Credential("twitch", accessToken);

        com.github.twitch4j.TwitchClient twitchClient = TwitchClientBuilder.builder()
                .withEventManager(eventManager)
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
