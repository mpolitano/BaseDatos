/*Proyecto Base de datos 2. Año 2015. UNRC
 * Autores: Cesar Cornejo, Mariano Politano, Fernando Raverta*/

package proyectoBase2;

public class Trigger {
	String name;
	String action;
	String event;
	String table;	
	
	public Trigger(String name, String action, String event, String table){
		this.name= name;
		this.action=action;
		this.event=event;
		this.table=table;
	}

    public boolean equals(Trigger tri) {
    	return this.name.equals(tri.name) && this.action.equals(tri.action) && this.event.equals(tri.event)
    			&& this.table.equals(tri.table);
}
	public String toString(){
		return "Trigger: "+ name +" con el evento: "+ event + "y la acccion: "+ action+ " de la tabla: "+ table;
	}
	
	
}
