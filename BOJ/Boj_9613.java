import java.io.*;
import java.util.*;

//Boj 9613 silver4
public class Solution {
    static int K, N, M, ans;
    static int pi(String a) {
        return Integer .parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = pi(br.readLine());
        for(int i=0; i<N; ++i) {
            String[] temp = br.readLine().split(" ");
            M = pi(temp[0]);
            int[] num = new int[M];
            for (int j=0; j<M; ++j) {
                num[j] = pi(temp[j+1]);
            }
            long Ans = 0;
            for (int j=0; j<M; ++j) {
                for (int k=j+1; k<M; ++k) {
                    Ans += gcd(num[j], num[k]);
                }
            }
            System.out.println(Ans);
        }
    }

    static long gcd(int A, int B){
        int max = Math.max(A, B);
        int min = Math.min(A, B);
        while (true){
            if(max%min==0) {
                break;
            }
            int tmp = min;
            min = max%min;
            max = tmp;
        }
        return min;
    }
}