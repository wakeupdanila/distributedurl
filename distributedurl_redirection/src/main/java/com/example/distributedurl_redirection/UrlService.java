package com.example.distributedurl_redirection;

import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UrlService {
    private final UrlRepository urlRepository;

    public UrlService(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    public Optional<Url> getUrl(String Id) {
        return urlRepository.findById(Id);
    }
}
