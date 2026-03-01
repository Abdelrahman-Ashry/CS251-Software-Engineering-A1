package com.mycompany.breadfastdietcalculator;

import java.util.Scanner;

public class BreadfastDietCalculator {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        Tracker myTracker = new Tracker();
        
        boolean running = true;

        System.out.println("Welcome to the Breadfast Diet Calculator!");

        while (running) {
            System.out.println("\n--- MAIN MENU ---");
            System.out.println("1. Log a food or drink");
            System.out.println("2. View daily summary");
            System.out.println("3. Exit");
            System.out.print("Choose an option (1-3): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear the enter key

            if (choice == 1) {
                // 1. Show the menu first!
                myTracker.showAvailableMenu();
                
                // 2. Then ask them what they want to log
                System.out.print("Food or Drink name: ");
                String foodInput = scanner.nextLine();
                
                myTracker.logItem(foodInput);
                
            } else if (choice == 2) {
                myTracker.printDailySummary();
                
            } else if (choice == 3) {
                System.out.println("Have a healthy day");
                running = false; 
                
            } else {
                System.out.println("Invalid option. Please type 1, 2, or 3.");
            }
        }
        
        scanner.close();
    }
}