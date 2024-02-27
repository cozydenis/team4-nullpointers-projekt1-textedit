package TextEditor;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The TextEditor class provides a simple text editor functionality with commands
 * to manipulate and display paragraphs.
 */
public class TextEditor {

    ChristmasEgg egg = new ChristmasEgg();
    Command command = new Command();
    Paragraphs paragraphs = new Paragraphs();
    Output output = new Output();

    boolean talemode = false;

    /**
     * Default constructor for the TextEditor class.
     */
    public TextEditor() {


    }

    /**
     * Initializes the necessary classes and starts the main loop for the text editor.
     * This method initializes instances of the Command, Paragraphs, and Output classes,
     * prints a welcome message, and enters a loop to process user commands until the user exits.
     */
    public void start() {

        boolean run = true;


        output.printHelpLine();

        final Logger LOGGER = Logger.getLogger(TextEditor.class.getName());


        // Start of the loop
        while (run) {
            try {
                Command actualCommand = command.getCommand();
                switch (actualCommand.getKeyWord()) {
                    case ADD -> paragraphs.setUserText(actualCommand.getPosition(), actualCommand.getText1());
                    case REPLACE ->
                            paragraphs.replaceUserText(actualCommand.getPosition(), actualCommand.getText1(), actualCommand.getText2());
                    case DUMMY -> paragraphs.setUserText(actualCommand.getPosition(), this.returnDummy());
                    case DEL -> paragraphs.deleteParagraph(actualCommand.getPosition());
                    case EXIT -> run = output.sayGoodNight(egg.retriveBedTimeStory());
                    case PRINT -> output.printParagraphs(paragraphs.getUserText());
                    case FORMAT_RAW -> {
                        output.setFormatRAW();
                        talemode = false;
                    }
                    case FORMAT_FIX -> {
                        output.setFormatFIX(actualCommand.getPosition());
                        talemode = false;
                    }
                    case FORMAT_CHRISTMASTALE -> {
                        output.setFormatTale();
                        talemode = true;
                    }
                    case INDEX -> output.printIndex(createIndex(paragraphs.getUserText()));

                }
            } catch (Exception e) {
                // Log the exception
                LOGGER.log(Level.FINE, "An exception occurred: ", e);
            }
        }
    }


    /**
     * Creates an index of terms and their corresponding paragraph numbers.
     *
     * @param paragraphs ArrayList of paragraphs to index.
     * @return A map where each term is associated with a comma-separated string of paragraph numbers.
     */
    public Map<String, String> createIndex(ArrayList<String> paragraphs) {
        int par = 0;
        if (paragraphs == null || paragraphs.isEmpty()) {
            return Collections.emptyMap();
        }

        Map<String, List<Integer>> termIndex = new HashMap<>();
        Map<String, Integer> wordFrequencies = new HashMap<>();

        for (String paragraph : paragraphs) {
            par++;
            String[] words = paragraph.split("\\s+");
            for (String word : words) {
                String cleanedWord = word.replaceAll("[^a-zA-Z]", "").toLowerCase();
                if (cleanedWord.length() > 2) {
                    termIndex.computeIfAbsent(cleanedWord, k -> new ArrayList<>()).add(par);
                    wordFrequencies.merge(cleanedWord, 1, Integer::sum);
                }
            }
        }

        // Filter out words that appear less than or equal to 3 times
        termIndex.entrySet().removeIf(entry -> wordFrequencies.get(entry.getKey()) <= 3);

        // Convert termIndex values to String and return the result
        Map<String, String> result = new HashMap<>();
        termIndex.forEach((key, value) -> {
            StringBuilder sb = new StringBuilder();
            for (int index : value) {
                sb.append(index).append(",");
            }
            sb.deleteCharAt(sb.length() - 1);
            result.put(key, sb.toString());
        });

        return result;
    }

    /**
     * Returns a dummy string based on the current mode.
     * <p>
     * If the mode is set to tale mode, it retrieves a part of a tale from the 'egg' object.
     * Otherwise, it returns a default placeholder string "Lorem ipsum dolor sit amet".
     *
     * @return A string based on the mode; a part of a tale or a default placeholder.
     */
    public String returnDummy() {
        if (talemode) {
            return egg.retriveApartOfaTale();
        } else {
            return "Lorem ipsum dolor sit amet";
        }
    }


}
