import java.io.*;
import java.util.*;

//Boj 2417 
public class Main {
    static int N, M, T, ans;
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        long n = Long.parseLong(br.readLine());

        long Ans = (long)Math.sqrt(n);
        if((Ans*Ans) < n) {
            ++Ans;
        }

        System.out.println(Ans);
       
    }

}