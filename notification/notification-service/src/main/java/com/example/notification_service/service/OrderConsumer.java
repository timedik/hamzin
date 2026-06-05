package com.example.notification_service.service;

import com.example.notification_service.entity.OrderEntity;
import com.example.notification_service.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderConsumer {

    private final OrderRepository repository;

    @KafkaListener(
            topics = "orders-topic",
            groupId = "group1"
    )
    public void consume(String product) {

        OrderEntity order = new OrderEntity();

        order.setProduct(product);

        repository.save(order);

        System.out.println("Saved to DB: " + product);
    }
}