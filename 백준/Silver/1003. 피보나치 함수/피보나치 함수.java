import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
    StringBuilder sb = new StringBuilder();

    //Input data
    int N = Integer.parseInt(br.readLine());
    
    //x1, y1 = y0, y0 + x0
    for (int i = 0; i < N; i++) {
      int fibo = Integer.parseInt(br.readLine());
      if (fibo == 0)
        sb.append("1 0\n");
      
      else if (fibo == 1)
        sb.append("0 1\n");

      else {
        int zero = 1;
        int one = 1;
        for (int n = 2; n < fibo; n++) {
          int temp = zero;
          zero  = one;
          one = zero + temp;
        }
        sb.append(zero + " " + one + "\n");
      }
    }

    //Output
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb + "");
    bw.flush();
    bw.close(); 
  }
}