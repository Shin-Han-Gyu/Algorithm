import java.io.*;

//Boj 4370 gold4
public class Solution {
    static int N, M, K, ans;
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            try {
                N = pi(br.readLine());
            }
            catch (Exception e) {
                break;
            }
            int chk = 1;
            while(true) {
                chk*=9;
                if(chk>=N) {
                    sb.append("Baekjoon wins.\n");
                    break;
                }
                chk*=2;
                if(chk>=N) {
                    sb.append("Donghyuk wins.\n");
                    break;
                }
            }

        }
        System.out.print(sb);
    }

}