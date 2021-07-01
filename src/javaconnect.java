import java.sql.*;
import javax.swing.JOptionPane;

public class javaconnect
{
    Connection conn;
    public static Connection ConnecrDb() throws InstantiationException, IllegalAccessException
    {
        try{
            Class.forName("org.sqlite.JDBC").newInstance();
            Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Admin.DESKTOP-JG53C3I\\Documents\\NetBeansProjects\\Student Library Management\\Student.db");
            return conn;
        }
            catch(ClassNotFoundException | SQLException e)
                    {
                        JOptionPane.showMessageDialog(null, e);
                        return null;
                    }
        
    }
}