class Main {

	public static void main(String[] args) {
    	(new Main()).init();
	}

  void init(){
	print("Hello");
	double cel = FtoC(73.6);
  }

  void print(String msg){
	System.out.println(msg);
  }

  double FtoC(double F){
	  double C = (F-32) * 9/5.0;
	  return C;
  }
  
  double sphereVolume(double r){
    double v = 4/3.0*Math.PI*Math.pow(r,3);
    return v;
  }
 
  double coneVolume(double r, double h){
    double v = 1.0/3*Math.PI*Math.pow(r,2)*h;
    return v;
  }