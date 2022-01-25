package com.example.kafka.appachekafkaproducerdemo.controller;

import com.example.kafka.appachekafkaproducerdemo.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;


@RestController
public class BookController {

    @Autowired
    KafkaTemplate<String, Object> kafkaTemplate;

    private static final String TOPIC = "test-topic";
    @PostMapping("/publish")
    public String publishMessage(@RequestBody Book book)
    {
        kafkaTemplate.send(TOPIC, book);
        return "Published Successfully!";
    }

    @GetMapping("/publishMsg/{name}")
    public String publishMessage(@PathVariable String name)
    {
        kafkaTemplate.send(TOPIC, name);
        return "Published Successfully!";
    }

    @GetMapping("/healthCheck")
    public String healthCheck()
    {
        return "true";
    }
}
