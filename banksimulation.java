import java.util.*;
class BankAccount{
    private String accountHolderName;
    private double balance;  
public BankAccount(String name, double initialbalance){
      this.accountHolderName=name;
      this.balance=initialbalance;
}
public void deposit(double amount){
    if(amount>0){
        balance+=amount;
        System.out.println("Deposited successfully");
        System.out.println("Available balance is"+balance);
    }
    else{
            System.out.println("Invalid Deposit!");
    }
}
public void withdraw(double amount){
    if(amount>0 && amount<=balance) {
        balance-=amount;
        System.out.println("Amount withdrawn successful");
        System.out.println("Available balance is"+balance);
    }
    else{
        System.out.println("Invalid Amount");
    }
}
public double getbalance(){
    return balance;
}
public void setbalance(double balance){
       this.balance=balance;
}
public void AccountDetails(){
    System.out.println("Account Holder Name:"+accountHolderName);
    System.out.println("Available Balance:"+balance);
}
}

class savingsAccount extends BankAccount{
    public savingsAccount(String name,double balance){
        super(name,balance);  
    }
    public void addinterest(){
       double interest=getbalance()*0.05;
       setbalance(getbalance()+interest);
       System.out.println("Interest added successfully");
       System.out.println("Available Balance:"+getbalance());
    }
}

class currentAccount extends BankAccount{
    private static double service_charges=500;
    public currentAccount(String name,double balance){
        super(name,balance);
    }
    public void deductcharges(){
        if(getbalance()>=service_charges){
            setbalance(getbalance()-service_charges);
            System.out.println("Service charges are deducted");
            System.out.println("Now the available balance is:"+getbalance());
        }else{
            System.out.println("Insufficient balance");
        }
    }
}

class banksimulation{
    public static void main(String[] args) {
        BankAccount account;
        Scanner sc=new Scanner(System.in);
        System.out.println("----------Welcome to Bank Account Simulation----------");
        System.out.println("Select account type:");
        System.out.println("1.savings account");
        System.out.println("2.Current account");
        int choice=sc.nextInt();
        sc.nextLine();
        System.out.println("Enter Account holder name:");
        String name=sc.nextLine();
        System.out.println("Enter initial deposit to get started:");
        double inbalance=sc.nextDouble();
         if(choice==1){
             account=new savingsAccount(name,inbalance);
         }
         else{
             account=new currentAccount(name,inbalance);            
            }
         
            System.out.println("choose any one operation"); 
         while(true){
           
         System.out.println("1.Deposit\n2.withdraw\n3.Account Details\n4.Add Interest or Deduct charges\n5.Exit");
         int option=sc.nextInt();
         switch(option){
            
            case 1:
                    System.out.print("Enter amount to be deposited:");
                    account.deposit(sc.nextDouble());
                    break;
            case 2:
                    System.out.print("Enter amount to withdraw:");
                    account.deposit(sc.nextDouble());
                    break;
            case 3:
                    account.AccountDetails();
                    break;
            case 4:
                    if(account instanceof savingsAccount){
                       ((savingsAccount)account).addinterest();
                    }
                     else if(account instanceof currentAccount){
                        ((currentAccount)account).deductcharges();
                     }   
                     break;
                    
            case 5:
                    System.out.println("---------Thank you----------");
                    sc.close();
                    return;
            default:
                    System.out.println("Option Invalid!! please check");               
         }
         System.out.println("\nChoose another operation:");
         
    }
}
}