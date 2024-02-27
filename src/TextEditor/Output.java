package TextEditor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * The Output class provides a method to print the paragraphs in different formats and
 * methods to set the format.
 * It also provides a method to print the help line.
 * The help line is a String that contains all the commands that are available.
 */
public class Output {

    KeyWord keyWord;
    private int maxWidth = 80;
    private String helpLine;

    private enum FormatSetting {RAW, FIX, TALE}

    ;
    private FormatSetting currentFormat;
    private String textSavedAsString; //The text that is saved as a String. Used for printing the paragraphs.
    private String nextLineToPrint = "";

    /**
     * Initializes the Outputclass and sets the helpLine.
     * The helpLine is a String that contains all the commands that are available.
     * The helpLine is printed when the program starts.
     * The currentFormat is set to RAW at the beginning.
     * The textSavedAsString is set to "" at the beginning, because there is no text saved yet.
     */
    public Output() {
        setHelpLine();
        this.currentFormat = FormatSetting.RAW;
        textSavedAsString = "";
    }

    /**
     * Sets the help line with the KeyWords. If a new command is added, 
     * the explanation of it's functuality has to be added here manually.
     * But if gets forgotten, the command will still be displayed in the line of commands.
     * Alternatively, in the future, the explanation texts could be handeled in the KeyWord class.
     */
    private void setHelpLine() {
        //Remove the unvalid commands from the list of allowed commands.
        List<String> allowedCommandFormats = KeyWord.getAllCommands();
        allowedCommandFormats.remove(KeyWord.UNKNOWN.getAllowedCommandFormat());
        allowedCommandFormats.remove(KeyWord.FORMAT_CHRISTMASTALE.getAllowedCommandFormat());

        this.helpLine = "\n" +
                "████████╗██╗  ██╗███████╗    ███████╗██████╗ ██╗████████╗ ██████╗ ██████╗ \n" +
                "╚══██╔══╝██║  ██║██╔════╝    ██╔════╝██╔══██╗██║╚══██╔══╝██╔═══██╗██╔══██╗\n" +
                "   ██║   ███████║█████╗      █████╗  ██║  ██║██║   ██║   ██║   ██║██████╔╝\n" +
                "   ██║   ██╔══██║██╔══╝      ██╔══╝  ██║  ██║██║   ██║   ██║   ██║██╔══██╗\n" +
                "   ██║   ██║  ██║███████╗    ███████╗██████╔╝██║   ██║   ╚██████╔╝██║  ██║\n" +
                "   ╚═╝   ╚═╝  ╚═╝╚══════╝    ╚══════╝╚═════╝ ╚═╝   ╚═╝    ╚═════╝ ╚═╝  ╚═╝\n" +
                "                                                                          \n" +
                "Welcome to the TextEditor!\n" +
                "You will be able to write what ever you desire and mingle with your paragraphs.\n" +
                "The commands below are available, so make good use of them.\n" +
                "Just enter the command as shown below, for example : ADD 2 to add a paragraph on position 2.\n"
                + "------------------------------------------------------------------------\n"
                + allowedCommandFormats + "\n" +
                "------------------------------------------------------------------------\n" +

                (String.format("%-20s %s", KeyWord.ADD.getAllowedCommandFormat()+ " <n>", "- Adds a new paragraph with the text <txt> at position <n>\n"))+
                (String.format("%-20s %s", KeyWord.DEL.getAllowedCommandFormat()+" <n>", "- Deletes the paragraph at position <n>\n"))+
                (String.format("%-20s %s", KeyWord.REPLACE.getAllowedCommandFormat()+ " <n>", "- <n> <txt1> <txt2> - Replaces all occurrences of <txt1> with <txt2> in paragraph <n>\n"))+
                (String.format("%-20s %s", KeyWord.DUMMY.getAllowedCommandFormat()+ " <n>", "- Adds some spice to your paragraphs <n> \n"))+
                (String.format("%-20s %s", KeyWord.FORMAT_RAW.getAllowedCommandFormat(), "- Sets the output format to raw\n"))+
                (String.format("%-20s %s", KeyWord.FORMAT_FIX.getAllowedCommandFormat()+ " <n>", "- Sets the output format to fixed width <n> \n"))+
                (String.format("%-20s %s", KeyWord.PRINT.getAllowedCommandFormat(), "- Prints your lovely paragraphs\n"))+
                (String.format("%-20s %s", KeyWord.INDEX.getAllowedCommandFormat(), "- Displays all words that are longer then 3 characters and appear more then 3 times\n"))+
                (String.format("%-20s %s", "", "  Additionally it will display in which paragraphs the words appear\n"))+
                (String.format("%-20s %s", KeyWord.EXIT.getAllowedCommandFormat(), "- Exits the program. Nothing is saved, everything will be gone forever!\n"))+
                "Note that if <n> is not entered, the command will always be execuded on the last paragraph.";
    }

