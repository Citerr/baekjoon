import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.HashSet;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    ArrayList<Integer>[] edgeLists = new ArrayList[N + 1];
    for (int n = 1; n <= N; n++)
      edgeLists[n] = new ArrayList<>();
    for (int m = 0; m < M; m++) {
      st = new StringTokenizer(br.readLine());
      int node1 = Integer.parseInt(st.nextToken());
      int node2 = Integer.parseInt(st.nextToken());
      edgeLists[node1].add(node2);
      edgeLists[node2].add(node1);
    }
    br.close();

    //BFS
    int min = 5001;
    int idx = 0;
    for (int n = 1; n <= N; n++) {
      HashSet<Integer> visited = new HashSet<>();
      ArrayList<Integer> roop = new ArrayList<>();
      visited.add(n);
      roop.addAll(edgeLists[n]);

      int sum = 0;
      int stage = 0;
      while (visited.size() < N) { //BFS 스테이지
        stage += 1;
        ArrayList<Integer> nextRoop = new ArrayList<>();
        for (int i: roop) {
          if (visited.contains(i)) continue;
          visited.add(i);
          for (int j: edgeLists[i]) nextRoop.add(j);
          sum += stage;
        }
        roop.clear();
        roop.addAll(nextRoop);
      }

      if (sum < min) {
        min = sum;
        idx = n;
      }
    }

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(idx + "");
    bw.flush();
    bw.close();
  }
}