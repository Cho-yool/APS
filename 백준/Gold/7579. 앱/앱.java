import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;


    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int ans = Integer.MAX_VALUE;
        int[] files = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] restart = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[][] dp = new int[N][100001];

        for(int i = 0 ; i < N; i++){
            int memory = files[i];
            int cost = restart[i];

            for(int j =0; j <= 100000; j ++){
                if( i == 0 ){
                    if(j >= cost) dp[i][j] = memory;
                }else{
                    if(j >= cost) dp[i][j] = Math.max(dp[i - 1][j - cost] + memory, dp[i - 1][j]);
                    else dp[i][j] = dp[i - 1][j];
                }
                if(dp[i][j] >= M) ans = Math.min(ans, j);
            }
        }
        System.out.println(ans);
    }

}