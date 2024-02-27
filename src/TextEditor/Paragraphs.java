package TextEditor;

import java.util.ArrayList;


/**
 * The Paragraphs class represents a collection of paragraphs in a text editor.
 * It provides methods to manipulate and manage paragraphs, such as adding,
 * deleting, and replacing paragraphs.
 */
public class Paragraphs {

    /**
     * The list that holds the paragraphs entered by the user.
     */
    private ArrayList<String> userText = new ArrayList<>();

    /**
     * Constructs an empty Paragraphs object.
     */
    public Paragraphs() {

    }


    /**
     * Sets the user-entered text for a specified paragraph index.
     *
     * @param n    The index of the paragraph to set.
     * @param text The text to set for the specified paragraph.
     */
    public void setUserText(int n, String text) {
        try {
            if (n <= userText.size()) {
                if (n == 0) {
                    userText.add(text);
                } else {
                    userText.add(n - 1, text);
                }
            } else if (n == userText.size() + 1) {
                userText.add(n - 1, text);
            } else {
                System.err.println("Element out of bounds.");
            }
        } catch (Throwable t) {
            System.err.println("Element out of bounds.");
        }
    }

    /**
     * Deletes the paragraph at the specified index.
     *
     * @param n The index of the paragraph to delete.
     */
    public void deleteParagraph(int n) {
        if (n <= userText.size() && userText.size() != 0) {
            if (n == 0) {
                userText.remove(userText.size() - 1);
            } else {
                userText.remove(n - 1);
            }
        } else {
            System.err.println("Paragraph does not exist");
        }
    }

    /**
     * Replaces the specified text in a paragraph with new text.
     *
     * @param n       The index of the paragraph to modify.
     * @param oldText The text to replace in the paragraph.
     * @param newText The new text to insert into the paragraph.
     */
    public void replaceUserText(int n, String oldText, String newText) {
        if (n <= userText.size() && userText.size() != 0) {
            String elementToModify;
            if (n == 0) {
                elementToModify = userText.get(userText.size() - 1).replaceAll(oldText, newText);
                userText.set(userText.size() - 1, elementToModify);
            } else {
                elementToModify = userText.get(n - 1).replaceAll(oldText, newText);
                userText.set(n - 1, elementToModify);
            }
        } else {
            System.err.println("Paragraph does not exist");
        }
    }


    /**
     * Gets the list of paragraphs entered by the user.
     *
     * @return The ArrayList containing user-entered paragraphs.
     */
    public ArrayList<String> getUserText() {
        return userText;
    }

}
