import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
//import java.util.StringTokenizer;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));    
    int N = Integer.parseInt(br.readLine());
    ArrayList<Integer> graph = new ArrayList<>();
    //Index => 0 ~ row * col. N ~ N + row *col.

    int[][] tbl = new int[N + 2][N + 2];
    for (int row = 1; row < N + 1; row++) {
      String str = new String(br.readLine());
      for (int col = 1; col < N + 1; col++) {
        tbl[row][col] = str.charAt(col - 1) - '0';
        if (tbl[row][col] == 1) graph.add(row * N + col - 1);
      }
    }

    int block = 0;
    ArrayList<Integer> RES = new ArrayList<>();
    while ( !graph.isEmpty() ) {
      block++;
      Queue<Integer> srchQ = new LinkedList<>();
      int index = graph.remove(0);
      srchQ.offer( index );
      int row = index / N;
      int col = index % N + 1;
      tbl[row][col] = 0;
      int house = 0;

      while ( !srchQ.isEmpty() ) {
        house++;
        index = srchQ.poll();
        row = index / N;
        col = index % N + 1;
        
        if (tbl[row][col + 1] == 1) {
          tbl[row][col + 1] = 0;
          srchQ.offer( index + 1 );
        }
        if (tbl[row][col - 1] == 1) {
          tbl[row][col - 1] = 0;
          srchQ.offer( index - 1 );
        }
        if (tbl[row + 1][col] == 1) {
          tbl[row + 1][col] = 0;
          srchQ.offer( index + N );
        }
        if (tbl[row - 1][col] == 1) {
          tbl[row - 1][col] = 0;
          srchQ.offer( index - N );
        }
        graph.removeAll(srchQ);
      }
      RES.add(house);
    }

    Collections.sort(RES);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write( block + "\n" );
    for (Integer i : RES) bw.write(i + "\n");
    bw.flush();
    bw.close();
  }
}