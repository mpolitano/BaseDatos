/*Proyecto Base de datos 2. Año 2015. UNRC
 * Autores: Cesar Cornejo, Mariano Politano, Fernando Raverta*/
package proyectoBase2;

public class ForeignKey {
	String key;
	String table;
	String foreignKey;
	String referenceTable;
	
	
	public ForeignKey(String key, String tbl, String foreignKey, String referenceTable){
		this.key= key;
		this.table = tbl;		
		this.foreignKey = foreignKey;
		this.referenceTable = referenceTable;
	}
	
	public String toString(){
		return "Clave Foranea: "+ foreignKey+ "Hace referencia al campo: "+ key+ " de la tabla " + table;
	}
	
	@Override
    public boolean equals(Object foreign) {
    	ForeignKey fk= (ForeignKey) foreign;
    	return this.key.equals(fk.key) && this.table.equals(fk.table) && this.foreignKey.equals(fk.foreignKey)
    			&& this.referenceTable.equals(fk.referenceTable);
    }
}
