package TextEditor;

import java.util.Scanner;

public class InputScanner {
    private Scanner scanner;

    public InputScanner() {
        scanner = new Scanner(System.in);
    }

    public String getLine() {
        String input = scanner.nextLine();
        return input.replaceAll("[^a-zA-ZäöüÄÖÜ0-9.,:;!? '()\"%+*\\[\\]{}\\\\/\\&#$]", "");
    }


}
