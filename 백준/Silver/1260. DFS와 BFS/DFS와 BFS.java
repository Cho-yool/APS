import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr;
	static boolean[] visited;
	static int N, M, V;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		arr = new int[N+1][N+1];
		visited = new boolean[N+1];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			arr[a][b] = arr[b][a] = 1;
		}
		
		dfs(V);

		sb.append("\n");
		visited = new boolean[N+1];
		
		bfs(V);
		
		bw.write(sb.toString());
		bw.close();
		br.close();
	}//main
	
	public static void dfs(int V) {
		visited[V] = true;
		sb.append(V).append(" ");
		
		for(int node = 1; node<arr.length; node++) {
			if(arr[V][node] == 1 && visited[node] == false)
				dfs(node);
		}
	}//dfs
	
	public static void bfs(int V) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(V);
		visited[V] = true;
		sb.append(V).append(" ");
		
		while(!queue.isEmpty()) {
			int firstNum = queue.poll();
			for(int node=1; node<arr.length; node++) {
				if(arr[firstNum][node] == 1 && visited[node] == false) {
					queue.offer(node);
					visited[node] = true;
					sb.append(node).append(" ");
				}
			}
		}
	}
}