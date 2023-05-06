import java.io.*;

//Boj 1612 gold5
public class Solution {
    static int N, K, ans;
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = pi(br.readLine());
        long chk = 1;
        ans = 1;
        if (N%2 == 0 || N%5 == 0) {
            System.out.println(-1);
        }
        else {
            while (chk % N != 0) {
                ++ans;
                chk = (chk % N) * 10 + 1;
            }
            System.out.println(ans);
        }
    }

}