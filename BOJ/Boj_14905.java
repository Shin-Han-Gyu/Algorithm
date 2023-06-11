import java.io.*;
import java.util.*;

//Boj 15711 gold3
public class Solution {
    static int K, N, M, ans;
    static boolean[] isPrime = new boolean[50000001];
    static ArrayList<Integer> prime = new ArrayList<>();
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for(int i=2; i<25000001; ++i) {
            if(isPrime[i]) {
                prime.add(i);
                for(int j=i+i; j<50000001; j+=i) {
                    isPrime[j] = false;
                }
            }
        }
        while(true) {
            try{
                N = pi(br.readLine());
                if(N<8) {
                    sb.append("Impossible.\n");
                    continue;
                }
                if(N%2==0) {
                    sb.append("2 2 ");
                    N-=4;
                }
                else {
                    sb.append("2 3 ");
                    N-=5;
                }
                if(N==4) {
                    sb.append("2 2\n");
                    continue;
                }
                else {
                    for(int i=3; i<N/2+1; i+=2) {
                        if(isPrime[i] && isPrime[N-i]) {
                            sb.append(i + " " + (N-i)+ "\n");
                            break;
                        }
                    }
                }
            }
            catch (Exception e) {
                break;
            }

        }

        System.out.print(sb);

    }


}