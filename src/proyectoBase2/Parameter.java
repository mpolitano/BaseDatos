/*Proyecto Base de datos 2. Año 2015. UNRC
 * Autores: Cesar Cornejo, Mariano Politano, Fernando Raverta*/

package proyectoBase2;

public class Parameter {
	String type;
	String format;	
	
	public Parameter(String type, String format){
		this.type= type;
		this.format=format;

	}
	
	public String toString(){
		String cad="";
		//casteo porque asi me lo devuelve la metadata, para mejor entendimiento.
		if (type.equals("2"))
			cad+= "parametro IN de tipo: ";
		if (type.equals("3"))
			cad+= "parametro INOUT de tipo ";
		if (type.equals("4"))	
			cad+= "parametro OUT de tipo: ";
		if (type.equals("5"))	
			cad+= "parametro de Retorno de tipo: ";	
			
			return cad+ format;
	}
	
	@Override
    public boolean equals(Object param) {
		Parameter parameters=(Parameter)param;
    	return this.type.equals(parameters.type) && this.format.equals(parameters.format);
    }
    
}
