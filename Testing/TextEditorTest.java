import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import TextEditor.TextEditor;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * JUnit tests for the {@link TextEditor} class.
 */
class TextEditorTest {

    /**
     * Test case for the {@link TextEditor#ReturnDummy()} method.
     */
    @Test
    void Testdummy() {
        // Create an instance of TextEditor
        TextEditor textEditor = new TextEditor();

        // Call the ReturnDummy method
        String expectedResult = textEditor.returnDummy();

        // Verify the result based on your expectations
        assertEquals(expectedResult, "Lorem ipsum dolor sit amet");
    }

    /**
     * Test case for the {@link TextEditor#createIndex(ArrayList)} method.
     */
    @Test
    void testCreateIndex() {
        // Create an instance of TextEditor
        TextEditor textEditor = new TextEditor();

        // Create a sample list of paragraphs
        ArrayList<String> paragraphs = new ArrayList<>();
        paragraphs.add("dromadaire dromadaire dromadaire cheval cheval oiseau");
        paragraphs.add("dromadaire dromadaire dromadaire cheval cheval oiseau");
        paragraphs.add("dromadaire dromadaire dromadaire cheval cheval oiseau");

        // Call the createIndex method
        Map<String, String> index = textEditor.createIndex(paragraphs);

        // Create the expected result
        Map<String, String> expectedResult = new HashMap<>();
        expectedResult.put("dromadaire", "1,1,1,2,2,2,3,3,3");
        expectedResult.put("cheval", "1,1,2,2,3,3");

        // Verify the result based on your expectations
        assertEquals(expectedResult, index);
    }
}
