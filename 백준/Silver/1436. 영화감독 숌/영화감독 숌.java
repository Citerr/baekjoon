import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
		br.close();
		
		int h = 0, t = 0; //head, tail
		Label: for (int i = 0; i < N; i++) {
		    if (h % 10 == 6) {
		        int stack = 0;
		        int left;
		        for (left = h; left%10 == 6; left /= 10) stack++;
		        int space = (int)Math.pow(10, stack) - 1;
		        
		        for (t = 0; t <= space; t++) {
		            if (i + 1 == N) {
		                if (left != 0) bw.write(left + "");
		                bw.write("666");
		                
		                int temp = t;
		                while ( !(temp == 0 && space == 0) ) {
		                    if (temp > 0) {
		                        temp /= 10;
		                        space /= 10;
		                    }
		                    else if (temp == 0 && space > 0) {
		                        space /= 10;
		                        bw.write("0");
		                    }
		                }
		                
		                if (t == 0) bw.write("\n");
		                else bw.write(t + "\n");
		                break Label;
		            }
		            i++;
		        }
		        i--; //Label 루프가 돌면서 i++가 한 번 더 되기 때문에 한번 빼줘야함함
		    }
		    
		    if (i + 1 == N) {
		        if (h != 0) bw.write(h + "");
		        bw.write("666" + "\n");
		    }
		    h++;
		}
		bw.flush();
		bw.close();
	}
}