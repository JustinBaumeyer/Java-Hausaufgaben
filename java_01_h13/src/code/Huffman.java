package code;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Collections;
import java.util.List;

public class Huffman {
    public static String decode(File f) {
        StringBuilder result = new StringBuilder();
        List<String> lines = Collections.emptyList();
        try {
            lines = Files.readAllLines(f.toPath(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (lines.size() != 28)
            throw new IllegalArgumentException("Die Datei entspricht nicht dem gewünschten Dateiformat!");

        char[] encrypted = lines.get(0).toCharArray();
        Node root = buildTree(lines.subList(1, lines.size()));

        Node current = root;
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

        public Node getLeft(boolean create) {
            if (create && left == null) this.left = new Node(null, null);
            return left;
        }

        public Node getRight(boolean create) {
            if (create && right == null) this.right = new Node(null, null);
            return right;
        }

        private boolean isLeaf() {
            return (this.getLeft(false) == null) && (this.getRight(false) == null);
        }
    }

    private static Node buildTree(List<String> list) {
        Node root = new Node(null, null);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() > 0) {
                String code = list.get(i);
                Node current = root;
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
