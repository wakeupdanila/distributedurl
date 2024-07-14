package com.example.distributedurl_redirection;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlRepository extends CassandraRepository<Url, String> {
}
