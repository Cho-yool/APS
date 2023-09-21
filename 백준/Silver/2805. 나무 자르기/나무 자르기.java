import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int N, M, max, min;
	static long sum;
	static int[] arr;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 나무의 수
		M = Integer.parseInt(st.nextToken()); // 집으로 가져가려는 나무의 길이
		
		max = 0;
		min = 0;
		sum = 0;
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if(max < arr[i]) max = arr[i];
		}
	
		int mid = 0;
		
		while(min < max) {
			mid = (max + min)/2;
			sum = 0;
			
			for(int i=0; i<N; i++) {
				if(arr[i] <= mid) continue;
				sum += (arr[i] - mid);
			}
			

			if(sum < M) max = mid;
			else min = mid + 1;		
		}
		
		bw.write(String.valueOf(min - 1));
		bw.close();
	}//main
}