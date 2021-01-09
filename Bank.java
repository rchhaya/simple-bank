import java.util.InputMismatchException;
import java.util.Scanner;

public class Bank {
    //Class for a bank that stores a balance and a name
    double balance = 0;
    String name = "";

    //Withdraw function
    public double withdraw (double balance, double withdrawAmt){ 
        if (balance<withdrawAmt) {
            System.out.print("Sorry, you cannot withdraw " + withdrawAmt + "without overdrafting.");
            return balance;
        }
        balance-=withdrawAmt;
        System.out.print("You withdrew $");
        System.out.printf("%.2f", withdrawAmt);
        System.out.print(". Your new balance is: $");
        System.out.printf("%.2f", balance);
        return balance;
    }

    //Deposit function
    public double deposit (double balance, double depositAmt){
        balance+=depositAmt;
        System.out.print("You deposited $");
        System.out.printf("%.2f", depositAmt);
        System.out.print(". Your new balance is: $");
        System.out.printf("%.2f", balance);
       return balance;
    }
    //Checking the balance function
    public double checkBalance (double balance){
        System.out.print("Your current balance: $");
        System.out.printf("%.2f", balance);
        return balance;
    }

    public static void main(String[] args) {
        Bank myAccount = new Bank();
        Scanner input = new Scanner(System.in);

        while (true){
            System.out.print("Hello! What's your name? ");
            myAccount.name = input.next();
            boolean nameFlag = false;
            for (int i = 0; i < myAccount.name.length(); i++){
                char c = myAccount.name.charAt(i);
                if (!Character.isLetter(c)){
                    break;
                }
                if (Character.isLetter(c) && i == myAccount.name.length() - 1){
                    nameFlag = true;
                }
            }
            if (nameFlag) {
                break;
            } else {
                System.out.println("Invalid input. Please enter a valid name consisting of letters. ");
            }
        }
        char first = myAccount.name.charAt(0);
        myAccount.name = myAccount.name.replace(first, Character.toUpperCase(first)); 
        
        while (true){
            System.out.print(myAccount.name + ", enter your current balance: $"); 
            boolean balanceFlag = false;
            try {
                String balance = input.next();
                myAccount.balance = Double.parseDouble(balance);
                balanceFlag = true;
            } catch (NumberFormatException e){
                System.out.println("Invalid input. Please enter a valid number.");
            }
            if (balanceFlag) break;
        }
        
        int actions = 0;
        while (actions != 4){
            System.out.print("\n" + "What would you like to do, " + myAccount.name + "? Type '1' for withdraw, '2' for deposit, '3' for check balance, and '4' for quit: ");
            String actionsStr = input.next();
            try {
                actions = Integer.parseInt(actionsStr);
            } catch (NumberFormatException e){
                System.out.println("Invalid input. Please enter either 1,2,3, or 4 please.");
                continue;
            }
            if (actions == 1){
                System.out.print("Enter amount to withdraw: $");
                try {
                    String withdraw = input.next();
                    double withdrawAmt = Double.parseDouble(withdraw);
                    myAccount.balance =  myAccount.withdraw(myAccount.balance, withdrawAmt);
                } catch (NumberFormatException e){
                    System.out.println("Invalid input. Please enter a valid number.");
                    continue;
                } 
            } else if (actions == 2){
                System.out.print("Enter amount to deposit: $");
                try {
                    String deposit = input.next();
                    double depositAmt = Double.parseDouble(deposit);
                    myAccount.balance = myAccount.deposit(myAccount.balance, depositAmt);
                } catch (NumberFormatException e){
                    System.out.println("Invalid input. Please enter a valid number.");
                    continue;
                } 
                
            } else if (actions == 3){
                myAccount.balance =  myAccount.checkBalance(myAccount.balance);
            } else {
                System.out.println("Invalid operation. Please try again.");
            }
        }
        System.out.print("Thanks, " + myAccount.name + "! Your balance is: $");
        System.out.printf("%.2f", myAccount.balance);
        System.out.println("\nPlease come again!");
        input.close();
    }
}