import java.io.*;
import java.util.*;

public class Main {

	public static class Node implements Comparable<Node> {
		
		int index, cost;
		
		public Node(int index, int cost) {
			this.index = index;
			this.cost = cost;
		}
		
		public int compareTo(Node other) {
			return Integer.compare(this.cost, other.cost);
		}
	}
	
	static int N, M, answer;
	static int[] distance;
	static List<List<Node>> list;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException{
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		list = new ArrayList<>();
		distance = new int[N+1];
		Arrays.fill(distance, 100000000);
		
		for(int i=0; i<=N; i++) list.add(new ArrayList<>());
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			list.get(a).add(new Node(b,c));
		}
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		dijkstra(start);
		
		bw.write(String.valueOf(distance[end]));
		bw.close();
	}//main
	
	public static void dijkstra(int start) {
		PriorityQueue<Node> queue = new PriorityQueue<>();
		queue.offer(new Node(start,0));
		distance[start] = 0;
		
		while(!queue.isEmpty()) {
			Node cur = queue.poll();
			
			if(cur.cost > distance[cur.index]) continue;
			
			for(Node next : list.get(cur.index)) {
				if(distance[next.index] > cur.cost + next.cost) {
					distance[next.index] = cur.cost + next.cost;
					queue.offer(new Node(next.index, distance[next.index]));
				}
			}
		}
	}
}