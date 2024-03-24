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
	    for (int i = 0; i < T; i++) {
	       int k = Integer.parseInt(br.readLine());
	       int n = Integer.parseInt(br.readLine());
	       bw.write(room(k, n) + "\n");
	       bw.flush();
	    }
	    bw.close();
	    br.close();
	    
	}
	
	public static int room(int k, int n) {
	    if (n == 1) return 1;
	    if (k == 0) return n;
	    return room(k-1, n) + room(k, n-1);
	}
}