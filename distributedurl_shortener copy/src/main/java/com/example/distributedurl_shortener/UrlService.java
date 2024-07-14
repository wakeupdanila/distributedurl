package com.example.distributedurl_shortener;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class UrlService {
    private final UrlRepository urlRepository;

    public UrlService(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    public boolean addUrl(Url url) {
        if (!isValidURL(url.getUrl())) {
            return false;
        }
        String id = generateId();
        while (urlRepository.existsById(id)) {
            id = generateId();
        }
        url.setId(id);
        url.setLastAccess(LocalDateTime.now());
        urlRepository.save(url);
        return true;
    }

    private String generateId() {
        return RandomStringUtils.randomAlphanumeric(10);
    }

    private boolean isValidURL(String url) {
        UrlValidator validator = new UrlValidator();
        return validator.isValid(url);
    }

}
