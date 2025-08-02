package org.example.services;

import org.example.models.TelegramMessage;

public interface TelegramService extends MessageSender<TelegramMessage> {
    void send(TelegramMessage telegramMessage);
}