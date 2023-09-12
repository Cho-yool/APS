import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] counting = new int[20000001];
		
		st = new StringTokenizer(br.readLine());
		// 입력받는 수에 10,000,000(1000만)을 더해서 저장(배열 index는 양수)
		for(int i=0; i<N; i++) 
			counting[Integer.parseInt(st.nextToken())+10000000]++;
		
		int M = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		// counting 배열의 index와 일치하는 숫자면 counting 배열의 index에 들어있는 값을 출력
		for(int i=0; i<M; i++) 
			sb.append(counting[Integer.parseInt(st.nextToken()) + 10000000]).append(" ");
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}