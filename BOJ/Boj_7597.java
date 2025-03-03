import java.io.*;
import java.util.*;

//Boj 7597 bronze1
public class Main {
    static int K, N, M, ans;
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String line = br.readLine();
            int A=0,B=0;
            if (line.equals("#")) {
                break;
            }
            int chk_A=0, chk_B=0;
            for(int i=0;i<line.length();i++) {
                char c = line.charAt(i);
                if(c=='A') {
                    chk_A++;
                }
                else if(c=='B') {
                    chk_B++;
                }

                if((chk_A==4 && chk_B<3) || (chk_A>3 && chk_A - chk_B==2)) {
                    ++A;
                    chk_A=0;
                    chk_B=0;
                }

                if((chk_B==4 && chk_A<3) || (chk_B>3 && chk_B - chk_A==2)) {
                    ++B;
                    chk_A=0;
                    chk_B=0;
                }
            }
            sb.append("A " + A + " B " + B + "\n");
        }
        System.out.println(sb.toString());
    }
}
