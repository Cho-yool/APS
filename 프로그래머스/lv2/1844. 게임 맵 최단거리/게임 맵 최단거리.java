import java.util.*;

class Solution {
    static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int N;
	static int M;
	static int move = -1;
    public int solution(int[][] map) {
        N = map.length;
        M = map[0].length;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visit = new boolean[N][M];
        q.offer(new int[] {0,0});
        visit[0][0] = true;
        bfs(map,visit,q);
        return move;
    }
    
    public static void bfs(int[][] map, boolean[][]  visit, Queue<int[]> q) {
		int size = q.size();
		int m = 0;
		while(!q.isEmpty()) {
			for(int i=0; i<size; i++) {
				int r = q.peek()[0];
				int c = q.poll()[1];
				if(r==N-1&&c==M-1) {
					move = m+1;
				}
				
				for(int d=0; d<4; d++) {
					int nr = r+dr[d];
					int nc = c+dc[d];
					
					if(nr<0 || nr>=N || nc<0 || nc>=M || visit[nr][nc] || map[nr][nc]==0) continue;
					q.offer(new int[] {nr,nc});
					visit[nr][nc] = true;
				}
			}
			size = q.size();
			m++;
		}
	}
}