package day2;

public class Main {
	public static void main(String[] args) {
		Library myLibrary = new Library();
		
		// Creating the library
		myLibrary.addBook(new Book("The Dune Part One","Frank Herbert")); //1
		myLibrary.addBook(new Book("The Hunger Games","Suzanne Collins")); //2
		myLibrary.addBook(new Book("Project Hail Mary","Andy Weir")); //3
		
		System.out.println("=== Library Status: Before Operations ===");
		myLibrary.showAllBooks();
		
		myLibrary.borrowBook("The Dune Part One");
		myLibrary.borrowBook("The Dune Part One"); //this is just the test to see if the logic works
		
		myLibrary.returnBook("The Dune Part One");
		System.out.println("\n===Library Status: After Operations ===");
		myLibrary.showAllBooks(); // checks all results
	}
}
