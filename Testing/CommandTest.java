import TextEditor.Command;
import TextEditor.KeyWord;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * This class contains unit tests for the Command class.
 */
public class CommandTest {


    /**
     * Tests the defineCommandType method with the "add" keyword.
     */
    @Test
    public void testDefineCommandWithAdd() {
        Command command = new Command();
        command.setText1("Hello");
        command.defineCommandType("add 1");

        assertEquals(KeyWord.ADD, command.getKeyWord());
        assertEquals(1, command.getPosition());
        assertEquals("Hello", command.getText1());
    }

    /**
     * Tests the defineCommandType method with the "del" keyword.
     */
    @Test
    public void testDefineCommandWithDelete() {
        Command command = new Command();
        command.defineCommandType("del 5");

        assertEquals(KeyWord.DEL, command.getKeyWord());
        assertEquals(5, command.getPosition());
    }


    /**
     * Tests the defineCommandType method with the "replace" keyword.
     */
    @Test
    public void testDefineCommandWithReplace() {
        Command command = new Command();
        command.setText1("Hello");
        command.setText2("Hallo");
        command.defineCommandType("replace 5");

        assertEquals(KeyWord.REPLACE, command.getKeyWord());
        assertEquals(5, command.getPosition());
        assertEquals("Hello", command.getText1());
        assertEquals("Hallo", command.getText2());
    }

    /**
     * Tests the defineCommandType method with the "dummy" keyword.
     */
    @Test
    public void testDefineCommandWithDummy() {
        Command command = new Command();
        command.defineCommandType("dummy");

        assertEquals(KeyWord.DUMMY, command.getKeyWord());
    }


    /**
     * Tests the defineCommandType method with the "exit" keyword.
     */
    @Test
    public void testDefineCommandWithExit() {
        Command command = new Command();
        command.defineCommandType("exit");

        assertEquals(KeyWord.EXIT, command.getKeyWord());

    }

    /**
     * Tests the defineCommandType method with the "print" keyword.
     */
    @Test
    public void testDefineCommandWithPrint() {
        Command command = new Command();
        command.defineCommandType("print");

        assertEquals(KeyWord.PRINT, command.getKeyWord());
    }

    /**
     * Tests the defineCommandType method with the "format raw" keyword.
     */
    @Test
    public void testDefineCommandWithFormatRaw() {
        Command command = new Command();
        command.defineCommandType("format raw");

        assertEquals(KeyWord.FORMAT_RAW, command.getKeyWord());
    }

    /**
     * Tests the defineCommandType method with the "format fix" keyword.
     */
    @Test
    public void testDefineCommandWithFormatFix() {
        Command command = new Command();
        command.defineCommandType("format fix 5");

        assertEquals(KeyWord.FORMAT_FIX, command.getKeyWord());
        assertEquals(5, command.getPosition());
    }

    /**
     * Tests the defineCommandType method with the "format christmastale" keyword.
     */
    @Test
    public void testDefineCommandWithFormatChristmasTale() {
        Command command = new Command();
        command.defineCommandType("format christmastale");

        assertEquals(KeyWord.FORMAT_CHRISTMASTALE, command.getKeyWord());
    }

    /**
     * Tests the defineCommandType method with the "index" keyword.
     */
    @Test
    public void testDefineCommandWithIndex() {
        Command command = new Command();
        command.defineCommandType("index");

        assertEquals(KeyWord.INDEX, command.getKeyWord());
    }

    /**
     * Tests the defineCommandType method with an invalid keyword.
     */
    @Test
    public void testDefineCommandWithInvalidKeyword() {
        Command command = new Command();
        command.defineCommandType("invalid");

        assertEquals(KeyWord.UNKNOWN, command.getKeyWord());

    }

    /**
     * Tests the defineCommandType method with an invalid position.
     * The method should throw a NumberFormatException.
     * Tested on all commands that require a position.
     */
    @Test
    public void testDefineCommandWithInvalidPosition() {
        Command command = new Command();

        assertThrows(NumberFormatException.class, () -> command.defineCommandType("add invalid"));
        assertThrows(NumberFormatException.class, () -> command.defineCommandType("replace invalid"));
        assertThrows(NumberFormatException.class, () -> command.defineCommandType("format fix invalid"));
        assertThrows(NumberFormatException.class, () -> command.defineCommandType("del invalid"));
    }


}