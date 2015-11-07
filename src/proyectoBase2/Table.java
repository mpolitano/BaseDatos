package proyectoBase2;

import java.util.ArrayList;

public class Table {
	String name;
	ArrayList<Column> columns;
	ArrayList<PrimaryKey> pk;
	ArrayList<UniqueKey> uk;
	ArrayList<ForeignKey> fk;

	public Table(String name,ArrayList<Column> columns,ArrayList<PrimaryKey> pk,
			ArrayList<UniqueKey> uk,ArrayList<ForeignKey> fk){
			
		this.name=name;
		this.columns=columns;
		this.pk	=pk;
		this.uk=uk;
		this.fk=fk;
	}
}
