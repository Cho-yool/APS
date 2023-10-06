import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int I, answer, startRow, startCol, endRow, endCol;
	static int[] dr = {-1, -2, -2, -1, 1, 2, 2, 1};
	static int[] dc = {-2, -1, 1, 2, 2, 1, -1, -2};
	static int[][] arr;
	static boolean[][] visited;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException{
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			
			I = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			startRow = Integer.parseInt(st.nextToken());
			startCol = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			endRow = Integer.parseInt(st.nextToken());
			endCol = Integer.parseInt(st.nextToken());
			
			answer = 0;
			arr = new int[I][I];
			visited = new boolean[I][I];
			
			bfs(startRow, startCol);
			answer = arr[endRow][endCol];
			bw.write(String.valueOf(answer) + "\n");
		}//tc
		bw.close();
	}//main
	
	public static void bfs(int row, int col) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] {row, col});
		visited[row][col] = true;

		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			int r = cur[0];
			int c = cur[1];
			
			for(int i=0; i<8; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				if(nr<0 || nc<0 || nr>=I || nc>=I || visited[nr][nc]) continue;
				arr[nr][nc] = arr[r][c] + 1;
				queue.offer(new int[] {nr, nc});
				visited[nr][nc] = true;
			}
		}
	}
}