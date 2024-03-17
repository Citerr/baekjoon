import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int ori = Integer.parseInt(br.readLine());
		int len = 0, mk = 0;
		for (int i = ori; i > 0; i /= 10) len += 9;
		//ori = mk + temp; => mk = ori - temp
		for (int i = ori - len*9; i < ori; i++) {
		    int temp = 0;
		    for (int j = i; j > 0; j /= 10) temp += j%10;
		    if (ori == i + temp) {
		        mk = i;
		        break;
		    }
		}
		bw.write(mk + "\n");
		bw.flush();
		
		br.close();
		bw.close();
	}
}