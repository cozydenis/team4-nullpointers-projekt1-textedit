package TextEditor;

import java.util.logging.Level;

/**
 * This class represents a command in the text editor.
 * It contains the keyword, position, and two text strings for the command.
 * It also uses an InputScanner to get user input.
 */
public class Command {

    private KeyWord keyWord;
    private int position;
    private String text1;
    private String text2;
    private static InputScanner inputScanner = new InputScanner();

    private static final int COMMAND_KEYWORD_INDEX = 0;
    private static final int COMMAND_POSITION_INDEX = 1;
    private static final int FORMAT_FIX_WIDTH_INDEX = 2;

    /**
     * Constructor for Command class.
     * Initializes keyword, position, and text strings to default values.
     */
    public Command() {
        this.keyWord = null;
        this.position = 0;
        this.text1 = "";
        this.text2 = "";

    }

    /**
     * Parses the command and returns the Command object.
     *
     * @return the Command object.
     */
    public Command getCommand() {
        parseCommand();
        return this;
    }


    /**
     * Parses the command from user input.
     */
    private void parseCommand() {
        // Reset all variables
        this.keyWord = null;
        this.position = 0;
        this.text1 = "";
        this.text2 = "";


        boolean isValidCommand = false;

        while (!isValidCommand) {
            System.out.print("> ");
            String commandStr = inputScanner.getLine();
            isValidCommand = defineCommandType(commandStr);

        }


    }


    /**
     * Defines the command type based on the input string.
     *
     * @param commandStr the input command string.
     * @return true if the command is valid, false otherwise.
     */
    //public now for testing purposes
    public boolean defineCommandType(String commandStr) {
        //Splits the command string into an array of strings Ex: "add 1" -> ["add", "1"]
        String commandStrArr[] = commandStr.split(" ");


        // Handles allocation of the keyWord
        String commandFormat = commandStrArr[COMMAND_KEYWORD_INDEX];
        this.keyWord = KeyWord.getByAllowedCommandFormat(commandFormat.toUpperCase());

        if (this.keyWord != KeyWord.UNKNOWN) {
            // Handles the position index if AdditionalInputNeeded is true
            if (this.keyWord.isAdditionalInputNeeded() && commandStrArr.length > COMMAND_POSITION_INDEX) {
                this.position = Integer.parseInt(commandStrArr[COMMAND_POSITION_INDEX]);
            }
        }

        // Handle special cases for FORMAT_RAW, FORMAT_FIX and FORMAT_CHRISTMASTALE
        if (commandStrArr.length > 1 && (commandStrArr[1].equalsIgnoreCase("raw") ||
                commandStrArr[1].equalsIgnoreCase("fix") ||
                (commandStrArr[1].equalsIgnoreCase("christmastale")))) {
            commandFormat += " " + commandStrArr[1];
            this.keyWord = KeyWord.getByAllowedCommandFormat(commandFormat.toUpperCase());
        }


        switch (this.keyWord) {
            case ADD:
                while (this.text1.isEmpty()) {
                    System.out.print("Text:");
                    this.text1 = inputScanner.getLine();
                }
                break;

            case REPLACE:
                while (this.text1.isEmpty()) {
                    System.out.print("To find:");
                    this.text1 = inputScanner.getLine();
                }
                while (this.text2.isEmpty()) {
                    System.out.print("To replace with:");
                    this.text2 = inputScanner.getLine();
                }
                break;
            case DUMMY:
                // No additional input needed
                break;
            case DEL:
                // No additional input needed
                break;
            case EXIT:
                // No additional input needed
                break;
            case PRINT:
                // No additional input needed
                break;
            case FORMAT_RAW:
                if (commandStrArr.length > FORMAT_FIX_WIDTH_INDEX) {
                    System.err.println("FORMAT RAW choosen, no additional input needed. If you want to change the format" +
                            ", please use FORMAT FIX.");
                }
                break;
            case FORMAT_CHRISTMASTALE:
                if (commandStrArr.length > FORMAT_FIX_WIDTH_INDEX) {
                    System.err.println("FORMAT CHRISTMASTALE choosen, no additional input needed. If you want to change the format" +
                            ", please use FORMAT FIX.");
                }
                break;

            case FORMAT_FIX:

                if (commandStrArr.length > FORMAT_FIX_WIDTH_INDEX) {
                    this.position = Integer.parseInt(commandStrArr[2]);
                } else {
                    System.err.print("Additional input needed for FORMAT FIX. Format changed to: RAW");
                    this.keyWord = KeyWord.FORMAT_RAW;
                }
                break;
            case INDEX:
                // No additional input needed
                break;

            default:
                System.err.println("Command not found. Please try again.");
                this.keyWord = KeyWord.UNKNOWN;
                return false;

        }
        return true;
    }

    /**
     * Returns the keyword of the command.
     *
     * @return the keyword of the command.
     */
    public KeyWord getKeyWord() {
        return keyWord;
    }

    /**
     * Returns the position of the command.
     *
     * @return the position of the command.
     */
    public int getPosition() {
        return this.position;
    }

    /**
     * Returns the first text string of the command.
     *
     * @return the first text string of the command.
     */
    public String getText1() {
        return text1;
    }

    /**
     * Returns the second text string of the command. Only used in Testing
     *
     * @return the second text string of the command.
     */
    public String getText2() {
        return text2;
    }

    /**
     * Sets Text1. Only used in Testing
     */
    public void setText1(String text1) {
        this.text1 = text1;
    }


    /**
     * Sets Text2. Only used in Testing
     */
    public void setText2(String text2) {
        this.text2 = text2;
    }
}
