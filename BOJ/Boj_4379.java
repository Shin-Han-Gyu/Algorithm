import java.io.*;
import java.math.*;
import java.util.*;

//Boj 4379 gold4
public class Solution {
    static int N, M, K, ans;
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer st = new StreamTokenizer(new InputStreamReader(System.in));
        while(true) {
            if (st.nextToken() != -2) {
                break;
            }
            BigInteger t = BigInteger.valueOf((int) st.nval);
            if (st.nextToken() != -2) {
                break;
            }
            int a = (int) st.nval;
            if (st.nextToken() != -2) {
                break;
            }
            int b = (int) st.nval;
            String temp = String.format("(%s^%d-1)/(%s^%d-1) ", t,a,t,b);
            if(t.toString().equals("1") || a%b!=0) {
                System.out.println(temp + "is not an integer with less than 100 digits.");
                continue;
            }

            BigInteger chk = new BigInteger("10").pow(100);
            BigInteger t1 = new BigInteger("1");
            for (int i=0; i<b; ++i){
                t1 = t1.multiply(t);
                if (t1.compareTo(chk) >= 0) {
                    break;
                }
            }
            BigInteger t2 = new BigInteger("1");
            BigInteger c = BigInteger.valueOf(0);
            for (int i=0; i<a; i+=b) {
                c = c.add(t2);
                if (c.compareTo(chk) >= 0) {
                    break;
                }
                t2 = t2.multiply(t1);
            }
            if (c.compareTo(chk) >= 0) {
                System.out.println(temp + "is not an integer with less than 100 digits.");
            }
            else {
                System.out.println(temp + c);
            }

        }

    }

}