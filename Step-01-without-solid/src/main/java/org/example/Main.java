package org.example;


import org.example.model.EmailMessage;
import org.example.model.Message;
import org.example.model.SmsMessage;
import org.example.model.TelegramMessage;
import org.example.services.EmailMessageService;
import org.example.services.SmsMessageService;
import org.example.services.TelegramMessageService;

import java.util.Scanner;

public class Main {
    public static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Hello and Welcome to SE Lab Messenger.");
        int userAnswer=0;
        do{
            Message message = null;
            org.example.services.MessageService messageService;
            String source;
            String target;
            String content;

            System.out.println("In order to send Sms message enter 1");
            System.out.println("In order to send Email message enter 2");
            System.out.println("In order to Exit, Enter 0");

            userAnswer= scanner.nextInt();

            if(userAnswer==0){
                break;
            }

            switch (userAnswer){
                case 1:
                    SmsMessage smsMessage = new SmsMessage();
                    System.out.print("Enter source phone : ");
                    source = scanner.next();
                    smsMessage.setSourcePhoneNumber(source);
                    System.out.print("Enter target phone : ");
                    target = scanner.next();
                    smsMessage.setTargetPhoneNumber(target);
                    System.out.println("Write Your Message : ");
                    content = scanner.next(".*$");
                    smsMessage.setContent(content);
                    message = smsMessage;
                    break;
                case 2:
                    EmailMessage emailMessage = new EmailMessage();
                    System.out.print("Enter source phone : ");
                    source = scanner.next();
                    emailMessage.setSourceEmailAddress(source);
                    System.out.print("Enter target phone : ");
                    target = scanner.next();
                    emailMessage.setTargetEmailAddress(target);
                    System.out.println("Write Your Message : ");
                    content = scanner.next();
                    emailMessage.setContent(content);
                    message = emailMessage;
                    break;
                case 3: 
                    TelegramMessage telegramMessage = new TelegramMessage();
                    System.out.print("Enter source telegram id : ");
                    source = scanner.next();
                    telegramMessage.setSourceId(source);
                    System.out.print("Enter target telegram id : ");
                    target = scanner.next();
                    telegramMessage.setTargetId(target);
                    System.out.println("Write Your Message : ");
                    content = scanner.next();
                    telegramMessage.setContent(content);
                    message = telegramMessage;
                    break;
            }

            if(message instanceof SmsMessage){
                messageService = new SmsMessageService();
                messageService.sendSmsMessage((SmsMessage) message);
            }else if(message instanceof EmailMessage){
                messageService = new EmailMessageService();
                messageService.sendEmailMessage((EmailMessage) message);
            }else if(message instanceof TelegramMessage){
                messageService = new TelegramMessageService();
                messageService.sendTelegramMessage((TelegramMessage) message);
            }

        }while (true);
    }
}