package day2;


//- hides the data it keeps the title, author and status private (encapsulation)
//- It sets it up the constructor takes a title and author whenever a new book is made and auto sets to avail.
//- It controls the actions uses safe functions to handle borrowing and returning
public class Book {
	// This is where the encapsulation fields are (Private) 
	
	private String title;
	private String author;
	private Boolean available;
	// Blueprint for creating the book object library 
	// Below is the constructor set for the title and author
	public Book(String title, String author) {
		
		this.title = title;
		this.author = author;
		this.available = true;
	}
	public String getTitle() {
		return title;
	}
	
	// This is where borrowing of book is
	public void borrowBook() {
		if (this.available) {
			this.available = false;
			System.out.println("\""+ title + "\" has been successfully borrowed");
		} else {
			System.out.println("Book has been already Borrowed");
		}
	}
	// This 
	public void returnBook() {
		this.available = true;
		System.out.println("\""+ title + "\" has been successfully returned");
	}
	
	public void getInfo() {
		String status = available ? "Available" : "Borrowed";
		System.out.println("Title: " + title + " | Author: " + author + "| Status:" + status);
	}
	
}
