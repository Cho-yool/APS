import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int V, E;
	static int[] parent;
	
	public static class Node implements Comparable<Node>{
		
		int nodeA, nodeB, cost;
		
		public Node(int a, int b, int c) {
			nodeA = a;
			nodeB = b;
			cost = c;
		}
	
		@Override
		public int compareTo(Node other) {
			return Integer.compare(this.cost, other.cost);
		}
	}
		
		public static int findParent(int x) {
			if(x == parent[x]) return x;
			
			return parent[x] = findParent(parent[x]);
		}
		
		public static void unionParent(int a, int b) {
			a = findParent(a);
			b = findParent(b);
			
			if(a < b) parent[b] = a;
			else parent[a] = b;
		}
		
		public static void main(String[] args) throws IOException{
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			PriorityQueue<Node> queue = new PriorityQueue<>();
			
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			parent = new int[V+1];
			for(int i=1; i<=V; i++) {
				parent[i] = i;
			}
			
			for(int i=0; i<E; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				
				queue.offer(new Node(a,b,c));
			}
			
			int result = 0;
			while(!queue.isEmpty()) {
				Node node = queue.poll();
				
				int a = node.nodeA;
				int b = node.nodeB;
				int c = node.cost;
				
				if(findParent(a) != findParent(b)) {
					unionParent(a,b);
					result += c;
				}
			}
			bw.write(String.valueOf(result));
			bw.close();
		}//main
}