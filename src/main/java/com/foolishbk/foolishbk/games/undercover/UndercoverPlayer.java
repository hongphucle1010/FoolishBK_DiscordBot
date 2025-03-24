package com.foolishbk.foolishbk.games.undercover;

import com.foolishbk.foolishbk.games.entities.Player;
import discord4j.core.object.entity.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class UndercoverPlayer extends Player {
    private Role role;
    private boolean alive = true;

    public UndercoverPlayer(User user) {
        super(user);
    }
}
