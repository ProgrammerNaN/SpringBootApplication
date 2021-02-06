package ru.sber.school.springbootapp;

public interface MessageService {
    Message getMessage(Long id);
    void saveMessage(Long id, Message message);
}
