import java.io.*;
import java.util.*;

//Boj 1843 gold3
public class Main {
    static int N, M, K, ans;
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = pi(br.readLine());
        long[] Ans = new long[3];
        boolean[] isPrime = new boolean[500001];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for(int i=2; i<Math.sqrt(500001); ++i) {
            if(isPrime[i]) {
                for(int j=i+i; j<500001; j+=i) {
                    isPrime[j] = false;
                }
            }
        }

//        X+Y = Z
//        제약 조건 A: 세 자연수 X, Y, Z는 모두 N 이하이며, 서로 다르다.
//        제약 조건 B: 세 자연수 X, Y, Z는 모두 N의 양의 약수이다.
//        제약 조건 C: 세 자연수 X, Y, Z는 모두 N 이하의 양의 소수이다.

        //A
        Ans[0] = N%2==1 ? ((long)N/2)*(N/2) : ((long)N*N/4)-(N/2);

        //B
        int chk = (int) Math.sqrt(N);
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=1; i<chk+1; ++i) {
            if(N%i==0) {
                arr.add(i);
                if(N/i!=0) {
                    if(!arr.contains(N/i)) {
                        arr.add(N/i);
                    }
                }
            }
        }
        arr.sort(Comparator.naturalOrder());

        for(int i=0; i<arr.size()-1; ++i) {
            for(int j=i; j<arr.size()-1; ++j) {
                if(arr.get(i)+arr.get(j)>N) {
                    break;
                }
                if(arr.contains(arr.get(i)+arr.get(j))) {
                    ++Ans[1];
                }
            }
        }

        //C

        for(int i=3; i<N; ++i) {
            if(i + 2>N) {
                break;
            }
            if(isPrime[i] && isPrime[i+2]) {
                ++Ans[2];
            }
        }

        System.out.print(Ans[0]+"\n"+Ans[1]+"\n"+Ans[2]);
    }

}