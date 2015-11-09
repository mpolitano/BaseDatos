package proyectoBase2;

public class PrimaryKey {
	String primaryKey;
	String table;
	
	public PrimaryKey(String primaryKey, String table){
		this.primaryKey= primaryKey;
		this.table=table;
	}


	public String toString(){
		return "Clave Primaria: "+ primaryKey +" de la table: "+ table;
	}
}
