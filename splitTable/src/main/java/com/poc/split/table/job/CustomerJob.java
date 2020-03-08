package com.poc.split.table.job;

import com.poc.split.table.dao.CustomerRepository;
import com.poc.split.table.entity.CustomerEntity;
import com.poc.split.table.mock.EntityMock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class CustomerJob {
    @Autowired
    private CustomerRepository repository;
    @Autowired
    private EntityMock mock;

    private Random random = new Random(47);

    public void run() {
        int count = random.nextInt(100);
        List<CustomerEntity> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add(mock.mockCustomer());
        }
        repository.saveAll(list);
    }
}
