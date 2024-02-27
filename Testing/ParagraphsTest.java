import java.util.ArrayList;

import TextEditor.Paragraphs;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * The {@code ParagraphsTest} class is a set of JUnit tests for the {@link Paragraphs} class.
 * It tests various functionalities such as adding paragraphs, deleting paragraphs, and replacing text in paragraphs.
 *
 * @author Your Name
 * @version 1.0
 * @since 2023-12-05
 */
public class ParagraphsTest {

    /**
     * Tests the method by adding a paragraph and
     * checking if it is successfully added.
     */
    @Test
    public void testAddParagraph() {
        Paragraphs paragraphs = new Paragraphs();
        paragraphs.setUserText(0, "First paragraph");
        assertEquals("First paragraph", paragraphs.getUserText().get(0));
    }

    /**
     * Tests the {@link Paragraphs#deleteParagraph(int)} method by adding a paragraph,
     * deleting it, and checking if the paragraphs list is empty.
     */
    @Test
    public void testDeleteParagraph() {
        Paragraphs paragraphs = new Paragraphs();
        paragraphs.setUserText(0, "First paragraph");
        paragraphs.deleteParagraph(0);
        assertTrue(paragraphs.getUserText().isEmpty());
    }

    /**
     * Tests the {@link Paragraphs#replaceUserText(int, String, String)} method by adding a paragraph,
     * replacing a specific text in that paragraph, and checking if the replacement is successful.
     */
    @Test
    public void testReplaceTextInParagraph() {
        Paragraphs paragraphs = new Paragraphs();
        paragraphs.setUserText(0, "This is a test");
        paragraphs.replaceUserText(0, "test", "JUnit");
        assertEquals("This is a JUnit", paragraphs.getUserText().get(0));
    }

    /**
     * Tests the {@link Paragraphs#replaceUserText(int, String, String)} method when trying to
     * replace text in a nonexistent paragraph. The paragraphs list should remain unchanged.
     */
    @Test
    public void testReplaceTextInNonexistentParagraph() {
        Paragraphs paragraphs = new Paragraphs();
        paragraphs.replaceUserText(0, "test", "JUnit");
        assertTrue(paragraphs.getUserText().isEmpty());
    }

    /**
     * Tests the {@link Paragraphs#deleteParagraph(int)} method when trying to delete a nonexistent paragraph.
     * The paragraphs list should remain unchanged.
     */
    @Test
    public void testDeleteNonexistentParagraph() {
        Paragraphs paragraphs = new Paragraphs();
        paragraphs.deleteParagraph(0);
        assertTrue(paragraphs.getUserText().isEmpty());
    }

    /**
     * Tests the method by attempting to add a paragraph
     * at an out-of-bounds index. The paragraphs list should remain unchanged.
     */
    @Test
    public void testAddParagraphOutOfBounds() {
        Paragraphs paragraphs = new Paragraphs();
        paragraphs.setUserText(2, "First paragraph");
        assertTrue(paragraphs.getUserText().isEmpty());
    }
}
