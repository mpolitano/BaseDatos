package proyectoBase2;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class DB {
	 static Connection connection;
	 static String driver = "org.postgresql.Driver";
	 static  String url = "jdbc:postgresql://localhost:5432/postgres";
	 static String user = "postgres";
	 static String pass = "root";
	 static String dataBase="proyecto2";
}
