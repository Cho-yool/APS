import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int n, answer;
	static int human1, human2;
	static int m;
	static int[] count;
	static int[][] arr;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException{
		
		n = Integer.parseInt(br.readLine());
		
		 st= new StringTokenizer(br.readLine());
		 human1 = Integer.parseInt(st.nextToken());
		 human2 = Integer.parseInt(st.nextToken());
		 count = new int[n+1];
		 arr = new int[n+1][n+1];
		 
		 m = Integer.parseInt(br.readLine());
		 for(int i=0; i<m; i++) {
			 st = new StringTokenizer(br.readLine());
			 int x = Integer.parseInt(st.nextToken());
			 int y = Integer.parseInt(st.nextToken());
			 arr[x][y] = arr[y][x] = 1;
		 }
		 
		 bfs(human1);
		 
		 bw.write(String.valueOf(answer));
		 bw.close();
	}//main
	
	public static void bfs(int idx) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(idx);
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			
			if(cur == human2) {
				answer = count[cur];
				return;
			}
			
			for(int i=1; i<=n; i++) {
				if(arr[cur][i] == 1 && count[i] == 0) {
					queue.offer(i);
					count[i] = count[cur] + 1;
				}
			}
		}
		if(count[human2] == 0) answer = -1;
	}
}