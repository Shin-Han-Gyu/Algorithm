import java.io.*;
import java.util.*;

//Boj 12931 gold5
public class Solution {
    static int N, M, K, ans;
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = pi(br.readLine());
        int[] num = new int[N];
        String[] temp = br.readLine().split(" ");

        int sum = 0;
        for(int i=0; i<N; ++i) {
            num[i] = pi(temp[i]);
            sum += num[i];
        }


        while(sum!=0) {
            int chk=0;
            for(int i=0; i<num.length; ++i) {
                if(num[i]%2==1) {
                    --num[i];
                    ++chk;
                }
            }

            if(chk!=0) {
                sum -= chk;
                ans += chk;
            }
            else {
                for(int i=0; i<num.length; ++i) {
                    num[i]/=2;
                }
                sum/=2;
                ++ans;
            }
        }
        System.out.println(ans);


    }

}