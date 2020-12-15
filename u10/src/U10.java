import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class U10 {
    public static void main(String[] args) {
        powersOfTwo().limit(10).forEach(System.out::println);
        getCharStream("Hallo Welt!").forEach(System.out::println);

        System.out.println(Arrays.toString(getPos("banana", 'a')));

        /*long current = System.nanoTime();
        System.out.println(current+"ms");
        System.out.println(isPrime(100000000000000181L));
        //2365193700ms seriell
        //374501600ms parallel
        System.out.println(System.nanoTime()-current+"ms");*/

        getFactors(12).forEach(System.out::println);
        System.out.println(Arrays.toString(uniq(new int[]{5, 2, 7, 7, 2, 9, 3, 3, 3, 2})));
        binaryNumbers().limit(10).forEach(System.out::println);
    }
    public static IntStream powersOfTwo() {
        return IntStream.range(0,30).map(n -> (int) Math.pow(2,n));
    }
    public static void testStream(IntStream stream, int num) {
        stream.limit(num).forEach(System.out::println);
    }
    public static int[] toArray(ArrayList<Integer> list) {
        return list.stream().mapToInt(i->i).toArray();
    }
    public static double[] getRandNumbers(int cnt) {
        return Stream.generate(new Random()::nextDouble).limit(cnt).mapToDouble(d->d).toArray();
    }
    public static Stream<Character> getCharStream(String s) {
        return s.chars().mapToObj(n -> (char)n);
    }
    public static int getMax(int[] arr) {
        return Arrays.stream(arr).parallel().max().orElse(0);
    }
    public static int[] getPos(String x, char c) {
        return IntStream.range(0,x.length()).filter(n -> x.charAt(n)==c).toArray();
    }
    public static boolean isPrime(long z) {
        return LongStream.rangeClosed(2, (long) Math.sqrt(z)).parallel().noneMatch(i -> z%i==0);
    }
    public static IntStream getFactors(int n) {
        return IntStream.rangeClosed(1,n).filter(i->n%i==0);
    }
    public static int[] uniq(int[] x) {
        return IntStream.range(0,x.length).parallel().filter(i->(i==0)||(x[i]!=x[i-1])).map(i->x[i]).toArray();
    }
    public static Stream<String> binaryNumbers() {
        return IntStream.iterate(0,n -> n+1).mapToObj(Integer::toBinaryString);
    }
}
