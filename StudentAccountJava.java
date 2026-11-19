import java.util.Scanner;

public class StudentAccountjava {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final int CORRECT_PIN = 1234;
        final int MAX_ATTEMPTS = 3;
        double balance = 1000.0;

        String[] transactions = new String[100];
        int transactionCount = 0;

        int attempts = 0;
        boolean isAuthenticated = false;

        while (attempts < MAX_ATTEMPTS) {
            System.out.print("Enter your PIN: ");
            int enteredPin = scanner.nextInt();
            attempts++;

            if (enteredPin == CORRECT_PIN) {
                isAuthenticated = true;
                System.out.println("Login successful!\n");
                break;
            } else {
                int remaining = MAX_ATTEMPTS - attempts;
                if (remaining > 0) {
                    System.out.println("Incorrect PIN. Attempts remaining: " + remaining);
                } else {
                    System.out.println("Maximum attempts reached. Exiting program.");
                }
            }
        }

        if (!isAuthenticated) {
            scanner.close();
            return;
        }

        int choice = 0;
        while (choice != 5) {
            System.out.println("\n--- ATM Main Menu ---");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. View Transaction History");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.printf("Current Balance: %.2f%n", balance);
                    break;

                case 2:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    if (depositAmount > 0) {
                        balance += depositAmount;
                        if (transactionCount < transactions.length) {
                            transactions[transactionCount] = String.format("Deposit: +%.2f | Balance: %.2f", depositAmount, balance);
                            transactionCount++;
                        }
                        System.out.printf("Successfully deposited %.2f.%n", depositAmount);
                    } else {
                        System.out.println("Invalid amount. Please enter a positive value.");
                    }
                    break;

                case 3:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    if (withdrawAmount <= 0) {
                        System.out.println("Invalid amount. Please enter a positive value.");
                    } else if (withdrawAmount <= balance) {
                        balance -= withdrawAmount;
                        if (transactionCount < transactions.length) {
                            transactions[transactionCount] = String.format("Withdrawal: -%.2f | Balance: %.2f", withdrawAmount, balance);
                            transactionCount++;
                        }
                        System.out.printf("Successfully withdrew %.2f.%n", withdrawAmount);
                    } else {
                        System.out.println("Error: Insufficient balance.");
                    }
                    break;

                case 4:
                    System.out.println("\n--- Transaction History ---");
                    if (transactionCount == 0) {
                        System.out.println("No transactions recorded yet.");
                    } else {
                        for (int i = 0; i < transactionCount; i++) {
                            System.out.println((i + 1) + ". " + transactions[i]);
                        }
                    }
                    break;

                case 5:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
