import java.io.*;
import java.util.*;

//Boj 12107 gold3
public class Main {
    static int N, M, T, ans;
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        N = pi(br.readLine());

        if(N==1) {
            System.out.println("B");
        }
        else {
            System.out.println("A");
        }
       
    }

}