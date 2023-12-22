package com.rustled.listener;

import com.github.twitch4j.chat.events.channel.ChannelMessageEvent;
import com.rustled.service.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ChatEventListener {

    @Autowired
    MessageService messageService;

    @EventListener
    public void handleChatEvent(ChannelMessageEvent channelMessageEvent) {
        messageService.sendMessage("Saw it");
        log.info("Handled chat event: {}", channelMessageEvent);
    }
}
