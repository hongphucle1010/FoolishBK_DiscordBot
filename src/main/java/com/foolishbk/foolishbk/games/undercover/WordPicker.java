package com.foolishbk.foolishbk.games.undercover;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.List;
import java.util.Random;

@Slf4j
@Component
public class WordPicker {

    private static final String FILE_NAME = "/words.json";
    private final Random random = new Random();
    private List<String> wordPairs;

    @PostConstruct
    public void init() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream is = getClass().getResourceAsStream(FILE_NAME);
            wordPairs = mapper.readValue(is, new TypeReference<>() {});
            log.info("Loaded {} word pairs", wordPairs.size());
        } catch (Exception e) {
            log.error("Failed to load word pairs from {}", FILE_NAME, e);
            throw new RuntimeException("Cannot load word pairs", e);
        }
    }

    public String[] pickRandomPair() {
        if (wordPairs == null || wordPairs.isEmpty()) {
            throw new IllegalStateException("Word list is not loaded");
        }
        String pair = wordPairs.get(random.nextInt(wordPairs.size()));
        return pair.split(",", 2); // returns [word1, word2]
    }
}
