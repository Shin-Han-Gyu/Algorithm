import java.io.*;
import java.util.*;

//Boj 
public class Main {
    static int K, N, M, ans;
    static boolean[] isPrime = new boolean[1001];
    static int pi(String a) {
        return Integer .parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = pi(br.readLine());
        ArrayList<Integer> arr = new ArrayList<>();
        ArrayList<Integer> arr1 = new ArrayList<>();
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for(int i=2; i<Math.sqrt(1001)+1; ++i) {
            if(isPrime[i]) {
                for(int j=i+i; j<1001; j+=i) {
                    isPrime[j] = false;
                }
            }
        }
        for(int i=2; i<1001; ++i) {
            if(isPrime[i]) {
                arr.add(i);
            }
        }
        for(int i=0; i<arr.size()-1; ++i) {
            arr1.add(arr.get(i)*arr.get(i+1));
        }

        for(int i=0; i<arr1.size(); ++i) {
            if(arr1.get(i)>N) {
                System.out.println(arr1.get(i));
                return;
            }
        }

    }

}