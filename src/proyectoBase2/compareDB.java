/*Proyecto Base de datos 2. Año 2015. UNRC
 * Autores: Cesar Cornejo, Mariano Politano, Fernando Raverta*/
package proyectoBase2;

import java.sql.*; 
import java.util.LinkedList;
import java.util.logging.*;

public class compareDB {

       

    public void compareTable(DataBase database1, DataBase database2){
    if (database1.equalsForTable(database2))
    	 /*Comparo todo a nivel de tabla, si son iguales en columnas, clave primaria, forraneas,
    	 nombre de la tabla y trigger definido sobre esta.
    	*/
    	System.out.println("Las bases de datos son iguales a nivel de tabla");
	else{
		//Hay diferencia en algun dato
		System.out.println("Las bases tienen diferencias a nivel de tabla: ");
		LinkedList<Table> tbl1=database1.getTables();
		LinkedList<Table> tbl2=database2.getTables();
		for (Table table1: tbl1) 
			for (Table table2 : tbl2)
				if(table1.equals(table2))
					System.out.println("Tabla compartida:  --- "+ table1.toString());  
		System.out.println("\n");
		//Chequeo de que tabla esta en una y no en la otra base de dato.
		LinkedList<Table> aux=new LinkedList<Table>(tbl1);	 	
		tbl1.removeAll(tbl2);
		tbl2.removeAll(aux);
		System.out.println("La base de dato: "+ DBConection.dataBase1 +", tiene la siguiente tablas extras: ");
		System.out.println(tbl1.toString());
		System.out.println("La base de dato:  "+ DBConection.dataBase2 +", tiene la siguiente tablas extras: ");
		System.out.println(tbl2.toString());
		//Chequeo de tablas con el mismo nombre pero diferentes columnas. Ya acote a las que no son iguales
		System.out.println("\n");
		for (Table table1: tbl1) {
            for (Table table2 : tbl2){
            	compareColumn( table1, table2);//comparo las columnas de las tablas
            	comparePrimaryKey(table1,table2);//comparo las claves primarias de las tablas
            	compareForeignKey(table1,table2);//comparo las claves forraneas de las tablas
            	compareIndex(table1,table2);//comparo los indeces de las tablas
            	compareTrigger(table1,table2);//comparo los trigger de las tablas
            	}         		
            }       
		}
    }
    
    public void compareColumn(Table table1, Table table2){
    	if (table1.getName().equals(table2.getName()))
    		//Comparo si tienen el mismo nombre para ver que datos diferentes tienen, sino me saldria q son distintas antes.
    		if(!table1.getColumns().equals(table2.getColumns())){
    			LinkedList<Column> auxColumn=new LinkedList<Column>(table1.getColumns());	 	
    			table1.getColumns().removeAll(table2.getColumns());
    			if(!table1.getColumns().isEmpty())
    				//Muestro todas las diferencias de las columnas.
    				System.out.println("La base de dato:  "+ DBConection.dataBase1 +", "
    					+ "tiene en la " + table1 + " las columnas : " + table1.getColumns() +
    					" que no estan en la tabla del mismo nombre en la BD: "+ DBConection.dataBase2+"\n");
    			table2.getColumns().removeAll(auxColumn);
    			if(!table2.getColumns().isEmpty())
    				System.out.println("La base de dato:  "+ DBConection.dataBase2 +", "
    					+ "tiene en la " + table2 + " las columnas : " + table2.getColumns() +
    					" que no estan en la tabla del mismo nombre en la BD: "+ DBConection.dataBase1 +"\n");
    		}
    }
    public void comparePrimaryKey(Table table1, Table table2){
    	if (table1.getName().equals(table2.getName()))
    		if(!table1.getPrimaryKey().equals(table2.getPrimaryKey())){
    				System.out.println("Tienen diferencia en la clave primaria de la  " + table1 
    					+"\n La claves primarias de"+ DBConection.dataBase1 + " son: "+ table1.getPrimaryKey()
    					+"\n La claves primarias de"+ DBConection.dataBase2 + " son: "+ table2.getPrimaryKey());
    		}
    } 
    
    public void compareForeignKey(Table table1, Table table2){
    	if (table1.getName().equals(table2.getName()))
    		if(!table1.getForeign().equals(table2.getForeign())){
    				System.out.println("Tienen diferencia en la clave forraneas de la  " + table1 
    					+"\n La claves forraneas de"+ DBConection.dataBase1 + " son: "+ table1.getForeign()
    					+"\n La claves forraneas de"+ DBConection.dataBase2 + " son: "+ table2.getForeign()); 				
    		}
    } 
    
