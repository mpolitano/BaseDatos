/*Proyecto Base de datos 2. Año 2015. UNRC
 * Autores: Cesar Cornejo, Mariano Politano, Fernando Raverta*/

package proyectoBase2;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class DBConection {
	 static Connection connection;
	 static String driver = "org.postgresql.Driver";
	 static  String host= "localhost";
	 static  String url = "jdbc:postgresql://"+host+":5432/";
	 static String user = "postgres";
	 static String pass = "root";
	 static String dataBase1="proyecto1";
	 static String dataBase2="proyecto2";
}
