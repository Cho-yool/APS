import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int M, N, K, index, startR, startC, endR, endC, count;
	static int[] area;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int[][] arr;
	static boolean[][] visited;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 가로줄
		M = Integer.parseInt(st.nextToken()); // 세로줄
		K = Integer.parseInt(st.nextToken()); // K줄 입력
		arr = new int[N][M];
		visited = new boolean[N][M];
		area = new int[1000];
		
		for(int k=0; k<K; k++) {
			st = new StringTokenizer(br.readLine());
			startC = Integer.parseInt(st.nextToken()); 
			startR = Integer.parseInt(st.nextToken()); 
			endC = Integer.parseInt(st.nextToken());
			endR = Integer.parseInt(st.nextToken());
			
			for(int i=startR; i<endR; i++) {
				for(int j=startC; j<endC; j++) {
					arr[i][j] = 1;
					visited[i][j] = true;
				}
			}
		}
		
		int answer = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(arr[i][j] == 0 && !visited[i][j]) {
					bfs(i,j);
					area[answer++] = count;
				}
			}
		}
		System.out.println(answer);
		Arrays.sort(area);
		for(int i=0; i<area.length; i++) {
			if(area[i] == 0) continue;
			sb.append(area[i]).append(" ");
		}
		
		bw.write(sb.toString());
		bw.close();
	}//main
	
	public static void bfs(int row, int col) {
		count = 0;
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] {row, col});
		visited[row][col] = true;
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			count++;
			
			int r = cur[0];
			int c = cur[1];
			
			for(int i=0; i<4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				if(nr<0 || nc<0 || nr>=N || nc>=M || visited[nr][nc] || arr[nr][nc] == 1) continue;
				arr[nr][nc] = arr[r][c] + 1;
				queue.offer(new int[] {nr, nc});
				visited[nr][nc] = true;
			}
		}
	}
}