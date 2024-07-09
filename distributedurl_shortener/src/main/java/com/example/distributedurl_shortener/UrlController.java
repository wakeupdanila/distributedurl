package com.example.distributedurl_shortener;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UrlController {

    @PostMapping("/")
    public void ShortenUrl(@RequestBody url newUrl) {
        return repository.save(newUrl);
    }
}