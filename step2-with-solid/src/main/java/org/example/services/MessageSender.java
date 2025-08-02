package org.example.services;

public interface MessageSender<T> {
    void send(T message);
}
