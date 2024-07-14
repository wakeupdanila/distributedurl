package com.example.distributedurl_cleanup;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.SASI;
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
    @SASI(indexMode = SASI.IndexMode.SPARSE)
    private LocalDateTime lastAccess;
}
