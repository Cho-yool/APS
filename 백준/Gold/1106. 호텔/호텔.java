import java.io.*;
import java.util.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static class Ad{
        int cost;
        int effect;

        public Ad(int cost,int effect){
            this.cost = cost;
            this.effect = effect;
        }
    }

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());

        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

         Map<Integer,Integer> memo = new HashMap<>();
         int max = 0;
         for(int i = 0; i < N; i++){
             st = new StringTokenizer(br.readLine());
             int c = Integer.parseInt(st.nextToken());
             int e = Integer.parseInt(st.nextToken());
             max = Math.max(max,e);
             if(memo.containsKey(e)){
                 if(memo.get(e) > c)
                    memo.put(e,c);

             }else {
                 memo.put(e, c);
             }
         }

         int[] dp = new int[Math.max(2*C+1,max+1)];
         Arrays.fill(dp,Integer.MAX_VALUE);
         dp[0] = 0;
         for(int i = 0 ; i < dp.length;i++){
             if(dp[i] == Integer.MAX_VALUE)continue;
             for(int n:memo.keySet()){
                 if(i + n < dp.length && dp[i + n] > dp[i] + memo.get(n)){
                     dp[i+n] = dp[i]+memo.get(n);
                 }
             }
         }
//        System.out.println(Arrays.toString(dp));
         int answer = Integer.MAX_VALUE;
         for(int i = C; i < dp.length; i++){
             answer = Math.min(answer, dp[i]);
         }
        System.out.println(answer);
    }
}