package code;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Collections;
import java.util.List;

public class Huffman {
    /**
     * Die Datei f wird eingelesen und der zu entschlüsselnde Text wird mit hilfe der Dekodier-Tabelle entschlüsselt
     * @param f Datei mit verschlüsseltem Text und Dekodier-Tabelle
     * @return Entschlüsselter Text
     * @throws IllegalArgumentException Es wird eine IllegalArgumentException geworfen, wenn die Datei f nicht das richtige Format hat.
     * @throws RuntimeException Es wird eine RuntimeException geworfen, falls beim Laden der Datei ein Fehler auftritt.
     */
    public static String decode(File f) {
        StringBuilder result = new StringBuilder();
        List<String> lines;

        //Die Zeilen in der Datei f werden in eine Liste geladen.
        try {
            lines = Files.readAllLines(f.toPath(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Beim Laden der Datei ist ein Fehler aufgetreten");
        }

        //Die Anforderung an die Datei ist, dass sie aus 28 Zeilen besteht
        if (lines.size() != 28)
            throw new IllegalArgumentException("Die Datei entspricht nicht dem gewünschten Dateiformat!");

        char[] encrypted = lines.get(0).toCharArray();
        Node root = buildTree(lines.subList(1, lines.size()));

        Node current = root;
        //Laueft den Baum solange durch, bis die aktuelle Kodierung des Buchstabens an einem Blatt ankommt und fuegt dessen Buchstaben an das Ergebnis hinzu.
        for (char c : encrypted) {
            if (c == '0' && current.getLeft(false) != null) current = current.getLeft(false);
            if (c == '1' && current.getRight(false) != null) current = current.getRight(false);
            if (current.isLeaf()) {
                result.append(current.getChar());
                current = root;
            }
        }
        return result.toString();
    }

    /**
     * Klasse Node fuer die Elemente des Baumes
     */
    private static class Node {
        private char ch;
        private Node left, right;

        public Node(Node left, Node right) {
            this.left = left;
            this.right = right;
        }

        public char getChar() {
            return ch;
        }

        public void setChar(char c) {
            this.ch = c;
        }

        /**
         * @param create Gibt an, ob die Node erstellt werden soll, wenn sie noch nicht existiert.
         * @return Gibt die linke Node zurueck.
         */
        public Node getLeft(boolean create) {
            if (create && left == null) this.left = new Node(null, null);
            return left;
        }

        /**
         * @param create Gibt an, ob die Node erstellt werden soll, wenn sie noch nicht existiert.
         * @return Gibt die rechte Node zurueck.
         */
        public Node getRight(boolean create) {
            if (create && right == null) this.right = new Node(null, null);
            return right;
        }

        /**
         * @return Gibt zurueck, ob die Node ein Blatt ist. Dies ist der Fall, wenn sie selbst keine Kinder hat.
         */
        private boolean isLeaf() {
            return (this.getLeft(false) == null) && (this.getRight(false) == null);
        }
    }

    /**
     * Wandelt die in einer Liste uebergebene Dekodier-Tabelle in einen Baum um, der fuer die Entschluesselung genutzt wird.
     * @param list Dekodier-Tabelle
     * @return Dekodier-Baum
     */
    private static Node buildTree(List<String> list) {
        Node root = new Node(null, null);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() > 0) {
                String code = list.get(i);
                Node current = root;
                //Geht die Kodierung des jeweiligen Buchstaben solange durch, bis man am Blatt angekommen ist und setzt dessen Char auf den jeweiligen Buchsstaben bzw Leerzeichen.
                for (char c : code.toCharArray()) {
                    if (c == '0') current = current.getLeft(true);
                    else if (c == '1') current = current.getRight(true);
                    else throw new IllegalArgumentException();
                }
                current.setChar((list.size() - 1 == i) ? ' ' : (char) ('A' + i));
            }
        }
        return root;
    }
}
