package org.example.services;

import org.example.models.TelegramMessage;

public class TelegramMessageService implements TelegramService {
    @Override
    public void send(TelegramMessage telegramMessage) {
        if (validateTelegramId(telegramMessage.getSourceId()) &&
                validateTelegramId(telegramMessage.getTargetId())) {
            System.out.println("تلاش برای ارسال پیام تلگرام از " + telegramMessage.getSourceId() +
                    " به " + telegramMessage.getTargetId() +
                    " با محتوا: " + telegramMessage.getContent());
            System.out.println("پیام با موفقیت ارسال شد!");
        } else {
            throw new IllegalArgumentException("شناسه تلگرام یا شماره تلفن معتبر نیست!");
        }
    }

    private boolean validateTelegramId(String telegramId) {
        if (telegramId.startsWith("@")) {
            return telegramId.length() >= 5 && telegramId.matches("@[a-zA-Z0-9_]+");
        }
        if (telegramId.length() != 11) {
            return false;
        }
        for (char digit : telegramId.toCharArray()) {
            if (!Character.isDigit(digit)) {
                return false;
            }
        }
        return true;
    }
}