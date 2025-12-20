class Main {

  public static void main(String[] args) {
    (new Main()).init();
  }
  
  void print(Object o){System.out.println(o);}
  void printt(Object o){System.out.print(o);}

  void init(){
    
  }



  
  int randInt(int lower, int upper){
    int range = upper - lower;
    return (int)(Math.random()*range+lower);
  }

// Challenge 1 
void allowance(){
  int day=1;
  int penny = 1;
  while(penny < 500){
    print("Day " + day + ": " + penny);
    penny *= 2;
    day++;
  }
  print("Penny  exceeds $5 in "+day+" days. Value is: "+ penny);
}

// Challenge 2
void addTwoNumbers(){
  int n1 = randInt(-100, 100);
  int n2 = randInt(-100, 100);
  int ans = -50;
  System.out.println("What is "+n1+" + "+ n2+" = ?");
  while(n1+n2 != ans){
    ans = Input.readInt();
    if(n1+n2==ans)
      System.out.println("Correct!");
    else
      System.out.println("Incorrect, try again.");
  }
}

// Challenge 3
int GCF(int n1, int n2){    
  int divisor = Math.min(n1,n2);
  while(!(n1%divisor==0 && n2%divisor==0)){
    divisor--;
  }
  System.out.println("GCF of " +n1+" and "+n2+" is: ");
  return divisor;
}

// Challenge 4
void menu(){
  int choice = 0;
  while (choice != 4){
    System.out.println("\nWelcome Looney Tune's System");
    System.out.println("Select from the following choices:");
    System.out.println("1 - Allowance");
    System.out.println("2 - Addition game");
    System.out.println("3 - Calculate the GCF of two integers");      
    System.out.println("4 - Exit Looney Tune System");
    choice = Input.readInt();
    
    if(choice == 1){
      allowance();
    }
    else if(choice == 2){
      addTwoNumbers();
    }
    else if(choice == 3){
      System.out.println("Enter first integer:");
      int n1 = Input.readInt();
      System.out.println("Enter second integer:");
      int n2 = Input.readInt();
      System.out.println(GCF(n1,n2));
    }
    else if(choice == 4){
      System.out.println("Exiting Looney Tune System...");      
    }
    else{ 
      System.out.println("Invalid choice, try again");
    }      
  }
}
  int randInt(int lower, int upper){
  int range = upper - lower + 1 ;
  return (int)(Math.random()*range) + lower;
}

// Bonus Challenge
void rockPaperScissors() {
  int player = 0;
  int computer = 0;

  while (true){
      System.out.println("Choose one:");
      System.out.println("1 - Rock");
      System.out.println("2 - Paper");
      System.out.println("3 - Scissors");

      player = Input.readInt();

      computer = (int)(Math.random() * 3) + 1;

      if (player == computer) {
          System.out.println("It's a draw. Play again.");
      }
      else if (player == 1 && computer == 3) {
          System.out.println("You chose Rock. Computer chose Scissors.");
          System.out.println("You win!");
          return;
      }
      else if (player == 1 && computer == 2) {
          System.out.println("You chose Rock. Computer chose Paper.");
          System.out.println("You lose.");
          return;
      }
      else if (player == 2 && computer == 1) {
          System.out.println("You chose Paper. Computer chose Rock.");
          System.out.println("You win!");
          return;
      }
      else if (player == 2 && computer == 3) {
          System.out.println("You chose Paper. Computer chose Scissors.");
          System.out.println("You lose.");
          return;
      }
      else if (player == 3 && computer == 2) {
          System.out.println("You chose Scissors. Computer chose Paper.");
          System.out.println("You win!");
          return;
      }
      else if (player == 3 && computer == 1) {
          System.out.println("You chose Scissors. Computer chose Rock.");
          System.out.println("You lose.");
          return;
      }
      else {
          System.out.println("Invalid choice. Try again.");
      }
  }
}

}
  
}