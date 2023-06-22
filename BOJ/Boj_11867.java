import java.io.*;
import java.util.*;

//Boj 11867 silver2
public class Solution {
    static int K, N, M, ans;
    static int pi(String a) {
        return Integer .parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] temp = br.readLine().split(" ");
        N = pi(temp[0]);
        M = pi(temp[1]);

        if(N%2==0 || M%2==0) {
            System.out.println("A");
        }
        else {
            System.out.println("B");
        }
    }

}