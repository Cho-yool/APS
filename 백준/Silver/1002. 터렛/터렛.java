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
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			StringBuilder sb = new StringBuilder();
			st = new StringTokenizer(br.readLine());
			
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int r1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			
			int result = 0;
			// 두 점의 좌표가 같고 떨어져 있는 거리도 같을 때 무한대
			if(x1==x2 && y1==y2 && r1 == r2) result = -1;
			
			// 두 점의 좌표는 같지만 거리가 다를 때 터렛이 있을 수 있는 위치는 없음
			else if(x1==x2 && y1==y2 && r1 != r2) result = 0;
			
			// 두 점 사이의 거리가 터렛과 떨어져 있는 거리보다 클 때 터렛이 있을 수 있는 위치는 없음
			else if(Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2) > Math.pow(r1+r2, 2)) result = 0;
			
			// 큰 원 안에 작은 원이 접하지 않고 들어있을 때
			else if(Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2) < Math.pow(r2-r1, 2)) result = 0;
			
			// 두 점의 좌표가 같고 거리가 0일 때 터렛은 딱 한 곳에만 위치할 수 있음
			else if(x1==x2 && y1==y2 && r1==0 && r2==0) result = 1;
			
			// 두 점 사이의 거리와 터렛과 떨어져 있는 거리가 일치할 때 터렛은 한 곳에만 위치 가능(외접원)
			else if(Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2) == Math.pow(r1+r2, 2)) result = 1;
			
			// 두 점 사이의 거리와 터렛과 떨어져 있는 거리가 일치할 때 터렛은 한 곳에만 위치 가능(내접원)
			else if(Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2) == Math.pow(r2-r1, 2)) result = 1;
			
			// 두 점이 이루는 원의 교점의 좌표가 2개일 때
			else if(Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2) < Math.pow(r2+r1, 2)) result = 2;
			
			sb.append(result).append("\n");
			bw.write(sb.toString());

		}//tc
		bw.flush();
		bw.close();
		br.close();
	}
}