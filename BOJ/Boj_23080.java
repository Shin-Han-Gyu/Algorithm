import java.io.*;
import java.util.*;

//Boj 23080 bronze3
public class Main {
    static int K, N, M, ans;
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        K = pi(br.readLine());
        String word =  br.readLine();

        StringBuilder resolve = new StringBuilder();

        for(int i=0; i<word.length(); i+=K) {
            resolve.append(word.charAt(i));
        }
        System.out.println(resolve);

    }

}