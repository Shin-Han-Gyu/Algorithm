import java.io.*;

//Boj
public class Solution {
    static int N, M, K, ans;
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] temp = br.readLine().split(" ");
        N = pi(temp[0]);
        K = pi(temp[1]);

        if(K==0) {
            System.out.println(N);
            return;
        }
        int money = (int) Math.pow(10, K);
        int result = N/money*money;
        if (N%money>=money/2) {
            result += money;
        }
        System.out.println(result);
    }

}