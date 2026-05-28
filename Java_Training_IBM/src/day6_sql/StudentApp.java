package day6_sql;

import java.sql.*;
import java.util.Scanner;
import java.util.InputMismatchException;

public class StudentApp {
	public static void main(String[] args) throws Exception {
		String url = "jdbc:postgresql://localhost:5432/postgres";
		String user = "postgres";
		String password = "660709";
		
		Connection conn = DriverManager.getConnection(url, user, password);
		System.out.println("System has Connected to PostgreSQL successfully!");
		
		Scanner scanner = new Scanner(System.in);
		boolean running = true;
		
		while (running) {
			System.out.println("\n=== Menu ===");
			System.out.println("[A]dd");
			System.out.println("[V]iew");
			System.out.println("[U]pdate Password");
			System.out.println("[D]elete");
			System.out.println("[Q]uit");
			System.out.println("\nEnter choice: ");
			
			String choice = scanner.nextLine().trim().toUpperCase();
			
			try {
				// ADD OPTION HERE
				if (choice.equals("A")) {
					System.out.print("Enter Student ID: ");
					int id = scanner.nextInt();
					scanner.nextLine();
					System.out.println("Enter Email: ");
					String email = scanner.nextLine();
					System.out.print("Enter Password: ");
					String pass = scanner.nextLine();
					System.out.println("Enter First Name: ");
					String fname = scanner.nextLine();
					System.out.println("Enter Last Name: ");
					String lname = scanner.nextLine();
					
					String sql = "INSERT INTO student (studentid, email, password, firstname, lastname, dateadded) VALUES(?, ?, ?, ?, ?, CURRENT_TIMESTAMP)";
					PreparedStatement stmt = conn.prepareStatement(sql);
					stmt.setInt(1,  id);
					stmt.setString(2, email);
					stmt.setString(3, pass);
					stmt.setString(4, fname);
					stmt.setString(5, lname);
					
					stmt.executeUpdate();
					System.out.println("Student Added Successfully");
				
				}
				//VIEW OPTION HERE
				else if(choice.equals("V")) {
					String sql = "SELECT * FROM student";
					Statement stmt = conn.createStatement();
					ResultSet rs = stmt.executeQuery(sql);
					
					System.out.println("\n--- Student List ---");
					while(rs.next()) {
						System.out.println("ID: " + rs.getInt("Studentid") +
							"| Name: " + rs.getString("firstname") + " " + rs.getString("lastname") +
							"| Email: " + rs.getString("email") +
							"| Added: " + rs.getTimestamp("dateadded"));
					}
				}
				// UPDATE PASSWORD OPTION HERE
				else if (choice.equals("U")) {
				    System.out.print("Enter Student ID to update: ");
				    int id = scanner.nextInt();
				    scanner.nextLine(); 
				    
				    System.out.println("Enter new Password: ");
				    String newPass = scanner.nextLine();
				    
				    String sql = "UPDATE student SET password = ?, dateupdated = CURRENT_TIMESTAMP WHERE studentid = ?";
				    PreparedStatement stmt = conn.prepareStatement(sql);
				    stmt.setString(1,  newPass);
				    stmt.setInt(2, id);
				    
				    int updatedRows = stmt.executeUpdate();
				    if (updatedRows > 0) {
				        System.out.println("Password updated Successfully!");
				    } else {
				        System.out.println("Student ID not found.");
				    }
				}
				
				// DELETE OPTION HERE
				else if (choice.equals("D")) {
					System.out.print("Enter Student ID to delete: ");
					int id = scanner.nextInt();
					scanner.nextLine();
					
					String sql = "DELETE FROM student WHERE studentid = ?";
					PreparedStatement stmt = conn.prepareStatement(sql);
					stmt.setInt(1, id);
					
					int deletedRows = stmt.executeUpdate();
					if (deletedRows > 0) {
						System.out.println("Student Deleted Successfully!");
					} else {
						System.out.println("Student ID not found.");
					}
				}
				// QUIT Option HERE
				else if (choice.equals("Q")) {
					running = false;
					System.out.println("Goodbye!");
				}
				
				else {
					System.out.println("Invalid Choice! Try again.");
				}
				
			} 
			catch (InputMismatchException e) {
				System.out.println("\n[Error]: Invalid input type! ID must be a numeric integer.");
				scanner.nextLine(); 
			} 
			catch (SQLException e) {
				System.out.println("\n[Database Error]: " + e.getMessage());
			}
		}
		
		conn.close();
		scanner.close();
	}
}