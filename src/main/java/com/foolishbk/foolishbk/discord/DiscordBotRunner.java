package com.foolishbk.foolishbk.discord;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class DiscordBotRunner implements CommandLineRunner {

    private final DiscordBotInitializer discordBotInitializer;

    @Override
    public void run(String... args) {
        log.info("DiscordBotRunner: Starting discord bot");
        // Keep the application alive as long as the bot is connected
        discordBotInitializer.getClient().onDisconnect().block();
    }
}
