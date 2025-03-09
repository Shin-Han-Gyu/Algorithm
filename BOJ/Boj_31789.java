import java.io.*;
import java.util.*;

//Boj 31789 bronze3
public class Main {
    static int K, N, M, ans;
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = pi(br.readLine());
        String[] temp = br.readLine().split(" ");
        int money = pi(temp[0]), attack =  pi(temp[1]);

        for(int i=0; i<N; ++i) {
            temp = br.readLine().split(" ");
            if(attack<pi(temp[1]) && pi(temp[0])<=money) {
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");


    }

}