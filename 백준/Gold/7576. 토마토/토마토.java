import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int M, N, answer;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int[][] arr;
	static boolean[][] visited;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException{
		
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visited = new boolean[N][M];
		answer = 0;
		int max = 0;
		int row = 0;
		int col = 0;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 1) {
					row = i;
					col = j;
				}
			}
		}
		
		bfs(row, col);
	loop :	for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(answer < arr[i][j]) answer = arr[i][j]-1;
					if(arr[i][j] == 0) {
						answer = -1;
						break loop;
					}
				}
			}
		
		bw.write(String.valueOf(answer));
		bw.close();
	}//main
	
	public static void bfs(int row, int col) {
		Queue<int[]> queue = new LinkedList<int[]>();
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(arr[i][j] == 1 && !visited[i][j]) {
					queue.offer(new int[] {i, j});
					visited[i][j] = true;
				}
			}
		}
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			int r = cur[0];
			int c = cur[1];
			
			for(int i=0; i<4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				if(nr<0 || nc<0 || nr>=N || nc>=M || visited[nr][nc] || arr[nr][nc] != 0) continue;
				arr[nr][nc] = arr[r][c] + 1;
				queue.offer(new int[] {nr, nc});
				visited[nr][nc] = true;
			}
		}
	}//bfs
}