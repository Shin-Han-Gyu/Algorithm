import java.io.*;
import java.util.*;

//Boj 11866 silver5
public class Solution {
    static int K, N, M, ans;
    static long Ans;
    static int pi(String a) {
        return Integer .parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] A = br.readLine().split(" ");
        N = pi(A[0]);
        K = pi(A[1]);

        int temp = K-1;
        ArrayList<Integer> a = new ArrayList<>();
        for(int i=1; i<N+1; i++) {
            a.add(i);
        }
        sb.append("<");
        while(true)
        {
            sb.append(String.format("%d", a.get(temp)));
            a.remove(temp);
            if(a.size()==0)
            {
                sb.append(">");
                break;
            }
            else
            {
                sb.append(", ");
                temp+=K-1;
                temp%=a.size();
            }
        }

        System.out.println(sb);
    }

}
