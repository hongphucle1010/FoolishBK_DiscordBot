package com.foolishbk.foolishbk.discord.commands;

import discord4j.core.event.domain.message.MessageCreateEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CommandManagerService {

    // Spring will inject all beans implementing Command.
    private final List<Command> commands;

    public void handle(MessageCreateEvent event) {
        String content = event.getMessage().getContent().trim();
        commands.stream()
                .filter(cmd -> content.startsWith(cmd.getTrigger()))
                .findFirst()
                .ifPresentOrElse(
                        command -> {
                            log.info("Command triggered: {}", command.getTrigger());
                            command.execute(event);
                        },
                        () -> log.debug("No matching command found for: {}", content)
                );
    }
}
