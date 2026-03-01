/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.breadfastdietcalculator;

/**
 *
 * @author 3com
 */

import java.util.LinkedHashMap;
import java.util.ArrayList;


public class Tracker {
    
    //The Dictionary 
    LinkedHashMap<String, FoodItem> menuDatabase;
    
    //Your Daily Diary
    ArrayList<FoodItem> dailyLog;
    //constructor
    public Tracker() {
        // Initialize empty lists
        menuDatabase = new LinkedHashMap<>();
        dailyLog = new ArrayList<>();
        // Sandwiches & Wraps
        menuDatabase.put("smoked salmon bagel", new FoodItem("Good source of healthy fats", "Smoked Salmon Bagel", 500, 20.0, 45.0, 0.0));
        menuDatabase.put("spicy chicken sandwich", new FoodItem("Remove the mayo and halve the spicy sauce", "Spicy Chicken Sandwich", 550, 25.0, 40.0, 0.0));
        menuDatabase.put("signature tuna sandwich", new FoodItem("Remove the mayo sauce", "Signature Tuna Sandwich", 550, 22.0, 42.0, 0.0));
        menuDatabase.put("premium turkey wrap", new FoodItem("Excellent choice: 32g of protein", "Premium Turkey Wrap", 450, 32.0, 35.0, 0.0));
        menuDatabase.put("spicy tuna wrap", new FoodItem("Remove the mayo sauce", "Spicy Tuna Wrap", 430, 20.0, 35.0, 0.0));
        menuDatabase.put("greel sandwich", new FoodItem("Note: Not that much protein", "Greel Sandwich", 420, 10.0, 40.0, 0.0));
        menuDatabase.put("turkey & cheese sandwich", new FoodItem("Remove the cheddar sauce (it is a disaster!)", "Turkey & Cheese Sandwich", 550, 25.0, 45.0, 0.0));
        
        // Salads
        menuDatabase.put("arugula halloumi salad", new FoodItem("Remove caramelized walnuts and sauces", "Arugula Halloumi Salad", 500, 15.0, 10.0, 0.0));
        menuDatabase.put("classic chicken caesar salad", new FoodItem("Remove any sauces", "Classic Chicken Caesar Salad", 380, 30.0, 15.0, 0.0));
        menuDatabase.put("mediterranean chicken salad", new FoodItem("No sauce, halve feta cheese and bread", "Mediterranean Chicken Salad", 400, 28.0, 20.0, 0.0));
        menuDatabase.put("apple chicken salad", new FoodItem("Reduce pasta, no sour cream or sauces", "Apple Chicken Salad", 430, 25.0, 30.0, 0.0));
        menuDatabase.put("tuna pasta salad", new FoodItem("Reduce pasta as much as you can, no sauces", "Tuna Pasta Salad", 650, 25.0, 60.0, 0.0));
        menuDatabase.put("greek salad", new FoodItem("Best Option!", "Greek Salad", 300, 10.0, 12.0, 0.0));
        
        // Hot Coffees
        menuDatabase.put("americano", new FoodItem("Preferably ordered with no sugar", "Americano", 10, 0.0, 0.0, 150.0));
        menuDatabase.put("white americano", new FoodItem("Skimmed milk preferred", "White Americano", 40, 2.0, 3.0, 150.0));
        menuDatabase.put("flat white", new FoodItem("Skimmed milk preferred", "Flat White", 110, 6.0, 8.0, 130.0));
        menuDatabase.put("cappuccino", new FoodItem("Skimmed milk preferred", "Cappuccino", 130, 7.0, 10.0, 130.0));
        menuDatabase.put("latte", new FoodItem("Use skimmed milk, not full fat", "Latte", 160, 9.0, 12.0, 150.0));
        menuDatabase.put("chai latte", new FoodItem("Use skimmed milk if possible", "Chai Latte", 50, 2.0, 10.0, 50.0));
        
        // Cold Drinks & Desserts
        menuDatabase.put("iced americano", new FoodItem("Diet sugar is preferred", "Iced Americano", 10, 0.0, 0.0, 150.0));
        menuDatabase.put("iced latte", new FoodItem("Use skimmed milk", "Iced Latte", 120, 8.0, 10.0, 150.0));
        menuDatabase.put("matcha", new FoodItem("Water/skimmed milk, no syrup, no sugar", "Matcha", 10, 0.0, 0.0, 70.0));
        menuDatabase.put("banana chia pudding", new FoodItem("Very good on the go option for breakfast", "Banana Chia Pudding", 300, 5.0, 35.0, 0.0));
        menuDatabase.put("mango chia pudding", new FoodItem("Good breakfast option", "Mango Chia Pudding", 300, 4.0, 38.0, 0.0));
        
        // Protein Snacks (Byld)
        menuDatabase.put("byld the red one", new FoodItem("22g Protein Crisps", "Byld The Red One", 200, 22.0, 15.0, 0.0));
        menuDatabase.put("byld the yellow one", new FoodItem("Great protein snack", "Byld The Yellow One", 210, 20.0, 15.0, 0.0));
        menuDatabase.put("byld the blue one", new FoodItem("Chocolate Brownies (10g protein)", "Byld The Blue One", 210, 10.0, 20.0, 0.0));
        menuDatabase.put("byld the green one", new FoodItem("Great protein snack", "Byld The Green One", 210, 20.0, 15.0, 0.0));
        menuDatabase.put("byld chunks", new FoodItem("Peanut Caramel (65 kcal per chunk)", "Byld Chunks", 65, 3.0, 6.0, 0.0));
    }
    
