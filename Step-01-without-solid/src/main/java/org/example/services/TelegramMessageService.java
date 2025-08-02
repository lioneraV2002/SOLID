

package edu.sharif.selab.services;

import edu.sharif.selab.models.EmailMessage;
import edu.sharif.selab.models.SmsMessage;
import edu.sharif.selab.models.TelegramMessage;

public class TelegramMessageService implements MessageService {
    @Override
    public void sendSmsMessage(SmsMessage smsMessage) {
        //Empty Body
    }

    @Override
    public void sendEmailMessage(EmailMessage emailMessage) {
        //Empty Body
    }

    @Override
    public void sendTelegramMessage(TelegramMessage telegramMessage) {
        if (validateTelegramId(telegramMessage.getSourceId()) && 
            validateTelegramId(telegramMessage.getTargetId())) {
            System.out.println("Sending a Telegram from " + telegramMessage.getSourceId() + 
                             " to " + telegramMessage.getTargetId() + 
                             " with content : " + telegramMessage.getContent());
        } else {
            throw new IllegalArgumentException("Telegram ID is Not Correct!");
        }
    }

    private boolean validateTelegramId(String telegramId) {
        // Validate if it's a username (starts with @) or phone number (11 digits)
        if (telegramId.startsWith("@")) {
            return telegramId.length() > 1 && telegramId.matches("@[a-zA-Z0-9_]+");
        }
        
        // Phone number validation (same as SMS)
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

