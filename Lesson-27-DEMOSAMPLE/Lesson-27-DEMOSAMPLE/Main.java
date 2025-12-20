class Main {
  public static void main(String[] args) {
    (new Main()).init();
  }
  void print(Object o){ System.out.println(o);}
  void printt(Object o){ System.out.print(o);}

  void init(){

    // This example we are substituting all lower case 
    // letters to another lower case letter.
    char[] sub = new char[5];
    sub[0] = 'a';
    sub[1] = 'e';
    sub[2] = 'i';
    sub[3] = 'o';
    sub[4] = 'u';

    char[] sub2 = new char[5];
    sub2[0] = '\u2663';  // Club
    sub2[1] = '\u2660';  // Spade
    sub2[2] = '\u2665';  // Heart
    sub2[3] = '\u2666';  // Diamond
    sub2[4] = '\u2836';  // Bralle symbol

    
    // Encoding message
    String file = Input.readFile("test.txt");

    //substituion
    String encodedMsg1 = subEncryption(file,sub,sub2);
    //Input.writeFile("Encode1.txt",encodedMsg1);

    // caesar cipher
    String encodedMsg2 = encode(encodedMsg1);
    //Input.writeFile("Encode2.txt",encodedMsg2);

    // reverse
    String encodedMsg3 = reverse(encodedMsg2);
    Input.writeFile("Encode3.txt",encodedMsg3);

    
    // decoding message
    String file2 = Input.readFile("Encode1.txt");
    
    String decodedMsg1 = reverse(file2);
    //Input.writeFile("Decode1.txt", decodedMsg1);
    
    String decodedMsg2 = decode(decodedMsg1);
    //Input.writeFile("Decode2.txt", decodedMsg2);
    
     String decodedMsg3 = subEncryption(decodedMsg2, sub2, sub);
    //Input.writeFile("Decode1.txt", decodedMsg3);
    
    
  }
  // Level 1 reverse string
  String reverse(String txt){
    String bld ="";
    
    return bld;
  }
  
  
  //Level 2 Cipher encoding with no wrapping
  String encode(String txt){
    String bld="";
    
     
    return bld;
  }

  
  String decode(String txt){
    String bld="";
   
    return bld;
  }

  // Level 3 Substituion encoding
  String subEncryption(String s, char[] sub, char[] sub2){
    String bld="";
   
    return bld;
  }
  
  
  int randInt(int lower, int upper){
    int range = upper - lower;
    return (int)(Math.random()*range+lower);
  }


  String levelOne(String input) {
        String vowels = "aeiouAEIOU";
        StringBuilder result = new StringBuilder(input);

        for (char c : input.toCharArray()) {
            if (vowels.indexOf(c) != -1) {
                result.append(":)");
            }
        }
        return result.toString();
    }

    // LEVEL 2: ASCII character shifting
    private static String levelTwo(String input) {
        StringBuilder result = new StringBuilder();

        for (char c : input.toCharArray()) {
            char lower = Character.toLowerCase(c);
            int ascii = c;

            switch (lower) {
                case 'w':
                    ascii += 2;
                    break;
                case 'c':
                    ascii += 3;
                    break;
                case 'm':
                    ascii -= 2;
                    break;
                case 'b':
                    ascii += 1;
                    break;
                case 'y':
                    ascii -= 3;
                    break;
                default:
                    break;
            }

            result.append((char) ascii);
        }
        return result.toString();
    }

    // LEVEL 3: Convert even ASCII values to binary
    private static String levelThree(String input) {
        StringBuilder result = new StringBuilder();

        for (char c : input.toCharArray()) {
            int ascii = c;

            if (ascii % 2 == 0) {
                String binary = String.format("%8s",
                        Integer.toBinaryString(ascii)).replace(' ', '0');
                result.append(binary);
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }
}
}