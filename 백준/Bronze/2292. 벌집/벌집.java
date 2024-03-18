import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int room = Integer.parseInt(br.readLine());
		int num = 1;
		//1, (1 + 6*1), (1 + 6*1+2), (1 + 6*1+2+3)
		for (int i = 0; ; i++) {
		    num += 6*i;
		    if (room <= num) {
		        bw.write(i + 1 + "\n");
		        break;
		    }
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
