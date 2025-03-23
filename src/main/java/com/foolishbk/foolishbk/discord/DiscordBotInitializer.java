package com.foolishbk.foolishbk.discord;

import com.foolishbk.foolishbk.discord.commands.CommandManagerService;
import discord4j.core.event.domain.message.MessageCreateEvent;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import jakarta.annotation.PostConstruct;
import discord4j.core.DiscordClient;
import discord4j.core.DiscordClientBuilder;
import discord4j.core.GatewayDiscordClient;

@Service
@RequiredArgsConstructor
public class DiscordBotInitializer {

    @Value("${discord.token}")
    private String token;

    @Getter
    private GatewayDiscordClient client;

    private final CommandManagerService commandManagerService;

    @PostConstruct
    public void init() {
        DiscordClient discordClient = DiscordClientBuilder.create(token).build();
        client = discordClient.login().block();
        if (client != null) {
            System.out.println("Discord Bot logged in successfully!");
            client.getEventDispatcher().on(MessageCreateEvent.class)
                    .subscribe(commandManagerService::handle);
        } else {
            throw new IllegalStateException("Failed to log in to Discord!");
        }
    }
}
