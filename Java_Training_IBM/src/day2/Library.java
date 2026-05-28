package day2;
import java.util.ArrayList;

public class Library {
	
	
	private ArrayList<Book> books; // Creates the Bookshelf basically, grows auto when added new book.
	
	public Library() {
		this.books = new ArrayList<>();
	}
	
	public void addBook(Book b) {
		books.add(b);
	}
	
	public void showAllBooks() { //This one scans the inventory uses the loop to get info from every book
		if(books.isEmpty()) {
			System.out.println("The Library is currently empty.");
			return;
		}
		for (Book b : books) {
			b.getInfo();
		}
	}
	public void borrowBook(String title) {
		System.out.println("---Attempting to borrow: \"" + title + "\" ---");
		for (Book b : books) {
			if (b.getTitle().equalsIgnoreCase(title)) { // It searches by the title basically when you want to borrow or return a book, it loops through the list to find a match.
				b.borrowBook(); // ^^ it also uses .equalsIgnoreCase so it does not matter at all with uppercase or lowercase
				return;
			}
		}
		System.out.println("Error: \"" + title + "\" was not found in the library");
	}
	public void returnBook(String title) {
		System.out.println("---Attempting to return: \"" + title + "\" ---");
		for (Book b : books) {
			if (b.getTitle().equalsIgnoreCase(title)) { //Essentially the same code as borrowbook except with different function
				b.returnBook();
				return;
			}
		} System.out.println("Error: \"" + title + "\" does not belong to this library");
	} 
}
