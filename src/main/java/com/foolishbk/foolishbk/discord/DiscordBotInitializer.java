package com.foolishbk.foolishbk.discord;

import com.foolishbk.foolishbk.discord.services.CommandManagerService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import discord4j.core.GatewayDiscordClient;

@Getter
@Service
@RequiredArgsConstructor
public class DiscordBotInitializer {

    private final GatewayDiscordClient client;

}