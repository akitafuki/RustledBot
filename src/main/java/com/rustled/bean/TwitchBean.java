package com.rustled.bean;

import com.github.philippheuer.credentialmanager.CredentialManager;
import com.github.philippheuer.credentialmanager.CredentialManagerBuilder;
import com.github.philippheuer.credentialmanager.domain.OAuth2Credential;
import com.github.philippheuer.events4j.core.EventManager;
import com.github.philippheuer.events4j.spring.SpringEventHandler;
import com.github.twitch4j.TwitchClient;
import com.github.twitch4j.TwitchClientBuilder;
import com.github.twitch4j.auth.providers.TwitchIdentityProvider;
import com.rustled.config.TwitchConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
@Slf4j
public class TwitchBean {
    private TwitchClient twitchClient;

    public TwitchBean(TwitchConfig twitchConfig, SpringEventHandler springEventHandler) {
        OAuth2Credential credential = new OAuth2Credential("twitch", twitchConfig.getOAuthToken());

        CredentialManager credentialManager = CredentialManagerBuilder.builder().build();
        credentialManager.registerIdentityProvider(
            new TwitchIdentityProvider(twitchConfig.getClientId(), twitchConfig.getClientSecret(), ""));

        twitchClient = TwitchClientBuilder.builder()
            .withCredentialManager(credentialManager)
            .withChatAccount(credential)
            .withEnableChat(true)
            .withEnableHelix(true)
            .build();

        EventManager eventManager = twitchClient.getEventManager();
        eventManager.registerEventHandler(springEventHandler);

        twitchClient.getChat().joinChannel(twitchConfig.getChannelName());

        log.info("TwitchBean created");
    }

    public TwitchClient getTwitchClient() {
        return twitchClient;
    }

    public void setTwitchClient(TwitchClient twitchClient) {
        this.twitchClient = twitchClient;
    }
}
