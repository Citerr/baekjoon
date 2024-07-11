import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.HashSet;

public class Main {
  static ArrayList<Integer>[] nodes;
  static HashSet<Integer> visited;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    nodes = new ArrayList[N];
    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      nodes[i] = new ArrayList<>();
      for (int j = 0; j < N; j++) {
        if ( st.nextToken().equals("1") ) nodes[i].add(j);
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < N; i++) {
      visited = new HashSet<>();
      DFS(i);
      for (int j = 0; j < N; j++) {
        if ( visited.contains(j) ) sb.append("1 ");
        else sb.append("0 ");
      }
      sb.append("\n");
    }

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write( sb + "" );
    bw.flush();
    bw.close();
  }

  static void DFS(int i) {
    for (int node : nodes[i]) {
      if ( visited.contains(node) ) continue;
      visited.add(node);
      DFS(node);
    }
  }
}