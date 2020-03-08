package com.poc.split.table.dao;

import com.poc.split.table.entity.OrderEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
    List<OrderEntity> findByOrderStatus(String status, Pageable pageable);

    @Modifying
    @Query("update OrderEntity set status=?1 where id=?2 and orderNo=?3")
    void updateOrderStatus(String status, Long id, String orderNo);
}
