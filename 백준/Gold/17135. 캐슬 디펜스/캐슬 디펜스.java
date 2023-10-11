import java.io.*;
import java.util.*;

public class Main {

	static int N, M, D, result;
	static int[] archer;
	static int[][] arr, copyarr;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException{
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		archer = new int[3];
		result = 0;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		combination(0,0);
		bw.write(String.valueOf(result));
		bw.close();
	}
	
	public static void combination(int start, int idx) {
		if(idx == 3) {
			result = Math.max(result, game());
			return;
		}
		
		for(int i=start; i<M; i++) {
			archer[idx] = i;
			combination(i+1, idx+1);
		}
	}
	
	public static int game() {
		int total = 0;
		copyarr = new int[N][M];
		
		for(int line = N; line>0; line--) {
			for(int pick : archer) {
				for(int dist = 1; dist<=D; dist++) {
					int kill = attack(copyarr, dist, line, pick);
					if(kill < 0) continue;
					total += kill;
					break;
					}
				}
			}
		return total;
		}
	
	public static int attack(int[][] copyarr, int dist, int line, int pick) {
		for(int m = pick-dist; m<=pick+dist; m++) {
			int n = line -(dist - Math.abs(pick-m));
			
			if(n<0 || m<0 || n>=line || m>=M) continue;
			if(arr[n][m] == 0) continue;
			if(copyarr[n][m] == 0) {
				copyarr[n][m] = line;
				return 1;
			} else if(copyarr[n][m] == line) return 0;
		}
		
		return -1;
	
	}
}