package proyectoBase2;

import java.sql.*; 
import java.util.ArrayList;
import java.util.logging.*;

public class compareBD {
    
    public static void main(String args[]) throws ClassNotFoundException, SQLException{
    	Class.forName(DB.driver);
    	Connection  conection = DriverManager.getConnection(DB.url,DB.user, DB.pass);
    	String[] tipo = {"TABLE"};
        DatabaseMetaData metaData = conection.getMetaData();
        ResultSet tablesBD2 = metaData.getTables(null,DB.dataBase, "%",tipo);
        System.out.println(" tablas de la base de datos ");
        while(tablesBD2.next()) {
        	String nameTable= tablesBD2.getString(3);
        	ArrayList<Column> column= getColumnDB(nameTable, metaData);
        	System.out.println(nameTable);
        	System.out.println(column.toString());

        }
        
    }

    public static ArrayList<Column> getColumnDB (String table, DatabaseMetaData metaData) throws SQLException{
    	ArrayList<Column> columnsList=new ArrayList<Column>();
    	ResultSet column= metaData.getColumns("public", "proyecto1", table, null);
        while(column.next()) {
        	String nameTable= column.getString(4);
        	String type= column.getString(6);
        	columnsList.add(new Column(nameTable, type));
    }
    	return columnsList;
}
}



