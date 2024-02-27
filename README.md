# Text editor - A Simple Text Processing Application

## Project Overview

Welcome to the TextEditor project, a Java-based application designed for basic text processing tasks. Developed as part
of PM1/Projekt 2 in Computer Science, this application allows users to interactively add, delete, and format text
paragraphs through a console interface. It's an exercise in understanding object-oriented design, command processing,
and text manipulation.

## Class Descriptions

### TextEditor

- **Purpose**: Serves as the main driver class of the application. It initializes the program and orchestrates the
  interaction between user inputs and application responses it also manages the dummy input as well as the index.
- **Functionality**:
    - Manages the overall application flow.
    - Initializes other classes.
    - Processes input/output operations.
    - Maintains the application's running state.

### Paragraphs

- **Purpose**: Represents all the paragraphs and handles them.
- **Functionality**:
    - Handles the storage and manipulation of text content.
    - Provides methods to access and modify paragraphs content.

### Output

- **Purpose**: Responsible for formatting and displaying text to the user.
- **Functionality**:
    - Manages text presentation in the console.
    - Implements different formatting styles (RAW, FIXED).
    - Ensures readability and appropriate formatting.

### KeyWord (Enum Class)

- **Purpose**: Represents the command keywords for the text editor. This enum classifies different types of commands that can be executed within the text editor, such as adding, replacing, or deleting text. It also helps in determining whether a command requires additional input from the user.
- **Functionality**:
    - Enumerates various command types (e.g., ADD, REPLACE, DEL).
    - Identifies if additional input is required for a command.
    - Facilitates command validation and interpretation.
    - Provides utility methods to retrieve and compare command keywords.

### Command

- **Purpose**: Acts as a command processor in the text editor. This class interprets user input, turning it into actionable commands by determining the keyword, position, and additional text parameters. It plays a crucial role in how the text editor responds to user interactions.
- **Functionality**:
    - Parses and interprets user input to form commands.
    - Holds details of a command like keyword, position, and text.
    - Utilizes the KeyWord enum to validate and categorize command types.
    - Provides methods for executing and managing text editor commands.
    - Facilitates user interaction with dynamic input handling.

### Scanner

- **Purpose**: Manages user input.
- **Functionality**:
    - Reads user inputs from the console.
    - Captures and relays inputs to the TextEditor.Command class.
    - Interfaces between the user and the application's command processing unit.

```mermaid
classDiagram
    class Main {
      +main(String[] args) void
    }

    class TextEditor {
    +Command command
    +Paragraphs paragraphs
    +Output output
    -boolean talemode
    --
    +TextEditor()
    +start()
    +createIndex(ArrayList<String> paragraphs): Map<String, String>
    +ReturnDummy(): String
  }

    class Command {
        -KeyWord keyWord
        -int position
        -String text1
        -String text2
        -static InputScanner inputScanner
        -static final int COMMAND_KEYWORD_INDEX
        -static final int COMMAND_POSITION_INDEX
        -static final int FORMAT_FIX_WIDTH_INDEX
        +Command()
        +getCommand(): Command
        +defineCommandType(commandStr: String): boolean
        +getKeyWord(): KeyWord
        +getPosition(): int
        +getText1(): String
        +getText2(): String
        +setText1(text1: String): void
        +setText2(text2: String): void
    }

    class Output {
      -KeyWord keyWord
      -int maxWidth
      -String helpLine
      -FormatSetting currentFormat
      -String textSavedAsString
      +Output()
      -setHelpLine() void
      -generateRawParagraphs(ArrayList String) String
      -generateFixedParagraphs(ArrayList String) String
      -containsSpace(String) boolean
      +printHelpLine() void
      +setFormatRAW() void
      +setFormatFIX(int) void
      +printParagraphs(ArrayList String) void
      +getTextSavedAsString() String
      +printIndex(Map String, String) void
    }

    class Paragraphs {
      -ArrayList String userText
      +Paragraphs()
      +setUserText(int, String) void
      +deleteParagraph(int) void
      +replaceUserText(int, String, String) void
      +getUserText() ArrayList String
    }

    class InputScanner {
      -Scanner scanner
      +InputScanner()
      +getLine() String
    }

    class KeyWord {
      <<enumeration>>
        ADD
        REPLACE
        DEL
        DUMMY
        EXIT
        PRINT
        FORMAT_RAW
        FORMAT_FIX
        INDEX
        UNKNOWN
        -boolean additionalInputNeeded
        -String allowedCommandFormat
        +KeyWord(additionalInputNeeded: boolean, allowedCommandFormat: String)
        +isAdditionalInputNeeded(): boolean
        +isCommandFormatAllowed(commandFormat: String): boolean
        +getAllowedCommandFormat(): String
        +getByAllowedCommandFormat(commandFormat: String): KeyWord
        +getAllCommands(): List~String~
    }

    class FormatSetting{
        <<enumeration>>
        RAW
        FIX
    }

    Main --|> TextEditor 
    TextEditor --|> Command 
    TextEditor --|> Paragraphs
    TextEditor --|> Output
    Command --|> KeyWord 
    Command --|> InputScanner
    Output --|> KeyWord 
    Output --|> FormatSetting

  ```  

# Testing Documentation

## Overview

This document provides an overview of the testing strategy for the TextEditor application. It outlines the approach for
unit and integration testing to ensure the reliability and correctness of the application.

## Unit Testing

### TextEditor

- **Objective**: Test the initialization and workflow management.
- **Test Cases**:
- The class is tested for its methods "index" and "dummy". For each an instance of the class is created, the specific
  methods is called, and the result in the paragraphs is tested.

### Paragraph

- **Objective**: Test the creation and manipulation of paragraphs content.
- **Test Cases**:
    - Creation with initial text.
    - Modification of content trough "add", "replace", "delete".
    - Handling of invalid content (e.g., non-string values).

### Output

- **Objective**: Test the formatting and output display functionality.
- **Test Cases**:
    - Output with `FORMAT RAW` setting.
    - Output with `FORMAT FIX` and various widths.
    - Handling of empty or null paragraphs. Also handling paragraphs with words longer then the width.

### Command / Scanner / ENUM KeyWord

- **Objective**: Test the parsing and execution of user commands.
- **Test Cases**:
    - Execution of `ADD`, `DEL`, `REPLACE` and other commandtypes in the ENUM KeyWord.
    - Correct parsing of command parameters.
    - Handling of unexpected input types / invalid commands.
