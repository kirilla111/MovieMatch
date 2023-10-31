package ru.afanasyev.adapter;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ru.afanasyev.app.api.TokenProvider;

@RequiredArgsConstructor
@Getter
@Slf4j
public abstract class AbstractMovieAdapter {
    protected final TokenProvider tokenProvider;
    protected String token;

    public void switchToken() {
        if (token == null) {
            token = tokenProvider.getToken();
            log.info("Switching token to: {}", token);
        }
    }
}
