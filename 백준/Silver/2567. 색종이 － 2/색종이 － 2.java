import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
	
public class Main {
	static int[] dr = {-1, 1, 0 ,0};
	static int[] dc = {0, 0, -1 ,1};
	static int sum, nr, nc;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[101][101];
		
		for(int h=0; h<N; h++) {
			st = new StringTokenizer(br.readLine());
			int num_1 = Integer.parseInt(st.nextToken());
			int num_2 = Integer.parseInt(st.nextToken());
			
			for(int i=num_1; i<num_1+10 && i<100; i++) {
				for(int j=num_2; j<num_2+10 && j<100; j++) {
					arr[i][j] = 1;
				}
			}
		}
		
		int count = 0;
		
		for(int i=1; i<arr.length; i++) {
			for(int j=1; j<arr.length; j++) {
				if(arr[i][j] == 1) {
					for(int k=0; k<4; k++) {
						nr = i + dr[k];
						nc = j + dc[k];
						
						if(nr >= 1 && nr <=100 && nc >=1 && nc <=100 && arr[nr][nc]==0) count++;
						else if(nr <1 || nr >100 || nc <1 || nr>100) count++;
					}
				}
			}
		}
		
		bw.write(String.valueOf(count));
		bw.close();
		br.close();
	}
}