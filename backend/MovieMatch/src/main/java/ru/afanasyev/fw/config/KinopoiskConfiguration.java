package ru.afanasyev.fw.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

@Configuration
public class KinopoiskConfiguration {
    private static final String TOKENS_FILE_NAME = "classpath:kinopoisk/tokens";

    @Bean(name = "kinopoisk-tokens")
    public Deque<String> availableTokens(@Value(TOKENS_FILE_NAME) Resource resource) throws IOException {
        Deque<String> tokens = new ArrayDeque<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(resource.getInputStream()))) {
            String token;
            while ((token = br.readLine()) != null) {
                tokens.add(token);
            }
        }
        return tokens;
    }
}
