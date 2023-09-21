import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M; // 건물, 도로
	static int[] parent;
	
	public static class Node implements Comparable<Node>{
		int nodeA, nodeB, cost;
		
		public Node(int a, int b, int c) {
			nodeA = a;
			nodeB = b;
			cost = c;
		}
		
		public int compareTo(Node other) {
			
			return Integer.compare(this.cost, other.cost);
		}
	}
	
	public static int find(int x) {
		if(x == parent[x]) return x;
		
		return parent[x] = find(parent[x]);
	}
	
	public static void union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		
		if(pa < pb) {
			int temp = parent[pb];
			parent[pb] = pa;
			parent[temp] = pa;
		}
		else parent[pa] = pb;
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		PriorityQueue<Node> queue = new PriorityQueue<>();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		parent = new int[N+1];
		for(int i=1; i<=N; i++) {
			parent[i] = i;
		}
		long totalCost = 0;
		long resultCost = 0;
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			totalCost += c;
			queue.offer(new Node(a,b,c));
		}
		
		while(!queue.isEmpty()) {
			
			Node node = queue.poll();
			int a = node.nodeA;
			int b = node.nodeB;
			int c = node.cost;
			
			if(find(a) != find(b)) {
				union(a,b);
				resultCost += c;
			}
		}
		
		long saveCost = totalCost - resultCost;
		
		for(int i=2; i<=N; i++) {
			if(find(i-1) != find(i)) {
				saveCost = -1;
			}
		}
		bw.write(String.valueOf(saveCost));
		bw.close();
		
	}//main
}