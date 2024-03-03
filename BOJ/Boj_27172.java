import java.io.*;
import java.util.*;

//Boj 27172 gold5
public class Main {
    static int N, M, K, T;
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = pi(br.readLine());
        int[] player = new int[N];
        boolean[] card = new boolean[1000001];
        int[] ans = new int[1000001];
        String[] a = br.readLine().split(" ");
        for(int i=0; i<N; ++i) {
            player[i] = pi(a[i]);
            card[player[i]] = true;
        }

        for(Integer i : player) {
            for(int j=i+i; j<1000001; j+=i) {
                if(card[j]) {
                    ++ans[i];
                    --ans[j];
                }
            }
        }
        for(int i=0; i<N; ++i) {
            System.out.print(ans[player[i]] + " ");
        }
    }

}