    /**
     * Prints the RAW paragraphs according to the requirements.
     *
     * @param paragraphs
     * @return textSavedAsString
     */
    private String generateRawParagraphs(ArrayList<String> paragraphs) {
        textSavedAsString = "";
        for (int i = 0; i < paragraphs.size(); i++) {
            textSavedAsString += (i + 1) + ": " + paragraphs.get(i) + "\n" + "\n";
        }
        return textSavedAsString;
    }

    /**
     * Prints the FIXED paragraphs according to the requirements.
     *
     * @param paragraphs
     * @return textSavedAsString
     */
    private String generateFixedParagraphs(ArrayList<String> paragraphs) {
        ArrayList<String> userText = new ArrayList<>();
        userText = paragraphs;
        textSavedAsString = ""; //Reset the textSavedAsString
        for (int p = 0; p < userText.size(); p++) {
            for (int c = 0; c < userText.get(p).length(); c++) {
                nextLineToPrint += userText.get(p).charAt(c);
                //If we are at the end of the paragraph, print the last line.
                if (c == (userText.get(p).length() - 1)) {
                    addLineToTextSavedAsString();
                    textSavedAsString += "\n";
                }
                //If the next line is as long as the maxWidth, print it.
                if (nextLineToPrint.length() == maxWidth) {
                    //If the next line contains a space, it goes back every char until it finds a space
                    //and prints the line until that space.
                    if (containsSpace(nextLineToPrint)) {
                        while (userText.get(p).charAt(c) != ' ') {
                            c--;
                            nextLineToPrint = nextLineToPrint.substring(0, nextLineToPrint.length() - 1);
                        }
                        addLineToTextSavedAsString();
                    }
                    //Otherwise, It just prints the line. (There it means the word is either longer or same as the maxWidth)
                    else {
                        addLineToTextSavedAsString();
                    }


                }
            }
        }
        return textSavedAsString;
    }

    /**
     * Adds the next line to the textSavedAsString and resets the nextLineToPrint.
     */
    private void addLineToTextSavedAsString() {

        //If the next line starts with a space, remove it.
        if (nextLineToPrint.charAt(0) == ' ') {
            nextLineToPrint = nextLineToPrint.substring(1);
        }

        textSavedAsString += nextLineToPrint + "\n";
        nextLineToPrint = "";
        
    }


    /**
     * Checks if the String contains a space.
     *
     * @param text
     * @return containsSpace
     */
    private boolean containsSpace(String text) {
        boolean containsSpace = false;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                containsSpace = true;
            }
        }
        return containsSpace;
    }

    /**
     * Prints the help line.
     */
    public void printHelpLine() {
        System.out.println(helpLine);
    }

    /**
     * Sets the current format to RAW.
     */
    public void setFormatRAW() {
        this.currentFormat = FormatSetting.RAW;
    }
    
    /**
     * Sets the current format to FIX and sets the maxwidth.
     *
     * @param width
     */
    public void setFormatFIX(int width) {
        this.currentFormat = FormatSetting.FIX;
        this.maxWidth = width;
    }


    /**
     * Prints the paragraphs in the current format.
     *
     * @param paragraphs
     */
    public void printParagraphs(ArrayList<String> paragraphs) {
        if (currentFormat == FormatSetting.RAW) {
            System.out.println(generateRawParagraphs(paragraphs));
        } else if (currentFormat == FormatSetting.TALE) {
            this.sayGoodNight(paragraphs.toString());
        } else {
            System.out.println(generateFixedParagraphs(paragraphs));
        }
    }

    /**
     * Returns the textSavedAsString.
     *
     * @return textSavedAsString
     * For testing purposes.
     */
    public String getTextSavedAsString() {
        return textSavedAsString;
    }

    /**
     * Prints the index.
     *
     * @param index
     */
    public void printIndex(Map<String, String> index) {
        for (Map.Entry<String, String> entry : index.entrySet()) {
            System.out.println(String.format("%-20s %s", entry.getKey(), entry.getValue()));
        }
    }






































































    
    /**
     * Sets the current format to TALE.
     */
    public void setFormatTale()  { this.currentFormat = FormatSetting.TALE; }

    /**
     * Prints the text in a tale format.
     *
     * @param text
     * @return false (ends the loop)
     */
    public boolean sayGoodNight(String text) {
        int delay = 10; // Delay in milliseconds
        int wordCount = 0;

        if (maxWidth > 20) {
            maxWidth = 20;
        }

        for (char c : (text.toCharArray())) {
            System.out.print(c);

            if (c == ' ') {
                wordCount++;
                if (wordCount == maxWidth / 6) {
                    System.out.print("\n");
                    wordCount = 0;
                }
            }

            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("\n");

        return false;
    }


}
