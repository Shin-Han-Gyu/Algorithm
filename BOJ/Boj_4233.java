import java.io.*;
import java.util.*;

//Boj 4233 gold5
public class Main {
    static int K, N, M, ans;
    static long Ans;
    static int pi(String a) {
        return Integer .parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            String[] temp = br.readLine().split(" ");
            if(temp[0].equals("0")) {
                return;
            }
            long p = Long.parseLong(temp[0]);
            long a = Long.parseLong(temp[1]);
            if(!isPrime(p) && chk(a,p,p)==a) {
                System.out.println("yes");
            }
            else {
                System.out.println("no");
            }

        }
    }

    static boolean isPrime(long num) {
        if(num<2) {
            return false;
        }
        for(int i=2; i*i<num+1; ++i) {
            if(num%i==0) {
                return false;
            }
        }
        return true;
    }

    static long chk(long a, long num, long m) {
        long ret = 1;
        while(num>0) {
            if((num & 1)>0) {
                ret = ret*a%m;
            }
            a = a*a%m;
            num >>= 1;
        }
        return ret;
    }
}