package com.foolishbk.foolishbk.games.entities;

import discord4j.core.object.entity.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class Player {
    @Getter
    private final User user;

    public String getUserId() {
        return user.getId().asString();
    }

    public String getUsername() {
        return user.getUsername();
    }
}
