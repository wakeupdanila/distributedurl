package com.example.distributedurl_shortener;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.LocalDateTime;

@Table
@Data
public class Url {
    public interface UserView {
    }


    public interface FullView extends UserView {
    }


    @PrimaryKey
    @JsonView(UserView.class)
    private String id;

    @JsonView(UserView.class)
    private String url;

    @JsonView(FullView.class)
    private LocalDateTime lastAccess;
}
