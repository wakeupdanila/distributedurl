package com.example.distributedurl_redirection;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Optional;

@RestController
public class UrlController {

    private final UrlService urlService;

    public UrlController(UrlService urlService) {
        this.urlService = urlService;
    }

    @GetMapping("/{id}")
    public RedirectView redirectToUrl(@PathVariable String id) {
        Optional<Url> url = urlService.getUrl(id);
        if (url.isEmpty()) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Url not found"
            );
        }
        return new RedirectView(url.get().getUrl());
    }
}