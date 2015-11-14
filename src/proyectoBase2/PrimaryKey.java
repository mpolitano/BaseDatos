/*Proyecto Base de datos 2. Año 2015. UNRC
 * Autores: Cesar Cornejo, Mariano Politano, Fernando Raverta*/

package proyectoBase2;

public class PrimaryKey {
	String primaryKey;
	String table;
	
	public PrimaryKey(String primaryKey, String table){
		this.primaryKey= primaryKey;
		this.table=table;
	}
	
	public String getPK(){
		return this.primaryKey;
	}


	public String toString(){
		return primaryKey ;
	}
	
	@Override
    public boolean equals(Object pk) {
		PrimaryKey pk1=(PrimaryKey)pk;
    	return this.primaryKey.equals(pk1.primaryKey) && this.table.equals(pk1.table);
    }
    
}
