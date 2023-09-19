import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int N, count_max, rain;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int[][] arr;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		visited = new boolean[N][N];
		rain = 0;
		count_max = 1;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(rain=1; rain<=100; rain++) {
			
			int count = 0;
			visited = new boolean[N][N];
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(!visited[i][j] && arr[i][j] > rain) {
						visited[i][j] = true;
						dfs(i, j);
						count++;
					}
				}
			}
			if(count_max < count) count_max = count;
		}
		
		bw.write(String.valueOf(count_max));
		bw.close();
		br.close();
	}//main
	
	public static void dfs(int row, int col) {
		
		for(int i=0; i<4; i++) {
			int nr = row + dr[i];
			int nc = col + dc[i];
			
			if(nr >=0 && nr < N && nc >=0 && nc < N && !visited[nr][nc] && arr[nr][nc] > rain) {
				visited[nr][nc] = true;
				dfs(nr, nc);
			}
		}
	}
}