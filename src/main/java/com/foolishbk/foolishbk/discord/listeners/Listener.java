package com.foolishbk.foolishbk.discord.listeners;

import discord4j.core.event.domain.Event;

public interface Listener<E extends Event> {
    Class<E> getEventType();
    void handle(E event);
}
