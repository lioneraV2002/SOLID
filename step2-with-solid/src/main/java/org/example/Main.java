package org.example;

import org.example.ui.UserInterface;

import java.util.Scanner;

/**
 * Hello world!
 */
public class Main {
    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Hello and Welcome to SE Lab Messenger.");
        UserInterface ui = new UserInterface();
        ui.run();
    }
}
