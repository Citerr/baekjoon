import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.HashSet;
import java.util.Collections;

public class Main {
  static ArrayList<Integer>[] edgeLists;
  static Queue<Integer> q = new LinkedList<>();
  static Queue<Integer> subBFS = new LinkedList<>();
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
    StringBuilder sb = new StringBuilder();
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int E = Integer.parseInt(st.nextToken());
    int V = Integer.parseInt(st.nextToken());
    edgeLists = new ArrayList[N + 1];

    for (int n = 0; n < N + 1; n++) 
      edgeLists[n] = new ArrayList<>();

    for (int e = 0; e < E; e++) {
      st = new StringTokenizer(br.readLine());
      int nodeA = Integer.parseInt(st.nextToken());
      int nodeB = Integer.parseInt(st.nextToken());
      edgeLists[nodeA].add(nodeB);
      edgeLists[nodeB].add(nodeA);
    }

    for (int n = 1; n < N + 1; n++)
      Collections.sort(edgeLists[n]);

    //DFS
    DFS(V);
    for (int i: q) sb.append(i + " ");
    sb.append("\n");

    //BFS
    q = new LinkedList<>();
    q.offer(V);
    subBFS.offer(V);
    while ( !subBFS.isEmpty() ) {
      BFS( subBFS.poll() );
    }
    for (int i: q) sb.append(i + " ");
    sb.append("\n");

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb + "");
    bw.flush();
    bw.close();
  }

  static int DFS(int n) {
    if (q.contains(n) || edgeLists[n] == null) return 0;
    q.offer(n);

    for (int i: edgeLists[n]) 
      DFS(i);
    
    return 0;
  }

  static int BFS(int n) {
    for (int i: edgeLists[n]) {
      if (!q.contains(i)) {
        q.offer(i);
        subBFS.offer(i);
      }
    }

    return 0;
  }
}