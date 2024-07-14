package com.example.distributedurl_shortener;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class KafkaMessage {
    private LocalDateTime timestamp;
    private String forbiddenWord;

}
