package com.example.distributedurl_cleanup;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UrlService {
    private final UrlRepository urlRepository;
    private final Logger logger = LoggerFactory.getLogger(UrlService.class);

    public UrlService(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    @Scheduled(fixedRate = 3600000, initialDelay = 15000)
    public void urlCleanup() {
        List<Url> urlsToRemove = urlRepository.findByLastAccessLessThan(LocalDateTime.now().minusDays(1));
        logger.info("Removing urls from database: {}", urlsToRemove);
        urlRepository.deleteAll(urlsToRemove);
    }
}
