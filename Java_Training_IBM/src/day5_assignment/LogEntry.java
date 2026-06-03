package day5_assignment;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogEntry {
	private LocalDateTime timestamp;
	private String level;
	private String message;
	
	public LogEntry(String line) throws MalformedLogEntryException {
		
		if(!line.startsWith("[") || !line.contains("]")) {
			throw new MalformedLogEntryException("Missing brackets: " + line);
		}
		if (!line.contains(":")) {
			throw new MalformedLogEntryException("Missing Seperator Colon: " + line);
		}
		
		try {
			
			int closeBracket = line.indexOf("]");
			String timeStr = line.substring(1, closeBracket);
			
			int colon = line.indexOf(":", closeBracket);
			String levelStr = line.substring(closeBracket + 1, colon).trim();
			String msgStr = line.substring(colon + 1).trim();
			
			if(!levelStr.equals("INFO") && !levelStr.equals("WARN") && !levelStr.equals("ERROR")) {
				throw new MalformedLogEntryException("Invalid log level: " + levelStr);
			}
			
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			this.timestamp = LocalDateTime.parse(timeStr, formatter);
			this.level = levelStr;
			this.message = msgStr;
			
		} catch (Exception e) {
			throw new MalformedLogEntryException("Invalid format content: " + line);
		}
			
	}
	
	public LocalDateTime getTimestamp() { return timestamp;}
	public String getLevel() { return level; }
	public String getMessage() { return message; }
}
