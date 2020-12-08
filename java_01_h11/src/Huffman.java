import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Huffman {
    public static void main(String[] args) {
        try {
            System.out.println(decode(new File("message.txt")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static String decode(File f) throws FileNotFoundException {
        ArrayList<String> lines = new ArrayList<>();
        Scanner scanner = new Scanner(f);
        while(scanner.hasNextLine()) {
            lines.add(scanner.nextLine());
        }

        if(lines.size() != 28) throw new IllegalArgumentException("Die Datei hat das falsche Format!");
        Map<String,Character> map= new HashMap<>();
        String toDecode = lines.get(0);
        for(int i =1; i < lines.size()-1;i++) {
            map.put(lines.get(i),(char)(64+i));
        }
        toDecode = toDecode.replace(lines.get(lines.size()-1)," ");
        for (Map.Entry<String, Character> entry : map.entrySet()) {
            toDecode = toDecode.replace(entry.getKey(), entry.getValue().toString());
        }
        System.out.println(map);
        return toDecode;
    }
}
