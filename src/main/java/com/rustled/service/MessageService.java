package com.rustled.service;

import com.rustled.bean.TwitchBean;
import com.rustled.config.TwitchConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    @Autowired
    TwitchBean twitchBean;
    @Autowired
    TwitchConfig twitchConfig;

    public void sendMessage(String message) {
        twitchBean.getTwitchClient().getChat().sendMessage(twitchConfig.getChannelName(), message);
    }
}
