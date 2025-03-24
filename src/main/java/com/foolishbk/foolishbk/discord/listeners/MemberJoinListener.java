package com.foolishbk.foolishbk.discord.listeners;

import discord4j.core.event.domain.guild.MemberJoinEvent;
import discord4j.core.object.entity.Member;
import org.springframework.stereotype.Component;

@Component
public class MemberJoinListener implements Listener<MemberJoinEvent> {

    @Override
    public Class<MemberJoinEvent> getEventType() {
        return MemberJoinEvent.class;
    }

    @Override
    public void handle(MemberJoinEvent event) {
        Member member = event.getMember();
        event.getGuild().flatMap(guild ->
                guild.getSystemChannel()
                        .flatMap(channel -> channel.createMessage("👋 Welcome, " + member.getDisplayName() + "!"))
        ).subscribe();
    }
}
