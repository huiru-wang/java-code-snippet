package com.snippet.kafkaexample.listeners;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

import java.util.List;
import java.util.Objects;

/**
 * 异步commit
 */
@Slf4j
@Configuration
public class CommitAsyncListener {
    @KafkaListener(
            containerFactory = "kafkaListenerContainerFactory",
            id = "commitAsyncListener",
            topics = {"snippet"},
            concurrency = "2"
    )
    public void onConsumerRecord(List<ConsumerRecord<String, String>> records, Consumer<String, String> consumer) {
        records.forEach(record -> {
            int partition = record.partition();
            String topic = record.topic();
            String key = record.key();
            String value = record.value();
            log.info("Order Listener on message: topic:{},partition:{},key:{},value:{}", topic, partition, key, value);
            // ...
        });

        // manual commit
        // consumer.commitAsync();
        consumer.commitAsync((offsets, exception) -> {
            if (Objects.isNull(exception)) {
                log.info("commit offset: {}", offsets);
            } else {
                log.error("commit error: ", exception);
            }
        });
    }
}
