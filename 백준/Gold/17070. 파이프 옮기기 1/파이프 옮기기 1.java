import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static int[][] arr;
	static long[][][] dp;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException{
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1][N+1];
		dp = new long[N+1][N+1][3];
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp[1][2][0] = 1;
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(arr[i][j] == 1) continue;
				
				dp[i][j][0] += dp[i][j-1][0] + dp[i][j-1][1];
				dp[i][j][2] += dp[i-1][j][1] + dp[i-1][j][2];
				
				if(arr[i-1][j] == 1 || arr[i][j-1] == 1) continue;
				dp[i][j][1] += dp[i-1][j-1][0] + dp[i-1][j-1][1] + dp[i-1][j-1][2];
			}
		}
		
		long answer = dp[N][N][0] + dp[N][N][1] + dp[N][N][2];
		bw.write(String.valueOf(answer));
		bw.close();
	}
}