import java.io.*;
import java.util.*;

//Boj 15654 silver3
public class Main {
    static int K, N, M, ans;
    static int[] numbers;
    static boolean[] visited;
    static List<Integer> sequence = new ArrayList<>();

    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        N = Integer.parseInt(temp[0]);
        M = Integer.parseInt(temp[1]);
        numbers = new int[N];
        visited = new boolean[N];
        temp = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(temp[i]);
        }
        Arrays.sort(numbers);
        backtrack(0);


    }

    static void backtrack(int depth) {
        if (depth == M) {
            for (int num : sequence) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                sequence.add(numbers[i]);
                backtrack(depth + 1);
                sequence.remove(sequence.size() - 1);
                visited[i] = false;
            }
        }

    }

}