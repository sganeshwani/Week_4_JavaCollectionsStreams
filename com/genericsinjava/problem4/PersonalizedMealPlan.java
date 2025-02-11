package com.genericsinjava.problem4;

import java.util.ArrayList;
import java.util.List;

// Interface representing a Meal Plan
interface MealPlan {
    String getMealType();
}

// Specific meal plans
class VegetarianMeal implements MealPlan {
    @Override
    public String getMealType() {
        return "Vegetarian Meal";
    }
}

class VeganMeal implements MealPlan {
    @Override
    public String getMealType() {
        return "Vegan Meal";
    }
}

class KetoMeal implements MealPlan {
    @Override
    public String getMealType() {
        return "Keto Meal";
    }
}

class HighProteinMeal implements MealPlan {
    @Override
    public String getMealType() {
        return "High-Protein Meal";
    }
}

// Generic Meal class with bounded type parameter
class Meal<T extends MealPlan> {
    private String mealName;
    private T mealType;

    public Meal(String mealName, T mealType) {
        this.mealName = mealName;
        this.mealType = mealType;
    }

    public String getMealName() {
        return mealName;
    }

    public T getMealType() {
        return mealType;
    }

    @Override
    public String toString() {
        return "Meal: " + mealName + " -> " + mealType.getMealType();
    }
}

// Meal Plan Generator
class MealPlanGenerator {
    private List<Meal<? extends MealPlan>> meals;

    public MealPlanGenerator() {
        this.meals = new ArrayList<>();
    }

    public void addMeal(Meal<? extends MealPlan> meal) {
        meals.add(meal);
    }

    public void generateMealPlan() {
        System.out.println("Generated Personalized Meal Plan:");
        for (Meal<? extends MealPlan> meal : meals) {
            System.out.println(meal);
        }
    }
}

// Main class to test the implementation
public class PersonalizedMealPlan {
    public static void main(String[] args) {
        MealPlanGenerator generator = new MealPlanGenerator();

        // Creating meals
        Meal<VegetarianMeal> vegMeal = new Meal<>("Grilled Vegetables", new VegetarianMeal());
        Meal<VeganMeal> veganMeal = new Meal<>("Tofu Salad", new VeganMeal());
        Meal<KetoMeal> ketoMeal = new Meal<>("Avocado Chicken", new KetoMeal());
        Meal<HighProteinMeal> proteinMeal = new Meal<>("Steak and Eggs", new HighProteinMeal());

        // Adding meals to generator
        generator.addMeal(vegMeal);
        generator.addMeal(veganMeal);
        generator.addMeal(ketoMeal);
        generator.addMeal(proteinMeal);

        // Generating a meal plan
        generator.generateMealPlan();
    }
}
