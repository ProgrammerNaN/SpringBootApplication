package ru.sber.school.springbootapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class MessageController {

    public static final Logger logger = LoggerFactory.getLogger(MessageController.class);

    private final AtomicLong counterId = new AtomicLong();

    @PostMapping("/message")
    public ResponseEntity<Long> saveMessage(@RequestBody Message message) {
        logger.info(message.getText());
        if ("".equals(message.getText())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Long>(counterId.incrementAndGet(), HttpStatus.OK);
    }

    @GetMapping("/message/{id}")
    public ResponseEntity<Message> getMessage(@PathVariable String id) {
        Message message = new Message();
        message.setText(id);
        return new ResponseEntity<Message>(message, HttpStatus.OK);
    }

}
