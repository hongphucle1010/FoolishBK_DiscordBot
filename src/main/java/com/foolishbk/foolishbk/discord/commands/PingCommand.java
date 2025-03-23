package com.foolishbk.foolishbk.discord.commands;

import discord4j.core.event.domain.message.MessageCreateEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Slf4j
@Component
public class PingCommand implements Command {

    @Override
    public String getTrigger() {
        return "!ping";
    }

    @Override
    public void execute(MessageCreateEvent event) {
        Objects.requireNonNull(event.getMessage().getChannel().block()).createMessage("Pong!").block();
        log.info("Executed PingCommand");
    }
}
