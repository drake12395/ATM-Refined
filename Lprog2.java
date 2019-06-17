import java.util.Scanner;
public class Lprog2 {

  public static void main(String[] args) {

	Scanner input = new Scanner(System.in);
    char cursor;   // used in case to reference user inputs (d,w,i,p)
    Account2[] acArray;   
    int accountNum, indexNum;
    double sum;     // used to keep track of amount of money being moved in and out of the accounts
    accountNum = input.nextInt();
    acArray = new Account2[accountNum];
 
    for(int i = 0; i < acArray.length; i++){  // creates desired amount of accounts
      acArray[i] = new Account2();
      System.out.println("account " + acArray[i].getAccountID() + " created");  // print accounts created
    }

    while(input.hasNext()){  // loop through input until it ends. 
      cursor = input.next().charAt(0);   //assign next input to variable to be evaluated in case below
      switch (cursor){
        case 'd':  // evaluates deposits
          indexNum = input.nextInt();
          sum = input.nextDouble();
          acArray[indexNum].deposit(sum);
          System.out.printf("$%.2f deposited into account " + acArray[indexNum].getAccountID() + "\n", sum);
          break;
        case 'w' :  // evaluates withdraws
          indexNum = input.nextInt();
          sum = input.nextDouble();
          if(acArray[indexNum].withdraw(sum)){
        	System.out.printf("$%.2f withdrawn from account " + acArray[indexNum].getAccountID() + "\n", sum);
          }
          else {
        	System.out.printf("Error: cannot withdraw $%.2f" + " from account " + acArray[indexNum].getAccountID() + "\n", sum); 
          }
          break;
        case 'i' :  // evaluates interest
          indexNum = input.nextInt();
          System.out.printf("$%.2f interest added to account " + acArray[indexNum].getAccountID() + "\n", acArray[indexNum].addInterest());
          break;
        case 'p' :  // evaluates transaction history and current balance
          indexNum = input.nextInt();
		  System.out.println("");
          System.out.println("****************");
		  System.out.println("* Transaction history for account " + acArray[indexNum].getAccountID());
		  acArray[indexNum].transHist();
		  System.out.println("****************");
          }
        }
	}
}

