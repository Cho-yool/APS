import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	
	static int N;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
	
		bw.write(String.valueOf(recur(N, 0)));
		bw.close();
		br.close();
	}//main
	
	public static int recur(int x, int count) {
		
		if(x < 2) return count;
		
		return Math.min(recur(x/2, count + 1 + (x%2)), recur(x/3, count + 1 + (x%3)));
		
	}
}