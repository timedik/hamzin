package com.example.demo.controller;

import com.example.demo.dto.OrderRequest;
import com.example.demo.service.OrderProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderProducer producer;

    @PostMapping
    public String createOrder(@RequestBody OrderRequest request) {

        producer.sendOrder(request.product());

        return "Order sent to Kafka";
    }
}