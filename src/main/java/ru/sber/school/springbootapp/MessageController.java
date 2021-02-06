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

    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping("/message")
    public ResponseEntity<Long> saveMessage(@RequestBody Message message) {
        logger.info(message.getText());
        if ("".equals(message.getText())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Long id = counterId.incrementAndGet();
        messageService.saveMessage(id, message);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @GetMapping("/message/{id}")
    public ResponseEntity<Message> getMessage(@PathVariable Long id) {
        Message message = messageService.getMessage(id);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

}
