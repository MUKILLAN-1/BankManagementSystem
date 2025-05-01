package Bank;
import java.util.*;

class Account {
    private String accountNumber;
    private String holderName;
    private double balance;

    public Account(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Amount deposited successfully.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println("Amount withdrawn successfully.");
        } else {
            System.out.println("Invalid or insufficient amount.");
        }
    }

    public void display() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + holderName);
        System.out.println("Balance: $" + balance);
        System.out.println("---------------------------");
    }
}

public class BankManagementSystem {
	 private static Map<String, Account> accounts = new HashMap<>();
	    private static Scanner sc = new Scanner(System.in);

	    public static void main(String[] args) {
	        int choice;
	        do {
	            System.out.println("\n--- Bank Management System ---");
	            System.out.println("1. Create Account");
	            System.out.println("2. View Account");
	            System.out.println("3. Deposit");
	            System.out.println("4. Withdraw");
	            System.out.println("5. View All Accounts");
	            System.out.println("6. Exit");
	            System.out.print("Enter your choice: ");
	            choice = sc.nextInt();
	            sc.nextLine();  // consume newline

	            switch (choice) {
	                case 1:
	                    createAccount();
	                    break;
	                case 2:
	                    viewAccount();
	                    break;
	                case 3:
	                    deposit();
	                    break;
	                case 4:
	                    withdraw();
	                    break;
	                case 5:
	                    viewAllAccounts();
	                    break;
	                case 6:
	                    System.out.println("Thank you for using the Bank Management System.");
	                    break;
	                default:
	                    System.out.println("Invalid choice.");
	            }
	        } while (choice != 6);
	    }

	    private static void createAccount() {
	        System.out.print("Enter account number: ");
	        String accNo = sc.nextLine();
	        if (accounts.containsKey(accNo)) {
	            System.out.println("Account already exists!");
	            return;
	        }

	        System.out.print("Enter account holder name: ");
	        String name = sc.nextLine();
	        System.out.print("Enter initial deposit amount: ");
	        double amount = sc.nextDouble();
	        sc.nextLine();  // consume newline

	        Account acc = new Account(accNo, name, amount);
	        accounts.put(accNo, acc);
	        System.out.println("Account created successfully.");
	    }

	    private static void viewAccount() {
	        System.out.print("Enter account number: ");
	        String accNo = sc.nextLine();
	        Account acc = accounts.get(accNo);
	        if (acc != null) {
	            acc.display();
	        } else {
	            System.out.println("Account not found.");
	        }
	    }

	    private static void deposit() {
	        System.out.print("Enter account number: ");
	        String accNo = sc.nextLine();
	        Account acc = accounts.get(accNo);
	        if (acc != null) {
	            System.out.print("Enter deposit amount: ");
	            double amount = sc.nextDouble();
	            sc.nextLine();  // consume newline
	            acc.deposit(amount);
	        } else {
	            System.out.println("Account not found.");
	        }
	    }

	    private static void withdraw() {
	        System.out.print("Enter account number: ");
	        String accNo = sc.nextLine();
	        Account acc = accounts.get(accNo);
	        if (acc != null) {
	            System.out.print("Enter withdrawal amount: ");
	            double amount = sc.nextDouble();
	            sc.nextLine();  // consume newline
	            acc.withdraw(amount);
	        } else {
	            System.out.println("Account not found.");
	        }
	    }

	    private static void viewAllAccounts() {
	        if (accounts.isEmpty()) {
	            System.out.println("No accounts available.");
	        } else {
	            for (Account acc : accounts.values()) {
	                acc.display();
	            }
	        }
	    }
	}


