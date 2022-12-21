import java.util.*;
class ATM_Interface {
    public static int takeInput(int lmt) {
        int input = 0;
        boolean flag = false;
        while (!flag) {
            try {
                Scanner sc = new Scanner(System.in);
                input = sc.nextInt();
                flag = true;
                if (flag && input > lmt || input < 1) {
                    System.out.println("Select the number between 1 to " + lmt);
                    flag = false;
                }
            } catch (Exception e) {
                System.out.println("Enter integer value only");
                flag = false;
            }
        }
        return input;
    }

    // main method

    public static void main(String[] args) {
        System.out.println("\n   WELCOME TO Bluej ATM   \n");
        System.out.println("1.Register\n2.Exit");
        System.out.print("Enter your choice : ");
        int choice = takeInput(2);
        if (choice == 1) {
            InterfaceOfAtm b = new InterfaceOfAtm();
            b.register();
            while (true) {
                System.out.println("\n1.Login\n2.Exit");
                System.out.print("Enter your choice: ");
                int ch = takeInput(2);
                if (ch == 1) {
                    if (b.login()) {
                        System.out.println("\n\nWELCOME BACK! " + b.name + "\n\n");
                        boolean isFinished = false;
                        while (!isFinished) {
                            System.out.println(
                                    "\n1.Deposit\n2.Withdraw\n3.Transfer\n4.Transaction History\n5.Check Balance");
                            System.out.print("Enter your choice : ");
                            int c = takeInput(6);
                            switch (c) {
                                case 1:
                                    b.deposit();
                                    break;
                                case 2:
                                    b.withdraw();
                                    break;
                                case 3:
                                    b.transfer();
                                    break;
                                case 4:
                                    b.transHistory();
                                    break;
                                case 5:
                                    b.checkBalance();
                                    break;
                                case 6:
                                    isFinished = true;
                                    break;
                                default:
                                    System.out.println("\nWrong Choice!");
                            }
                        }
                    }
                } else
                    System.exit(0);
            }
        }
    };
}