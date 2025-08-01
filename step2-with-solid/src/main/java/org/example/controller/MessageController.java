package org.example.controller;


import org.example.models.Message;
import org.example.services.MessageServiceFactory;

public class MessageController {
    public void sendMessage(Message message) {
        try {
            MessageServiceFactory.sendMessage(message);
        } catch (IllegalArgumentException e) {
            System.out.println("خطا: " + e.getMessage());
        }
    }
}