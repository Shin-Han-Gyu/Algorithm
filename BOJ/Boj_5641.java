import java.io.*;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//Boj 5641 gold5
public class Solution {
    static int N, M, K, ans;
    static boolean[][] visit;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static boolean[] isPrime;
    static char[][] map;
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        isPrime = new boolean[8010];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for(int i=2; i<(int)Math.sqrt(8010); ++i) {
            if(isPrime[i]) {
                for(int j=i+i; j<8010; j+=i) {
                    isPrime[j] = false;
                }
            }
        }

        while(true) {
            String[] temp = br.readLine().split(" ");
            N = pi(temp[0]);
            K = pi(temp[1]);
            if(N==0) {
                break;
            }
            int chkPrime=-1;
            for(int i=K+1; i<8010; ++i) {
                boolean flag = true;
                for(int j=2; j<K+1; ++j) {
                    if(isPrime[j]) {
                        if(i%j!=0 && (i+2)%j!=0) {
                            continue;
                        }
                        else {
                            flag = false;
                            break;
                        }
                    }
                }
                if(flag) {
                    chkPrime = i;
                    break;
                }
            }

            BigInteger t = new BigInteger("1");

            for(int i=2; i<K+1; ++i) {
                if(isPrime[i]) {
                    t = t.multiply(new BigInteger(String.valueOf(i)));
                }
            }
            String c = "%d%0"+(N-t.toString().length())+"d\n";
            System.out.printf(c, t, chkPrime);
        }

    }

}