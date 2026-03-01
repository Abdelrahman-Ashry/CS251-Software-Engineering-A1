/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.breadfastdietcalculator;

/**
 *
 * @author 3com
 */
public class FoodItem {
    
        String dietip, name;
        int calories;
        double protein, carbs,caffeine;
    //constuctor
    public FoodItem(String dietip,String name, int calories, double protein, double carbs, double caffeine){
        
       
         this.dietip=dietip;
         this.name=name;
         this.calories=calories;
         this.protein=protein;
         this.carbs=carbs;
         this.caffeine=caffeine;
    }
    // Getters
    public String getName() {
        return name;
    }

    public int getCalories() {
        return calories;
    }

    public double getProtein() {
        return protein;
    }

    public double getCarbs() {
        return carbs;
    }

    public double getCaffeine() {
        return caffeine;
    }

    public String getDietTip() {
        return dietip;
    }
    
    
}
