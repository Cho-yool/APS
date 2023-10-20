import java.io.*;
import java.util.*;

public class Main {

	static int N, M, K, answer;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int[][] arr;
	static boolean[][] visited;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException{
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			answer = 0;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			arr = new int[N][M];
			visited = new boolean[N][M];
			
			for(int i=0; i<K; i++) {
					st = new StringTokenizer(br.readLine());
					int x = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());
					arr[x][y] = 1;
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(arr[i][j] == 1 && !visited[i][j]) {
						bfs(i,j);
						answer++;
					}
				}
			}
			
			bw.write(String.valueOf(answer) + "\n");
		}//tc
		bw.close();
	}//main
	
	public static void bfs(int row, int col) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {row, col});
		visited[row][col] = true;
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			int r = cur[0];
			int c = cur[1];
			
			for(int i=0; i<4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				if(nr<0 || nc<0 || nr>=N || nc>=M || visited[nr][nc] || arr[nr][nc] == 0) continue;
				queue.offer(new int[] {nr, nc});
				visited[nr][nc] = true;
			}
		}
			
	}
}