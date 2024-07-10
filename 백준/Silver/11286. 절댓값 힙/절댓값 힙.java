import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
//import java.util.StringTokenizer;
import java.util.PriorityQueue;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int N = Integer.parseInt(br.readLine());
    PriorityQueue<Integer> pq = new PriorityQueue<>((e1, e2) -> {
      int e1_abs = Math.abs(e1);
      int e2_abs = Math.abs(e2);

      if (e1_abs == e2_abs) return  e1 > e2 ? 1 : -1;
      else return e1_abs - e2_abs;
      //return 양수 = 자리바꿈.
      //0이나 음수는 유지.
    });

    for (int i = 0; i < N; i++) {
      int x = Integer.parseInt(br.readLine());
      if (x != 0) pq.offer(x);
      else {
        if ( pq.isEmpty() ) sb.append("0\n");
        else sb.append( pq.poll() + "\n" );
      }
    }

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write( sb + "" );
    bw.flush();
    bw.close();
  }   
}