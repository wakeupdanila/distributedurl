package com.example.distributedurl_redirection;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;


@Service
public class UrlService {
    private final UrlRepository urlRepository;

    public UrlService(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    public Optional<Url> getUrl(String Id) {
        Optional<Url> url = urlRepository.findById(Id);
        if (url.isPresent()) {
            url.get().setLastAccess(LocalDateTime.now());
            urlRepository.save(url.get());
        }
        return urlRepository.findById(Id);
    }
}
