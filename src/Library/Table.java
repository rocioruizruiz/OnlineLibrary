package library;
import java.util.*;

public class Table<T> {
	
	private List<List<T>> tabla;
	private List<T> nUses;
	private List<T> isbns;
	private List<Objects> bokesitos;
	
	public Table() {
		this.tabla = new ArrayList<List<T>>();
		this.nUses = new ArrayList<T>();
		this.isbns = new ArrayList<T>();
		this.bokesitos = new ArrayList<Objects>();
		
		
	}
	
	public void create_table(List<Book> books) {
		
		
		String p ="";
		int q = 0;
		;
		for (int i=0; i<books.size(); i++) {
			Book b = new Book();
			b = books.get(i);
			p = "" + books.get(i).getUses() + "";
			q = Integer.parseInt(p);
			this.nUses.add((T) p);
			this.isbns.add((T) b.getIsbn());
			Objects o = new Objects(b, q);
			bokesitos.add(o);
			
			
		}
		
		this.tabla.add(this.nUses);
		this.tabla.add(this.isbns);
		
		System.out.println(tabla.toString());
	}
	
	public void cuantityOrder() {
		bokesitos.sort(Comparator.comparing(Objects::getUses));
		Collections.reverse(bokesitos);
		for(Objects b : bokesitos) {
			System.out.println(b.getUses());
		}
	}
}
		
