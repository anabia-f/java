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
     
		  Database   db =  new  Database("jdbc:sqlite:chinook.db" );	

      //What do we get we join to tables like artists and albums?
      // GET ONLY first 5 records
      sql  = " Select * From artists ";
      sql += " Inner Join albums  On artists.artistid = albums.artistid ";
      result = db.runSQL(sql,"table-auto");
      //print(result);
    
      //How do you find all the invoices id for customer Astrid Gruber?
      sql  = " Select invoices.invoiceid From customers ";
      sql += " Inner Join invoices On customers.customerid = invoices.customerid ";
      sql += " Where customers.firstname='Astrid' and Lastname='Gruber' ";
      result = db.runSQL(sql,"table-auto");
      //print(result);
    
      //How do you find the albums names for the artist Audioslave?
      sql  = " Select albums.title From albums ";
      sql += " Inner Join artists On artists.artistid = albums.artistid ";
      sql += " Where artists.name='Audioslave' ";
      result = db.runSQL(sql,"table-auto");
      //print(result);

    
      //How do you find the artist's names from the playlist Brazilian Music?
    //There are duplicates we should use select distinct
      sql  = " Select Distinct artists.name From artists ";
      sql += " Inner Join albums On artists.artistid = albums.artistid ";
      sql += " Inner Join tracks On albums.albumid = tracks.albumid ";
      sql += " Inner Join playlist_track On tracks.trackid = playlist_track.trackid ";
      sql += " Inner Join playlists On playlists.playlistid = playlist_track.playlistid ";
      sql += " Where playlists.name='Brazilian Music' ";
      result = db.runSQL(sql,"table-auto");
      print(result);

      //Alternate sql syntax
      sql  = " Select Distinct artists.name  ";
      sql += " From artists,albums,tracks,playlists,playlist_track ";
      sql += " Where artists.artistid = albums.artistid ";
      sql += " And albums.albumid = tracks.albumid ";
      sql += " And tracks.trackid = playlist_track.trackid ";
      sql += " And playlists.playlistid = playlist_track.playlistid ";
      sql += " And playlists.name='Brazilian Music' ";
      result = db.runSQL(sql,"table-auto");
      print(result);
      
  }    
}