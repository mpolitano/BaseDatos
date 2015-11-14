/*Proyecto Base de datos 2. Año 2015. UNRC
 * Autores: Cesar Cornejo, Mariano Politano, Fernando Raverta*/

package proyectoBase2;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class Date {
	
	//Obtengo las tablas de la base de datos, junto con todos los datos de la misma
	public LinkedList<Table> getTable (String schema, Connection  conection ) throws SQLException{
    	LinkedList<Table> tbl=new LinkedList<Table>();
    	String[] tipo = {"TABLE"};
        DatabaseMetaData metaData = conection.getMetaData();
        ResultSet tables = metaData.getTables(null,schema, "%",tipo);// Obtengo las tablas de la base de dato
        while(tables.next()) {
	        String nameTable= tables.getString(3); //Nombre de la tabla
	    	LinkedList<Column> column= getColumns(schema,nameTable, conection); // Columnas de la tabla
	    	LinkedList<PrimaryKey> pk= getPrimaryKey (schema,nameTable, conection); // Claves primarias
	    	LinkedList<ForeignKey> fk= getForeignKey (schema,nameTable,conection);//Claves Forraneas
	    	LinkedList<Index> index= getIndex (schema,nameTable,conection);// Indices
	    	LinkedList<Trigger> trigger= getTrigger (schema,nameTable,conection);// Trigger
	    	tbl.add(new Table(nameTable,column, pk, index, fk, trigger)); //Agrego la tabla.
        }
        return tbl;
    }

	//Obtengo todas las columnas de la tabla dada.
    public LinkedList<Column> getColumns (String schema, String table,Connection  conection ) throws SQLException{
    	LinkedList<Column> columnsList=new LinkedList<Column>();
        DatabaseMetaData metaData = conection.getMetaData();
    	ResultSet column= metaData.getColumns(null, schema, table, null);
        while(column.next()) {
        	String nameColumna= column.getString(4);
        	String type= column.getString(6);
        	String size= column.getString(7);
        	columnsList.add(new Column(nameColumna, type,size));
    }
        
    	return columnsList;
}
	//Obtengo todas las claves primarias de la tabla dada.
    public LinkedList<PrimaryKey> getPrimaryKey (String schema, String table , Connection  conection) throws SQLException{
    	LinkedList<PrimaryKey> pk=new LinkedList<PrimaryKey>();
        DatabaseMetaData metaData = conection.getMetaData();
    	ResultSet column= metaData.getPrimaryKeys(null, schema, table);
        while(column.next()) {
        	String primaryKey= column.getString(4);
        	pk.add(new PrimaryKey(primaryKey, table));
        }
    	return pk;
    }
    
	//Obtengo todas las claves forraneas de la tabla dada.
    public LinkedList<ForeignKey> getForeignKey(String schema,String table,Connection  conection) throws SQLException{
    	LinkedList<ForeignKey> fk = new LinkedList<ForeignKey>();
        DatabaseMetaData metaData = conection.getMetaData();
    	ResultSet column = metaData.getImportedKeys(null, schema, table);
    	while (column.next()){
    		String originalKey = column.getString("PKCOLUMN_NAME");
    		String originalTable = column.getString("PKTABLE_NAME");
    		String foreignKey = column.getString("FKTABLE_NAME");
    		String foreignTable = column.getString("FKCOLUMN_NAME");
    		fk.add(new ForeignKey(originalKey,originalTable,foreignKey, foreignTable));
    	}
    	return fk;
    }
    
	//Obtengo todas los indices de la tabla dada.
    public LinkedList<Index> getIndex(String schema,String table,Connection  conection) throws SQLException{
    	LinkedList<Index> ind = new LinkedList<Index>();
        DatabaseMetaData metaData = conection.getMetaData();
    	ResultSet index = metaData.getIndexInfo(null, schema, table, false, true);
	    while (index.next()) {
	    	String name = index.getString("INDEX_NAME");
    		String column = index.getString("COLUMN_NAME");
    		Boolean unique = index.getBoolean( "NON_UNIQUE");
    		ind.add(new Index(name,column,!unique,table));
    	}
    	return ind;
    }

	//Obtengo todas los triggers de la tabla dada.
    public LinkedList<Trigger> getTrigger(String schema,String table, Connection  conection) throws SQLException{
    	LinkedList<Trigger> triggers = new LinkedList<Trigger>();
        DatabaseMetaData metaData = conection.getMetaData();
        PreparedStatement statement = conection.prepareStatement("SELECT action_timing as action, trigger_name as name, event_manipulation as event FROM "
        		+ "information_schema.triggers WHERE event_object_table = '"+ table +"' ;");
        ResultSet rs = statement.executeQuery();
    	while (rs.next()){
    		String name = rs.getString("name");
    		String actionTrigger = rs.getString("action");
    		String event = rs.getString("event");
    		triggers.add(new Trigger(name,actionTrigger,event, table));
    	}
    	return triggers;
    }
    
	//Obtengo todas los procedimientos de la tabla dada.
    public LinkedList<Procedure> getProcedure(String schema, Connection  conection) throws SQLException{
    	LinkedList<Procedure> proc = new LinkedList<Procedure>();
        DatabaseMetaData metaData = conection.getMetaData();
    	ResultSet procedure = metaData.getProcedures(null, schema, "%");
    	ResultSet parameters;
    	while (procedure.next()){
    		String name = procedure.getString("PROCEDURE_NAME");
    		//String type = procedure.getString("PROCEDURE_TYPE");
    		 parameters = metaData.getProcedureColumns(null, schema, name, "%");
    		 LinkedList<Parameter> param =new LinkedList<Parameter>();
    		while (parameters.next()) {
    			String ColumnType=parameters.getString(5); //tipo de paramentros in, out, etc
    			String type=parameters.getString("TYPE_NAME"); //tipo de parameters varchar, int, float,etc
    			param.add(new Parameter(ColumnType, type));
    		}
    		proc.add(new Procedure(name,param));
    	}
    	return proc;
    }
}
