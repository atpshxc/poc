package com.poc.split.table.shard;

import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class DatabaseSharding implements PreciseShardingAlgorithm {
    @Override
    public String doSharding(Collection collection, PreciseShardingValue preciseShardingValue) {
        if ((((Long) preciseShardingValue.getValue()) & 1) == 0) {
            return "order0";
        } else {
            return "order1";
        }
    }
}
