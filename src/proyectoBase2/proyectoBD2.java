/*Proyecto Base de datos 2. Año 2015. UNRC
 * Autores: Cesar Cornejo, Mariano Politano, Fernando Raverta*/

package proyectoBase2;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;

public class proyectoBD2 {

	//Para ejecutar hay que agregar, host, user,pass,database1, dataBase2. Sino toma los defectos de la clase DBConection.
    public static void main(String args[]) throws ClassNotFoundException, SQLException{   	
    	if (args.length == 5) { 
        	DBConection.host=args[0];
        	DBConection.user=args[1];
        	DBConection.pass=args[2];
        	DBConection.dataBase1=args[3];
        	DBConection.dataBase2=args[4];
    	}else
             System.out.println("Faltan datos por ingresar. \n"
             		+ "Para empezar recuerde que debe ingresar localhost,usuario, pass, base de dato1 y base de datos 2.\n"
             		+ "El programa arrancara en el modo defecto.\n");
    	
    	Date datos = new Date();
    	DataBase database1=null;
    	DataBase database2=null;
    	Class.forName(DBConection.driver);
    	Connection  conection = DriverManager.getConnection(DBConection.url,DBConection.user, DBConection.pass); //Conecto a la base de datos.
    	database1= new DataBase(DBConection.dataBase1, datos.getTable(DBConection.dataBase1,conection), datos.getProcedure(DBConection.dataBase1,conection));
     	database2= new DataBase(DBConection.dataBase2, datos.getTable(DBConection.dataBase2,conection), datos.getProcedure(DBConection.dataBase2,conection));
     	compareDB comparador= new compareDB();
     	comparador.compareTable(database1,database2);
     	comparador.compareProcedure(database1,database2);
    }

}
