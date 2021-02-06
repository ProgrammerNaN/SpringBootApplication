package ru.sber.school.springbootapp;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
@Profile("local")
public class MessageServiceLocal implements MessageService {

    private final Map<Long, Message> messages = new ConcurrentHashMap<>();


    @Override
    public Message getMessage(Long id) {
        return messages.get(id);
    }

    @Override
    public void saveMessage(Long id, Message message) {
        messages.put(id, message);
    }
}
