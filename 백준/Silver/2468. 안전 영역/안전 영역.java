import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, rain, count, count_max;
	static int[] dr = {-1, 1, 0 , 0};
	static int[] dc = {0, 0, -1 , 1};
	static int[][] arr;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		visited = new boolean[N][N];
		count = 0;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		if(rain == 0) count_max = 1;
		
		for(rain=1; rain<=100; rain++) {
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(arr[i][j] <= rain) arr[i][j] = -1;
				}
			}
			visited = new boolean[N][N];
			count = 0;
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(arr[i][j] != -1 && !visited[i][j])
						bfs(i, j);
					if(count_max < count) count_max = count; 
				}
			}
		}		
		
		bw.write(String.valueOf(count_max));
		bw.close();
		br.close();
		
	}//main
	
	public static void bfs(int row, int col) {
		Queue< int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] {row, col});
		visited[row][col] = true;
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			int r = cur[0];
			int c = cur[1];
			
			for(int i=0; i<4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				if(nr >=0 && nr < N && nc >=0 && nc <N && !visited[nr][nc] && arr[nr][nc] != -1) {
					visited[nr][nc] = true;
					queue.offer(new int[] {nr, nc});
				}	
			}
		}
		count++;
	}
}