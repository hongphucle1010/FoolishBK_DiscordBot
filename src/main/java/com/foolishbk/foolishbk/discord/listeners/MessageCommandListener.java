package com.foolishbk.foolishbk.discord.listeners;

import com.foolishbk.foolishbk.discord.services.CommandManagerService;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MessageCommandListener implements Listener<MessageCreateEvent> {

    private final CommandManagerService commandManagerService;

    @Override
    public Class<MessageCreateEvent> getEventType() {
        return MessageCreateEvent.class;
    }

    @Override
    public void handle(MessageCreateEvent event) {
        // Ignore bots
        if (event.getMessage().getAuthor().map(User::isBot).orElse(true)) return;

        // Forward message to command handler
        commandManagerService.handle(event);
    }
}
