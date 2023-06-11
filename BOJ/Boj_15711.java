import java.io.*;
import java.util.*;

//Boj 15711 gold3
public class Solution {
    static int K, N, M, ans;
    static boolean[] isPrime = new boolean[2000001];
    static ArrayList<Integer> prime = new ArrayList<>();
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        K = pi(br.readLine());
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for(int i=2; i<2000001; ++i) {
            if(isPrime[i]) {
                prime.add(i);
                for(int j=i+i; j<2000001; j+=i) {
                    isPrime[j] = false;
                }
            }
        }


        for(int k=0; k<K; ++k) {
            String[] temp = br.readLine().split(" ");
            long chk = Long.parseLong(temp[0]) + Long.parseLong(temp[1]);

            if(chk<4) {
                sb.append("NO\n");
                continue;
            }
            if(chk%2==0) {
                sb.append("YES\n");
                continue;
            }
            if(find(chk)) {
                sb.append("YES\n");
            }
            else {
                sb.append("NO\n");
            }

        }
        System.out.print(sb);

    }

    static boolean find(long a) {
        if(a-2<2000001) {
            int temp = (int)a-2;
            if(isPrime[temp]) {
                return true;
            }
            else {
                return false;
            }
        }
        for(Integer i : prime) {
            if((a-2)%i==0) {
                return false;
            }
        }
        return true;
    }

}