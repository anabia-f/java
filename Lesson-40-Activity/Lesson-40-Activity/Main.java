
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
   

    String queryResult="";
    String sql ="";

    //Challenge 1
    Database db =  new Database("jdbc:sqlite:students.db" );	
    
    //Challenge 2
    sql = " SELECT * FROM cr101 WHERE ";
    sql += " teacher1 = 'BANU' OR teacher2 = 'BANU'"; 
    queryResult = db.runSQL(sql,"table-auto");
    print(queryResult); 
    print("*");

    //Challenge 3
    sql += " teacher1 = 'PORCHETTA' AND period = 2";
    queryResult = db.runSQL(sql,"table-auto");
    print(queryResult);
    print("*");
     
    //Challenge 4
    sql = " SELECT DISTINCT studentID FROM cr101 ";
    queryResult = db.runSQL(sql,"table-auto");
    print(queryResult); 
    print("*");
      
    //Challenge 5
    sql = "SELECT studentID, grade, course, room, period FROM cr101 WHERE ";
    sql += "grade = 11 AND room IN(322, 105, 106, 323)";
    queryResult = db.runSQL(sql,"table-auto");
    print(queryResult); 
    print("*");

    //Challenge 6
    sql += " course LIKE 'M%X'";
    queryResult = db.runSQL(sql,"table-auto");
    print(queryResult);    
     

    


    
     
  }    
}