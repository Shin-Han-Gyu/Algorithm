import java.io.*;
import java.util.*;

//Boj 9339 bronze1
public class Main {
    static int K, N, M, ans;
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        M = pi(br.readLine());

        for(int i = 0; i < M; ++i) {
            K = pi(br.readLine());
            Set<String> stud = new HashSet<>();
            String[] str = br.readLine().split(" ");
            for(int j = 0; j < K; ++j) {
                stud.add(str[j]);
            }
            N = pi(br.readLine());
            ans = 0;
            int[] st = new int[2];
            st[1] = 987654321;
            for(int j = 0; j < N; ++j) {
                String[] a = br.readLine().split(" ");
                int chk = pi(a[1])*60 + pi(a[2]);
                if(stud.contains(a[0]) && chk<361 && chk>0) {
                    ++ans;
                    if(chk<st[1]) {
                        st[0] = pi(a[0]);
                        st[1] = chk;
                    }
                }
            }
            System.out.println(st[0] + " " + ans);

        }
    }
}
