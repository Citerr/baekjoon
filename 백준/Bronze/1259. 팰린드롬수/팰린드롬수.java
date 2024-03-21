import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		while (true) {
		    String num = br.readLine();
		    if (num.charAt(0) == '0') break;
		    int len = num.length();
		    int flag = 0;
		    char[] temp = new char[len];
		    for (int i = 0; i < len; i++) temp[i] = num.charAt(len - 1 - i);
		    for (int i = 0; i < len; i++) {
		        if (temp[i] != num.charAt(i)) break;
		        flag++;
		    }
		    if (flag == len) bw.write("yes\n");
		    else bw.write("no\n");
		}
		bw.flush();
		br.close();
		bw.close();
	}
}