package com.poc.split.table.job;

import com.poc.split.table.dao.EsOrderRepository;
import com.poc.split.table.dao.OrderRepository;
import com.poc.split.table.dao.PaymentRepository;
import com.poc.split.table.domain.Order;
import com.poc.split.table.entity.OrderEntity;
import com.poc.split.table.entity.PaymentEntity;
import com.poc.split.table.mock.EntityMock;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class PaymentJob {
    @Autowired
    private PaymentRepository repository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private EntityMock mock;
    @Autowired
    private EsOrderRepository esOrderRepository;

    private Random random = new Random(47);

    public void run() {
        int count = random.nextInt(10);
        long total = orderRepository.count();
        List<PaymentEntity> list = new ArrayList<>();
        List<Order> orders = new ArrayList<>();
        while (count-- > 0) {
            int pageSize = 10 + random.nextInt(100);
            int pageNum = random.nextInt(1 + (int) (total / pageSize));
            Pageable pageable = PageRequest.of(pageNum, pageSize);
            List<OrderEntity> page = orderRepository.findByOrderStatus("UNPAY", pageable);
            page.forEach(o -> {
                o.setOrderStatus("PAYED");
                Order order = new Order();
                BeanUtils.copyProperties(o, order);
                orders.add(order);
                orderRepository.updateOrderStatus("PAYED", o.getId(), o.getOrderNo());
                PaymentEntity paymentEntity = mock.mockPayment();
                paymentEntity.setCustNo(o.getCustNo());
                paymentEntity.setOrderNo(o.getOrderNo());
                list.add(paymentEntity);
            });
        }
        repository.saveAll(list);
        esOrderRepository.saveAll(orders);
    }
}
