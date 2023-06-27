import java.io.*;
import java.util.*;

//Boj 1701 gold3
public class Solution {
    static int K, N, M, ans;
    static int pi(String a) {
        return Integer .parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String temp = br.readLine();
        for(int i=0; i<temp.length(); ++i) {
            int chk = 0;
            String str = temp.substring(i);

            int[] a = new int[str.length()];

            for(int j=1; j<str.length(); ++j){
                while(chk>0 && str.charAt(chk) != str.charAt(j)){
                    chk = a[chk - 1];
                }

                if(str.charAt(chk) == str.charAt(j)){
                    chk += 1;
                }

                a[j] = chk;
                ans = Math.max(ans, a[j]);
            }
        }

        System.out.println(ans);
    }

}