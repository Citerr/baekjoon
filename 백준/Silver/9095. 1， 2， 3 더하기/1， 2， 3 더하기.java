import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  static int[] cases = new int[12];
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
    int N = Integer.parseInt(br.readLine());
    cases[1] = 1;
    cases[2] = 2;
    cases[3] = 4;
    
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    for (int i = 0; i < N; i++)
      bw.write(caseSum(Integer.parseInt(br.readLine()))+ "\n");
    br.close();
    
    bw.flush();
    bw.close(); 
  }

  static int caseSum(int n) {
    if (n != 0 && cases[n] == 0)
      return caseSum(n - 1) + caseSum(n - 2) + caseSum(n - 3);
    
    return cases[n];
  }
}