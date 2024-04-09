import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String brace = new String();
		
		while ( !( (brace = br.readLine()).equals(".")) ) {
			
			Stack<Character> stack = new Stack<>();
			for (int i = 0; brace.charAt(i) != '.'; i++) {
				if ( brace.charAt(i) == '(' || brace.charAt(i) == '[' )
					stack.push(brace.charAt(i));
				else if ( brace.charAt(i) == ')' || brace.charAt(i) == ']' ) {
					if ( !stack.empty() ) {
						if ( (stack.peek() == '(' && brace.charAt(i) == ')' ) || (stack.peek() == '[' && brace.charAt(i) == ']') ) {
							stack.pop();
							continue;
						}
					}
					stack.push(brace.charAt(i));	
				}
			}
			
			if (stack.empty()) bw.write("yes\n");
			else bw.write("no\n");
		}
		
		br.close();
		bw.flush();
		bw.close();
	}	
}