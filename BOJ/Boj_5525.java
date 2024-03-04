import java.io.*;
import java.util.*;

//Boj 5525 silver1
public class Main {
    static int N, M, K, T, Ans;
    static Set<Integer> s = new TreeSet<>();
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = pi(br.readLine());
        M = pi(br.readLine());

        String S = br.readLine();
        int chk =0;
        for(int i=1; i<M-1;) {
            if(S.charAt(i)=='O' && S.charAt(i+1)=='I') {
                ++chk;
                if(chk==N) {
                    if(S.charAt(i-(chk*2-1))=='I') {
                        ++Ans;
                    }
                    --chk;
                }
                i+=2;
            }
            else {
                chk = 0;
                ++i;
            }

        }
        System.out.println(Ans);

    }

}