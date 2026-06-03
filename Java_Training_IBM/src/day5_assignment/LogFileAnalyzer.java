package day5_assignment;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class LogFileAnalyzer {
	public static void main(String[] args) {
		String inputFile = "src/day5_assignment/server.log/";
		String outputFile = "src/day5_assignment/summary.txt";
		
		Map<String, Integer> levelCounts = new HashMap<>();
		levelCounts.put("INFO", 0);
		levelCounts.put("WARN", 0);
		levelCounts.put("ERROR", 0);
		
		List<String> errorMessages = new ArrayList<>();
		LocalDateTime earliest = null;
		LocalDateTime latest = null;
		int totalEntries = 0;
		
		try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
			String line;
			while((line = br.readLine()) != null) {
				if (line.trim().isEmpty()) continue;
				
				try {
					LogEntry entry = new LogEntry(line);
					totalEntries++;
					
					levelCounts.put(entry.getLevel(), levelCounts.get(entry.getLevel()) + 1);
					
					if (entry.getLevel().equals("ERROR")) {
						errorMessages.add(entry.getMessage());
					}
					
					if (earliest == null || entry.getTimestamp().isBefore(earliest)) {
						earliest = entry.getTimestamp();
					}
					if(latest == null || entry.getTimestamp().isAfter(latest)) {
						latest = entry.getTimestamp();					
						}
				} catch (MalformedLogEntryException e) {
					System.err.println("Skipped line: " + e.getMessage());
				}
			} 
		} catch (FileNotFoundException e) {
			System.err.println("Error: File not found -> " + inputFile);
			return;
		} catch (IOException e) {
			System.err.println("Error reading file: " + e.getMessage());
			return;
		}
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			bw.write("Log Summary Report\n----------\n");
			bw.write("Total Entries: " + totalEntries + "\n");
			bw.write("INFO: " + levelCounts.get("INFO") + "\n");
			bw.write("WARN: " + levelCounts.get("WARN") + "\n");
			bw.write("ERROR: " + levelCounts.get("ERROR") + "\n");
			bw.write("Error Messages: \n");
			for (String e : errorMessages) {
				bw.write("- " + e + "\n");
			}
			bw.write("\n");
			bw.write("Earliest TimeStamp: " + earliest + "\n");
			bw.write("Latest TimeStamp: " + latest + "\n");
		} catch (IOException e) {
		
	}
	}}

