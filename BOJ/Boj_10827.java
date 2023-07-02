import java.io.*;
import java.math.BigDecimal;
import java.util.*;

//Boj 10827 gold5
public class Solution {
    static int K, N, M, ans;
    static int pi(String a) {
        return Integer .parseInt(a);
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] temp = br.readLine().split(" ");

        BigDecimal a = new BigDecimal(temp[0]);
        N = pi(temp[1]);
        a = a.pow(N);
        System.out.println(a.toPlainString());
        
    }

}