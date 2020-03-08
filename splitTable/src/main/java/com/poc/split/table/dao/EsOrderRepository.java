package com.poc.split.table.dao;

import com.poc.split.table.domain.Order;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EsOrderRepository extends ElasticsearchRepository<Order, Long> {
}
