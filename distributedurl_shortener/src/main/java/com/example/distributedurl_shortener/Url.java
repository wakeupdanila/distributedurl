package com.example.distributedurl_shortener;

import lombok.Data;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.LocalDateTime;

@Table
@Data
public class Url {
    
    @PrimaryKey
    private long Id;

    private String Url;

    private LocalDateTime LastAccess;
}