    public void compareIndex(Table table1, Table table2){
    	if (table1.getName().equals(table2.getName()))
    		if(!table1.getIndex().equals(table2.getIndex())){
    				System.out.println("Tienen diferencia en el indece de la  " + table1 
    					+"\n El indice de "+ DBConection.dataBase1 + " son: "+ table1.getIndex()
    					+"\n El indice de "+ DBConection.dataBase2 + " son: "+ table2.getIndex());
    		}
    } 

    public void compareTrigger(Table table1, Table table2){
    	if (table1.getName().equals(table2.getName()))
    		if(!table1.getTriggers().equals(table2.getTriggers())){
    			LinkedList<Trigger> auxColumn=new LinkedList<Trigger>(table1.getTriggers());	 	
    			table1.getTriggers().removeAll(table2.getColumns());
    			if(!table1.getColumns().isEmpty())
    				System.out.println("La base de dato:  "+ DBConection.dataBase1 +", "
    					+ "tiene en la " + table1 + " el trigger : " + table1.getTriggers() +
    					" que no estan en la tabla del mismo nombre en la BD: "+ DBConection.dataBase2+"\n");
    			table2.getTriggers().removeAll(auxColumn);
    			if(!table2.getColumns().isEmpty())
    				System.out.println("La base de dato:  "+ DBConection.dataBase2 +", "
    					+ "tiene en la " + table2 + " el trigger : " + table2.getColumns() +
    					" que no estan en la tabla del mismo nombre en la BD: "+ DBConection.dataBase1 +"\n");
    		}
    }
    
    public void compareProcedure(DataBase database1, DataBase database2){
        if (database1.equalsForProcedure(database2))
        	 /*Comparo todo a nivel de procedimeinto, si son iguales en nombre y parametros
        	*/
        	System.out.println("Las bases de datos son iguales a nivel de procedimiento");
    	else{
    		//Hay diferencia en algun dato    		System.out.println(proc2.toString());

    		System.out.println("Las bases tienen diferencias a nivel de procedimiento: ");
    		LinkedList<Procedure> proc1=database1.getProcedure();
    		LinkedList<Procedure> proc2=database2.getProcedure();
	    		for (Procedure procedure1: proc1) 
	    			for (Procedure procedure2 : proc2)
	    				if(procedure1.equals(procedure2))
	    					System.out.println("Procedimientos compartidos:  --- "+ procedure1.toString());  
	    		System.out.println("\n");
    		//Chequeo de que procedimiento esta en una y no en la otra base de dato.
    		LinkedList<Procedure> aux=new LinkedList<Procedure>(proc1);	 	
    		proc1.removeAll(proc2);
    		proc2.removeAll(aux);
    		if (proc1.isEmpty())
    			System.out.println("No tiene procedimientos la base de datos: "+ DBConection.dataBase1 );
    		else{
    			System.out.println("La base de dato: "+ DBConection.dataBase1 +", tiene los siguientes procedimientos extras: ");
    			System.out.println(proc1.toString());}
    		if (proc2.isEmpty())
    			System.out.println("No tiene procedimientos la base de datos: "+ DBConection.dataBase2 );
    		else{
    			System.out.println("La base de dato: "+ DBConection.dataBase2 +", tiene los siguientes procedimientos extras: ");
        		System.out.println(proc2.toString());}
    		//Chequeo de procedimientos con el mismo nombre pero diferentes perfiles
    		System.out.println("\n");
    		for (Procedure procedure1: proc1) {
                for (Procedure procedure2 : proc2){
                	compareProfiles( procedure1, procedure2);
                	}         		
                }       
    		}
        }
    
    public static void compareProfiles(Procedure procedure1, Procedure procedure2){
    	if (procedure1.getName().equals(procedure2.getName()))
    		if(!procedure1.getParameters().equals(procedure2.getParameters())){
    				System.out.println("Tienen diferencia en los perfiles del procedimiento de la  " + procedure1 
    					+"\n El perfil del procedimiento: "+ procedure1.getName()+ "en la BD: "+ DBConection.dataBase1 + " son: "+ procedure1.getParameters()
    					+"\n El perfil del procedimiento: "+ procedure2.getName()+ "en la BD: "+ DBConection.dataBase2 + " son: "+ procedure2.getParameters());	
    		}
    }     

}



