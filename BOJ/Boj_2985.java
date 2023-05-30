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
        M = pi(temp[1]);
        K = pi(temp[2]);

        if(N+M==K) {
            System.out.printf("%d+%d=%d",N,M,K);
        }
        else if(N==M+K) {
            System.out.printf("%d=%d+%d",N,M,K);
        }
        else if(N-M==K) {
            System.out.printf("%d-%d=%d",N,M,K);
        }
        else if(N==M-K) {
            System.out.printf("%d=%d-%d",N,M,K);
        }
        else if(N/M==K) {
            System.out.printf("%d/%d=%d",N,M,K);
        }
        else if(N==M/K) {
            System.out.printf("%d=%d/%d",N,M,K);
        }
        else if(N*M==K) {
            System.out.printf("%d*%d=%d",N,M,K);
        }
        else if(N==M*K) {
            System.out.printf("%d=%d*%d",N,M,K);
        }
    }

}