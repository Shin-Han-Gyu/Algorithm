import java.io.*;
import java.util.*;

//Boj 11597 silver5
public class Main {
    static int K, N, M, ans;

    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = pi(br.readLine());
        int[] stud = new int[N];
        for(int i=0; i<N; ++i) {
            stud[i] = pi(br.readLine());
        }
        int min = Integer.MAX_VALUE;
        Arrays.sort(stud);
        for(int i=0; i<N/2; ++i) {
            min = Math.min(min, stud[i] + stud[N-i-1]);
        }
        System.out.println(min);
    }

}