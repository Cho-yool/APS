import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, count; // N : 컴퓨터 수, M : 네트워크 상에서 직접 연결되어 있는 컴퓨터 쌍의 수
	static int[][] arr;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		arr = new int[N+1][N+1];
		visited = new boolean[N+1];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			arr[a][b] = arr[b][a] = 1;
		}
		
		bfs(1);
		int ans = count - 1; // 실제 답에서 1번 컴퓨터를 poll()한 경우를 빼줘야함 
		bw.write(String.valueOf(ans));
		bw.close();
		br.close();
	}//main
	
	public static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(start);
		visited[start] = true;
		
		count = 0;
		
		while(!queue.isEmpty()) {
			int first = queue.poll();
			count++;
			for(int node=1; node<arr.length; node++) {
				if(!visited[node] && arr[first][node] == 1) {
					queue.offer(node);
					visited[node] = true;
				}
			}
		}		
	}
}