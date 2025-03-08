import java.io.*;
import java.util.*;

//Boj 17988 silver4
public class Main {
    static int K, N, M, ans;
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        String a =  br.readLine();
        String s = br.readLine();
        Set<String> result = new TreeSet<>();
        generateLevenshteinDistanceOne(a, s, result);

        for (String word : result) {
            sb.append(word+"\n");
        }
        System.out.println(sb);
    }

    private static void generateLevenshteinDistanceOne(String alphabet, String s, Set<String> result) {
        int n = s.length();

        for (int i = 0; i < n; i++) {
            for (char c : alphabet.toCharArray()) {
                if (c != s.charAt(i)) {
                    String modified = s.substring(0, i) + c + s.substring(i + 1);
                    result.add(modified);
                }
            }
        }

        for (int i = 0; i <= n; i++) {
            for (char c : alphabet.toCharArray()) {
                String modified = s.substring(0, i) + c + s.substring(i);
                result.add(modified);
            }
        }

        for (int i = 0; i < n; i++) {
            String modified = s.substring(0, i) + s.substring(i + 1);
            result.add(modified);
        }
    }

}