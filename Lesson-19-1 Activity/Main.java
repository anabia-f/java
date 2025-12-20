class Main {

  public static void main(String[] args) {
    (new Main()).init();
  }
  
  void print(Object o){System.out.println(o);}
  void printt(Object o){System.out.print(o);}

  void init(){


    
  }

// Challenge 1
int rollDice(){
  int dice1 = (int)(Math.random()*6) + 1;
  int dice2 = (int)(Math.random()*6) + 1;
  return dice1 + " " + dice2;
}

// Challenge 2
String lotto(){
  String result = "";
  for(int x=1; x<=5; x++){
    result += (int)(Math.random()*(48-1+1)) + 1 + " ";

  return result;
  }
}

// Challenge 3
void diceDistribution(int N){
  int d1=0, d2=0, d3=0, d4=0, d5=0, d6=0;
  for(int x=0; x<N; x++){
    int roll = (int)(Math.random()*6) + 1;
    if(roll==1)
      d1++;
    else if(roll==2)
      d2++;
    else if(roll==3)
      d3++;
    else if(roll==4)
      d4++;
    else if(roll==5)
      d5++;
    else if(roll==6)
      d6++;
  }
  System.out.println("roll of 1: "+ d1);
  System.out.println("roll of 2: "+ d2);
  System.out.println("roll of 3: "+ d3);
  System.out.println("roll of 4: "+ d4);
  System.out.println("roll of 5: "+ d5);
  System.out.println("roll of 6: "+ d6);
  }

// Challenge 4
String additionTutor(){
  int n1 = (int)(Math.random() * 101);
  int n2 = (int)(Math.random() * 101);
  System.out.println("Find the sum");
  System.out.println(n1 + " + "+n2+" = ?");
  int ans = Input.readInt();
  if(ans == n1+n2){
    return "Correct!";
  }
  else{
    return "Incorrect";
  }   
}

// Bonus Challenge
String mathQuiz(){
  String op = "";
  double answer = 0;
    
  int n1 = (int)( Math.random()*(100-(-100)+1) ) + (-100);
  int n2 = (int)( Math.random()*(100-(-100)+1) ) + (-100);
  int operation = (int)( Math.random()*(3-0+1) ) + 0;

  if( operation == 0){
    answer = n1+n2;
    op = " + ";
  }
  else if (operation == 1){
    answer = n1-n2;
    op = " - ";      
  }
  else if (operation == 2){
    answer = n1*n2;
    op = " * ";      
  }
  else if (operation == 3){
    answer = n1/n2;
    op = " / ";      
  }
    
  System.out.println("Enter the answer:");
  System.out.println(n1+ op + n2+" = ?");
  int ans = Input.readInt();
  if(ans == answer){
    return "Correct!";
  }
  else{
    return "Incorrect";
  }
}