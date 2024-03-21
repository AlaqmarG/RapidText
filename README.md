# RapidText Docs
RapidText is a lightweight command line text file editor. RapidText enabled the editing of any file with the `.txt` extension purely through the command line. This command line tool requires the Brock University `BasicIO` Package. The package `.jar` files can be acquired from the Brock University Computer Science Department. Documentation for these packages can be found [here.](https://www.cosc.brocku.ca/archive/sites/all/files/documentation/Brock_packages/)

## Getting Started
To use RapidText you must compile the two included `.java` files in found in `/src`. The program can then be executed by running the complied `editor.class` java file. Upon launching the `.class` file the user will be prompted to select a text file they wish to edit. Upon selecting the desired file, the user is greeted with this command-line interface.

![image](https://github.com/AlaqmarG/RapidText/assets/117380848/b5878c9f-9262-46a3-9c93-ac24a1e1b8c6)

## Available Tools
### Get Help
The user may enter `h` at any point to access the list of available functions and their corresponding useage hints.

![image](https://github.com/AlaqmarG/RapidText/assets/117380848/cdba0b38-2e36-4505-abba-5fa660aef81b)

### Display Text
The user may enter `p` at any point to view all the contents of the text file currently loaded to the buffer.

RapidText uses a line pointer as opposed to a character pointer. The line currently selected by the pointer is displayed with the `>` symbol, where as other lines are displayed with the `]` symbol.

![image](https://github.com/AlaqmarG/RapidText/assets/117380848/6fe3b01f-bbe9-4db5-ab33-8c84ce65c085)

### Navigation
The user can use the line cursor to navigate to any line in the buffer. There is 4 primary ways to navigate the file buffer. The user may use the `u` function to navigate up by one line, or the `d` function to navigate down by one line. Note that running the `u` or `d` functions doesn't provide any output. To view the changes the user may use the `p` function, as highlighted in the [Display Text](https://github.com/AlaqmarG/RapidText/new/master?filename=README.md#display-text) Section.

The user may also use the `t` function to navigate to the top most line of the file buffer, or the `b` function to navigate to the bottom most line of the file buffer. Like the `u` and `d` function the `t` and `d` function do not produce any output, and in order to view their effects you may print the buffer using the `p` function, as highlighted in the [Display Text](https://github.com/AlaqmarG/RapidText/new/master?filename=README.md#display-text) Section.

![image](https://github.com/AlaqmarG/RapidText/assets/117380848/60ac9747-a768-416e-b4f8-48c5876858a4)

### Text Manipulation
The user may insert a line into the file buffer using the `i[text]` function. The `[text]` content is inserted to the line below the current position of the line cursor.

The user may cut a line from the text buffer using the `c` function. The cut function doesn't remove the line from the buffer until the line is pasted elsewhere using the `v` function. Using the `c` function cuts the line at the current position of the line cursor. When the user pastes the cutted line using the `v` function, the line is moved from its original position to a new line below the line cursors position at the time of using the `v` function.

The user may also edit the line currently selected by the line cursor using the `e[text]` function. The original content of the line is replaced by the content passed as `[text]`.

![image](https://github.com/AlaqmarG/RapidText/assets/117380848/2207bc6b-c066-4548-b0bd-e0ada097b6b6)

### Searching
The user can search for the occurrance of a word in the text file using the `?[text]` function. The function repositions the cursor to the first occrance of the `[text]` content after the current position of the cursor. This function only searches after the current position of the cursor. In order to search the entire file, the user may use the `t` function to navigate to the top of the file, before searching.

![image](https://github.com/AlaqmarG/RapidText/assets/117380848/cf679cc4-0b00-41c1-8146-d4e7897bf59d)

### File Functions
The user may reload the file to the buffer from the `.txt` file by using the `r` function. The `r` function prompts the user to pick a file to reload the buffer from. Reloading the buffer will erase all unsaved changes.

The user may save the changes they make to a file using the `s` function. This function saves the current state of the file buffer to the file on the users drive. The user upon using the `s` function is prompted select the destination to save the file to, the user may choose to either save to a new `.txt` file or replace the original file.

The user may quit RapidText by using the `q` function. This function doesn't save changes, and any unsaved changes will be lost.
