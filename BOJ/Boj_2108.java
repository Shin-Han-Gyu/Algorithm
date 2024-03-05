import java.io.*;
import java.util.*;

//Boj 2108 silver3
public class Main {
    static int N, M, K, T, Ans;
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = pi(br.readLine());
        ArrayList<Integer> A = new ArrayList<>();
        int sum = 0;
        for(int i=0; i<N; ++i) {
            int temp = pi(br.readLine());
            sum += temp;
            A.add(temp);
        }
        System.out.println((int)Math.round((double)sum/N));
        Collections.sort(A);

        System.out.println(A.get(N/2));

        int[] chk = new int[8001];
        for(int i=0; i<N; ++i) {
            ++chk[A.get(i)+4000];
        }

        int[] chk_ = chk.clone();

        Arrays.sort(chk_);

        T = chk_[8000];

        for(int i=0; i<8001; ++i) {
            if(chk[i]==T) {
                if(Ans==0) {
                    Ans = i-4000;
                }
                else {
                    Ans = i-4000;
                    break;
                }
            }
        }
        System.out.println(Ans);
        System.out.println(A.get(N-1)-A.get(0));
    }

}