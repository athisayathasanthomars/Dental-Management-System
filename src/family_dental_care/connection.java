package family_dental_care;
import java.sql.*;
public class connection {
    public Connection connection ;
   
     public Connection connectDB () {
         
            try {
                    connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/family_dental_care", "root", "");//Establishing connection
                    
                    if(connection!=null)
                        System.out.println("Connected With the database successfully"); //Message after successful connection
                    else
                        System.out.println("DB is not connected");
            } catch (SQLException e) {

                    System.out.println("Error while connecting to the database"); //Message if something goes wrong while conneting to the database

            }
            return connection;
            }
     public static void main(String arg[]) {
         connection jm=new connection();         
         jm.connectDB();
     }
}
