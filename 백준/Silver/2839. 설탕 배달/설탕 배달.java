import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int cnt = -1;

		if (N%5 == 0) cnt = N/5;
		else {
			for (int i = N/5; i >= 0; i--) {
				//N = 5 * (N/5 - i) + 3 * x
				if ( (N - (5 * i))%3 == 0 ) {
					cnt = i + (N - 5 * i)/3;
					break;
				}
			}
		}

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(cnt + "\n");
		bw.flush();
		bw.close();
	}
}