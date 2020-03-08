package com.poc.split.table.shard;

import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

import java.util.Collection;

@Component
public class TableSharding implements PreciseShardingAlgorithm {
    @Override
    public String doSharding(Collection collection, PreciseShardingValue preciseShardingValue) {
        String orders = "t_order";
        if (preciseShardingValue.getLogicTableName().equals(orders)) {
            String orderNo = (String) preciseShardingValue.getValue();
            return orders + Math.abs(DigestUtils.md5DigestAsHex(orderNo.getBytes()).hashCode() % 10);
        }
        return preciseShardingValue.getLogicTableName();
    }
}
