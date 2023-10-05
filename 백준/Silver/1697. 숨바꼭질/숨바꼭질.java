import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, K, answer;
	static int[] visited;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		visited = new int[100001];		
		
		bfs(N);
		bw.write(String.valueOf(answer));
		bw.close();
		
	}//main
	public static void bfs(int num) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(num);
		visited[num] = 0;
		
		answer = 0;
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			if(cur == K) {
				answer = visited[cur];
				return;
			}
			if(cur-1 >=0 && visited[cur-1] ==0) {
				visited[cur-1] = visited[cur] + 1;
				queue.offer(cur-1);
			}
			if(cur+1 <= 100000 && visited[cur+1] == 0) {
				visited[cur+1] = visited[cur] + 1;
				queue.offer(cur+1);
			}
			if(cur*2 <= 100000 && visited[cur*2] == 0) {
				visited[cur*2] = visited[cur] + 1;
				queue.offer(cur*2);
			}
		}
	}
}