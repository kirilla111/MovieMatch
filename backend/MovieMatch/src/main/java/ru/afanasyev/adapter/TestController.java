package ru.afanasyev.adapter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/external/hello-world")
public class TestController {
    @GetMapping
    public String helloWorld() {
        return "hello-world";
    }
}
