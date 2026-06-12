import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.sql.*;

import java.net.InetSocketAddress;
import java.util.Map;

//For compiling on the shell on repl: Same on mac
//javac -cp sqlite-jdbc-3.23.1.jar: Main.java
//java -cp sqlite-jdbc-3.23.1.jar: Main

//Use for windows
//javac -cp sqlite-jdbc-3.23.1.jar; Main.java
class Main {

 public static void main(String[] args)throws IOException{
    (new Main()).init();
  }


  void print(Object o){ System.out.println(o);}
  void printt(Object o){ System.out.print(o);}

  void init() throws IOException{
   

    // create a port - our Gateway
    int port = 8500;
      
    //create the HTTPserver object
    HttpServer server = HttpServer.create(new InetSocketAddress(port),0);

    // create the database object
    Database db = new Database("jdbc:sqlite:chinook.db");
    // Add your  code here
    server.createContext("/", new RouteHandler("You are connected, but route not given or incorrect....") );

    sql  = " Select customers.customerId, customers.firstname, customers.lastname, customers.phone from Customers ";
    server.createContext("/customers", new RouteHandler(db,sql) ) ;

    sql  = " Select * from employees ";
    sql += " LIMIT 15 ";
    server.createContext("/employees", new RouteHandler(db,sql) ) ;

    sql  = " Select * From tracks ";
    sql += " Inner Join albums ON albums.albumid=tracks.albumid ";
    sql += " Inner Join artists ON albums.artistid=artists.artistid ";
    sql += " LIMIT 15 ";
    server.createContext("/albumsinfo", new RouteHandler(db,sql) );

    sql  = " Select customers.firstname, customers.lastname, tracks.name, invoices.invoicedate From tracks ";
    sql += " Inner Join invoice_items ON invoice_items.trackid=tracks.trackid ";
    sql += " Inner Join invoices ON invoices.invoiceid=invoice_items.invoiceid ";
    sql += " Inner Join customers ON invoices.customerid=customers.customerid ";
    sql += " LIMIT 15 ";
    server.createContext("/customersongs", new RouteHandler(db,sql) );

    //Start the server
    server.start();
    System.out.println("Server is listening on port "+port);
       
      
    }    
}