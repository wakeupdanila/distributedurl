package com.example.distributedurl_shortener;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
public class KafkaMessage {

    private LocalDateTime timestamp;
    private String forbiddenWord;

}
