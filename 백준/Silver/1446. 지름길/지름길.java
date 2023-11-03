import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static class ShortCut {
        int start;
        int end;
        int distance;

        public ShortCut(int start, int end ,int distance){
            this.start = start;
            this.end = end;
            this.distance = distance;
        }
    }

    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        ArrayList<ShortCut> memo = new ArrayList<>();
        int[] dp = new int[T+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());

            if(end > T) continue;
            memo.add(new ShortCut(
                    start
                    ,end
                    ,distance));
        }

        for(int i = 0; i <= T; i++){
            if(i == 0)
                dp[i] = 0;
            else
                dp[i] = Math.min(dp[i], dp[i-1] + 1);
            for(ShortCut sc : memo){
                if(sc.start == i){
                    dp[sc.end] = Math.min(dp[sc.end],dp[i] + sc.distance);
                }
            }

        }
        sb.append(dp[T]);
        System.out.print(sb);
    }

}