package com.example.distributedurl_shortener;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service
public class UrlService {
    private final UrlRepository urlRepository;

    private final KafkaTemplate<String, KafkaMessage> kafkaTemplate;

    private void sendMessage(Url url, String word) {
        kafkaTemplate.send("urls.forbidden", url.getId(), new KafkaMessage(url.getLastAccess(), word));
    }

    public UrlService(UrlRepository urlRepository, KafkaTemplate<String, KafkaMessage> kafkaTemplate) {
        this.urlRepository = urlRepository;
        this.kafkaTemplate = kafkaTemplate;
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
        checkUrl(url);
        return true;
    }

    private void checkUrl(Url url) {
        for (String word : forbiddenWords) {

            if (url.getUrl().toLowerCase().contains(word)) {
                sendMessage(url, word);
                return;
            }
        }
    }

    private String generateId() {
        return RandomStringUtils.randomAlphanumeric(10);
    }

    private boolean isValidURL(String url) {
        UrlValidator validator = new UrlValidator();
        return validator.isValid(url);
    }

    private final List<String> forbiddenWords = Arrays.asList(
            "asshole",
            "nigger",
            "dickhead"
    );

}
