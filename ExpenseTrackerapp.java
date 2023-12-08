package Tasks;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

class Expense {
    private String description;
    private double amount;
    private String category;
    private Date date;

    public Expense(String description, double amount, String category) {
        this.description = description;
        this.amount = amount;
        this.category = category;
        this.date = new Date();
    }

    @Override
    public String toString() {
        return "Expense{" +
                "description='" + description + '\'' +
                ", amount=" + amount +
                ", category='" + category + '\'' +
                ", date=" + date +
                '}';
    }
}

class ExpenseTracker {
    private List<Expense> expenses;

    public ExpenseTracker() {
        this.expenses = new ArrayList<>();
    }

    public void addExpense(Expense expense) {
        expenses.add(expense);
    }

    public List<Expense> getExpenses() {
        return new ArrayList<>(expenses); 
    }

    
}

public class ExpenseTrackerapp {
    public static void main(String[] args) {
        ExpenseTracker expenseTracker = new ExpenseTracker();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Exit");

            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    
                    System.out.print("Enter description: ");
                    String description = scanner.nextLine();

                    System.out.print("Enter amount: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine(); 

                    System.out.print("Enter category: ");
                    String category = scanner.nextLine();

                    
                    Expense newExpense = new Expense(description, amount, category);
                    expenseTracker.addExpense(newExpense);
                    System.out.println("Expense added successfully!");
                    break;

                case 2:
                    
                    List<Expense> allExpenses = expenseTracker.getExpenses();
                    for (Expense expense : allExpenses) {
                        System.out.println(expense);
                    }
                    break;

                case 3:
                    
                    System.out.println("Exiting Expense Tracker. Goodbye!");
                    System.exit(0);

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}

