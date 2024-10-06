package TemplateMenu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 1. Class Definition
public class TemplateProgram {
    
    // 2. Attributes (List to store data)
    private List<ObjectType> objects;

    // Constructor to initialize list
    public TemplateProgram() {
        this.objects = new ArrayList<>();
    }

    // 3. Methods
    
    // Method to add an object
    public void addObject(ObjectType obj) {
        objects.add(obj);
        System.out.println("Object added.");
    }

    // Method to remove an object
    public void removeObject(int index) {
        if (index >= 0 && index < objects.size()) {
            objects.remove(index);
            System.out.println("Object removed.");
        } else {
            System.out.println("Invalid index.");
        }
    }

    // Method to display the list of objects
    public void showList() {
        for (int i = 0; i < objects.size(); i++) {
            System.out.println(i + ". " + objects.get(i));
        }
    }

    // Method to handle ranges or filtering (for example)
    public void filterByRange(int min, int max) {
        for (ObjectType obj : objects) {
            if (obj.getValue() >= min && obj.getValue() <= max) {
                System.out.println(obj);
            }
        }
    }

    // 4. Main method with menu logic
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TemplateProgram program = new TemplateProgram();
        
        // Main loop
        boolean running = true;
        while (running) {
            // 5. Display menu and get user input
            System.out.println("Menu:");
            System.out.println("1. Add Object");
            System.out.println("2. Remove Object");
            System.out.println("3. Show List");
            System.out.println("4. Filter by Range");
            System.out.println("5. Quit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            
            // Handle menu options
            switch (option) {
                case 1:
                    // Call add method
                    System.out.print("Enter object details: ");
                    ObjectType obj = new ObjectType(scanner.next(), option); // Replace with actual input handling
                    program.addObject(obj);
                    break;
                case 2:
                    // Call remove method
                    System.out.print("Enter index to remove: ");
                    int index = scanner.nextInt();
                    program.removeObject(index);
                    break;
                case 3:
                    // Call show list method
                    program.showList();
                    break;
                case 4:
                    // Call filter by range method
                    System.out.print("Enter min value: ");
                    int min = scanner.nextInt();
                    System.out.print("Enter max value: ");
                    int max = scanner.nextInt();
                    program.filterByRange(min, max);
                    break;
                case 5:
                    // Quit program
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
        
        System.out.println("Program terminated.");
        scanner.close();
    }
}

// Example object class (ObjectType)
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

    public String toString() {
        return "Name: " + name + ", Value: " + value;
    }
}
