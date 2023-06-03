import java.io.*;
import java.util.*;

//Boj 1111 gold3
public class Solution {
    static int N, M, K, ans;
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = pi(br.readLine());
        int[] a = new int[N];
        String[] temp = br.readLine().split(" ");
        for(int i=0; i<N; ++i) {
            a[i] = pi(temp[i]);
        }

        if(N==1 ||(N==2 && a[0]!=a[1])) {
            System.out.println("A");
            return;
        }
        if(N==2 && a[0]==a[1]) {
            System.out.println(a[0]);
            return;
        }
        int A=0;
        if(a[1]-a[0]!=0) {
            A = (a[2]-a[1])/(a[1]-a[0]);
        }

        int B = a[1]-a[0]*A;

        for(int i=1; i<N; ++i) {
            if(a[i]!=a[i-1]*A+B) {
                System.out.println("B");
                return;
            }
        }

        System.out.println(a[N-1]*A+B);
    }

}