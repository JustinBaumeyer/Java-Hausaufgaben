package code;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;

public class Huffman {
    /**
     * Die Datei f wird eingelesen und der zu entschlüsselnde Text wird mit hilfe der Dekodier-Tabelle entschlüsselt
     *
     * @param f Datei mit verschlüsseltem Text und Dekodier-Tabelle
     * @return Entschlüsselter Text
     * @throws IllegalArgumentException Es wird eine IllegalArgumentException geworfen, wenn die Datei f nicht das richtige Format hat.
     * @throws RuntimeException         Es wird eine RuntimeException geworfen, falls beim Laden der Datei ein Fehler auftritt.
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

        //Jeder Buchstabe wird mit seiner Kodierung in einer HashMap gespeichert.
        HashMap<String, Character> values = new HashMap<>();
        for (int i = 1; i < lines.size(); i++) {
            values.put(lines.get(i), i == lines.size() - 1 ? (' ') : ((char) ('A' + i - 1)));
        }

        //Jeder Character im verschluesselten Text wird durchgegangen und zu current hinzugefuegt.
        // Wenn ein Buchstabe mit dem aktuellen Wert von current kodiert ist,
        // wird der entsprechende Buchstabe hinzugefuegt und current zurueckgesetzt.
        String current = "";
        for (char c : encrypted) {
            current += c;
            if (values.containsKey(current)) {
                result.append(values.get(current));
                current = "";
            }
        }
        return result.toString();
    }
}
