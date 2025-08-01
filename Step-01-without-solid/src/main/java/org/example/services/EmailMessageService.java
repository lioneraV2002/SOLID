package org.example.services;



import org.example.model.EmailMessage;
import org.example.model.SmsMessage;
import org.example.model.TelegramMessage;

import java.util.regex.Pattern;

public class EmailMessageService implements MessageService{
    @Override
    public void sendSmsMessage(SmsMessage smsMessage) {
        //Empty Body
    }

    @Override
    public void sendEmailMessage(EmailMessage emailMessage) {
        if(validateEmailAddress(emailMessage.getSourceEmailAddress()) && validateEmailAddress(emailMessage.getTargetEmailAddress())){
            System.out.println("Sending a SMS from " + emailMessage.getSourceEmailAddress() + " to " + emailMessage.getTargetEmailAddress() + " with content : " + emailMessage.getContent());
        }else{
            throw new IllegalArgumentException("Email Address is Not Correct!");
        }
    }

    @Override
    public void sendTelegramMessage(TelegramMessage telegramMessage) {
        //Empty Body!

    }

    public boolean validateEmailAddress(String email) {
        // Regular expression pattern for validating email addresses
        String emailRegex = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$";

        // Compile the pattern into a regex Pattern object
        Pattern pattern = Pattern.compile(emailRegex);

        // Check if the email string matches the regex pattern
        return pattern.matcher(email).matches();
    }
}
