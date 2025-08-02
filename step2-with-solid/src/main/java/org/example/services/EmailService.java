package org.example.services;

import org.example.models.EmailMessage;

public interface EmailService extends MessageSender<EmailMessage> {
    void send(EmailMessage emailMessage);
}