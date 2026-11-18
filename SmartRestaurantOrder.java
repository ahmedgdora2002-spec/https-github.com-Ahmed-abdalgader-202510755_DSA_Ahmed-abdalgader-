import java.util.Scanner;

public class SmartRestaurantOrder {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Constants
        final double DRINK_PRICE = 15.50;

        // Variables
        String name;
        int age;
        double mealPrice;
        int drinks;
        boolean isStudent;
        int rating;

        // Input
        System.out.print("Enter customer name: ");
        name = input.nextLine();

        System.out.print("Enter customer age: ");
        age = input.nextInt();

        System.out.print("Enter meal price: ");
        mealPrice = input.nextDouble();

        System.out.print("Enter number of drinks: ");
        drinks = input.nextInt();

        System.out.print("Are you a student? (true/false): ");
        isStudent = input.nextBoolean();

        System.out.print("Enter service rating (1-5): ");
        rating = input.nextInt();

        // Calculations
        double drinksCost = drinks * DRINK_PRICE;
        double subtotal = mealPrice + drinksCost;

        // Discount
        double discountRate = 0;

        if (isStudent && age >= 60) {
            discountRate = 0.10;
        } else if (isStudent) {
            discountRate = 0.10;
        } else if (age >= 60) {
            discountRate = 0.05;
        } else {
            discountRate = 0;
        }

        double discount = subtotal * discountRate;

        // Tip
        double tip = 0;

        if (rating < 1 || rating > 5) {
            System.out.println("Error: Rating must be between 1 and 5.");
            input.close();
            return;
        } else if (rating == 4 || rating == 5) {
            tip = (subtotal - discount) * 0.10;
        } else {
            tip = 0;
        }

        // Final bill
        double finalBill = subtotal - discount + tip;

        // Type casting
        int wholeAmount = (int) finalBill;

        // Receipt
        System.out.println("\n===== SMART RESTAURANT =====");
        System.out.println("Customer: " + name);
        System.out.println("Meal: $" + mealPrice);
        System.out.println("Drinks: $" + drinksCost);
        System.out.println("Discount: $" + discount);
        System.out.println("Tip: $" + tip);
        System.out.println("Final bill: $" + finalBill);
        System.out.println("Whole amount: $" + wholeAmount);

        input.close();
    }
}  
