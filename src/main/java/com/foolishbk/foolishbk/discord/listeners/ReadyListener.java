package com.foolishbk.foolishbk.discord.listeners;

import discord4j.core.event.domain.lifecycle.ReadyEvent;
import org.springframework.stereotype.Component;

@Component
public class ReadyListener implements Listener<ReadyEvent> {
    @Override
    public Class<ReadyEvent> getEventType() {
        return ReadyEvent.class;
    }

    @Override
    public void handle(ReadyEvent event) {
        System.out.println("✅ Bot is ready as: " + event.getSelf().getUsername());
    }
}
