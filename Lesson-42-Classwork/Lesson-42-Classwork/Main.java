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
      String sql = "";
      INSERT INTO CR101(section, period, teacher1, room, studentid, course) VALUES (3, 1, 'WHOKNOWS', 'ROOFTOP', 'STUDENT2', 'MCLUB1');
      INSERT INTO CR101(studentid, section, teacher, period, room, course) VALUES ('STUDENT4', 1, 'PORCHETTA', 2, 108, 'CN100');

     
		  Database   db =  new  Database("jdbc:sqlite:");	
      INSERT INTO CR101(section, period, teacher1, room, studentid, course) VALUES (3, 1, 'WHOKNOWS', 'ROOFTOP', 'STUDENT2', 'MCLUB1');
      

      
  }    
}