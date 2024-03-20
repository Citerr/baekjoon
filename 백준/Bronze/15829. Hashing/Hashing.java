import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));	
	    
	    long sum = 0;
	    int T = Integer.parseInt(br.readLine());
	    String str = br.readLine();
	    
	    for (int i = 0; i < T; i++) {
	        long temp =  str.charAt(i) - 'a' + 1;
	        for (int j = i; j > 0; j--) {
	            temp *= 31;
	            temp %= 1234567891;
	        }
	        sum += temp;
	    }
	    bw.write(sum % 1234567891 + "\n");
	    
	    br.close();
	    bw.close();
	}
}