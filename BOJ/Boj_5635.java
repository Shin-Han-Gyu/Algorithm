import java.io.*;
import java.util.*;

//Boj 5635
public class Solution {
    static int K, N, M, ans;
    static int pi(String a) {
        return Integer .parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] Ans = new String[2];
        int[] chk = new int[2];
        N = pi(br.readLine());
        String[] temp = br.readLine().split(" ");
        if(N==1) {
            System.out.println(temp[0]+"\n"+temp[0]);
        }
        Ans[0] = temp[0];
        Ans[1] = temp[0];
        chk[0] = day(temp);
        chk[1] = day(temp);

        temp = br.readLine().split(" ");
        if(chk[0]>day(temp)) {
            chk[1] = day(temp);
            Ans[1] = temp[0];
        }
        else {
            chk[0] = day(temp);
            Ans[0] = temp[0];
        }

        for(int i=0; i<N-2; ++i) {
            temp = br.readLine().split(" ");
            if(day(temp)<chk[1]) {
                chk[1] = day(temp);
                Ans[1] = temp[0];
            }
            if(day(temp)>chk[0]) {
                chk[0] = day(temp);
                Ans[0] = temp[0];
            }
        }

        System.out.println(Ans[0]+"\n"+Ans[1]);
    }
    static int day(String[] temp) {
        return pi(temp[3])*10000+pi(temp[2])*100+pi(temp[1]);
    }

}