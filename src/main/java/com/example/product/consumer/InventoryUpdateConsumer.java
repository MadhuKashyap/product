package com.example.product.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class InventoryUpdateConsumer {
    private static final Logger logger = LoggerFactory.getLogger(InventoryUpdateConsumer.class);

    @KafkaListener(
        topics = "inventory-update",
        groupId = "test-group-1",
        containerFactory = "kafkaListenerContainerFactory",
        autoStartup = "true"
    )
    public void listen(
        @Payload String message,
        @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
        @Header(KafkaHeaders.RECEIVED_PARTITION) int partition,
        @Header(KafkaHeaders.OFFSET) long offset,
        Acknowledgment ack
    ) {
        try {
            logger.info("Received message from topic: {}, partition: {}, offset: {}", topic, partition, offset);
            logger.info("Message content: {}", message);
            
            // Process the message here
            // TODO: Add your message processing logic
            
            // Acknowledge the message
            ack.acknowledge();
            logger.info("Successfully processed and acknowledged message");
        } catch (Exception e) {
            logger.error("Error processing message: {}", e.getMessage(), e);
            // You might want to implement retry logic here or send to a dead letter queue
            throw e; // Re-throw to trigger Kafka's retry mechanism
        }
    }
}
