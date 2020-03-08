package com.poc.split.table.job;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.poc.split.table.dao.CustomerRepository;
import com.poc.split.table.dao.OrderRepository;
import com.poc.split.table.domain.Order;
import com.poc.split.table.entity.CustomerEntity;
import com.poc.split.table.entity.OrderEntity;
import com.poc.split.table.mock.EntityMock;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

@Component
public class OrderJob {
    @Autowired
    private OrderRepository repository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private EntityMock mock;
    @Autowired
    private RestHighLevelClient client;

    private Random random = new Random(47);
    private ObjectMapper mapper = new ObjectMapper();

    public void run() {
        int count = 1 + random.nextInt(10);
        long total = customerRepository.count();
        if (total < 10) {
            return;
        }
        long start = random.nextInt((int) total/2);
        while (count-- > 0) {
            List<CustomerEntity> list = customerRepository.findByIdBetween(start, start + 100);
            list.forEach(customerEntity -> {
                OrderEntity orderEntity = mock.mockOrder();
                orderEntity.setCustNo(customerEntity.getCustNo());
                repository.save(orderEntity);
                Order order = new Order();
                BeanUtils.copyProperties(orderEntity, order);

                try {
                    IndexRequest indexRequest = new IndexRequest("orders", "docs", String.valueOf(order.getId()))
                            .source(mapper.convertValue(order, HashMap.class));
                    UpdateRequest updateRequest =
                            new UpdateRequest("orders", "docs", String.valueOf(order.getId())).upsert(indexRequest);
                    updateRequest.doc(indexRequest);
                    client.update(updateRequest, RequestOptions.DEFAULT);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
