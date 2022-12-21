import java.util.Scanner;

class InterfaceOfAtm {
    String name;
    String userName;
    String password;
    String accountNo;
    double balance = 200000;
    int transactions = 0;
    String transactionHistory = "";

    // User Registration

    public void register() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your Name : ");
        this.name = sc.nextLine();
        System.out.println("\nEnter Username : ");
        this.userName = sc.nextLine();
        System.out.println("\nEnter the Password : ");
        this.password = sc.nextLine();
        System.out.println("\nEnter your Account Number : ");
        this.accountNo = sc.nextLine();
        System.out.println("\nRegistration completed successfully! Kindly login to your Account.");
    }

    // User Login

    public boolean login() {
        boolean isLogin = false;
        Scanner sc = new Scanner(System.in);
        while (!isLogin) {
            System.out.print("\nEneter Username : ");
            String username = sc.nextLine();
            if (username.equals(userName)) {
                while (!isLogin) {
                    System.out.print("\nEnter Your Password : ");
                    String Password = sc.nextLine();
                    if (Password.equals(password)) {
                        System.out.println("\nLogin successfull!");
                        isLogin = true;
                    } else
                        System.out.println("\nIncorrect Password");
                }
            } else
                System.out.println("\nUsername not found");
        }
        return isLogin;
    }

    // Withdraw money

    public void withdraw() {
        System.out.println("\nEnter the amount to be withdrawn : ");
        Scanner sc = new Scanner(System.in);
        double amount = sc.nextDouble();
        try {
            if (balance >= amount) {
                balance -= amount;
                System.out.println("\nWithdrawal successful!");
                String str = "Rs " + amount + " Withdrawn\n";
                transactionHistory = transactionHistory.concat(str);
            } else
                System.out.println("\nInsufficient Balance.");
        } catch (Exception e) {
        }
    }

    // Deposit

    public void deposit() {
        System.out.println("\nEnter amount to deposit : ");
        Scanner sc = new Scanner(System.in);
        double amount = sc.nextDouble();
        try {
            if (amount <= 100000.00) {
                transactions++;
                balance += amount;
                System.out.println("\nDeposit successful!");
                String str = "Rs " + amount + " deposited\n";
                transactionHistory = transactionHistory.concat(str);
            } else
                System.out.println("\nLimit Exceeded!");
        } catch (Exception e) {
        }
    }

    // Transfer

    public void transfer() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter recepient name : ");
        String recepient = sc.nextLine();
        System.out.println("\nEnter amount to be transferred : ");
        double amount = sc.nextDouble();
        try {
            if (balance >= amount) {
                if (amount <= 50000.00) {
                    transactions++;
                    balance -= amount;
                    System.out.println("\nSuccessfully transferred to " + recepient);
                    String str = "Rs " + amount + " transferred to " + recepient + "\n";
                    transactionHistory = transactionHistory.concat(str);
                } else
                    System.out.println("\nSorry! Limit is ₹50000.00");
            } else
                System.out.println("\nInsufficient Balance.");
        } catch (Exception e) {
        }
    }

    // Check balance

    public void checkBalance() {
        System.out.println("\nRs " + balance);
    }

    // transaction history

    public void transHistory() {
        if (transactions == 0)
            System.out.println("\nEmpty!");
        else
            System.out.println("\n" + transactionHistory);
    }
}

