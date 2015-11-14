/*Proyecto Base de datos 2. Año 2015. UNRC
 * Autores: Cesar Cornejo, Mariano Politano, Fernando Raverta*/
package proyectoBase2;

import java.util.LinkedList;

public class Table {
	String name;
	LinkedList<Column> columns;
	LinkedList<PrimaryKey> pk;
	LinkedList<Index> index;
	LinkedList<ForeignKey> fk;
	LinkedList<Trigger> trig;

	public Table(String name,LinkedList<Column> columns,LinkedList<PrimaryKey> pk,
			LinkedList<Index> index,LinkedList<ForeignKey> fk, LinkedList<Trigger> trig){
			
		this.name=name;
		this.columns=columns;
		this.pk	=pk;
		this.index=index;
		this.fk=fk;
		this.trig=trig;
	}
	
	public String getName(){
		return this.name;
	}
	
	public LinkedList<Column> getColumns(){
		return this.columns;
	}
	
	public LinkedList<PrimaryKey> getPrimaryKey(){
		return this.pk;
	}
	
	public 	LinkedList<ForeignKey>  getForeign(){
		return this.fk;
	}
	public 	LinkedList<Index>  getIndex(){
		return this.index;
	}
	public 	LinkedList<Trigger>  getTriggers(){
		return this.trig;
	}
	@Override
    public boolean equals(Object tbl) {
    	Table tbl1= (Table) tbl;
    	return this.name.equals(tbl1.name) && this.pk.equals(tbl1.pk) && this.columns.equals(tbl1.columns)
    			&& this.index.equals(tbl1.index) && this.fk.equals(tbl1.fk) && this.trig.equals(tbl1.trig);
}
	public String toString(){
		return "Tabla: "+ name;
	}
	
	

}
