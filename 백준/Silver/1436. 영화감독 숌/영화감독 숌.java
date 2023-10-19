import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	
	public static void main(String[] args) throws IOException{
		
		N = Integer.parseInt(br.readLine());
		String str = "666";
		int count = 0;
		int num = 666;
		while(true) {
			if(Integer.toString(num).contains(str)) {
				count++;
				if(count == N) break;
				num++;
			}
			else num++;
		}
		
		bw.write(String.valueOf(num));
		bw.close();
	}
}