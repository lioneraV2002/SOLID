package org.example.services;


import org.example.model.EmailMessage;
import org.example.model.SmsMessage;
import org.example.model.TelegramMessage;

public interface MessageService {
    public void sendSmsMessage(SmsMessage smsMessage);
    public void sendEmailMessage(EmailMessage emailMessage);
    public void sendTelegramMessage(TelegramMessage telegramMessage);
}