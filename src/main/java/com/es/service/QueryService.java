package com.es.service;

import co.elastic.clients.elasticsearch._types.query_dsl.QueryBuilders;
import com.es.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.client.elc.NativeQuery;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.query.Criteria;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static co.elastic.clients.elasticsearch._types.query_dsl.QueryBuilders.match;
@Service
public class QueryService {

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Autowired
    private ElasticsearchOperations elasticsearchOperations;
//    public OrderSearchService (ElasticsearchOperations elasticsearchOperations){    this.elasticsearchOperations = elasticsearchOperations;}


//    public List<Customer> multiMatchQuery(String text) {
//        NativeSearchQuery searchQuery = NativeQuery.builder().
//                .withQuery(QueryBuilders.multiMatchQuery(text)
//                        .field("firstname")
//                        .field("lastname")
//                        .type(MultiMatchQueryBuilder.Type.BEST_FIELDS))
//                .build();
//
//        List<Customer> customers = elasticsearchOperations.queryForList(searchQuery, Customer.class);
//        return customers;
//    }
    public List<Customer> findByFirstNameAndAge(String firstName, int age) {
        var criteria = QueryBuilders.bool(builder -> builder.must(
                match(queryName -> queryName.field("firstname").query(firstName)),
                match(queryAge -> queryAge.field("age").query(age))
        ));

        return elasticsearchTemplate.search(NativeQuery.builder().withQuery(criteria).build(), Customer.class)
                .stream().map(SearchHit::getContent).toList();
    }

//    public List<OrderDocument> searchByProductAndQuantity(String product, int quantity)
//    {    Criteria criteria = new Criteria("product").is(product)
//            .and("quantity").is(quantity);
//        Query query = new CriteriaQuery(criteria);    return elasticsearchOperations.search(query, OrderDocument.class)            .stream()            .map(hit -> hit.getContent())  // Extract actual documents            .collect(Collectors.toList());}
//}

//    public List<Customer> searchByProductAndQuantity(String firstname, int age) {
//        Criteria criteria = new Criteria("firstname").is(firstname).and("age").is(age);
//        Query query = new CriteriaQuery(criteria);
//        return elasticsearchOperations.search(query, Customer.class).stream().map(hit -> hit.getContent()).collect(Collectors.toList());}
    }