package code;

import java.io.File;

public class Test {
    public static void main(String[] args) {
        System.out.println(Huffman.decode(new File("message.txt")));
    }
}
