import java.io.*;
import java.util.*;

//Boj 11502 silver4
public class Main {
    static int N, M, K, T;
    static long ans;
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = pi(br.readLine());
        ans = 1;
        boolean[] isPrime = new boolean[1001];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        ArrayList<Integer> Prime = new ArrayList<>();
        for(int i=2; i<Math.sqrt(1001); ++i) {
            if(isPrime[i]) {
                for(int j=i+i; j<1001; j+=i) {
                    isPrime[j] = false;
                }
            }
        }
        for(int i=3; i<1001; ++i) {
            if(isPrime[i]) Prime.add(i);
        }

        for(int t=0; t<T; ++t) {
            N = pi(br.readLine());

            if(isPrime[N-4]) {
                System.out.println("2 2 "+(N-4));
                continue;
            }

            for(Integer i : Prime) {
                boolean chk = false;
                for(Integer j : Prime) {
                    if(i>j || N-i-j<3) {
                        continue;
                    }
                    if(isPrime[N-i-j]) {
                        System.out.println(i + " " + j + " " + (N-i-j));
                        chk = true;
                        break;
                    }
                }
                if(chk) {
                    break;
                }
            }


        }

    }

}