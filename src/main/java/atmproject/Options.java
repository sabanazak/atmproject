package atmproject;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class Options extends Account{
    Scanner input = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");
    Map<Integer, Integer> data = new HashMap<>();
    boolean flag = true;
    public void login(){
        System.out.println("Welcome to Techproed ATM..");
        int counter = 0;
        do {
            data.put(12345, 1234);//person A
            data.put(23456, 2345);//Person B
            data.put(34567,3456);//Person C
            data.put(45678,4567);//Person D
            try{
                System.out.println("Enter the account number: ");
                setAccountNumber(input.nextInt());
                System.out.println("Enter the pin number: ");
                setPinNumber(input.nextInt());
            }catch (Exception e){
                System.out.println("You entered an invalid character(s)!");
                System.out.println("Please provide and integer to proceed or press Q to quit the system");
                String exit = input.nextLine();
                if(exit.equalsIgnoreCase("q")){
                    flag = false;
                }
                e.printStackTrace();
                System.exit(0);
            }
            int count = 0;
            for (Map.Entry<Integer, Integer> w: data.entrySet()){
                //12345
                if(w.getKey().equals(getAccountNumber()) && w.getValue().equals(getPinNumber())){
                    getAccountTypes();//You can start your actions with any account
                }else {
                    count++;
                }
            }
            if(count == data.size()){
                counter ++;
                System.out.println("Account number or pin number is invalid!");
                System.out.println("Press any integer to proceed or press q to quit");
                String exit = input.nextLine();
                if(exit.equalsIgnoreCase("q")){
                    flag = false;
                }
            }
            if(counter == 3){
                System.out.println("Your account has been blocked!!");
                flag = false;
            }
        }while (flag);
    }
    public void getAccountTypes(){
        System.out.println("Select the account you want to access!");
        System.out.println("1: Checking account");
        System.out.println("2: Saving account");
        System.out.println("3: Quit");
        int option = input.nextInt();
        switch(option) {
            case 1:
                System.out.println("you are in checking account");
                checkingOperations();
                break;
            case 2:
                System.out.println("You are in your saving account");
                savingOperations();
                break;
            case 3:
                flag = false;
                break;
            default:
                System.out.println("Invalid choice! Please select 1, 2 or 3");
                getAccountTypes();
        }
    }
    public void checkingOperations(){
        do{
            optionMessages();
            int option = input.nextInt();
            if(option == 4){
                break;
            }
            switch (option) {
                case 1:
                    System.out.println("Your checking balance is: "+moneyFormat.format(getCheckingBalance()));
                    break;
                case 2:
                    getCheckingWithdraw();
                    break;
                case 3:
                    getCheckingDeposit();
                    break;
                default:
                    System.out.println("invalid option, please select 1, 2, 3 or 4");
            }
        }while (true);
    }
    public void savingOperations(){
        do {
            optionMessages();
            int option = input.nextInt();
            if(option == 4){
                break;
            }
            switch (option){
                case 1:
                    System.out.println("Your saving balance is: "+moneyFormat.format(getSavingBalance()));
                    break;
                case 2:
                    getSavingWithdraw();
                    break;
                case 3:
                    getSavingDeposit();
                    break;
                default:
                    System.out.println("invalid option, please select 1, 2, 3 or 4");
            }
        }while (true);
    }
    public void optionMessages(){
        System.out.println("Select Option:");
        System.out.println("1: View the balance");
        System.out.println("2: Withdraw");
        System.out.println("3: Deposit");
        System.out.println("4: Exit");
    }
}
