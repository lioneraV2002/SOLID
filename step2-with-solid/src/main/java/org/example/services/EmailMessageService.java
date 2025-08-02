package org.example.services;
import org.example.models.TelegramMessage;

public class EmailMessageService implements EmailService {
    @Override
    public void send(TelegramMessage telegramMessage) {
        // Empty implementation since SMS service doesn't handle Telegram messages
    }
}
