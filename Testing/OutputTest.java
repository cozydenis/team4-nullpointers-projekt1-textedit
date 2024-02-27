import java.util.ArrayList;
import TextEditor.Output;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class OutputTest {


    Output output = new Output();

    @Test
    public void testRAWformat(){
    ArrayList<String> userText = new ArrayList<>();
    userText.add("Hello");
    userText.add("world!");
    userText.add("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec a diam lectus. Sed sit amet ipsum mauris. Maecenas congue ligula ac quam viverra nec consectetur ante hendrerit.");
    userText.add("Donec et mollis dolor. Praesent et diam eget libero egestas mattis sit amet vitae augue.");

    output.setFormatRAW();
    
    output.printParagraphs(userText);

    String result = output.getTextSavedAsString();
    String expected = 
        """
        1: Hello 

        2: world!

        3: Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec a diam lectus. Sed sit amet ipsum mauris. Maecenas congue ligula ac quam viverra nec consectetur ante hendrerit.
        
        4: Donec et mollis dolor. Praesent et diam eget libero egestas mattis sit amet vitae augue.
        """;
    	


    assertEquals(expected.trim(), result.trim(), "falscher Text");
    };

    @Test
    public void testFIXformatWordLongerThanWidth(){
    ArrayList<String> userText = new ArrayList<>();
        userText.add("1234567890");
    
    output.setFormatFIX(5);

    output.printParagraphs(userText);

    String result = output.getTextSavedAsString();

    String expected = 
        """ 
        12345
        67890
        """;
    

        

    assertEquals(expected.trim(), result.trim(), "falscher Text");

    };



    @Test
    public void testEmptyValue(){

    ArrayList<String> userText = new ArrayList<>();
    
    output.setFormatFIX(5);

    output.printParagraphs(userText);

    String result = output.getTextSavedAsString();

    String expected = "";
    

        

    assertEquals(expected, result, "falscher Text");


    }

}