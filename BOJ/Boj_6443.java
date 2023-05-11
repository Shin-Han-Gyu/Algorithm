import java.io.*;
import java.math.*;
import java.util.*;

//Boj 6443 gold5
public class Main {
    static int N, M, K, ans;
    static char[] a;
    static TreeSet<String> s;
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = pi(br.readLine());

        for(int i=0; i<N; ++i) {
            a = br.readLine().toCharArray();
            s = new TreeSet<>();
            Arrays.sort(a);
            StringBuilder sb = new StringBuilder();
            sb.append(new String(a) + "\n");
            while(next_permutation(a.length)) {
                sb.append(new String(a) + "\n");
            }
            System.out.print(sb);
        }
    }
    
    static boolean next_permutation(int n) {
        int idx = n-1;

        while(idx > 0 && a[idx] <= a[idx-1]) {
            --idx;
        }
        if(idx == 0)
            return false;

        for(int i=n-1; i>=idx; --i) {
            if(a[idx-1] < a[i]) {
                char temp = a[i];
                a[i] = a[idx-1];
                a[idx-1] = temp;
                break;
            }
        }

        Arrays.sort(a, idx, n);
        return true;
    }

}