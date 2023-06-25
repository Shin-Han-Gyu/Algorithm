import java.io.*;
import java.util.*;

//Boj 16120 gold4
public class Solution {
    static int K, N, M, ans;
    static int pi(String a) {
        return Integer .parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String A = br.readLine();
        int chk = 0;
        for(int i=0; i<A.length(); ++i) {
            if (A.charAt(i) == 'P'){
                ++chk;
                continue;
            }
            if (chk >= 2 && i<A.length()-1 && A.charAt(i+1) == 'P') {
                --chk;
                ++i;
            }
            else {
                System.out.println("NP");
                return;
            }
        }

        if (chk==1) {
            System.out.println("PPAP");
        }
        else {
            System.out.println("NP");
        }

    }

}