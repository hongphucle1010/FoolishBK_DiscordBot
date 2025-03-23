package com.foolishbk.foolishbk.discord;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class DiscordBotRunner implements CommandLineRunner {

    private final DiscordBotInitializer discordBotInitializer;

    @Override
    public void run(String... args) throws Exception {
        // This will block until the bot disconnects.
        discordBotInitializer.getClient().onDisconnect().block();
    }
}