import java.io.*;

//Boj 1082 Gold3
public class Solution {
    static int P, N, M, ans;
    static int[][] map;
    static int[] price;
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = pi(br.readLine());
        price = new int[N];

        String[] temp = br.readLine().split(" ");

        int chk1 = Integer.MAX_VALUE;
        int chk1_idx=-1;
        int chk2 = Integer.MAX_VALUE;
        int chk2_idx=-1;
        for(int i=0; i<N; ++i) {
            price[i] = pi(temp[i]);
            if(price[i]<=chk1) {
                chk1 = price[i];
                chk1_idx = i;
            }
            if(i!=0 && price[i]<=chk2) {
                chk2 = price[i];
                chk2_idx = i;
            }
        }
        M = pi(br.readLine());
        if(chk2>M) {
            System.out.println(0);
            System.exit(0);
        }
        String numbers = "";
        numbers += chk2_idx;
        M-=chk2;
        while(M>=chk1) {
            numbers += chk1_idx;
            M -= chk1;
        }
        char[] numbers_ = numbers.toCharArray();
        int temp_;
        for (int i=0; i<numbers.length(); ++i) {
            for (int j=N-1; j>-1; --j) {
                temp_ = numbers_[i] - '0';

                if (M>=price[j] - price[temp_]) {
                    M -= price[j] - price[temp_];
                    numbers_[i] = (char)('0'+j);
                    break;
                }
            }
        }
        System.out.println(numbers_);


    }

}