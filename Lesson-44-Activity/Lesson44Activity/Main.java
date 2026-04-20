import java.io.IOException;
import java.sql.*;
//For compiling on the shell on repl: Same on mac
//javac -cp sqlite-jdbc-3.23.1.jar: Main.java

//Use for windows
//javac -cp sqlite-jdbc-3.23.1.jar; ServerExample.java
class Main {

 public static void main(String[] args)throws IOException{
    (new Main()).init();
  }

  void print(Object o){ System.out.println(o);}
  void printt(Object o){ System.out.print(o);}

  void init() {

    String result="";
    String sql = "";
     
		Database db = new Database("jdbc:sqlite:chinook.db" );	

    //1
    //For the first 30 tracks, get the name of the track and the album name that it belongs to.

    
    //2
    //For each Invoice from April 2012, retrieve customer first and last name, invoice id, and Invoice date

    
    //3
    //For the first 20 invoices get the customer id, invoice id, track name, unit price and quantity .(Hint: information is in three tables) 


    //4
    //What is the list of customers' names whose merchandise is being shipped either to the USA, Germany or Poland? (Hint: use billingcountry and remove duplicates)

    
    //5

    
    //6


    
    //7
    //List all the Pop Artist names.

      
  }    
}