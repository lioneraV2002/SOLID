package org.example.services;


import org.example.model.EmailMessage;
import org.example.model.SmsMessage;

public interface MessageService {
    public void sendSmsMessage(SmsMessage smsMessage);
    public void sendEmailMessage(EmailMessage emailMessage);

}
