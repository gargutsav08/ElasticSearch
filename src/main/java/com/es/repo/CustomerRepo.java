package com.es.repo;

import com.es.model.Customer;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface CustomerRepo  extends ElasticsearchRepository<Customer,String> {
//    List<Customer> findByProductContaining(String firstName);

}
