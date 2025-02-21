//package com.es.config;
////
//import org.elasticsearch.client.RestClient;
//import org.elasticsearch.client.RestHighLevelClient;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.elasticsearch.client.ClientConfiguration;
//import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
//
////import org.springframework.data.elasticsearch.client.elc.ElasticsearchTemplate;
////import org.springframework.data.elasticsearch.config.EnableElasticsearchAuditing;
////import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
////import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
////
////import java.io.IOException;
////
//@Configuration
//public class ESConfig {
////
////    @Bean
////    public NodeBuilder builder(){
////    return NodeBuilder();
////}
////    @Bean
////    public ElasticsearchOperations elasticsearchTemplate() throws IOException {
////        return new ElasticsearchTemplate(builder().local(true).node().client());
////    }
////
////}
//
//    @Bean
//    public RestHighLevelClient client() {
//        ClientConfiguration clientConfiguration = ClientConfiguration.builder()
//                .connectedTo("localhost:9200")
//                .build();
//
//        return RestClients.create(clientConfiguration).rest();
//    }
//
//    @Bean
//    public ElasticsearchRestTemplate elasticsearchRestTemplate() {
//        return new ElasticsearchRestTemplate(client());
//    }
//
//}
