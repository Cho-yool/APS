import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static class Str implements Comparable<Str>{
        String str;
        int count = 1;

        public Str(String str){
            this.str = str;
        }

        @Override
        public String toString() {
            return str;
        }

        @Override
        public int compareTo(Str o){
            if(o.count == this.count){
                if(o.str.length() == this.str.length()){
                    return this.str.compareTo(o.str);
                }
                return o.str.length() - this.str.length();
            }

            return o.count - this.count;
        }
    }

    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Str> memo = new HashMap<>();
        PriorityQueue<Str> pq = new PriorityQueue<>();

        for(int i = 0; i < N; i++){
            String str = br.readLine();

            if(str.length() >= M){
                if(memo.containsKey(str)){
                    memo.get(str).count++;
                }else{
                    memo.put(str, new Str(str));
                }
            }

        }

        for(String i : memo.keySet()){
            pq.add(memo.get(i));
        }

        while (!pq.isEmpty()){
            sb.append(pq.poll()).append("\n");
        }

        System.out.print(sb);
    }

}