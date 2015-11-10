package proyectoBase2;

import java.sql.*; 
import java.util.ArrayList;
import java.util.logging.*;

public class compareBD {
    
    public static void main(String args[]) throws ClassNotFoundException, SQLException{
    	Class.forName(DB.driver);
    	Connection  conection = DriverManager.getConnection(DB.url,DB.user, DB.pass); //Conecto a la base de datos.
    	String[] tipo = {"TABLE"};
        DatabaseMetaData metaData = conection.getMetaData();
        ResultSet tablesBD2 = metaData.getTables(null,DB.dataBase, "%",tipo);// Obtengo las tablas de la base de dato
        System.out.println(" tablas de la base de datos ");
        while(tablesBD2.next()) {
        	String nameTable= tablesBD2.getString(3); //Nombre de la tabla
        	ArrayList<Column> column= getColumnDB(nameTable, metaData); // Columnas de la tabla
        	ArrayList<PrimaryKey> pk= getPrimaryKey (nameTable, metaData); // Claves primarias
        	ArrayList<ForeignKey> fk= getForeignKey (nameTable,metaData);
        	//indices
        	//checks el texto plano
        	//trigger parte de la tabla(esta asociado)
        	//perfiles de las acciones
        	System.out.println(nameTable);
        	System.out.println(column.toString());
        	System.out.println(pk.toString());
        }
    }

    public static ArrayList<Column> getColumnDB (String table, DatabaseMetaData metaData) throws SQLException{
    	ArrayList<Column> columnsList=new ArrayList<Column>();
    	ResultSet column= metaData.getColumns(null, DB.dataBase, table, null);
        while(column.next()) {
        	String nameTable= column.getString(4);
        	String type= column.getString(6);
        	
        	columnsList.add(new Column(nameTable, type));
    }
    	return columnsList;
}
    
    public static ArrayList<PrimaryKey> getPrimaryKey (String table, DatabaseMetaData metaData) throws SQLException{
    	ArrayList<PrimaryKey> pk=new ArrayList<PrimaryKey>();
    	ResultSet column= metaData.getPrimaryKeys(null, DB.dataBase, table);
        while(column.next()) {
        	String primaryKey= column.getString(4);
        	pk.add(new PrimaryKey(primaryKey, table));
        }
    	return pk;
    }
    
    public static ArrayList<ForeignKey> getForeignKey(String table, DatabaseMetaData metaData) throws SQLException{
    	ArrayList<ForeignKey> fk = new ArrayList<ForeignKey>();
    	ResultSet column = metaData.getExportedKeys(null, DB.dataBase, table);
    	while (column.next()){
    		String foreignKey = column.getString(4);
    		fk.add(new ForeignKey(foreignKey, table));
    	}
    	return fk;
    }
    
}



