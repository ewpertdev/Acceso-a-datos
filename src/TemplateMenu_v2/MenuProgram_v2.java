package TemplateMenu_v2;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class MenuProgram_v2 {
    private Scanner scanner;
    private List<ObjectType> objects;

    // Constructor to initialize list
    public MenuProgram_v2() {
        this.scanner = new Scanner(System.in);
        this.objects = new ArrayList<>();
    }

    // Method to run the program
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
    private int getMenuChoice() {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next(); // Consume invalid input
        }
        return scanner.nextInt();
    }

    // Processing the choice
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
