import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
 
public class HiveJdbcClient {
  private static String driverName = "org.apache.hive.jdbc.HiveDriver";
 
  public static void main(String[] args) throws SQLException {
    try {
      Class.forName(driverName);
    } catch (ClassNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      System.exit(1);
    }
    Connection con = DriverManager.getConnection("jdbc:hive2://localhost:10000", "sparksql", "");
    Statement stmt = con.createStatement();
    ResultSet res = stmt.executeQuery("select key, value from src limit 5");
    while (res.next()) {
      System.out.print("result:");
      System.out.println(String.valueOf(res.getInt(1)) + "\t" + res.getString(2));
    }
  }
}
