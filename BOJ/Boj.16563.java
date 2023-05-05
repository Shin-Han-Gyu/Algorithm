import java.io.*;

//Boj 16563 gold4
public class Solution {
    static int N, M, ans;
    static int[] fact;
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        fact = new int[5000000];
        for(int i=0; i<5000000; ++i) {
            fact[i] = i;
        }
        fact[0] = -1;
        fact[1] = -1;
        for(int i=2; i<(int)Math.sqrt(5000000); ++i) {
            if(fact[i]==i) {
                for(int j=i*2; j<5000000; j+=i) {
                    if(fact[j]==j) {
                        fact[j] = i;
                    }
                }
            }
        }
        
        N = pi(br.readLine());
        String[] temp = br.readLine().split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; ++i) {
            int num = pi(temp[i]);
            if(num==1 || fact[num]==num) {
                sb.append(num +" \n");
                continue;
            }
            String a = "";
            while(num>1) {
                a += fact[num] + " ";
                num /= fact[num];
            }

            sb.append(a.substring(0, a.length()-1) + "\n");
        }

        System.out.print(sb);

    }

}