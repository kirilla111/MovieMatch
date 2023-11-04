package ru.afanasyev.adapter.kinopoisk;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.afanasyev.adapter.AbstractMovieAdapter;
import ru.afanasyev.app.api.MovieDataService;

@Component
@Slf4j
public class KinopoiskAdapter extends AbstractMovieAdapter implements MovieDataService {
    public KinopoiskAdapter(KinopoiskTokenProvider tokenProvider) {
        super(tokenProvider);
    }

    @Override
    public Object getRandomMovie() {
        return token;
    }
}
