import java.io.*;
import java.util.*;

public class Main {

	static int n, m, finalCost, cityCount;
	static int INF = 100000000;
	static int[] distance, city;
	static List<List<Node>> list;
	static List<Integer> route;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static 	StringBuilder sb = new StringBuilder();
	
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
	
	public static void main(String[] args) throws IOException{
		
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		list = new ArrayList<>();
		route = new ArrayList<>();
		distance = new int[n+1];
		city = new int[n+1];
		Arrays.fill(distance, INF);
		for(int i=0; i<=n; i++) {
			list.add(new ArrayList<>());
		}
		
		for(int i=0; i<m; i++) {
			st  = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			list.get(a).add(new Node(b,c));
		}
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		finalCost = dijkstra(start,end);
		
		// end가 다시 start 이전으로 돌아갈 때까지
		while(end != 0) {
			// city[end]값에 end 바로 이전의 index가 담겨있으므로
			// route라는 list에 end값을 담으면서
			// end값을 다시 그전의 값으로 갱신하기
			route.add(end);
			end = city[end];
		}
		
		for(int i=route.size()-1; i>=0; i--) {
			sb.append(route.get(i) + " ");
		}
		
		bw.write(String.valueOf(finalCost) + "\n" + route.size() + "\n");
		bw.write(sb.toString());
		bw.close();
	}//main
	
	public static int dijkstra(int start, int end) {

		PriorityQueue<Node> queue = new PriorityQueue<>();
		queue.offer(new Node(start,0));
		distance[start] = 0;
		
		while(!queue.isEmpty()) {
			Node cur = queue.poll();
			
			if(distance[cur.index] < cur.cost) continue;
			
			for(Node next : list.get(cur.index)) {
				if(distance[next.index] > cur.cost + next.cost) {
					cityCount++;
					distance[next.index] = cur.cost + next.cost;
					queue.offer(new Node(next.index, distance[next.index]));
					city[next.index] = cur.index;
				}
			}
		}
		return distance[end];
	}
}