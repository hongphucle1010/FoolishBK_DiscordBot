package com.foolishbk.foolishbk.discord.services;

import com.foolishbk.foolishbk.discord.listeners.Listener;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.domain.Event;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ListenerManagerService {

    private final GatewayDiscordClient client;
    private final List<Listener<? extends Event>> listeners;

    @PostConstruct
    public void registerListeners() {
        for (Listener<?> listener : listeners) {
            registerListener(listener);
            log.info("✅ Registered listener: {}", listener.getClass().getSimpleName());
        }
    }

    private <E extends Event> void registerListener(Listener<E> listener) {
        client.getEventDispatcher()
                .on(listener.getEventType())
                .subscribe(listener::handle);
    }
}
