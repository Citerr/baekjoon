import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));	
	    
	    int sum = 0;
	    int T = Integer.parseInt(br.readLine());
	    String str = br.readLine();
	    
	    for (int i = 0; i < T; i++) sum += (str.charAt(i) - 'a' + 1) * Math.pow(31, i);
	    bw.write(sum % 1234567891 + "\n");
	    
	    br.close();
	    bw.close();
	}
}