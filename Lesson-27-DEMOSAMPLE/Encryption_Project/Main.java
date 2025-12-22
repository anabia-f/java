class Main {
  public static void main(String[] args) {
    (new Main()).init();
  }

// Level 1
class VowelSmiley{
    String addSmiley(String text){
        String result = "";
        String vowels = "aeiouAEIOU";

        for (int i = 0; i < text.length(); i++){
            String c = text.substring(i, i + 1);
            result = result + c;

            if (vowels.indexOf(c) != -1){
                result = result + ":)";
            }
        }

        return result;
    }
    void run(){
        String input = "Hello World";
        String output = addSmiley(input);
        System.out.println(output);
    }
}

// Level 2 
class EthiopicCipher{

    String mEthiopic(String text){
        String result = "";

        for (int i = 0; i < text.length(); i++){
            String c = text.substring(i, i + 1);

            if (c.equals("W")) {
                result = result + "ወ";
            }else if (c.equals("C")){
                result = result + "ጨ";
            }else if (c.equals("B")){
                result = result + "በ";
            }else if (c.equals("M")){
                result = result + "መ";
            }else if (c.equals("Y")){
                result = result + "የ";
            }else{
                result = result + c; 
            }
        }
        return result;
    }

    void run(){
        String input = "WCBMY are letters";
        String output = mEthiopic(input);
        System.out.println(output);
    }
}

// Level 3
class BinaryConvert{

    String convertToBinary(String text){
        String result = "";

        for (int i = 0; i < text.length(); i++){
            String c = text.substring(i, i + 1);

            if (c.equals("a") || c.equals("s") || c.equals(".")){
                int ascii = c.charAt(0);
                String binary = Integer.toBinaryString(ascii);
                result = result + binary + " "; 
            }else{
                result = result + c;
            }
        }

        return result;
    }

    void run() 
        String input = "a simple test.";
        String output = convertToBinary(input);
        System.out.println(output);
    }
}


}