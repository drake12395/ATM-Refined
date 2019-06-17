 class Account2 {
   private int accountID;  // private variables to keep account information enclosed
   private double balance;
   private static final double INTEREST_RATE = 0.005;
   private int pos;       // position variable to use as index position in the recordTrans method
   private String[] recordTrans;
	  //construct account object
   Account2(){
     balance = 0.0;
     accountID = 1000 + (int)(Math.random() * 9000);
     recordTrans = new String[5]; // use counter in trans method to stop at desired amount
   }
   public int getAccountID(){
	 return accountID;
   }
   public double deposit(double sum){  //adds deposit to balance
     adTrans(String.format("* $%.2f deposited " + "\n", sum));
	 return balance += sum;
   }
   public boolean withdraw( double sum){  //subtracts withdraw from balance
	 if ( balance < sum){   // check for overdraft
	   return false;
	 }
	 else{
       adTrans(String.format("* $%.2f withdrawn " + "\n", sum));
	   balance -= sum;
	   return true;
	 }
   }
   public double addInterest(){  //adds interest when called to loop and sets balance to include interest
     double interest = balance * INTEREST_RATE;
	 balance += interest;
	 adTrans(String.format("* $%.2f earned in interest " + "\n", interest));
	 return interest;
   }
   public double getBalance(){
     return balance;
   }
   private void adTrans(String message){   //populates a string array with the print statements
	 recordTrans[pos] = message;
     pos++;                               //moves the position of the index up one after each incoming message
   }
   public void transHist(){
     for(int i = 0; i < pos; i++){    //loops through each transaction in each account
   	   System.out.print(recordTrans[i]);
	 }
     System.out.printf("* Current balance: $%.2f" + "\n", balance);  // prints current balance outside of loop
   }
}
