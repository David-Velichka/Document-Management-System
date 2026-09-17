package com.paperless.rest.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ElasticsearchConfig {

    @Value("${elasticsearch.uris:http://localhost:9200}")
    private String elasticsearchUri;

    public String getElasticsearchUri() {
        return elasticsearchUri;
    }
}
