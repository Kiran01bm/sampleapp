import java.sql.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;


// Create a table and insert records..

public class SampleDataSeeder
{
  public static void main(String[] args)
  {
    try
    {
      String dbDriver = "com.mysql.cj.jdbc.Driver";
      String jdbcURL = System.getenv("DB_CONNECTION_STRING");
      Class.forName(dbDriver);
      Connection conn = DriverManager.getConnection(jdbcURL, System.getenv("DB_USERNAME") , System.getenv("DB_PASSWORD"));
      
      System.out.println(" ");
      System.out.println("Connecting to db -->"+ jdbcURL);

      Statement st = conn.createStatement();

      
      // Create table
      String createSearchTable = "CREATE TABLE articles (" 
    				+ "id INT(64) NOT NULL AUTO_INCREMENT,"  
    				+ "title VARCHAR(500) NOT NULL," 
    				+ "PRIMARY KEY (id))";  
      st.executeUpdate(createSearchTable);
      
      // Insert records
      String fileName = "/usr/src/apps/dataseeder/resources/searchContent.txt";

    	try (Scanner scanner = new Scanner(new File(fileName))) {
    		while (scanner.hasNext()){
    			st.executeUpdate("INSERT INTO articles (title) VALUES ('" + scanner.nextLine() + "')");
    		}
    	} catch (IOException e) {
    		e.printStackTrace();
    	}

      conn.close();
    }
    catch (Exception e)
    {
      System.err.println(e.getMessage());
      e.printStackTrace();
    }

  }
}
