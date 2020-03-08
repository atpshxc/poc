package com.poc.split.table.mock;

import com.poc.split.table.entity.CustomerEntity;
import com.poc.split.table.entity.OrderEntity;
import com.poc.split.table.entity.PaymentEntity;
import com.poc.split.table.util.SequenceUtil;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

@Component
public class EntityMock {
    @Autowired
    private SequenceUtil sequenceUtil;

    private Random random = new Random(47);

    public CustomerEntity mockCustomer() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 1970 + random.nextInt(40));
        calendar.set(Calendar.MONTH, random.nextInt(12));
        calendar.set(Calendar.DAY_OF_MONTH, random.nextInt(30));
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setAge((short) random.nextInt(100));
        customerEntity.setBankCard(RandomStringUtils.randomNumeric(16));
        customerEntity.setBankCode(RandomStringUtils.randomAlphabetic(3,5).toUpperCase());
        customerEntity.setBirthday(calendar.getTime());
        customerEntity.setCity(RandomStringUtils.randomAlphabetic(20));
        customerEntity.setCustNo(sequenceUtil.next("CT"));
        customerEntity.setDateCreated(new Date());
        customerEntity.setEmail(RandomStringUtils.randomAlphanumeric(10) + "@" + RandomStringUtils.randomAlphanumeric(3,9) + ".com");
        customerEntity.setIdNo(RandomStringUtils.randomNumeric(18));
        customerEntity.setMobile(RandomStringUtils.randomNumeric(11));
        customerEntity.setUsername(RandomStringUtils.randomAlphanumeric(6, 20));
        customerEntity.setPassword(RandomStringUtils.randomAlphanumeric(6, 20));
        return customerEntity;
    }

    public OrderEntity mockOrder() {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setCol0(RandomStringUtils.randomAlphanumeric(20));
        orderEntity.setCol1(RandomStringUtils.randomAlphanumeric(20));
        orderEntity.setCol2(RandomStringUtils.randomAlphanumeric(20));
        orderEntity.setCol3(RandomStringUtils.randomAlphanumeric(20));
        orderEntity.setCol4(RandomStringUtils.randomAlphanumeric(20));
        orderEntity.setCol5(RandomStringUtils.randomAlphanumeric(20));
        orderEntity.setCol6(RandomStringUtils.randomAlphanumeric(20));
        orderEntity.setCol7(RandomStringUtils.randomAlphanumeric(20));
        orderEntity.setCol8(RandomStringUtils.randomAlphanumeric(20));
        orderEntity.setCol9(RandomStringUtils.randomAlphanumeric(20));
        orderEntity.setDateCreated(new Date());
        orderEntity.setOrderNo(sequenceUtil.next("OD"));
        orderEntity.setOrderStatus("UNPAY");
        orderEntity.setRemark(RandomStringUtils.randomAlphanumeric(100));
        return orderEntity;
    }

    public PaymentEntity mockPayment() {
        PaymentEntity paymentEntity = new PaymentEntity();
        paymentEntity.setDateCreated(new Date());
        paymentEntity.setPayNo(sequenceUtil.next("PN"));
        paymentEntity.setStatus(RandomStringUtils.randomAlphabetic(4));
        return paymentEntity;
    }
}
