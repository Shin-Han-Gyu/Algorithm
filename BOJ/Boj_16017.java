import java.io.*;
import java.util.*;

//Boj 16017
// https://www.acmicpc.net/problem/16017
public class Main {
    static int K, N, M, ans;
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] chk = new int[4];

        for(int i=0; i<4; ++i) {
            chk[i] = pi(br.readLine());
        }

        if(chk[0] != 9 && chk[0]!=8) {
            System.out.println("answer");
            return;
        }
        if(chk[1]!=chk[2]) {
            System.out.println("answer");
            return;
        }

        if(chk[3] != 9 && chk[3]!=8) {
            System.out.println("answer");
        }
        else {
            System.out.println("ignore");
        }
    }

}