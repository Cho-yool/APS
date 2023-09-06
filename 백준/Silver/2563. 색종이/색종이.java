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
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[100][100];
		
		
		for(int tc=1; tc<=N; tc++) {
			st = new StringTokenizer(br.readLine());
			int row = Integer.parseInt(st.nextToken());
			int col = Integer.parseInt(st.nextToken());
			
			// 색종이가 붙은 검은 영역을 숫자 1로 바꾸기
			for(int i=row; i<row+10; i++) {
				for(int j=col; j<col+10; j++) {
					arr[i][j] = 1;
				}
			}
		}//tc
		
		int sum = 0;
		
		// 100*100 2차원 배열을 완전 탐색하여 1인 곳을 모두 더하기
		for(int i=0; i<100; i++) {
			for(int j=0; j<100; j++) {
				sum += arr[i][j];
			}
		}
		
		bw.write(String.valueOf(sum));
		bw.flush();
		bw.close();
		br.close();
	}
}