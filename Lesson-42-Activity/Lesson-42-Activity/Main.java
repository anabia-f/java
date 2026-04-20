
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

		Database db = new Database("jdbc:sqlite:" );	
    
    //Challenge 1
    sql =  " Update cr101 ";
    sql += " set room = 122 ";
    sql += " Where studentid='STUDENT1001' AND period=3 ";
    db.runSQL(sql);    
    sql  = " Select * From cr101 ";
    sql += " Where studentid='STUDENT1001' AND period=3 ";
    queryResult = db.runSQL(sql,"table-auto");
    print(queryResult);

    //Challenge 2
    sql =  " Delete From cr101 ";
    sql += " Where studentid='STUDENT1200' AND course='ZQCTEDA' ";
    db.runSQL(sql);
    sql  = " Select * From cr101 ";
    sql += " Where studentid='STUDENT1200' AND course='ZQCTEDA' ";
    queryResult = db.runSQL(sql,"table-auto");
    print(queryResult);

    //Challenge 3
    sql =  " Update cr101 ";
    sql += " set room = 213 ";
    sql += " Where teacher1='DOYLE' AND period in (4,5)  ";
    db.runSQL(sql);   
    sql  = " Select * From cr101 ";
    sql += " Where teacher1='DOYLE' AND period in (4,5)  ";
    queryResult = db.runSQL(sql,"table-auto");
    print(queryResult);

    //Challenge 4
    sql =  " Update cr101 ";
    sql += " set teacher1 = 'ARCHETTI' ";
    sql += " Where teacher1='ROFFLER' AND course='MQF44QGF' ";
    sql += " AND section=1 ";
    db.runSQL(sql);

    // Challenge 5:
    sql  = " Select * From cr101 ";
    sql += " Where studentid='STUDENT999' ";
    queryResult = db.runSQL(sql,"table-auto");
    print(queryResult);
    sql =  " Update cr101 ";
    sql += " set grade = '11', offclass = '3C8' ";
    sql += " Where studentid='STUDENT999' ";
    db.runSQL(sql);
    
    //Challenge 6
    sql =  " Insert Into cr101 ";
    sql += " (course, section, teacher1, period, room, studentid) ";
    sql += " values ('MKUFTC6', 1, 'CASTRO R', 9, 322, 'STUDENT1231')";
    db.runSQL(sql);

     
      }    
}