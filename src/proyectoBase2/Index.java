/*Proyecto Base de datos 2. Año 2015. UNRC
 * Autores: Cesar Cornejo, Mariano Politano, Fernando Raverta*/

package proyectoBase2;

public class Index {
	String name;
	String column;
	Boolean unique;
	String table;

	
	public Index(String name, String column,Boolean unique, String table){
		this.name= name;
		this.column=column;
		this.unique=unique;
		this.table=table;
	}
	
	@Override
    public boolean equals(Object ind) {
		Index index=(Index)ind;
    	return this.name.equals(index.name) && this.column.equals(index.column)
    			&& this.unique.equals(index.unique)&& this.table.equals(index.table);
    }
	
	public String toString(){
		return "Indice: "+ name +" en la tabla : "+ table + " y sobre la columna : "+ column;
	}
}
