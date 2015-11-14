/*Proyecto Base de datos 2. Año 2015. UNRC
 * Autores: Cesar Cornejo, Mariano Politano, Fernando Raverta*/
package proyectoBase2;

public class Column {
	String name;
	String type;
	String size;
	
	public Column(String name, String type, String size){
		this.name= name;
		this.type=type;
		this.size=size;
	}


	public String toString(){
		return "Columna: "+ name +" de tipo: "+ type ;
	}
	
	@Override
    public boolean equals(Object column) {
		Column col=(Column) column;
    	return this.name.equals(col.name) && this.type.equals(col.type) && this.size.equals(col.size);
    }
}
