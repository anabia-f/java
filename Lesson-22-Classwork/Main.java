class Main {
  public static void main(String[] args) {
    (new Main()).init();
  }
  void print(Object o){ System.out.println(o);}
  void printt(Object o){ System.out.print(o);}

  void init(){
   // Problem 1 
   String[] friends = {"Liam", "Noah", "Olivia", "Emma", "Lucas", "Amelia"};
  }

  
// Problem 2
  double celsiusToFahrenheit(double c){
        return c*9/5+32;
  }

  double[] convert(double[] celcius){
    double[] fahrenheit = new double[celsius.length];
  
    for (int i = 0; i < celsius.length; i++) {
      fahrenheit[i] = celsiusToFahrenheit(celsius[i]);
    }

    return fahrenheit;
  }

  void init() {
    double[] temperatures = {0, 10, 20, 30};
    double[] result = convert(temperatures);

    for (int i = 0; i < result.length; i++) {
      print(result[i]);
    }
  }
}