    //takes in the name the user typed
    public void logItem(String searchName) {
        
        // Force the word to be lowercase
        searchName = searchName.toLowerCase();
        
        //  Ask the dictionary if it knows this word
        if (menuDatabase.containsKey(searchName)) {
            
            //Grab the exact FoodItem object from the dictionary
            FoodItem foundItem = menuDatabase.get(searchName);
            
            // Add it to your daily diary
            dailyLog.add(foundItem);
            
            
            
            System.out.println("Success! Added: " + foundItem.getName());
            System.out.println("Breadfast Tip: " + foundItem.getDietTip());
            System.out.println("Nutrition:");
            System.out.println("Calories: " + foundItem.getCalories() + " kcal");
            System.out.println("Protein:  " + foundItem.getProtein() + " g");
            System.out.println("Carbs:    " + foundItem.getCarbs() + " g");
            System.out.println("Caffeine: " + foundItem.getCaffeine() + " mg\n");
            
        } else {
            
            System.out.println("Sorry, '" + searchName + "' is not on the menu. Try again");
        }
        
        
    }// The Calculator 
    public void printDailySummary() {
        
        
        int totalCalories = 0;
        double totalProtein = 0.0;
        double totalCarbs = 0.0;
        double totalCaffeine = 0.0;

        System.out.println("\n--- YOUR DAILY TOTALS ---");

        // 2. Loop through every item in your diary
        for (FoodItem item : dailyLog) {
            
            
            totalCalories += item.getCalories();
            totalProtein+=item.getProtein(); 
            totalCarbs+=item.getCarbs();
            totalCaffeine+=item.getCaffeine();
            
            
            
        }

        //Print the final results
        System.out.println("Calories: " + totalCalories + " kcal");
        System.out.println("Protein:  " + totalProtein + " g");
        System.out.println("Carbs:    " + totalCarbs + " g");
        System.out.println("Caffeine: " + totalCaffeine + " mg");
        System.out.println("-------------------------\n");
    }

   // Method to show all available items
    public void showAvailableMenu() {
        System.out.println("\n--- AVAILABLE BREADFAST MENU ---");
        
        // This loop grabs every "key" (the food name) from your dictionary
        for (String itemName : menuDatabase.keySet()) {
            System.out.println("- " + itemName);
        }
        
        System.out.println("--------------------------------");
    }
}

    
    
    
 
