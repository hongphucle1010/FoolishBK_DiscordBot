package com.foolishbk.foolishbk.discord;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DiscordBotRunner implements CommandLineRunner {

    private final DiscordBotInitializer discordBotInitializer;

    public DiscordBotRunner(DiscordBotInitializer discordBotInitializer) {
        this.discordBotInitializer = discordBotInitializer;
    }

    @Override
    public void run(String... args) throws Exception {
        // This will block until the bot disconnects.
        discordBotInitializer.getClient().onDisconnect().block();
    }
}