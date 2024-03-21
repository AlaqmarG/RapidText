import BasicIO.*;
import java.util.Scanner;

public class editor {
    node n; // linked-list
    node cursor; // pointer acts as cursor
    node clipboard; // Current clipboard

    public editor() {
        // Loads data from file to internal linked list
        ASCIIDataFile in = new ASCIIDataFile();
        loadText(in);
        in.close();

        // Processes user input
        listenForInput();
    }

    private void listenForInput() {
        showHelp();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            String line = scanner.nextLine();

            if (line.startsWith("w")) {
                printWordCount();
            } else if (line.startsWith("u")) {
                if (cursor.prev == null) {
                    cursor.prev = new node("", null, cursor);
                }

                cursor = cursor.prev;
            } else if (line.startsWith("d")) {
                if (cursor.next == null) {
                    cursor.next = new node("", cursor, null);
                }

                cursor = cursor.next;
            } else if (line.startsWith("i")) {
                String text = line.substring(1);

                node p = cursor.next;

                cursor.next = new node(text, cursor, cursor.next);
                cursor = cursor.next;
                p.prev = cursor;
            } else if (line.startsWith("r")) {
                ASCIIDataFile file = new ASCIIDataFile();
                loadText(file);
                file.close();
            } else if (line.startsWith("t")) {
                cursor = n;
            } else if (line.startsWith("h")) {
                showHelp();
            } else if (line.startsWith("x")) {
                clipboard = cursor;
            } else if (line.startsWith("v")) {
                paste();
            } else if (line.startsWith("e")) {
                cursor.item = line.substring(1);
            } else if (line.startsWith("b")) {
                pointBottom();
            } else if (line.startsWith("s")) {
                saveFile();
            } else if (line.startsWith("c")) {
                System.out.println(cursor.item);
            } else if (line.startsWith("p")) {
                printBuffer();
            } else if (line.startsWith("?")) {
                findWord(line.substring(1));
            } else if (line.startsWith("q")) {
                System.out.println("Exiting");
                break;
            }
        }
    }

    // Places cursor on first line containing search word, or creates new line at end of file if not found
    private void findWord(String searchWord) {
        boolean foundWord = false;

        while (true) {
            for (String word : cursor.item.split(" ")) {
                if (word.equals(searchWord)) {
                    foundWord = true;
                    break;
                }
            }

            if (cursor.next != null && !foundWord) {
                cursor = cursor.next;
            } else {
                break;
            }
        }

        if (!foundWord) {
            cursor.next = new node("", cursor, null);
            cursor = cursor.next;
        }
    }

    // Goes through linked list and adds up words in every line, prints final word count
    private void printWordCount() {
        node p = n;
        int wordCount = 0;

        while (p != null) {
            wordCount += p.item.split(" ").length;
            p = p.next;
        }

        System.out.println(wordCount + " words");
    }

    // Move clipboard node to cursor position
    private void paste() {
        // Remove node from current position
        if (clipboard.prev != null) {
            clipboard.prev.next = clipboard.next;
        } else {
            n = n.next;
        }

        if (clipboard.next != null) {
            clipboard.next.prev = clipboard.prev;
        }

        // Adds node to new position
        node p = cursor.prev;

        cursor.prev = clipboard;

        if (p != null) {
            p.next = clipboard;
        }

        clipboard.next = cursor;
        clipboard.prev = p;

        // Resets n to start of linked-list
        if (n.prev != null) {
            n = n.prev;
        }
    }

    // move the cursor to the end of the linked list
    private void pointBottom() {
        while (cursor.next != null) {
            cursor = cursor.next;
        }
    }

    // Prompts user to save a file and writes linked list to the file
    private void saveFile() {
        ASCIIOutputFile out = new ASCIIOutputFile();

        node p = n;

        while (p != null) {
            out.writeLine(p.item);
            p = p.next;
        }
    }

    // Prints help text to console
    private void showHelp() {
        System.out.println("u: up,\td: down,\ti[text]: insert line,\tr: reload file,\tt: top,\th: help,");
        System.out.println("x: cut,\tv: paste,\te[new text]: edit line,\tb: bottom,\ts: save buffer,");
        System.out.println("c: current,\tp: print buffer,\t?[text]: search for text,\tq: quit");
    }

    // Iterates through linked list and prints every line to console
    private void printBuffer() {
        System.out.println("====================");

        node p = n;

        while (p != null) {
            if (p == cursor) {
                System.out.print(">");
            } else {
                System.out.print("]");
            }

            System.out.println(p.item);
            p = p.next;
        }

        System.out.println("====================");
    }

    private void loadText(ASCIIDataFile in) {
        node p = null; // points to the end of the linked list

        while (true) {
            String line = in.readLine();
            if (in.isEOF()) { break; }

            if (p == null) {
                n = new node(line, null, null);
                cursor = n;
                p = n;
            } else {
                p.next = new node(line, p, null);
                p = p.next;
            }
        }
    }

    public static void main(String[] args) { new editor(); }
}
