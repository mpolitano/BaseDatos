package proyectoBase2;

public class Column {
	String name;
	String type;
	
	public Column(String name, String type){
		this.name= name;
		this.type=type;
	}


	public String toString(){
		return "Columna: "+ name +" de tipo: "+ type;
	}
}
