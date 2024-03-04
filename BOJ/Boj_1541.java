import java.io.*;
import java.util.*;

//Boj 1541 silver2
public class Main {
    static int N, M, K, T, Ans;
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String A = br.readLine();
        Queue<String> q = new LinkedList<>();
        int chk = 0;
        for(int i=1; i<A.length(); ++i) {
            if(A.charAt(i) == '-' || A.charAt(i) == '+') {
                q.add(A.substring(chk, i));
                q.add(A.substring(i, i+1));
                chk = ++i;
            }
        }
        q.add(A.substring(chk));

        while(!q.isEmpty()) {
            String temp = q.poll();

            if(temp.equals("+")) {
                continue;
            }
            else if(temp.equals("-")) {
                int sum = 0;
                while(!q.isEmpty() && !q.peek().equals("-")) {
                    String temp1 = q.poll();
                    if(temp1.equals("+")) {
                        continue;
                    }
                    else {
                        sum += pi(temp1);
                    }
                }
                Ans -= sum;
            }
            else {
                Ans += pi(temp);
            }
        }
        System.out.println(Ans);
    }

}