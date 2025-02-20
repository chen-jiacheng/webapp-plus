package com.chenjiacheng.webapp.task;

import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.elasticjob.api.ShardingContext;
import org.apache.shardingsphere.elasticjob.simple.job.SimpleJob;
import org.springframework.stereotype.Component;

/**
 * Created by chenjiacheng on 2025/2/21 00:16
 *
 * @author chenjiacheng
 * @since 1.0.0
 */
@Slf4j
@Component
public class DemoJob implements SimpleJob {
    @Override
    public void execute(ShardingContext shardingContext) {
        log.info("DemoJob.start:{}",shardingContext.getShardingParameter());
        log.info("DemoJob.end");
    }
}
