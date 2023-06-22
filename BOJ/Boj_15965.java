import java.io.*;
import java.util.*;

//Boj 15965 silver1
public class Solution {
    static int K, N, M, ans;
    static boolean[] isPrime = new boolean[10000001];
    static int pi(String a) {
        return Integer .parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        ArrayList<Integer> arr = new ArrayList<>();
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for(int i=2; i<Math.sqrt(10000001)+1; ++i) {
            if(isPrime[i]) {
                for(int j=i+i; j<10000001; j+=i) {
                    isPrime[j] = false;
                }
            }
        }
        for(int i=2; i<10000001; ++i) {
            if(isPrime[i]) {
                arr.add(i);
            }
        }

        System.out.println(arr.get(pi(br.readLine())-1));

    }

}