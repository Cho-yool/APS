import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = br.readLine();
		int result = 0;
		
		// 문자열을 "-" 기준으로 자르기
		// ex) 55-50+40 -> 55 , 50+40
		String[] sub = str.split("-");
		for(int i=0; i<sub.length; i++) {
			
			// 잘린 문자열을 또 다시 "\\+"기준으로 자르기(+는 메타문자라 \\ 붙여줘야함)
			// 55, 50, 40
			String[] add = sub[i].split("\\+");
			
			for(int j=0; j<add.length; j++) {
				
				// 가장 첫번째 오는 잘린 문자열은 숫자이므로 무조건 더해주기
				if(i==0) result += Integer.parseInt(add[j]);
				
				// 그 뒤에 오는 잘린 문자열의 숫자들은 모두 빼주기
				else result -= Integer.parseInt(add[j]);
			}
		}
		bw.write(String.valueOf(result));
		bw.flush();
		bw.close();
		br.close();
		
	}		
}