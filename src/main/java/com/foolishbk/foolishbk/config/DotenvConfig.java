package com.foolishbk.foolishbk.config;

import io.github.cdimascio.dotenv.Dotenv;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DotenvConfig {

    @PostConstruct
    public void init() {
        // Load .env file from the project root; ignore if missing
        Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();

        // Option 1: Set all entries as System properties
        dotenv.entries().forEach(entry -> {
            if (System.getProperty(entry.getKey()) == null) {
                System.setProperty(entry.getKey(), entry.getValue());
            }
        });

        // Option 2: Alternatively, explicitly map a key from .env to your Spring property
        // Uncomment the line below if your .env variable is named DISCORD_TOKEN
        // System.setProperty("discord.token", dotenv.get("DISCORD_TOKEN"));
    }
}
