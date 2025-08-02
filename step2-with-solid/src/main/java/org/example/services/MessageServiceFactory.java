package org.example.services;


import org.example.models.Message;

public class MessageServiceFactory {
    @SuppressWarnings("unchecked")
    public static void sendMessage(Message message) {
        MessageSender<Message> sender = (MessageSender<Message>) ServiceRegistry.getService(message.getMessageType());
        sender.send(message);
    }
}