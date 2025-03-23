package com.foolishbk.foolishbk.discord;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import jakarta.annotation.PostConstruct;
import discord4j.core.DiscordClient;
import discord4j.core.DiscordClientBuilder;
import discord4j.core.GatewayDiscordClient;

@Service
public class DiscordBotInitializer {

    @Value("${discord.token}")
    private String token;

    @Getter
    private GatewayDiscordClient client;

    @PostConstruct
    public void init() {
        // Create the Discord client and log in
        DiscordClient discordClient = DiscordClientBuilder.create(token).build();
        client = discordClient.login().block();
        if (client != null) {
            System.out.println("Discord Bot logged in successfully!");
            // Register any event listeners or commands here
            registerListeners();
        } else {
            throw new IllegalStateException("Failed to log in to Discord!");
        }
    }

    private void registerListeners() {
        // Example: Register a simple message listener
        client.getEventDispatcher().on(discord4j.core.event.domain.message.MessageCreateEvent.class)
                .subscribe(event -> {
                    String content = event.getMessage().getContent();
                    if (content.equalsIgnoreCase("!ping")) {
                        event.getMessage().getChannel().block().createMessage("Pong!").block();
                    }
                });
    }

}
