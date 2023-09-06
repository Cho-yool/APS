import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		// 몇번째 대각선 줄인지 확인
		int n = 1;
		
		while(true) {
			if((n*n-n)/2+1 <= N) n++;
			else {
				n -= 1;
				break;
			}

		}
		
		// n-1번째 대각선 줄에서 첫번째 시작위치 start
		// ex) 14번째 분수 = 11~15번째 분수 사이에 있으므로 11번째가 start
		int start = ((n)*(n-1))/2 + 1;
		int diff = N-start;
		
		if(n%2 == 0) sb.append(1+diff).append("/").append(n-diff);
		else if(n%2 == 1) sb.append(n-diff).append("/").append(1+diff);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}