package com.example.distributedurl_cleanup;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface UrlRepository extends CassandraRepository<Url, String> {
    List<Url> findByLastAccessLessThan(LocalDateTime lastAccess);
}
