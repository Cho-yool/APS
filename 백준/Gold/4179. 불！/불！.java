import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int R, C, answer, Jrow, Jcol;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static char[][] ch;
	static int[][] visited;
	static Queue<int[]> queue = new LinkedList<int[]>();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException{
		
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		ch = new char[R][C];
		visited = new int[R][C];
		answer = 0;
		
		Jrow = 0;
		Jcol = 0;
		for(int i=0; i<R; i++) {
			String str = br.readLine();
			for(int j=0; j<C; j++) {
				ch[i][j] = str.charAt(j);
				if(ch[i][j] == 'F') {
					queue.offer(new int[] {i, j});
					visited[i][j] = -1;
				}
				else if(ch[i][j] == '#') visited[i][j] = -1;
				else if(ch[i][j] == 'J') {
					Jrow = i;
					Jcol = j;
				}
			}
		}
		bfs(Jrow, Jcol);
		if(answer >= 1) bw.write(String.valueOf(answer));
		else bw.write("IMPOSSIBLE");
		bw.close();
	}//main
	
	public static void bfs(int row, int col) throws IOException {
		queue.offer(new int[] {row, col});
		visited[row][col] = 1;
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			int r = cur[0];
			int c = cur[1];
			
			if(r == 0 || c == 0 || r ==R-1 || c == C-1) {
				if(visited[r][c] >= 1) {
					answer = visited[r][c];
					return;
				}
			}
			
			for(int i=0; i<4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				if(nr<0 || nc<0 || nr>=R || nc>=C  || visited[nr][nc] == -1) continue;
				
				// 현재 위치가 지훈이면서 다음 갈 곳이 '.' 이라면
				if(visited[r][c] >= 1 && visited[nr][nc] == 0) {
					queue.offer(new int[] {nr, nc});
					visited[nr][nc] = visited[r][c] + 1;
				}
				// 현재 위치가 불이면서 다음 갈 곳이 '.' 이라면
				else if(visited[r][c] == -1 && visited[nr][nc] == 0) {
					queue.offer(new int[] {nr, nc});
					visited[nr][nc] = -1;
				}
			}
		}
	}
}