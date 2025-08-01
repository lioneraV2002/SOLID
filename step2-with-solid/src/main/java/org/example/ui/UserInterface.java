package org.example.ui;


import org.example.Main;
import org.example.controller.MessageController;
import org.example.models.EmailMessage;
import org.example.models.Message;
import org.example.models.SmsMessage;
import org.example.models.TelegramMessage;

import java.util.Scanner;

public class UserInterface {
    private final Scanner scanner = Main.scanner;
    private final MessageController controller = new MessageController();

    public void run() {
        int userAnswer;
        do {
            displayMenu();
            while (!scanner.hasNextInt()) {
                System.out.println("لطفاً عدد معتبر وارد کنید!");
                scanner.next();
            }
            userAnswer = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            if (userAnswer == 0) {
                break;
            }

            if (userAnswer < 1 || userAnswer > 3) {
                System.out.println("گزینه نامعتبر! لطفاً ۱، ۲، ۳ یا ۰ وارد کنید.");
                continue;
            }

            Message message = collectInput(userAnswer);
            if (message != null) {
                controller.sendMessage(message);
            }
        } while (true);
    }

    private void displayMenu() {
        System.out.println("برای ارسال پیام SMS عدد ۱ را وارد کنید");
        System.out.println("برای ارسال پیام ایمیل عدد ۲ را وارد کنید");
        System.out.println("برای ارسال پیام تلگرام عدد ۳ را وارد کنید");
        System.out.println("برای خروج، عدد ۰ را وارد کنید");
    }

    private Message collectInput(int choice) {
        String source, target, content;
        switch (choice) {
            case 1:
                System.out.print("شماره مبدا را وارد کنید: ");
                source = scanner.nextLine();
                System.out.print("شماره مقصد را وارد کنید: ");
                target = scanner.nextLine();
                System.out.println("پیام خود را بنویسید: ");
                content = scanner.nextLine();
                SmsMessage sms = new SmsMessage();
                sms.setSourcePhoneNumber(source);
                sms.setTargetPhoneNumber(target);
                sms.setContent(content);
                return sms;
            case 2:
                System.out.print("ایمیل مبدا را وارد کنید: ");
                source = scanner.nextLine();
                System.out.print("ایمیل مقصد را وارد کنید: ");
                target = scanner.nextLine();
                System.out.println("پیام خود را بنویسید: ");
                content = scanner.nextLine();
                EmailMessage email = new EmailMessage();
                email.setSourceEmailAddress(source);
                email.setTargetEmailAddress(target);
                email.setContent(content);
                return email;
            case 3:
                System.out.print("شناسه تلگرام مبدا را وارد کنید: ");
                source = scanner.nextLine();
                System.out.print("شناسه تلگرام مقصد را وارد کنید: ");
                target = scanner.nextLine();
                System.out.println("پیام خود را بنویسید: ");
                content = scanner.nextLine();
                TelegramMessage telegram = new TelegramMessage();
                telegram.setSourceId(source);
                telegram.setTargetId(target);
                telegram.setContent(content);
                return telegram;
            default:
                return null;
        }
    }
}
