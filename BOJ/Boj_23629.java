import java.io.*;
import java.util.*;

//Boj 23629 gold5
public class Solution {
    static int N, M, K, ans;
    static Map<String, Integer> map = new HashMap<>();
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map.put("ZERO", 0);
        map.put("ONE", 1);
        map.put("TWO", 2);
        map.put("THREE", 3);
        map.put("FOUR", 4);
        map.put("FIVE", 5);
        map.put("SIX", 6);
        map.put("SEVEN", 7);
        map.put("EIGHT", 8);
        map.put("NINE", 9);

        String temp = br.readLine();
        String ori = temp;
        for(String s : map.keySet()) {
            temp = temp.replaceAll(s, Integer.toString(map.get(s)));
        }
        StringBuilder sb = new StringBuilder();
        sb.append(temp+"\n");

        Queue<Long> q_num = new LinkedList<>();
        Queue<String> q_operator = new LinkedList<>();
        String chk = "";
        try {
            for(int i=0; i<temp.length(); ++i) {
                if("+-x/=".contains(Character.toString(temp.charAt(i)))) {
                    if(chk.equals("")) {
                        System.out.println("Madness!");
                        return;
                    }
                    q_num.add(Long.parseLong(chk));
                    chk = "";
                    q_operator.add(Character.toString(temp.charAt(i)));
                }
                else {
                    chk += temp.charAt(i);
                }
            }
        }
        catch (NumberFormatException e) {
            System.out.println("Madness!");
            return;
        }
        if(q_num.size()==1 && q_operator.size()!=1) {
            System.out.println("Madness!");
            return;
        }
        else if(temp.charAt(temp.length()-1)!='=') {
            System.out.println("Madness!");
            return;
        }
        else if(q_num.size()==1 && q_operator.size()==1){
            System.out.println(temp);
            System.out.println(ori.substring(0, ori.length()-1));
            return;
        }

        long Ans = q_num.poll();
        while(!q_num.isEmpty()) {
            String operator = q_operator.poll();
            long num = q_num.poll();

            if("+".equals(operator)) {
                Ans += num;
            }
            else if("-".equals(operator)) {
                Ans -= num;
            }
            else if("x".equals(operator)) {
                Ans *= num;
            }
            else if("/".equals(operator)) {
                Ans /= num;
            }
            else if("=".equals(operator)) {
                if(q_num.size()!=0) {
                    System.out.println("Madness!");
                    return;
                }
                break;
            }
        }

        temp = Long.toString(Ans);

        for(String s : map.keySet()) {
            temp = temp.replaceAll(Integer.toString(map.get(s)), s);
        }
        sb.append(temp);
        System.out.println(sb);


    }

}