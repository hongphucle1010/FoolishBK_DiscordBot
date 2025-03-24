package com.foolishbk.foolishbk.games.undercover;

import com.foolishbk.foolishbk.games.entities.Player;
import discord4j.core.object.entity.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.*;

@Getter
@RequiredArgsConstructor
public class UndercoverGameSession {

    private final String channelId;
    private final List<User> players = new ArrayList<>();
    private List<UndercoverPlayer> currentRoundPlayers;
    private final Map<Role, String> words = new HashMap<>();
    private final WordPicker wordPicker;
    private boolean started = false;
    private int round = 0;

    public void addPlayer(User user) {
        players.add(user);
    }

    public void removePlayer(User user) {
        players.remove(user);
    }

    public void startGame() {
        started = true;
        round = 1;
        assignRoles();
    }

    private void assignRoles() {
        int numPlayers = players.size();
        int numMrWhites = 1;
        int numUndercovers = (numPlayers - numMrWhites) / 3;
        int numCivilians = numPlayers - numMrWhites - numUndercovers;

        List<Role> roles = new ArrayList<>();
        for (int i = 0; i < numMrWhites; i++) {
            roles.add(Role.MR_WHITE);
        }
        for (int i = 0; i < numUndercovers; i++) {
            roles.add(Role.UNDERCOVER);
        }
        for (int i = 0; i < numCivilians; i++) {
            roles.add(Role.CIVILIAN);
        }
        Collections.shuffle(roles);

        // Create UndercoverPlayers and assign a random role from the shuffled list
        currentRoundPlayers = new LinkedList<>();
        for (int i = 0; i < numPlayers; i++) {
            UndercoverPlayer player = new UndercoverPlayer(players.get(i));
            player.setRole(roles.get(i));
            currentRoundPlayers.add(player);
        }
    }

    private void assignWords() {

    }


}
