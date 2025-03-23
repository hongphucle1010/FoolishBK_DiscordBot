package com.foolishbk.foolishbk.discord.commands;

import discord4j.core.event.domain.message.MessageCreateEvent;

public interface Command {
    String getTrigger(); // e.g., "!ping" or "!startgame"
    void execute(MessageCreateEvent event);
}
