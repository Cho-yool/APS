import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String L = st.nextToken();
		String R = st.nextToken();
		
		// 자릿수가 다르면 반드시 8이 포함되어있지 않은 수가 존재함
		int result = 0;
		
		// 자릿수가 같을 때
		if(L.length() == R.length()) {
			for(int i=0; i<L.length(); i++) {
				// 같은 자리에 있는 수가 달라질때까지 8의 개수를 조사
				if(L.charAt(i) != R.charAt(i)) break;
				if(L.charAt(i) == '8') result++;
			}
		}
		
		bw.write(String.valueOf(result));
		bw.flush();
		bw.close();
		br.close();		
	}
}