package com.foolishbk.foolishbk.discord.commands;

import discord4j.core.event.domain.message.MessageCreateEvent;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class HelpCommand implements Command {
    @Override
    public String getTrigger() {
        return "!help";
    }

    @Override
    public void execute(MessageCreateEvent event) {
        String helpText = """
        🤖 Available Commands:
        • !ping - Check if the bot is alive
        • !help - Show this message
        """;
        Objects.requireNonNull(event.getMessage().getChannel().block()).createMessage(helpText).block();
    }
}
