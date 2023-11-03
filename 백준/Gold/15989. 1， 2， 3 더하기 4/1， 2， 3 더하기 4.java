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

        int[][] dp = new int[10001][4];

        dp[1][1] = 1;
        dp[2][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;

        for(int i = 4; i < 10001; i++){
            dp[i][1] = dp[i-1][1];
            dp[i][2] = dp[i-2][1] + dp[i-2][2];
            dp[i][3] = dp[i-3][1] + dp[i-3][2] + dp[i-3][3];
        }

        int T = Integer.parseInt(br.readLine());

        for(int i =0; i < T; i++){
            int num = Integer.parseInt(br.readLine());
            sb.append(dp[num][1] + dp[num][2] + dp[num][3]).append("\n");
        }

        System.out.print(sb);
    }

}