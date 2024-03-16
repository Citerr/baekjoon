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
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int prime = 0;
		Label: for (int i = 0; i < T; i++) {
		    int temp = Integer.parseInt(st.nextToken());
		    if (temp == 1) continue;
		    
		    int flag = 0;
		    for (int j = 2; j < temp; j++) {
		        if (temp%j == 0) {
		            flag++;
		            continue Label;
		        }
		    }
		    if (flag == 0) prime++;
		}
		bw.write(prime + "\n");
		bw.flush();
		
		br.close();
		bw.close();
	}
}