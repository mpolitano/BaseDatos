package proyectoBase2;

public class Column {
	String name;
	String type;
	//agregar tamaño
	
	//String role;
	//String reference;
	
	public Column(String name, String type ){
		this.name= name;
		this.type=type;
		//this.role = role;
		//this.reference = reference;
	}


	public String toString(){
		return "Columna: "+ name +" de tipo: "+ type;
	}
}
