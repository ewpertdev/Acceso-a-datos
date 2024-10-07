package TemplateMenu_v2;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

// Step by step to solve these kinds of problems (making menus in general):
// 1. We create a scanner object to read the user's input
// 2. We create a list of objects to store the objects
// 3. We create a constructor to initialize the scanner and the list
// 4. We create a method to run the program
// 5. We create a method to display the menu
// 6. We create a method to get the user's menu choice
// 7. We create a method to process the choice
// 8. We create a method to add an object
// 9. We create a method to remove an object

public class MenuProgram_v2 {
    // We create a scanner object to read the user's input
    private Scanner scanner;
    // We create a list of objects to store the objects
    private List<ObjectType> objects;

    // Constructor to initialize list
    public MenuProgram_v2() {
        this.scanner = new Scanner(System.in);
        this.objects = new ArrayList<>();
    }

    // Method to run the program
    // We use boolean to control the loop because we want to be able to exit the loop
    // The displayMenu method is used to display the menu
    // The int choice = getMenuChoice() we use it to get the user's choice by calling the getMenuChoice method, we put getMenuChoice inside int choice because we need to use it in the while loop condition
    // running = processChoice(choice) is used to process the choice and return the boolean value to control the loop, lets explain it:
    // If the choice is 5, the running variable will be false, and the loop will end
    // If the choice is not 5, the running variable will be true, and the loop will continue
    // This is because in our processChoice method we have a switch case that will return true if the choice is not 5 and false if the choice is 5
    // The scanner.close() is used to close the scanner object because we are using the try with resources statement
    // The try with resources statement is used to close the scanner object after the program ends
    // So how does the user get to choose what they want? They can choose from 1 to 5, 
    // 1. Add
    // 2. Remove
    // 3. Show
    // 4. Range
    // 5. Quit
    // The user can choose from 1 to 4, if they choose 5, the program will end
    // The program will ask the user to enter the name and value of the object, and the program will add it to the list
    // The program will ask the user to enter the index of the object to remove, and the program will remove it from the list
    // The program will show the list of objects
    // Its a public method because we want to be able to call it from the main method but we can call other methods from here because they are private
    public void run() {
        boolean running = true;
        while (running) {
            displayMenu();
            int choice = getMenuChoice();
            running = processChoice(choice);
        }
        scanner.close();
    }

    // Displaying the menu
    // It's a private method because we don't want to show it to the user, we dont want to show it because we want to keep it in the class
    private void displayMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Add");
        System.out.println("2. Remove");
        System.out.println("3. Show");
        System.out.println("4. Range");
        System.out.println("5. Quit");
        System.out.print("Enter your choice: ");
    }

    // Getting the user's menu choice
    // Step by step explanation:
    // 1. We use a while loop to check if the user's input is an integer
    // 2. We use the hasNextInt() method to check if the user's input is an integer
    // 3. If the user's input is not an integer, we show an error message
    // 4. We use the nextInt() method to get the user's choice
    // The parameter of this method is empty because we are using the scanner object that we created in the constructor
    // Why is this method private and it has int?...so we can return it
    private int getMenuChoice() {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next(); // Consume invalid input because if we dont do this, the program will enter an infinite loop
        }
        return scanner.nextInt();
    }

    // Processing the choice
    // Step by step explanation:
    // 1. We use a switch case to check the user's choice
    // 2. We use the break statement to exit the switch case
    // 3. We use the return statement to return the boolean value to control the loop
    // 4. We use the default statement to handle the invalid choice
    // The parameter choice is the user's choice, the reason why it needs an argument is because we need to pass the choice to the method
    // The return true statement is used to continue the loop
    // The return false statement is used to exit the loop
    // The switch case is used to check the user's choice
    // The case 1 is used to add an object
    // The case 2 is used to remove an object
    // The case 3 is used to show the list of objects
    // The case 4 is used to filter the list of objects by range
    // The case 5 is used to quit the program
    private boolean processChoice(int choice) {
        switch (choice) {
            case 1:
                add();
                break;
            case 2:
                remove();
                break;
            case 3:
                show();
                break;
            case 4:
                range();
                break;
            case 5:
                return false; // Quit
            default:
                System.out.println("Invalid choice. Please try again.");
        }
        return true;
    }

    // Add an object
    // Step by step explanation:
    // 1. We ask the user to enter the name and value of the object
    // 2. We create a new object with the name and value entered by the user
    // 3. We add the object to the list
    // 4. We show the object added
    private void add() {
        System.out.print("Enter the name: ");
        String name = scanner.next();
        System.out.print("Enter the value: ");
        int value = scanner.nextInt();
        
        ObjectType obj = new ObjectType(name, value);
        objects.add(obj);
        System.out.println("Added: " + obj);
    }

    // Remove an object by index
    private void remove() {
        System.out.println("Enter the index of the object to remove: ");
        int index = scanner.nextInt();
        if (index >= 0 && index < objects.size()) {
            ObjectType removed = objects.remove(index);
            System.out.println("Removed: " + removed);
        } else {
            System.out.println("Invalid index.");
        }
    }

    // Show the list of objects
    private void show() {
        if (objects.isEmpty()) {
            System.out.println("No objects available.");
        } else {
            System.out.println("List of objects:");
            for (int i = 0; i < objects.size(); i++) {
                System.out.println(i + ": " + objects.get(i));
            }
        }
    }

    // Range filter logic
    private void range() {
        System.out.print("Enter the minimum value: ");
        int min = scanner.nextInt();
        System.out.print("Enter the maximum value: ");
        int max = scanner.nextInt();

        System.out.println("Objects in the range " + min + " to " + max + ":");
        for (ObjectType obj : objects) {
            if (obj.getValue() >= min && obj.getValue() <= max) {
                System.out.println(obj);
            }
        }
    }

    // Class to represent an object
    class ObjectType {
        private String name;
        private int value;

        public ObjectType(String name, int value) {
            this.name = name;
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        @Override
        public String toString() {
            return "Name: " + name + ", Value: " + value;
        }
    }

    // Main method to run the program
    public static void main(String[] args) {
        new MenuProgram_v2().run();
    }
}
