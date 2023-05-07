import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

//Boj 1153 gold3
public class Solution {
    static int N, K, ans;
    static boolean[] isPrime;
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = pi(br.readLine());
        isPrime = new boolean[1000000];
        Arrays.fill(isPrime, true);
        ArrayList<Integer> prime = new ArrayList<>();
        isPrime[0] = false;
        isPrime[1] = false;

        for(int i=2; i<(int)Math.sqrt(1000000); ++i) {
            if(isPrime[i]) {
                prime.add(i);
                for(int j=i+i; j<1000000; j+=i) {
                    isPrime[j] = false;
                }
            }
        }
        String a = "";
        if(N%2==0) {
            N-=4;
            a = 2 + " " + 2 + " ";
        }
        else {
            N-=5;
            a = 2 + " " + 3 + " ";
        }
        if(N<4) {
            System.out.println(-1);
            return;
        }

        int prime1=2;
        int idx = 0;
        while(true) {
            if(isPrime[N-prime1]) {
                a +=prime1 + " " + (N-prime1);
                break;
            }
            else {
                prime1 = prime.get(++idx);
            }
        }
        System.out.println(a);

    }

}