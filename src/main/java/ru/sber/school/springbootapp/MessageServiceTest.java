package ru.sber.school.springbootapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
@Profile("test")
public class MessageServiceTest implements MessageService {

    private static final Logger logger = LoggerFactory.getLogger(MessageServiceTest.class);

    private final Map<Long, Message> messages = new ConcurrentHashMap<>();

    @Override
    public Message getMessage(Long id) {
        logger.info("Return: {} - {}", id, messages.get(id).getText());
        return messages.get(id);
    }

    @Override
    public void saveMessage(Long id, Message message) {
        logger.info("Save: {} - {}", id, message.getText());
        messages.put(id, message);
    }
}
