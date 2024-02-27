package TextEditor;

import java.util.ArrayList;
import java.util.List;

/**
 * This enum represents the keywords for commands in the text editor.
 * Each keyword has a flag indicating if additional input is needed for the command,
 * and a string representing the allowed command format.
 */
public enum KeyWord {
    ADD(true, "ADD"),
    REPLACE(true, "REPLACE"),
    DEL(true, "DEL"),
    DUMMY(true, "DUMMY"),
    EXIT(false, "EXIT"),
    PRINT(false, "PRINT"),
    FORMAT_RAW(false, "FORMAT RAW"),
    FORMAT_CHRISTMASTALE(false,"FORMAT CHRISTMASTALE"),
    FORMAT_FIX(true, "FORMAT FIX"),
    INDEX(false, "INDEX"),
    UNKNOWN(false, "UNKNOWN");




    private final boolean additionalInputNeeded;
    private final String allowedCommandFormat;

    /**
     * Constructor for KeyWord enum.
     *
     * @param additionalInputNeeded a boolean indicating if additional input is needed for the command.
     * @param allowedCommandFormat a string representing the allowed command format.
     */
    KeyWord(boolean additioanlInputNeeded, String allowedCommandFormat) {
        this.additionalInputNeeded = additioanlInputNeeded;
        this.allowedCommandFormat = allowedCommandFormat;
    }

    /**
     * Checks if additional input is needed for the command.
     *
     * @return true if additional input is needed, false otherwise.
     */
    public boolean isAdditionalInputNeeded() {
        return additionalInputNeeded;
    }

    /**
     * Checks if the command format is allowed.
     *
     * @param commandFormat the command format to check.
     * @return true if the command format is allowed, false otherwise.
     */
    public boolean isCommandFormatAllowed(String CommandFormat) {
        return allowedCommandFormat.equals(CommandFormat);

    }

    /**
     * Returns the allowed command format.
     *
     * @return the allowed command format.
     */
    public String getAllowedCommandFormat() {
        return allowedCommandFormat;
    }

    /**
     * Returns the KeyWord for the given command format.
     *
     * @param commandFormat the command format to check.
     * @return the KeyWord for the given command format, or UNKNOWN if the command format is not recognized.
     */
    public static KeyWord getByAllowedCommandFormat(String commandFormat) {
        for (KeyWord keyWord : KeyWord.values()) {
            if (keyWord.allowedCommandFormat.equalsIgnoreCase(commandFormat)) {
                return keyWord;
            }
        }
        return UNKNOWN;
    }


    /**
     * Returns a list of all allowed command formats.
     *
     * @return a list of all allowed command formats.
     */
    public static List<String> getAllCommands() {
        List<String> allowedCommandFormats = new ArrayList<>();
        for (KeyWord keyWord : KeyWord.values()) {
            allowedCommandFormats.add(keyWord.allowedCommandFormat);
        }
        return allowedCommandFormats;
    }
}
