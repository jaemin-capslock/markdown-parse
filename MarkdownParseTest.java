import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.*;
public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1+1);
    }
    
    @Test
    public void testGetlink() throws IOException{
        Path fileName = Path.of("test-file.md");
        String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        List<String> expectedList = List.of("https://something.com", "some-page.html");
        assertEquals(expectedList, links);
    }
    @Test
    public void testGetlinkTwo() throws IOException{
        Path fileName = Path.of("test-file-2.md");
        String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        List<String> expectedList = List.of("https://www.google.com");
        assertEquals(expectedList, links);

    }
    @Test
    public void testGetlinkThree() throws IOException {
        Path fileName = Path.of("test-file9.md");
        String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        List<String> expectedList = List.of("https://something.com");
        assertEquals(expectedList, links);
    }
    
}
