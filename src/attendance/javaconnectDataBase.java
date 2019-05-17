package attendance;

import java.sql.*;
public class javaconnectDataBase {
    Connection con;
   /* public static Connection ConnectDB(){
        try{
           Class.forName("org.sqlite.JDBC"); 

            Connection con=DriverManager.getConnection("jdbc.sqlite:Attendance.db");
                        System.out.println("Connection to SQLite has been established.");
            return con;
        }
        catch(Exception e){
            System.out.print(e.getMessage());
            JOptionPane.showMessageDialog(null,e);
            return null;
        }
    }*/
    public static Connection ConnectDB() {
        Connection conn = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:/Users/rewant/NetBeansProjects/OJ Project/Attendance/Attendance.db ";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            
            System.out.println("Connection to SQLite has been established.");
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
//        } finally {
//            try {
//                if (conn != null) {
//                    conn.close();
//                }
//            } catch (SQLException ex) {
//                System.out.println(ex.getMessage());
//            }
//        }
        return conn;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ConnectDB();
    }
}
