import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
    StringBuilder sb = new StringBuilder();
    StringTokenizer st1 = new StringTokenizer(br.readLine(), "-");
    int sum = 0;
    boolean first = true;
    while ( st1.hasMoreTokens() ) {
      StringTokenizer st2 = new StringTokenizer(st1.nextToken(), "+");
      int part = 0;
      while ( st2.hasMoreTokens() ) 
        part += Integer.parseInt(st2.nextToken());
        
      if ( first ) {
        first = false;
        part *= -1;
      }
      sum -= part;
    }
    sb.append(sum + "\n");
    
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb + "");
    bw.flush();
    bw.close();
  }
}