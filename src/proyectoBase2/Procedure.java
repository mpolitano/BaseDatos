/*Proyecto Base de datos 2. Año 2015. UNRC
 * Autores: Cesar Cornejo, Mariano Politano, Fernando Raverta*/

package proyectoBase2;

import java.util.LinkedList;

public class Procedure {
	String name;
	LinkedList<Parameter> parameter;

	
	public Procedure(String name, LinkedList<Parameter> parameter ){
		this.name= name;
		this.parameter=parameter;
	}

	public String getName(){
		return this.name;
	}
	
	public LinkedList<Parameter> getParameters(){
		return this.parameter;
	}

	public String toString(){
		return "Procedure: "+ name +" con parametros: "+ parameter;
	}
	
	@Override
    public boolean equals(Object proc) {
		Procedure pro=(Procedure)proc;
    	return this.name.equals(pro.name) && this.parameter.equals(pro.parameter);
    }
    
}
