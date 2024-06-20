package budget_tracker;

import java.util.HashMap;
import java.util.Scanner;

/**
 * This program is a simple budget tracker that allows users to track their income and expenses.
 * Users can enter income amounts, expense amounts, and optionally categorize them with dates.
 */
public class BudgetTracker {

    public static void main(String[] args) {
        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        // Initialize variables to track total income and expense
        double totalIncome = 0.0;
        double totalExpense = 0.0;

        // Display a welcome message to the user
        displayWelcomeMessage();

        // Loop to keep prompting the user for choices until they exit
        while (true) {
            // Get the user's choice (Income, Expense, or Exit)
            char userChoice = getUserChoice(scanner);

            // Exit the loop if the user chooses to exit
            if (userChoice == 'X') {
                break;
            } else if (userChoice == 'I') {
                // Get income details and update total income
                HashMap<String, Object> incomeData = getIncomeData(scanner);
                totalIncome += (Double) incomeData.get("amount");
            } else if (userChoice == 'E') {
                // Get expense details and update total expense
                HashMap<String, Object> expenseData = getExpenseData(scanner);
                totalExpense += (Double) expenseData.get("amount");
            } else {
                System.out.println("Invalid choice. Please enter I, E, or X.");
            }

            // Calculate and display the current balance
            double currentBalance = calculateBalance(totalIncome, totalExpense);
            displayBalance(currentBalance);
        }

        System.out.println("Thank you for using The Budget Tracker Program!");
        scanner.close(); // Close the Scanner object after use
    }

    /**
     * Displays a welcome message to the user explaining the program's purpose.
     */
    public static void displayWelcomeMessage() {
        System.out.println("Welcome to your Budget Tracker!");
        System.out.println("This program helps you track your income and expenses.");
    }

    /**
     * Prompts the user for their choice (Income, Expense, or Exit) and validates the input.
     *
     * @param scanner Scanner object used to read user input.
     * @return Returns the user's choice as a character (I, E, or X).
     */
    public static char getUserChoice(Scanner scanner) {
        while (true) { // Loop until a valid choice is entered
            System.out.print("Enter your choice (I - Income, E - Expense, X - Exit): ");
            char userChoice = scanner.nextLine().toUpperCase().charAt(0);
            if (userChoice == 'I' || userChoice == 'E' || userChoice == 'X') {
                return userChoice;
            } else {
                System.out.println("Invalid choice. Please enter I, E, or X.");
            }
        }
    }

    /**
     * Prompts the user for income details (amount, optional date, and category) and returns them in a HashMap.
     *
     * @param scanner Scanner object used to read user input.
     * @return Returns a HashMap containing income data (amount, date - optional, category - optional).
     */
    public static HashMap<String, Object> getIncomeData(Scanner scanner) {
        HashMap<String, Object> incomeData = new HashMap<>(); // Create a HashMap to store income data

        System.out.print("Enter income amount: ");
        double incomeAmount = scanner.nextDouble();
        incomeData.put("amount", incomeAmount); // Add income amount to the HashMap

        System.out.print("Enter income date (YYYY-MM-DD format): ");
        while(true) {
        	  String incomeDate = scanner.nextLine().trim(); // Read and trim user input
              if (!incomeDate.isEmpty()) {
                  incomeData.put("date", incomeDate); // Add income date to the HashMap
                  break;
              }

        }
      
        System.out.print("Enter income category: ");
        String incomeCategory = scanner.nextLine().trim();
        if (!incomeCategory.isEmpty()) {
            incomeData.put("category", incomeCategory); // Add income category to the HashMap
        }

        scanner.nextLine();
        scanner.nextLine(); // Consume extra newline character after double input

        return incomeData;
    }

    /**
     * Prompts the user for expense details (amount, optional date, and category) and returns them in a HashMap.
     *
     * @param scanner Scanner object used to read user input.
     * @return Returns a HashMap containing expense data (amount, date - optional, category - optional).
     */
    public static HashMap<String, Object> getExpenseData(Scanner scanner) {
        HashMap<String, Object> expenseData = new HashMap<>(); // Create a HashMap to store expense data

        System.out.print("Enter expense amount: ");
        double expenseAmount = scanner.nextDouble();
        expenseData.put("amount", expenseAmount); // Add expense amount to the HashMap

        System.out.print("Enter expense date (YYYY-MM-DD format): ");
        while (true) {
        	String expenseDate = scanner.nextLine().trim(); // Read and trim user input
            if (!expenseDate.isEmpty()) {
                expenseData.put("date", expenseDate); // Add expense date to the HashMap
                break;
            }
        }
        
        System.out.print("Enter expense category: ");
        String expenseCategory = scanner.nextLine().trim();
        if (!expenseCategory.isEmpty()) {
            expenseData.put("category", expenseCategory); // Add expense category to the HashMap
        }

        scanner.nextLine(); // Consume extra newline character after double input

        return expenseData;
    }

    /**
     * Calculates the current balance by subtracting total expense from total income.
     *
     * @param totalIncome The total income amount.
     * @param totalExpense The total expense amount.
     * @return The calculated current balance.
     */
    public static double calculateBalance(double totalIncome, double totalExpense) {
        return totalIncome - totalExpense;
    }

    /**
     * Displays the current balance to the user with a dollar sign format.
     *
     * @param currentBalance The calculated current balance.
     */
    public static void displayBalance(double currentBalance) {
        System.out.println("Your current balance is: $" + currentBalance);
    }
}

