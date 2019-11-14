package library;

public interface SearchBy {
	Book searchByIsbn(String anIsbn);
	Book searchByTitle(String anTitle);
	User searchById(String anId);
}
