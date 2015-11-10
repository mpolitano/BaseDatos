package proyectoBase2;

public class ForeignKey {
	String foreignKey;
	String table;
	
	public ForeignKey(String fk, String tbl){
		this.foreignKey = fk;
		this.table = tbl;
	}
	
	public String toString(){
		return "Clave Foranea: "+ foreignKey +" de la table: "+ table;
	}
}
