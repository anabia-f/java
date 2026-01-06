class Main {
  public static void main(String[] args) {
    (new Main()).init();
  }
  void print(Object o){ System.out.println(o);}
  void printt(Object o){ System.out.print(o);}

  void init(){
    Dog dog1 = new Dog();
    dog1.name = "Toto";
    Dog dog2 = new Dog();
    dog2.name = "Snoopy";
    Dog dog3 = new Dog();
    dog3.name = "Poophy";
    
    dog1.bark();
    dog2.bark();
    dog3.bark();
   
  }




  
  int randInt(int lower, int upper){
    int range = upper - lower;
    return (int)(Math.random()*range+lower);
  }

}