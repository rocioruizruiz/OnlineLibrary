package library;

public interface SearchBy { //Busqueda de Biblioteca.
	Book searchByIsbn(String anIsbn);
	Book searchByTitle(String anTitle);
	User searchById(String anId);
}
