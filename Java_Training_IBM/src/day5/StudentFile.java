package day5;

/* Student Name: Aditya Dash
 * Student ID: 12233203
 * Course: Computer Science
 * Activity: File I/O Basics (Combining file io and exception handling)
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StudentFile {
	public static void main(String[] args) {
		String csvFile = "src/day5/student.csv/";
		String jsonFile = "src/day5/student.json/";
		
		List<String[]> studentRecords = new ArrayList<>();
		String line;
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(csvFile));
			BufferedWriter bw = new BufferedWriter(new FileWriter(jsonFile));
			
			br.readLine();
			
			while((line = br.readLine()) != null) {
				String[] data = line.split(",");
				if(data.length == 3) {
					data[0] = data[0].replace("\"","").trim();
					data[1] = data[1].replace("\"","").trim();
					data[2] = data[2].replace("\"","").trim();
					studentRecords.add(data);
				}
			}
			br.close();
			
			bw.write("[\n");
			for (int i = 0; i < studentRecords.size(); i++) {
				String[] student = studentRecords.get(i);
				bw.write("  {\n");
				bw.write("   \"id\": \"" + student[0] + "\",\n");
				bw.write("   \"name\": \"" + student[1] + "\",\n");
				bw.write("   \"course\": \"" + student[2] + "\"\n");
				
				if (i < studentRecords.size() - 1) {
					bw.write("  },\n");
				} else {
					bw.write("  }\n");
				}
			}
			
			bw.write("]");
			bw.close();
			
			System.out.println("File converted Successfully!");
		} catch (IOException e) {
			System.out.println("File error: " + e.getMessage());
		}
	}
}