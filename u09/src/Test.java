import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Test {
    public static void main(String[] args) {
        System.out.println(kombinationAusPrimzahlen(7));
    }
    public static long fakultaet(int n) {
        return n < 2 ? 1 : fakultaet(n-1)*n;
    }
    public static long fibonacci(int n) {
        return n < 2 ? n : fibonacci(n-2) + fibonacci(n-1);
    }
    public static long summe(long anfang, long ende) {
        return anfang + (anfang==ende? 0 : Test.summe(anfang+1,ende));
    }
    public static int ggt(int a, int b) {
        if(a==b) return a;
        if(a>b) return ggt(a-b,b);
        return ggt(a,b-a);
    }
    public static long getPascalWert(int n, int k) {
        return fakultaet(n) / (fakultaet(k) * fakultaet(n-k));
    }
    public static void rekursiveAusgabe(int n) {
        if(n==0) {
            return;
        } else {
            rekursiveAusgabe(n/10);
        }
        System.out.println(n%10);
    }
    public static String umkehren(String s) {
        return s.length()==0?"":s.charAt(s.length()-1) + umkehren(s.substring(0,s.length()-1));
    }

    public static void geldautomat1(int betrag) {
        int[] scheine = {500,200,100,50,20,10,5};
        int n;
        for(int schein : scheine) {
            n = betrag / schein;
            if(n > 0) {
                System.out.println(n + " * " + schein);
                betrag-= n*schein;
            }
        }
    }
    public static ArrayList<Integer> geldautomat2(int betrag) {
        ArrayList<Integer> out = new ArrayList<>();
        int[] scheine = {500,200,100,50,20,10,5};
        int n;
        for(int schein : scheine) {
            n = betrag / schein;
            if(n > 0) {
                IntStream.range(0,n).forEach(value -> {out.add(schein);});
                betrag-= n*schein;
            }
        }
        return out;
    }
    public static int[] geldautomat3(int betrag) {
        int[] scheine = {500,200,100,50,20,10,5};
        int[] out = new int[scheine.length];
        int n;
        for(int i = 0; i < scheine.length;i++) {
            n = betrag / scheine[i];
            if(n > 0) {
                for(int j = 0; j < n;j++) {
                    out[i]++;
                }
                betrag-= n*scheine[i];
            }
        }
        return out;
    }
    private static int kombinationAusPrimzahlen(int n) {
        int max = 0;
        for(int i = 1; i < n;i++) {
            if(isSumOfKprimes(n,i)) max = i;
        }
        return max;
    }
    public static boolean isSumOfKprimes(int N,int K) {
        if (N < 2*K)
            return false;
        if (K == 1)
            return isPrime(N);

        if (K == 2)
        {
            if (N%2 == 0)
                return true;
            return isPrime(N - 2);
        }
        return true;
    }
    public static boolean isPrime(int x) {
        for (int i=2; i*i<=x; i++)
            if (x%i == 0)
                return false;
        return true;
    }

}
