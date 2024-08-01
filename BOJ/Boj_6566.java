import java.io.*;
import java.util.*;

//Boj 6566 silver1
// https://www.acmicpc.net/problem/6566
public class Main {
    static int K, N, M, ans;
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        TreeMap<String, Integer> map = new TreeMap<>(Comparator.reverseOrder());
        TreeMap<String, String> map3 = new TreeMap<>(Comparator.reverseOrder());
        HashMap<String, ArrayList<String>> map2 = new HashMap<>();
        while(true) {
            try{
                char[] a = br.readLine().toCharArray();
                String origin = new String(a);
                Arrays.sort(a);
                String a_ = new String(a);
//                System.out.println(origin  + " ----- " + a_);
                map.put(a_, map.getOrDefault(a_, 0)+1);
                ArrayList<String> arr = map2.getOrDefault(a_, new ArrayList<>());
                if(!arr.contains(origin)) arr.add(origin);
                map2.put(a_, arr);
                Collections.sort(arr);
                map3.put(a_, arr.get(0));
            }
            catch(Exception e){
                break;
            }
        }
        List<String> keySet = new ArrayList<>(map.keySet());
        keySet.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(map.get(o1) == map.get(o2)) {
                    return map3.get(o1).compareTo(map3.get(o2));
                }
                return map.get(o2).compareTo(map.get(o1));
            }
        });
        int cnt = 0;
        for(String s : keySet) {
            if(cnt==5) break;
            sb.append("Group of size " + map.get(s) + ": ");
            ArrayList<String> arr = map2.get(s);
            Collections.sort(arr);
            for(int i = 0; i < arr.size(); i++) {
//                if(i==5) break;
                sb.append(arr.get(i) + " ");
            }
            sb.append(".\n");
            ++cnt;
        }

        System.out.println(sb);
    }

}