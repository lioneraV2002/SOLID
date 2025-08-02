package org.example.services;

import java.util.HashMap;
import java.util.Map;

public class ServiceRegistry {
    private static final Map<String, MessageSender<?>> services = new HashMap<>();

    static {
        services.put("SMS", new SmsMessageService());
        services.put("EMAIL", new EmailMessageService());
        services.put("TELEGRAM", new TelegramMessageService());
    }

    @SuppressWarnings("unchecked")
    public static <T> MessageSender<T> getService(String messageType) {
        MessageSender<?> service = services.get(messageType);
        if (service == null) {
            throw new IllegalArgumentException("نوع پیام ناشناخته: " + messageType);
        }
        return (MessageSender<T>) service;
    }
}