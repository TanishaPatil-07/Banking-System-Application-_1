import java.util.Scanner;

// *************** YOUR HW => Add it for multiple custoer data by using arraylist or array object.
interface RBI{
    final double rateSA = 0.04;
    final double  rateCA = 0.02;
    void calcInterest();
}


abstract class BankAccount{
    Scanner sc = new Scanner(System.in);

    int accNum, balance;
    String name, city;

    public BankAccount(){
        //initialize the balance of a newly created account to 1k.
        balance = 1000;
    }

    abstract public void deposit();
    abstract public void withdraw();

    public void addCustData(){
        System.out.println();
        System.out.println("Enter Customer A/C Number: ");
        accNum = sc.nextInt();
        System.out.println("Enter Customer Name: ");
        name = sc.next();
        System.out.println("Enter Customer City: ");
        city = sc.next();
        System.out.println("Record is added!");
    }
    public void showCustData(){
        System.out.println();
        System.out.println("Customer A/C Number: "+accNum);
        System.out.println("Customer Name: "+name);
        System.out.println("Customer City: "+city);
        System.out.println("Account Balance: "+balance);
    }
}



class CurrentAccount extends BankAccount {
    public void deposit() {
        System.out.println();
        System.out.println("Enter the amount to be deposited: ");
        int amt = sc.nextInt();
        balance = balance + amt;
        System.out.println("Updated amount is: " + balance);
    }

    public void withdraw() {
        System.out.println();
        System.out.println("Enter the amount to be withdrawn: ");
        int amt = sc.nextInt();
        if (amt > 10000) {
            System.out.println("Minimum Withdrawal Limit is 10000 only.");
        } else {
            if (balance - amt >= 1000) {
                balance = balance - amt;
                System.out.println("Amount withdrawn successfully.");
            } else {
                System.out.println("Minimum amount should be 1000 ");
            }
        }
    }
}


    class Interest1 extends CurrentAccount implements RBI {
        public void calcInterest() {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter rate of interest: ");
            int rate = sc.nextInt();
            double rate1 = (double) rate / 100;
            if (rate1 >= rateCA) {
                double amt = balance * rate1;
                System.out.println("Your Total Interest on Current Account is " + amt);
            } else {
                System.out.println("Minimum Interest Rate is 2% ");
            }
        }
    }


    class SavingsAccount extends BankAccount {
        public void deposit() {
            System.out.println();
            System.out.println("Enter the amount to be deposited: ");
            int amt = sc.nextInt();
            balance = balance + amt;
            System.out.println("Updated amount is: " + balance);
        }

        public void withdraw() {
            System.out.println();
            System.out.println("Enter the amount to be withdrawn: ");
            int amt = sc.nextInt();
            if (amt > 10000) {
                System.out.println("Minimum Withdrawal Limit is 10000 only.");
            } else {
                if (balance - amt >= 1000) {
                    balance = balance - amt;
                    System.out.println("Amount withdrawn successfully.");
                } else {
                    System.out.println("Minimum amount should be 1000 ");
                }
            }
        }
    }


        class Interest2 extends SavingsAccount implements RBI {
            public void calcInterest() {
                Scanner sc = new Scanner(System.in);
                System.out.println("Enter your rate of interest: ");
                int rate = sc.nextInt();
                double rate1 = (double) rate / 100;
                if (rate1 >= rateSA) {
                    double amt = balance * rate1;
                    System.out.println("Your Total Interest Rate on the Savings Account is " + amt);
                } else {
                    System.out.println("Min Interest Rate should be 4% ");
                }
            }
        }


        public class BankingSystem {
            public static void main(String[] args) {
                Scanner sc1 = new Scanner(System.in);

//        BankAccount obj = new BankAccount();
                SavingsAccount sa = new SavingsAccount();
                CurrentAccount ca = new CurrentAccount();

                Interest1 i1 = new Interest1();
                Interest2 i2 = new Interest2();

                while (true) {
                    System.out.println("1. For Current Account ");
                    System.out.println("2. For Savings Account ");
                    System.out.println("3. Exit ");

                    int n1 = sc1.nextInt();
                    if (n1 == 1) {
                        System.out.println("\t* For Current Account *");
                        System.out.println("1. Add Customer Data ");
                        System.out.println("2. Show Customer Data ");
                        System.out.println("3. Deposit ");
                        System.out.println("4. Withdraw ");
                        System.out.println("5. Calculate Interest ");
                        System.out.println("0. Exit ");

                        int n = sc1.nextInt();
                        switch (n) {
                            case 1:
                                i1.addCustData();
                                break;
                            case 2:
                                i1.showCustData();
                                break;
                            case 3:
                                i1.deposit();
                                break;
                            case 4:
                                i1.withdraw();
                                break;
                            case 5:
                                i1.calcInterest();
                                break;
                            case 0:
                                System.exit(0);
                                break;
                        }
                    } else if (n1 == 2) {
                        System.out.println("\t* For Savings Account *");
                        System.out.println("1. Add Customer Data ");
                        System.out.println("2. Show Customer Data ");
                        System.out.println("3. Deposit ");
                        System.out.println("4. Withdraw ");
                        System.out.println("5. Calculate Interest ");
                        System.out.println("0. Exit ");

                        int n = sc1.nextInt();
                        switch (n) {
                            case 1:
                                i2.addCustData();
                                break;
                            case 2:
                                i2.showCustData();
                                break;
                            case 3:
                                i2.deposit();
                                break;
                            case 4:
                                i2.withdraw();
                                break;
                            case 5:
                                i2.calcInterest();
                                break;
                        }
                    } else {
                        System.exit(0);
                    }

                }
            }
        }


