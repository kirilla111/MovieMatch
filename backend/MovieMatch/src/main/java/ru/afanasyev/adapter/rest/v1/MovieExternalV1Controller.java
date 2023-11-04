package ru.afanasyev.adapter.rest.v1;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.afanasyev.app.api.MovieDataService;

@RestController
@RequestMapping("/api/v1/external/movie")
@RequiredArgsConstructor
@Tag(name = "Контроллер фильмов")
public class MovieExternalV1Controller {
    private final MovieDataService movieDataService;

    @GetMapping("/random")
    public Object getRandomMovie() {
        return movieDataService.getRandomMovie();
    }
}
