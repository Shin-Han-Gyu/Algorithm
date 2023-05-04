import java.io.*;
import java.util.*;

//Boj 2023 gold5
public class Solution {
    static int N, M, ans;
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = pi(br.readLine());

        awesomePrime(2,1);
        awesomePrime(3,1);
        awesomePrime(5,1);
        awesomePrime(7,1);
    }

    static boolean isPrime(int n) {
        for(int i=2; i<Math.sqrt(n)+1; ++i) {
            if(n%i==0) {
                return false;
            }
        }
        return true;
    }

    static void awesomePrime(int n, int cnt) {
        if(cnt==N) {
            System.out.println(n);
            return;
        }

        for(int i=0; i<10; ++i) {
            int temp = i + n*10;
            if(isPrime(temp)) {
                awesomePrime(temp, cnt+1);
            }
        }
    }
}