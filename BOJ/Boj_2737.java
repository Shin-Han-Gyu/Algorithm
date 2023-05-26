import java.io.*;
import java.util.*;

//Boj 2737 gold3
public class Main {
    static int N, M, K, T, ans;
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = pi(br.readLine());

        for(int t=0; t<T; ++t) {
            N = pi(br.readLine())-1;
            ans = 0;
            for (int i=2; N> 0; ++i) {
                N -=i;
                if (N % i == 0) {
                    ++ans;
                }
            }
            System.out.println(ans);
        }

    }

}