import java.io.*;
import java.util.*;

//Boj 5875 gold3
public class Solution {
    static int N, M, K, ans;
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String temp = br.readLine();
        int chk=0, left=0, right=0;

        for(int i=0; i<temp.length(); ++i) {
            if(temp.charAt(i)=='(') {
                ++chk;
                ++left;
            }
            else {
                --chk;
                ++right;
            }

            if(chk<2) {
                left=0;
            }
            if(chk==-1) {
                ans = right;
                break;
            }
        }

        if(chk>0) {
            ans = left;
        }
        System.out.println(ans);

    }

}