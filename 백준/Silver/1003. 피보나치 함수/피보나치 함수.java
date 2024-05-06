import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
    StringBuilder sb = new StringBuilder();

    int N = Integer.parseInt(br.readLine());
    
    for (int i = 0; i < N; i++) {
      int fibo = Integer.parseInt(br.readLine());
      
      int zero = 1;
      int one = 0;
      for (int n = 0; n < fibo; n++) {
       int temp = zero;
        zero = one;
        one = zero + temp;
      }
      sb.append(zero + " " + one + "\n");
    }

    //Output
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb + "");
    bw.flush();
    bw.close(); 
  }
}