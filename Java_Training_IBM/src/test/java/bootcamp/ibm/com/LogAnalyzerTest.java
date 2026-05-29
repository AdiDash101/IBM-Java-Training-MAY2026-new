package bootcamp.ibm.com;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

public class LogAnalyzerTest {
	
	private final PrintStream standardOut = System.out;
	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
	private final Path outputPath = Path.of("resources/summary.txt");
	
	@BeforeEach
	public void setUp() throws IOException {
		System.setOut(new PrintStream(outputStreamCaptor)); 
		Files.deleteIfExists(outputPath);
		Files.createDirectories(Path.of("resources"));
	}
	
	@AfterEach
	public void tearDown() throws IOException {
		System.setOut(standardOut);
		Files.deleteIfExists(outputPath);
	}
	
	@Test 
	void exec001() throws IOException {
		String expectedFile = Files.readString(Path.of("src/test/resources/exec001/summary.txt"));
		String inputFile = "src/test/resources/exec001/server.log";
		
		LogAnalyzer.main(new String[] {inputFile});
		
		String summaryFile = Files.readString(outputPath);
		
		assertEquals(expectedFile.trim().replace("\r\n", "\n"), summaryFile.trim().replace("\r\n", "\n"));
		assertTrue(outputStreamCaptor.toString().contains("Analysis complete. Summary written to summary.txt"));
	}
	
	@Test
	void exec002() throws IOException {
		String expectedFile = Files.readString(Path.of("src/test/resources/exec002/summary.txt"));
		String inputFile = "src/test/resources/exec002/server.log";
		
		LogAnalyzer.main(new String[] {inputFile});
		
		String summaryFile = Files.readString(outputPath);
		String consoleOutput = outputStreamCaptor.toString();
		
		assertAll(
		() -> assertEquals(expectedFile.trim().replace("\r\n", "\n"), summaryFile.trim().replace("\r\n", "\n")),
		() -> assertTrue(consoleOutput.contains("Skipping malformed line: ")),
		() -> assertTrue(consoleOutput.contains("Analysis complete. Summary written to summary.txt"))
		);
	}
	
	@Test
	void exec003() throws IOException {
		String inputFile = "src/test/resources/exec003/nonexistent.log";
		
		LogAnalyzer.main(new String[] {inputFile});
		
		assertFalse(Files.exists(outputPath));
		assertTrue(outputStreamCaptor.toString().contains("Log file not found.")); 
	}

	@Test
	void exec004() throws IOException {
		String expectedFile = Files.readString(Path.of("src/test/resources/exec004/summary.txt"));
		String inputFile = "src/test/resources/exec004/server.log";
		
		LogAnalyzer.main(new String[] {inputFile});
		
		String summaryFile = Files.readString(outputPath);

		assertEquals(expectedFile.trim().replace("\r\n", "\n"), summaryFile.trim().replace("\r\n", "\n"));
		assertTrue(outputStreamCaptor.toString().contains("Analysis complete. Summary written to summary.txt"));
	}
}