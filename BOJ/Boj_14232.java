import java.io.*;
import java.util.*;

//Boj 14232 silver1
public class Solution {
    static int N, M, K, ans;
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        long n = Long.parseLong(br.readLine());

        int chk = 2;
        ArrayList<Long> arr = new ArrayList<>();
        while(n!=1) {
            if (chk>=1000000) {
                arr.add(n);
                break;
            }
            if (n%chk == 0) {
                n/=chk;
                arr.add((long)chk);
            }
            else {
                chk++;
            }
        }
        System.out.println(arr.size());
        for(Long i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();

    }

}