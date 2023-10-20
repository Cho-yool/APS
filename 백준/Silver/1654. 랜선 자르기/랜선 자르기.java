import java.io.*;
import java.util.*;

public class Main {

	static int N, K; 
	static long answer, sum, max, min;
	static long[] arr;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException{
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new long[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, arr[i]);
		}
		
		max++;
		min = 0;
		long count = 0;
		
		while(min < max) {
			
			long mid = (max+min)/2;
			count = 0;
			
			for(int i=0; i<N; i++) {
				count += arr[i]/mid;
			}
			
			if(count < K) max = mid;
			else min = mid + 1;
		}
		
		answer = min - 1;
		bw.write(String.valueOf(answer));
		bw.close();
		
	}//main
	
}