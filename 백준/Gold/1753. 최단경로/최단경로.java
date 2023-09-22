import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int V, E, start;
	static int[] distance;
	static ArrayList<ArrayList<Node>> list;
	
	public static class Node implements Comparable<Node>{
		int idx, cost;
		
		public Node (int idx, int cost) {
			this.idx = idx;
			this.cost = cost;
		}
		
		public int compareTo(Node other) {
			return Integer.compare(this.cost, other.cost);
		}
	}
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(br.readLine());
		list = new ArrayList<ArrayList<Node>>();
		// 리스트에 노드 추가(1번부터 V번까지)
		for(int i=0; i<=V; i++) {
			list.add(new ArrayList<Node>());
		}
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			// 유향 그래프의 경우
			list.get(s).add(new Node(e, c));
		}
		
		// 다익스트라 알고리즘 초기화
		distance = new int[V+1];
		for(int i=0; i<=V; i++) {
			distance[i] = Integer.MAX_VALUE;
		}
		// 출발점의 가중치는 0으로 갱신
		
		PriorityQueue<Node> queue = new PriorityQueue<>();
		queue.offer(new Node(start, 0));
		distance[start] = 0;
		
		while(!queue.isEmpty()) {
			Node curNode = queue.poll();
			
			if(distance[curNode.idx] < curNode.cost) continue;
			
			for(int i=0; i<list.get(curNode.idx).size(); i++) {
				Node nextNode = list.get(curNode.idx).get(i);
				
				if(distance[nextNode.idx] > curNode.cost + nextNode.cost) {
					distance[nextNode.idx] = curNode.cost + nextNode.cost;
					
					queue.offer(new Node(nextNode.idx, distance[nextNode.idx]));
				}
			}
		}
		for(int i=1; i<=V; i++) {
			if(distance[i] == Integer.MAX_VALUE) {
				bw.write("INF" + "\n");
			}
			else bw.write(String.valueOf(distance[i]) + "\n");
		}
		bw.close();
	}//main
}