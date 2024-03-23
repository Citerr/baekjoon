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
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int gcd = Euclid(a, b);
		int lcm = a*b/gcd;
		bw.write(gcd + "\n" + lcm);
		bw.flush();
		
		br.close();
		bw.close();
		
	}
	
	public static int Euclid(int a, int b) {
	    if (b == 0)
	        return a;
	   return Euclid(b, a%b);
	}
}