package SayalElectronics;
import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.Statement;

public class connection  {

    Connection c;
    Statement s;

    connection() throws Exception{
        Class.forName("org.sqlite.JDBC");
        c = DriverManager.getConnection("jdbc:sqlite:C://sqlite//electronics.db");
        s = c.createStatement();




    }
}
