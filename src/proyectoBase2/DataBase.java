/*Proyecto Base de datos 2. Año 2015. UNRC
 * Autores: Cesar Cornejo, Mariano Politano, Fernando Raverta*/
package proyectoBase2;

import java.util.LinkedList;

public class DataBase {
    private String name;
    private LinkedList<Table> table;
    private LinkedList<Procedure> proc;

    
	public DataBase(String name, LinkedList<Table>  table,  LinkedList<Procedure> proc){
		this.name= name;
		this.table=table;
		this.proc=proc;
	}
	
	public LinkedList<Table> getTables(){
		return this.table;
	}
	
	public LinkedList<Procedure> getProcedure(){
		return this.proc;
	}
	
	public String getName(){
		return this.name;
	}
	
	public LinkedList<Procedure> getProc(){
		return this.proc;
	}

    public boolean equalsForTable(DataBase DB) {
    	return  this.table.equals(DB.table);
}
    public boolean equalsForProcedure(DataBase DB) {
    	return  this.proc.equals(DB.proc);
}


}
